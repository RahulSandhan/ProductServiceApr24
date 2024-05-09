package com.example.apr24firstapi.representing_inheritance.table_per_class;

import lombok.Data;

@Data
public class TA extends User {
    private double avgRating;
    private String college;
}
