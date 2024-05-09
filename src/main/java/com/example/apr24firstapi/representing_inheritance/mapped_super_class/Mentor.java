package com.example.apr24firstapi.representing_inheritance.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_mentor")
public class Mentor extends User{
    private String company;
    private double avgRating;
}
