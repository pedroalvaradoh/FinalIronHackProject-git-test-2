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
    private List <BookedActivity> bookedActivityList;
    public User() {
    }

    public User(String userName, String email, Long creditCardInfo, List<BookedActivity> bookedActivityList) {
        this.userName = userName;
        this.email = email;
        this.creditCardInfo = creditCardInfo;
        this.bookedActivityList = bookedActivityList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<BookedActivity> getGetBookedActivityList() {
        return bookedActivityList;
    }

    public void setGetBookedActivityList(List<BookedActivity> getBookedActivityList) {
        this.bookedActivityList = getBookedActivityList;
    }
}
