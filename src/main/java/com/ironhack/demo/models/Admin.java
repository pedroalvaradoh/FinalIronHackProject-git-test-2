package com.ironhack.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String adminName;

    public Admin(String adminName) {
        this.adminName = adminName;
    }

    public Admin() {
    }
}
