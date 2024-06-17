package com.springheaven.Mailer.model;


import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDate;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private LocalDate membershipExpiryDate;

    // Getters and setters
    // ...
}
