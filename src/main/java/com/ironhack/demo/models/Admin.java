package com.ironhack.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Admin {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String adminName;
    @ManyToMany
    @JoinTable(name = "admin_activity",
            joinColumns = @JoinColumn(name = "admin_id"),
            inverseJoinColumns = @JoinColumn(name = "activity_id"))
    private List<Activity> activities;

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
