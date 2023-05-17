package com.ironhack.demo.models;

import com.ironhack.demo.enums.ActivityStatus;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class Activity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long activityCode;
    private String activityName;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    @Column(name = "activity_status", columnDefinition="ENUM('AVAILABLE','NOT_AVAILABLE','WAITING_LIST')",nullable = false)
    private ActivityStatus activityStatus;
    @OneToMany (mappedBy = "activity")
    private List <BookedActivity> bookedActivityList;
    @ManyToMany(mappedBy = "activities")
    private List<Admin> admins;

    public Activity() {
    }

    public Activity(String activityName, BigDecimal price, ActivityStatus activityStatus) {
        this.activityName = activityName;
        this.price = price;
        this.activityStatus = activityStatus;
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

    public List<BookedActivity> getBookedActivityList() {
        return bookedActivityList;
    }

    public void setBookedActivityList(List<BookedActivity> bookedActivityList) {
        this.bookedActivityList = bookedActivityList;
    }
}
