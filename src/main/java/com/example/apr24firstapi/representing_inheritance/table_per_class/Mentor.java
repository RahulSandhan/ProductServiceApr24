package com.example.apr24firstapi.representing_inheritance.table_per_class;

import lombok.Data;

@Data
public class Mentor extends User {
    private String company;
    private double avgRating;
}
