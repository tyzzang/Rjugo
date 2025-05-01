// src/main/java/com/allbadgi/rjugo/dto/FinancialProductFilterRequest.java
package com.allbadgi.rjugo.dto;

import java.util.List;

public class FinancialProductFilterRequest {
    // 은행 ID 목록
    private List<Integer> bankIds;
    // 금리 정렬: "기본 금리 높은 순" or "최고 금리 높은 순"
    private List<String> rateSort;
    // 가입기간 목록
    private List<String> terms;
    // 최소금액 조건 목록
    private List<String> minAmounts;

    public FinancialProductFilterRequest() {}

    public List<Integer> getBankIds() { return bankIds; }
    public void setBankIds(List<Integer> bankIds) { this.bankIds = bankIds; }

    public List<String> getRateSort() { return rateSort; }
    public void setRateSort(List<String> rateSort) { this.rateSort = rateSort; }

    public List<String> getTerms() { return terms; }
    public void setTerms(List<String> terms) { this.terms = terms; }

    public List<String> getMinAmounts() { return minAmounts; }
    public void setMinAmounts(List<String> minAmounts) { this.minAmounts = minAmounts; }
}
