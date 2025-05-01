package com.allbadgi.rjugo.service;

import com.allbadgi.rjugo.dto.FinancialProductDto;
import com.allbadgi.rjugo.entity.FinancialProduct;
import com.allbadgi.rjugo.repository.FinancialProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FinancialProductService {
    private static final Logger logger = LoggerFactory.getLogger(FinancialProductService.class);
    private final FinancialProductRepository repo;

    public FinancialProductService(FinancialProductRepository repo) {
        this.repo = repo;
    }

    /**
     * 금융상품 검색
     * @param bankIds      은행 ID 리스트 (선택)
     * @param rateSort     금리 정렬 옵션
     * @param terms        가입기간 필터
     * @param minAmounts   최소금액 필터
     * @return             필터링·정렬된 FinancialProductDto 리스트
     */
    public List<FinancialProductDto> search(
            List<Integer> bankIds,
            List<String> rateSort,
            List<String> terms,
            List<String> minAmounts
    ) {
        logger.info("[FinancialProductService.search] 필터 bankIds={}, rateSort={}, terms={}, minAmounts={}",
                bankIds, rateSort, terms, minAmounts);

        Specification<FinancialProduct> spec = Specification.where(null);
        // 은행 필터
        if (bankIds != null && !bankIds.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    root.get("bank").get("id").in(bankIds)
            );
        }
        // 가입기간 필터
        if (terms != null && !terms.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    root.get("term").in(terms)
            );
        }
        // 최소금액 필터
        if (minAmounts != null && !minAmounts.isEmpty()) {
            spec = spec.and((root, query, cb) ->
                    root.get("minAmount").in(minAmounts)
            );
        }

        // 정렬 설정
        Sort sort = Sort.unsorted();
        if (rateSort != null) {
            if (rateSort.contains("기본 금리 높은 순")) {
                sort = Sort.by(Sort.Direction.DESC, "baseInterestRate");
            } else if (rateSort.contains("최고 금리 높은 순")) {
                sort = Sort.by(Sort.Direction.DESC, "maxInterestRate");
            }
        }

        List<FinancialProductDto> results =
                repo.findAll(spec, sort)
                        .stream()
                        .map(p -> new FinancialProductDto(
                                p.getId(),
                                p.getBank().getId(),
                                p.getBank().getName(),
                                p.getProductName(),
                                p.getProductType(),
                                p.getBaseInterestRate(),
                                p.getMaxInterestRate(),
                                p.getTerm(),
                                p.getMinAmount(),
                                p.getBenefitsSummary(),
                                p.getApplicationMethod(),
                                p.getSourceUrl()
                        ))
                        .collect(Collectors.toList());

        logger.info("[FinancialProductService.search] 결과 개수: {}건", results.size());
        return results;
    }
}
