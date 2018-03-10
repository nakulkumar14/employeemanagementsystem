package com.springboot.springbootservices.controller;

import com.springboot.springbootservices.model.Department;
import com.springboot.springbootservices.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/addDepartment", method = RequestMethod.POST)
    public void addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
    }

    @RequestMapping(value = "/getById/{id}",method = RequestMethod.GET)
    public Department getById(@PathVariable("id") Integer id){
        return departmentService.getById(id);
    }

    @RequestMapping(value = "/getByName/{name}", method = RequestMethod.GET)
    public Department getByName(@PathVariable("name") String name){
        return departmentService.getByName(name);
    }
}
