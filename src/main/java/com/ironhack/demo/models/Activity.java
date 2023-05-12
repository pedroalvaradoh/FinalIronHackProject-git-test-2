package com.ironhack.demo.models;

import jakarta.persistence.*;

@Entity
public class Activity {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long activityCode;

    private String activityName;
    @Enumerated(EnumType.STRING)
    @Column(name = "activity_status", columnDefinition="ENUM('AVAILABLE','NOT_AVAILABLE','WAITING_LIST')",nullable = false)
    private ActivityStatus activityStatus;
}
