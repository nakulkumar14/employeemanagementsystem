package com.springboot.springbootservices.controller;

import com.springboot.springbootservices.model.Salary;
import com.springboot.springbootservices.service.SalaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/salary")
public class SalaryController {

    private static final String CLASS = SalaryController.class.getSimpleName();

    @Autowired
    private SalaryService salaryService;

    @RequestMapping(value = "/getSalaryForEmpId/{id}", method = RequestMethod.GET)
    public List<Salary> getSalaryForEmpId(@PathVariable("id") Long id){
        return salaryService.getSalaryForEmpId(id);
    }

    @RequestMapping(value = "/getSalaryForEmployeeName/{firstName}/{lastName}",method = RequestMethod.GET)
    public List<Salary> getSalaryForEmployeeName(@PathVariable("firstName") String firstName, @PathVariable("lastName") String lastName){
        return salaryService.getSalaryForEmployeeName(firstName, lastName);
    }
}
