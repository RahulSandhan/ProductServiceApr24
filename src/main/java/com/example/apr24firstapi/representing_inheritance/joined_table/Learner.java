package com.example.apr24firstapi.representing_inheritance.joined_table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Data;

@Data
@PrimaryKeyJoinColumn(name= "user_id")
@Entity(name = "jt_learners")
public class Learner extends User {
    private String college;
    private String company;
}
