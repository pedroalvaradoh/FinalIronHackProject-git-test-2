package com.ironhack.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Roll extends Admin{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long rollId;
    private String rollName;

    public Roll() {
    }

    public Roll(String adminName, Long rollId, String rollName) {
        super(adminName);
        this.rollId = rollId;
        this.rollName = rollName;
    }

}
