package com.allbadgi.rjugo.dto;

import java.math.BigDecimal;

public class FinancialProductDto {
    private Integer id;
    private Integer bankId;
    private String bankName;
    private String productName;
    private String productType;
    private BigDecimal baseInterestRate;
    private BigDecimal maxInterestRate;
    private String term;
    private String minAmount;
    private String benefitsSummary;
    private String applicationMethod;
    private String sourceUrl;

    public FinancialProductDto() {}

    public FinancialProductDto(
            Integer id,
            Integer bankId,
            String bankName,
            String productName,
            String productType,
            BigDecimal baseInterestRate,
            BigDecimal maxInterestRate,
            String term,
            String minAmount,
            String benefitsSummary,
            String applicationMethod,
            String sourceUrl
    ) {
        this.id = id;
        this.bankId = bankId;
        this.bankName = bankName;
        this.productName = productName;
        this.productType = productType;
        this.baseInterestRate = baseInterestRate;
        this.maxInterestRate = maxInterestRate;
        this.term = term;
        this.minAmount = minAmount;
        this.benefitsSummary = benefitsSummary;
        this.applicationMethod = applicationMethod;
        this.sourceUrl = sourceUrl;
    }
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Integer getBankId() { return bankId; }
    public void setBankId(Integer bankId) { this.bankId = bankId; }
    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public String getProductType() { return productType; }
    public void setProductType(String productType) { this.productType = productType; }
    public BigDecimal getBaseInterestRate() { return baseInterestRate; }
    public void setBaseInterestRate(BigDecimal baseInterestRate) { this.baseInterestRate = baseInterestRate; }
    public BigDecimal getMaxInterestRate() { return maxInterestRate; }
    public void setMaxInterestRate(BigDecimal maxInterestRate) { this.maxInterestRate = maxInterestRate; }
    public String getTerm() { return term; }
    public void setTerm(String term) { this.term = term; }
    public String getMinAmount() { return minAmount; }
    public void setMinAmount(String minAmount) { this.minAmount = minAmount; }
    public String getBenefitsSummary() { return benefitsSummary; }
    public void setBenefitsSummary(String benefitsSummary) { this.benefitsSummary = benefitsSummary; }
    public String getApplicationMethod() { return applicationMethod; }
    public void setApplicationMethod(String applicationMethod) { this.applicationMethod = applicationMethod; }
    public String getSourceUrl() { return sourceUrl; }
    public void setSourceUrl(String sourceUrl) { this.sourceUrl = sourceUrl; }
}
