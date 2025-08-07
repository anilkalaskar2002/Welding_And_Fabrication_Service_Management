package com.example.CrudOperation.Model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Product")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 1000)
    private String description;

    @Column
    private Double price;

    @Column
    private String category; // e.g., "Welding", "Gates", "Grills", "Fabrication"

    @Column
    private String imageUrl; // Optional: for product images

    @Column
    private Boolean available = true;
}