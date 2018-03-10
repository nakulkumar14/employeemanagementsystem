package com.springboot.springbootservices.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "salaries")
@Data
public class Salary {

    @EmbeddedId
    private SalaryId salaryId;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "to_date")
    private Date toDate;
}