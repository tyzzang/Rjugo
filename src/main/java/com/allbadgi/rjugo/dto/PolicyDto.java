// src/main/java/com/allbadgi/rjugo/dto/PolicyDto.java
package com.allbadgi.rjugo.dto;

public class PolicyDto {
    private Integer id;
    private String regionName;
    private String policyName;
    private String category;
    private String empStatus;
    private Integer ageMin;
    private Integer ageMax;
    private String additionalConditions;
    private String supportDetails;
    private String applicationMethod;
    private String implementingAgency;
    private String operatingPeriod;
    private String sourceUrl;

    public PolicyDto() {}

    public PolicyDto(
            Integer id,
            String regionName,
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
            String sourceUrl
    ) {
        this.id = id;
        this.regionName = regionName;
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

    // --- getters & setters 생략 없이 모두 추가 ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getRegionName() { return regionName; }
    public void setRegionName(String regionName) { this.regionName = regionName; }
    public String getPolicyName() { return policyName; }
    public void setPolicyName(String policyName) { this.policyName = policyName; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getEmpStatus() { return empStatus; }
    public void setEmpStatus(String empStatus) { this.empStatus = empStatus; }
    public Integer getAgeMin() { return ageMin; }
    public void setAgeMin(Integer ageMin) { this.ageMin = ageMin; }
    public Integer getAgeMax() { return ageMax; }
    public void setAgeMax(Integer ageMax) { this.ageMax = ageMax; }
    public String getAdditionalConditions() { return additionalConditions; }
    public void setAdditionalConditions(String additionalConditions) { this.additionalConditions = additionalConditions; }
    public String getSupportDetails() { return supportDetails; }
    public void setSupportDetails(String supportDetails) { this.supportDetails = supportDetails; }
    public String getApplicationMethod() { return applicationMethod; }
    public void setApplicationMethod(String applicationMethod) { this.applicationMethod = applicationMethod; }
    public String getImplementingAgency() { return implementingAgency; }
    public void setImplementingAgency(String implementingAgency) { this.implementingAgency = implementingAgency; }
    public String getOperatingPeriod() { return operatingPeriod; }
    public void setOperatingPeriod(String operatingPeriod) { this.operatingPeriod = operatingPeriod; }
    public String getSourceUrl() { return sourceUrl; }
    public void setSourceUrl(String sourceUrl) { this.sourceUrl = sourceUrl; }
}
