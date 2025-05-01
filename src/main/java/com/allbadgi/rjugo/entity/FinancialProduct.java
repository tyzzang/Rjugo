package com.allbadgi.rjugo.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "financial_product")
public class FinancialProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_id", nullable = false)
    private Bank bank;

    @Column(name = "product_name", nullable = false, length = 255)
    private String productName;

    @Column(name = "product_type", length = 100)
    private String productType;

    @Column(name = "base_interest_rate", precision = 5, scale = 2)
    private BigDecimal baseInterestRate;

    @Column(name = "max_interest_rate", precision = 5, scale = 2)
    private BigDecimal maxInterestRate;

    @Column(name = "term", length = 50)
    private String term;

    @Column(name = "min_amount", length = 15)
    private String minAmount;

    @Column(name = "benefits_summary", columnDefinition = "TEXT")
    private String benefitsSummary;

    @Column(name = "application_method", columnDefinition = "TEXT")
    private String applicationMethod;

    @Column(name = "source_url", length = 255)
    private String sourceUrl;

    public FinancialProduct() {}
    // 생성자 생략 가능
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public Bank getBank() { return bank; }
    public void setBank(Bank bank) { this.bank = bank; }
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
