package com.springboot.springbootservices.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "dept_emp")
public class DeptEmpMapping {

    @EmbeddedId
    private DeptEmpId deptEmpId;

    @Column(name = "from_date")
    private Date fromDate;

    @Column(name = "to_date")
    private Date toDate;
}
