package com.ironhack.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

}
