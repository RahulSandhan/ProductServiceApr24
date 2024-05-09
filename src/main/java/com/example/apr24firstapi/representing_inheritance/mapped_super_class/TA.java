package com.example.apr24firstapi.representing_inheritance.mapped_super_class;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity(name = "msc_ta")
public class TA extends User{
    private double avgRating;
    private String college;
}
