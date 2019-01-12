package com.springboot.springbootservices.service.impl;

import com.springboot.springbootservices.dao.DepartmentRepository;
import com.springboot.springbootservices.model.Department;
import com.springboot.springbootservices.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DepartmentServiceImpl implements DepartmentService{

    private static final String CLASS = DepartmentServiceImpl.class.getSimpleName();

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartments() {
        return (List<Department>) departmentRepository.findAll();
    }

    @Override
    public void addDepartment(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department getById(Integer id) {
        return departmentRepository.findOne(id);
    }

    @Override
    public Department getByName(String name) {
        return departmentRepository.findByDeptName(name);
    }

    @Override
    public void removeDepartmentById(Integer id) {
        departmentRepository.delete(id);
    }

    @Override
    public void removeDepartmentByName(String name) {
        Department department = departmentRepository.findByDeptName(name);
        departmentRepository.delete(department.getId());
    }
}
