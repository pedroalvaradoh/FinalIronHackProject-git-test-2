package com.ironhack.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class Roll extends Admin{
    private String rollName;

    public Roll() {
    }

    public Roll(String adminName, BigDecimal price, String rollName) {
        this.rollName = rollName;
    }

    public String getRollName() {
        return rollName;
    }

    public void setRollName(String rollName) {
        this.rollName = rollName;
    }
}
