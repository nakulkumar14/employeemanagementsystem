//package com.springboot.springbootservices.model;
//
//import lombok.Data;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
//import java.io.Serializable;
//
//@Data
//@Embeddable
//public class DeptEmpId implements Serializable{
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="emp_no")
//    private Employee employee;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name="dept_id")
//    private Department department;
//}
