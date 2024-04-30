package com.example.apr24firstapi.dtos;

import com.example.apr24firstapi.models.Category;
import lombok.Data;

@Data
public class FakeProductServiceDto {
    private long id;
    private String title;
    private double price;
    private String description;
    private String image;
    private String category;
}
