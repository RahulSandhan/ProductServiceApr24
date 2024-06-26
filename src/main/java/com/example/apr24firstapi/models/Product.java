package com.example.apr24firstapi.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    @ManyToOne
    private Category category;

    private int qty;
}
