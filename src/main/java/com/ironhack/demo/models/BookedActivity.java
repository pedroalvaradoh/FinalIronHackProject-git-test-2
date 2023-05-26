package com.ironhack.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BookedActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @ManyToOne
    @JsonBackReference
    private User user;
    @ManyToOne
    @JsonIgnore
    private Instructor instructor;
    @ManyToOne
    @JsonIgnore
    private Activity activity;

    public BookedActivity() {
    }

    public BookedActivity(User user, Instructor instructor, Activity activity) {
        this.user = user;
        this.instructor = instructor;
        this.activity = activity;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
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

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}

