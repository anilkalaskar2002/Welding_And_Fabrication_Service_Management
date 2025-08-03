package com.example.CrudOperation.Model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "Contact")
@Data
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phone;

    @Column(length = 2000)
    private String message;

    @Column
    private String selectedProducts; // Comma-separated list of product IDs or names

    @Column
    private LocalDateTime submittedAt = LocalDateTime.now();

    @Column
    private Boolean processed = false; // For admin to mark as processed
}