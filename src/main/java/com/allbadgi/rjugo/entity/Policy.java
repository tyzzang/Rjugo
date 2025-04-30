// src/main/java/com/allbadgi/rjugo/entity/Policy.java
package com.allbadgi.rjugo.entity;

import javax.persistence.*;

@Entity
@Table(name = "policy")
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "policy_id")
    private Integer id;

    // region_id FK → Region 엔티티와 N:1 관계
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id", nullable = false)
    private Region region;

    @Column(name = "policy_name", nullable = false, length = 255)
    private String policyName;

    @Column(name = "category", length = 50)
    private String category;

    @Column(name = "emp_status", length = 20)
    private String empStatus;

    @Column(name = "age_min")
    private Integer ageMin;

    @Column(name = "age_max")
    private Integer ageMax;

    @Column(name = "additional_conditions", columnDefinition = "TEXT")
    private String additionalConditions;

    @Column(name = "support_details", columnDefinition = "TEXT")
    private String supportDetails;

    @Column(name = "application_method", columnDefinition = "TEXT")
    private String applicationMethod;

    @Column(name = "implementing_agency", length = 255)
    private String implementingAgency;

    @Column(name = "operating_period", length = 100)
    private String operatingPeriod;

    @Column(name = "source_url", length = 255)
    private String sourceUrl;

    public Policy() {
    }

    public Policy(Integer id,
                  Region region,
                  String policyName,
                  String category,
                  String empStatus,
                  Integer ageMin,
                  Integer ageMax,
                  String additionalConditions,
                  String supportDetails,
                  String applicationMethod,
                  String implementingAgency,
                  String operatingPeriod,
                  String sourceUrl) {
        this.id = id;
        this.region = region;
        this.policyName = policyName;
        this.category = category;
        this.empStatus = empStatus;
        this.ageMin = ageMin;
        this.ageMax = ageMax;
        this.additionalConditions = additionalConditions;
        this.supportDetails = supportDetails;
        this.applicationMethod = applicationMethod;
        this.implementingAgency = implementingAgency;
        this.operatingPeriod = operatingPeriod;
        this.sourceUrl = sourceUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public String getPolicyName() {
        return policyName;
    }

    public void setPolicyName(String policyName) {
        this.policyName = policyName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(Integer ageMax) {
        this.ageMax = ageMax;
    }

    public String getAdditionalConditions() {
        return additionalConditions;
    }

    public void setAdditionalConditions(String additionalConditions) {
        this.additionalConditions = additionalConditions;
    }

    public String getSupportDetails() {
        return supportDetails;
    }

    public void setSupportDetails(String supportDetails) {
        this.supportDetails = supportDetails;
    }

    public String getApplicationMethod() {
        return applicationMethod;
    }

    public void setApplicationMethod(String applicationMethod) {
        this.applicationMethod = applicationMethod;
    }

    public String getImplementingAgency() {
        return implementingAgency;
    }

    public void setImplementingAgency(String implementingAgency) {
        this.implementingAgency = implementingAgency;
    }

    public String getOperatingPeriod() {
        return operatingPeriod;
    }

    public void setOperatingPeriod(String operatingPeriod) {
        this.operatingPeriod = operatingPeriod;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
