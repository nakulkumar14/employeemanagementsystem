package com.springboot.springbootservices.model;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GenericGenerator(name = "sequence_dep_id", strategy = "com.springboot.springbootservices.util.DepartmentIdGenerator")
    @GeneratedValue(generator = "sequence_dep_id")
    @Column(name = "dept_no")
    private String deptNo;

    @Column(name = "dept_name")
    private String deptName;
}
