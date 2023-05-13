package com.ironhack.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Instructor extends User {
    private Long phoneNumber;
    @Enumerated(EnumType.STRING)
    @Column(name = "instructor_status", columnDefinition = "ENUM('ON','OFF','BUSY')", nullable = false)
    private InstructorStatus instructorStatus;
    @OneToMany
    @JoinColumn (name = "pending_activities", referencedColumnName = "activity_code")
    private List <Activity> activityList;

    public Instructor() {
    }

    public Instructor(String userName, String email, Long creditCardInfo, List<BookingCart> bookingCartList, Long phoneNumber, InstructorStatus instructorStatus, List<Activity> activityList) {
        super(userName, email, creditCardInfo, bookingCartList);
        this.phoneNumber = phoneNumber;
        this.instructorStatus = instructorStatus;
        this.activityList = activityList;
    }

    public Long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public InstructorStatus getInstructorStatus() {
        return instructorStatus;
    }

    public void setInstructorStatus(InstructorStatus instructorStatus) {
        this.instructorStatus = instructorStatus;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}

