package com.allbadgi.rjugo.service;

import com.allbadgi.rjugo.dto.PolicyDto;
import com.allbadgi.rjugo.dto.PolicyFilterRequest;
import com.allbadgi.rjugo.entity.Policy;
import com.allbadgi.rjugo.repository.PolicyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    private static final Logger logger = LoggerFactory.getLogger(PolicyService.class);

    private final PolicyRepository repo;

    public PolicyService(PolicyRepository repo) {
        this.repo = repo;
    }

    /**
     * DB 기반 동적 검색
     * 지역 이름을 ID로 사전 매핑하여 검색 수행
     */
    public List<PolicyDto> search(PolicyFilterRequest req) {
        // 1) 입력 필터 로깅
        logger.info("[PolicyService.search] 검색 필터 - regions: {}, categories: {}, statuses: {}, ageGroups: {}",
                req.getRegion(), req.getCategory(), req.getStatus(), req.getAgeGroup());

        Specification<Policy> spec = Specification.where(null);

        // 2) 지역 이름 → ID 매핑
        List<String> regionNames = req.getRegion() == null
                ? List.of()
                : req.getRegion().stream()
                .filter(Objects::nonNull)
                .filter(s -> !s.isBlank())
                .collect(Collectors.toList());
        List<Integer> regionIds = regionNames.stream()
                .map(name -> {
                    switch (name) {
                        case "경기도": return 1;
                        case "서울특별시": return 2;
                        // 추가 지역 매핑 필요 시 케이스 추가
                        default: return null;
                    }
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        if (!regionIds.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    root.get("region").get("id").in(regionIds)
            );
        }

        // 3) 분야 필터
        List<String> categories = req.getCategory() == null
                ? List.of()
                : req.getCategory().stream()
                .filter(s -> s != null && !s.isBlank())
                .collect(Collectors.toList());
        if (!categories.isEmpty()) {
            spec = spec.and((root, query, cb) -> root.get("category").in(categories));
        }

        // 4) 취업상태 필터
        List<String> statuses = req.getStatus() == null
                ? List.of()
                : req.getStatus().stream()
                .filter(s -> s != null && !s.isBlank())
                .collect(Collectors.toList());
        if (!statuses.isEmpty()) {
            spec = spec.and((root, query, cb) -> root.get("empStatus").in(statuses));
        }

        // 5) 연령대 필터
        List<String> ageGroups = req.getAgeGroup() == null
                ? List.of()
                : req.getAgeGroup().stream()
                .filter(s -> s != null && s.matches("\\d+~\\d+"))
                .collect(Collectors.toList());
        if (!ageGroups.isEmpty()) {
            List<Specification<Policy>> ageSpecs = new ArrayList<>();
            for (String group : ageGroups) {
                String[] parts = group.split("~");
                int min = Integer.parseInt(parts[0]);
                int max = Integer.parseInt(parts[1]);
                ageSpecs.add((root, query, cb) -> {
                    Predicate minOk = cb.lessThanOrEqualTo(root.get("ageMin"), max);
                    Predicate maxOk = cb.greaterThanOrEqualTo(root.get("ageMax"), min);
                    return cb.and(minOk, maxOk);
                });
            }
            Specification<Policy> ageSpec = ageSpecs.stream()
                    .reduce(Specification::or)
                    .orElse((root, query, cb) -> cb.conjunction());
            spec = spec.and(ageSpec);
        }

        // 6) 최종 조회 및 DTO 변환
        List<PolicyDto> results = repo.findAll(spec).stream()
                .map(p -> new PolicyDto(
                        p.getId(),
                        p.getRegion().getName(),
                        p.getPolicyName(),
                        p.getCategory(),
                        p.getEmpStatus(),
                        p.getAgeMin(),
                        p.getAgeMax(),
                        p.getAdditionalConditions(),
                        p.getSupportDetails(),
                        p.getApplicationMethod(),
                        p.getImplementingAgency(),
                        p.getOperatingPeriod(),
                        p.getSourceUrl()
                ))
                .collect(Collectors.toList());

        // 7) 검색 결과 로깅
        logger.info("[PolicyService.search] 검색 결과 개수: {}건", results.size());
        // 정책명만 출력
        String names = results.stream()
                .map(PolicyDto::getPolicyName)
                .collect(Collectors.joining(", "));
        logger.info("[PolicyService.search] 검색된 정책명: {}", names);

        return results;
    }
}
