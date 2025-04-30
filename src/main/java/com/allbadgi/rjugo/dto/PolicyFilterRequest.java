// src/main/java/com/allbadgi/rjugo/dto/PolicyFilterRequest.java
package com.allbadgi.rjugo.dto;

import java.util.List;

public class PolicyFilterRequest {

    private List<String> region;
    private List<String> category;
    private List<String> status;
    private List<String> ageGroup;

    public PolicyFilterRequest() {
    }

    public PolicyFilterRequest(List<String> region, List<String> category, List<String> status, List<String> ageGroup) {
        this.region = region;
        this.category = category;
        this.status = status;
        this.ageGroup = ageGroup;
    }

    public List<String> getRegion() {
        return region;
    }

    public void setRegion(List<String> region) {
        this.region = region;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }

    public List<String> getStatus() {
        return status;
    }

    public void setStatus(List<String> status) {
        this.status = status;
    }

    public List<String> getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(List<String> ageGroup) {
        this.ageGroup = ageGroup;
    }
}
