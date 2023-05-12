package com.ironhack.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class BookingCart {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long cartId;

    private Long activityCode;
    private BigDecimal price;
    private Long quantity;
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn (name = "booked_by", referencedColumnName = "user_id")
    private User user;
}
