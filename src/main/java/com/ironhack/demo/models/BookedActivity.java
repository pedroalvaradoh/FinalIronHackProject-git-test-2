package com.ironhack.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class BookedActivity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartId;
    @ManyToMany
    private List<User> userList;
    @ManyToOne
    @JsonIgnore
    private Instructor instructor;
    @ManyToOne
    private Activity activity;


    public BookedActivity() {
    }

    public BookedActivity(List<User> userList, Instructor instructor) {
        this.userList = userList;
        this.instructor = instructor;
    }

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }


}

