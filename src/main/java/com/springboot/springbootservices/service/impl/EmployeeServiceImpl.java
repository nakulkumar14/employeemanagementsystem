package com.springboot.springbootservices.service.impl;

import com.springboot.springbootservices.dao.EmployeeRepository;
import com.springboot.springbootservices.dao.SalaryRepository;
import com.springboot.springbootservices.enums.Gender;
import com.springboot.springbootservices.model.*;
import com.springboot.springbootservices.request.SaveEmployeeDTO;
import com.springboot.springbootservices.service.DepartmentService;
import com.springboot.springbootservices.service.EmployeeService;
import com.springboot.springbootservices.service.SalaryService;
import com.springboot.springbootservices.service.TitleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    private static final String CLASS = EmployeeServiceImpl.class.getSimpleName();

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private TitleService titleService;

    @Autowired
    private DepartmentService departmentService;

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

    @Override
    public void saveEmployee(SaveEmployeeDTO employeeDTO){
        Employee employee = new Employee();
        employee.setGender(employeeDTO.getGender());
        employee.setDob(employeeDTO.getDob());
        employee.setFirstname(employeeDTO.getFirstname());
        employee.setLastname(employeeDTO.getLastname());
        employee.setHireDate(employeeDTO.getHireDate());

        employeeRepository.save(employee);

        Salary salary = new Salary();
        salary.setSalary(employeeDTO.getSalary());

        SalaryId salaryId = new SalaryId();
        salaryId.setEmployee(employee);
        salaryId.setFromDate(employeeDTO.getHireDate());

        salary.setSalaryId(salaryId);
        salary.setToDate(getFutureDate());

        salaryService.addSalary(salary);

        Title title = new Title();
        title.setToDate(getFutureDate());
        TitleId titleId = new TitleId();
        titleId.setEmployee(employee);
        titleId.setTitle("Manager");
        titleId.setFromDate(employee.getHireDate());
        title.setTitleId(titleId);

        titleService.addTitle(title);

//        DeptEmpMapping deptEmpMapping = new DeptEmpMapping();
//        deptEmpMapping.setFromDate(employeeDTO.getHireDate());
//        deptEmpMapping.setToDate(getFutureDate());
//
//        Department department = departmentService.getById(employeeDTO.getDeptId());
//
//        DeptEmpId deptEmpId = new DeptEmpId();
//        deptEmpId.setDepartment(department);
//        deptEmpId.setEmployee(employee);
//
//        deptEmpMapping.setDeptEmpId(deptEmpId);
    }

    private Date getFutureDate(){
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date());
        instance.add(Calendar.YEAR, 100);
        return instance.getTime();
    }
}
