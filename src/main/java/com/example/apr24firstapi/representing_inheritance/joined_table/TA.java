package com.example.apr24firstapi.representing_inheritance.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@Entity(name = "jt_tas")
@PrimaryKeyJoinColumn(name= "user_id")
public class TA extends User {
    private double avgRating;
    private String college;
}
