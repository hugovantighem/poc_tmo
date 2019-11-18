package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "T_PATIENT")
public class Patient {

    @Id
    public Long id;
    public String firstname;
    public String lastname;
    public String email;
}