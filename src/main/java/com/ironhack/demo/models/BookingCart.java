package com.ironhack.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
public class BookingCart {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long cartId;
    private Long activityCode;
    private Long quantity;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "booked_by", referencedColumnName = "user_id")
    private User user;
    @OneToOne
    @JoinColumn (name = "activity_code", referencedColumnName = "activity_code")
    private Activity activity;

    public BookingCart() {
    }

    public BookingCart(Long activityCode, Long quantity, User user, List<Activity> activityList, Activity activity) {
        this.activityCode = activityCode;
        this.quantity = quantity;
        this.user = user;
        this.activity = activity;
    }

    public Long getActivityCode() {
        return activityCode;
    }

    public void setActivityCode(Long activityCode) {
        this.activityCode = activityCode;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
