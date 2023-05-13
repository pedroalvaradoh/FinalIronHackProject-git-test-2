package com.ironhack.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Inheritance (strategy = InheritanceType.JOINED)
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String email;
    private Long creditCardInfo;
    @OneToMany (mappedBy = "user")
    private List <BookingCart> bookingCartList;
    @OneToMany (mappedBy = "user")
    private List <Activity> activityList;
    public User() {
    }

    public User(String userName, String email, Long creditCardInfo, List<BookingCart> bookingCartList, List<Activity> activityList) {
        this.userName = userName;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.bookingCartList = bookingCartList;
        this.activityList = activityList;
    }

    public User(String userName, String email, Long creditCardInfo, List<BookingCart> bookingCartList) {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCreditCardInfo() {
        return creditCardInfo;
    }

    public void setCreditCardInfo(Long creditCardInfo) {
        this.creditCardInfo = creditCardInfo;
    }

    public List<BookingCart> getBookingCartList() {
        return bookingCartList;
    }

    public void setBookingCartList(List<BookingCart> bookingCartList) {
        this.bookingCartList = bookingCartList;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }
}
