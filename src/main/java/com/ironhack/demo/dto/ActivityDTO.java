package com.ironhack.demo.dto;

import com.ironhack.demo.enums.ActivityStatus;

import java.math.BigDecimal;

public class ActivityDTO {
    private Long activityCode;
    private String activityName;
    private BigDecimal price;
    private ActivityStatus activityStatus;

    public ActivityDTO(Long activityCode) {
        this.activityCode = activityCode;
    }

    public ActivityDTO(String activityName, BigDecimal price, ActivityStatus activityStatus) {
        this.activityName = activityName;
        this.price = price;
        this.activityStatus = activityStatus;
    }

    public ActivityDTO() {
    }

    public Long getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(Long activityCode) {
        this.activityCode = activityCode;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public ActivityStatus getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }
}
