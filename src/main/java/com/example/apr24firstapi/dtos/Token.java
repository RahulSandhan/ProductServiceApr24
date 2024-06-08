package com.example.apr24firstapi.dtos;

import lombok.Data;
import java.util.Date;

@Data
public class Token {
    private int id;
    private String value;
    private User user;
    private Date expiresAt;
    private boolean isActive; //by default its value will be true, when we want to delete it - we will set it to false
}