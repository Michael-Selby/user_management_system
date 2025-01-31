package com.AnualProject.January.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="_parent")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String password;

}
