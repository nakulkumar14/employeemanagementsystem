package com.springboot.springbootservices.service;

import com.springboot.springbootservices.model.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> getAllDepartments();

    void addDepartment(Department department);

    Department getById(Integer id);

    Department getByName(String name);

    void removeDepartmentById(Integer id);

    void removeDepartmentByName(String name);
}
