package com.allbadgi.rjugo.service;

import com.allbadgi.rjugo.dto.PolicyDto;
import com.allbadgi.rjugo.dto.PolicyFilterRequest;
import com.allbadgi.rjugo.entity.Policy;
import com.allbadgi.rjugo.repository.PolicyRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PolicyService {

    private final PolicyRepository repo;

    public PolicyService(PolicyRepository repo) {
        this.repo = repo;
    }

    public List<PolicyDto> search(PolicyFilterRequest req) {
        // 1) 기본 빈 Specification
        Specification<Policy> spec = Specification.where(null);

        // 2) region.name IN (:regions)
        if (req.getRegion() != null && !req.getRegion().isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    root.join("region").get("name").in(req.getRegion())
            );
        }

        // 3) category IN (:categories)
        if (req.getCategory() != null && !req.getCategory().isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    root.get("category").in(req.getCategory())
            );
        }

        // 4) empStatus IN (:statuses)
        if (req.getStatus() != null && !req.getStatus().isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    root.get("empStatus").in(req.getStatus())
            );
        }

        // 5) ageGroup 목록 처리 ("19~24", "25~29", …)
        if (req.getAgeGroup() != null && !req.getAgeGroup().isEmpty()) {
            // 각 그룹별로 Predicate 생성
            List<Specification<Policy>> ageSpecs = new ArrayList<>();
            for (String group : req.getAgeGroup()) {
                String[] parts = group.split("~");
                int grpMin = Integer.parseInt(parts[0]);
                int grpMax = Integer.parseInt(parts[1]);
                ageSpecs.add((root, query, cb) -> {
                    Predicate minOk = cb.lessThanOrEqualTo(root.get("ageMin"), grpMax);
                    Predicate maxOk = cb.greaterThanOrEqualTo(root.get("ageMax"), grpMin);
                    return cb.and(minOk, maxOk);
                });
            }
            // OR 로 합치기
            Specification<Policy> ageSpec = ageSpecs.stream()
                    .reduce(Specification::or)
                    .orElse((root, query, cb) -> cb.conjunction());
            spec = spec.and(ageSpec);
        }

        // 6) 최종 조회 및 DTO 매핑
        return repo.findAll(spec).stream()
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
    }
}
