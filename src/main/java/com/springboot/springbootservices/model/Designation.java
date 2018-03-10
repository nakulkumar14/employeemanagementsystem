package com.springboot.springbootservices.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "designation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;
}
