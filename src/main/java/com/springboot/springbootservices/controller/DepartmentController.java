package com.springboot.springbootservices.controller;

import com.springboot.springbootservices.model.Department;
import com.springboot.springbootservices.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/getAllDepartments",method = RequestMethod.GET)
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }
}
