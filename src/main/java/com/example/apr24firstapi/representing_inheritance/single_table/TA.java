package com.example.apr24firstapi.representing_inheritance.single_table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue(value = "3")
public class TA extends User {
    private double avgRating;
    private String college;
}
