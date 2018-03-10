package com.springboot.springbootservices.service.impl;

import com.springboot.springbootservices.dao.SalaryRepository;
import com.springboot.springbootservices.model.Employee;
import com.springboot.springbootservices.model.Salary;
import com.springboot.springbootservices.service.EmployeeService;
import com.springboot.springbootservices.service.SalaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@Service
public class SalaryServiceImpl implements SalaryService{

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Salary> getSalaryForEmpId(Long id) {
        List<Salary> salaries = salaryRepository.findAllByEmployeeId(id);
        log.info("Salaries : {}",salaries);
        return salaries;
    }

    @Override
    public List<Salary> getSalaryForEmployeeName(String firstName, String lastName) {
        List<Employee> employees = employeeService.findByFirstNameAndLastName(firstName, lastName);
        if (!CollectionUtils.isEmpty(employees) && employees.size()==1){
            return salaryRepository.findAllByEmployeeId(employees.get(0).getEmpNo());
        }
        return null;
    }
}
