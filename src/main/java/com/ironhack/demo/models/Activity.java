package com.ironhack.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

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
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "performed_by", referencedColumnName = "user_id")
    private User user;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "taught_by", referencedColumnName = "instructor_id")
    private Instructor instructor;
    @OneToOne
    private BookingCart bookingCart;

    public Activity() {
    }

    public Activity(String activityName, BigDecimal price, ActivityStatus activityStatus, User user, Instructor instructor, BookingCart bookingCart) {
        this.activityName = activityName;
        this.price = price;
        this.activityStatus = activityStatus;
        this.user = user;
        this.instructor = instructor;
        this.bookingCart = bookingCart;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public BookingCart getBookingCart() {
        return bookingCart;
    }

    public void setBookingCart(BookingCart bookingCart) {
        this.bookingCart = bookingCart;
    }
}
