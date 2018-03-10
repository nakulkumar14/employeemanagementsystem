package com.springboot.springbootservices.service.impl;

import com.springboot.springbootservices.dao.EmployeeRepository;
import com.springboot.springbootservices.enums.Gender;
import com.springboot.springbootservices.model.CustomObject;
import com.springboot.springbootservices.model.Employee;
import com.springboot.springbootservices.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Slf4j
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public Page<Employee> findByGender(Gender gender, Pageable pageable) {
        return employeeRepository.findByGender(gender,pageable);
    }

    @Override
    public Page<Employee> getEmployees(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findByDobBetween(Date startDate, Date endDate) {
        return employeeRepository.findByDobBetween(startDate, endDate);
    }

    @Override
    public List<Employee> findTopByGender(Gender gender) {
        return employeeRepository.findTopByGender(gender);
    }

    @Override
    public List<Employee> findTop5ByLastname(String lastname) {
        return employeeRepository.findTop5ByLastname(lastname);
    }

    @Override
    public List<Employee> findTop5ByLastnameOrderByEmpNoDesc(String lastname) {
        return employeeRepository.findTop5ByLastnameOrderByEmpNoDesc(lastname);
    }

    @Override
    public List<Employee> findByFirstnameLikeAndGender(String firstname, Gender gender) {
        return employeeRepository.findByFirstnameLikeAndGender(firstname,gender);
    }

    @Override
    public Long countDistinctByGender(Gender gender) {
        return employeeRepository.countDistinctByGender(gender);
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.delete(id);
    }

    @Override
    public List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {
        return employeeRepository.findByFirstnameAndLastname(firstName, lastName);
    }

    @Override
    public List<CustomObject> test() {
        List<CustomObject> customObjectList = employeeRepository.findCustomObjects();
        log.info("customObjectList : {}",customObjectList);
        return customObjectList;
    }
}
