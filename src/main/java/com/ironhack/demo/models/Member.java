package com.ironhack.demo.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Member extends User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn (name = "member", referencedColumnName = "user_id")
    private User user;

    public Member(String userName, String email, Long creditCardInfo, List<BookingCart> bookingCartList, User user) {
        super(userName, email, creditCardInfo, bookingCartList);
        this.user = user;
    }

    public Member() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
