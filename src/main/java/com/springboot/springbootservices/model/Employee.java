package com.springboot.springbootservices.model;

import com.springboot.springbootservices.enums.Gender;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public @Data class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no")
    private Long empNo;

    @Column(name = "birth_date")
    private Date dob;

    @Column(name = "first_name")
    private String firstname;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "hire_date")
    private Date hireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;
}
