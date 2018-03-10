package com.springboot.springbootservices.service;

import com.springboot.springbootservices.model.Salary;

import java.util.List;

public interface SalaryService {

    List<Salary> getSalaryForEmpId(Long id);

    List<Salary> getSalaryForEmployeeName(String firstName, String lastName);
}
