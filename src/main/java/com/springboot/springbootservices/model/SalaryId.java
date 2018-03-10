package com.springboot.springbootservices.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Data
@Embeddable
public class SalaryId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name="emp_no")
    private Employee employee;

    @Column(name = "from_date")
    private Date fromDate;
}