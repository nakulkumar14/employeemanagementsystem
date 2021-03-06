package com.springboot.springbootservices.service;

import com.springboot.springbootservices.enums.Gender;
import com.springboot.springbootservices.model.CustomObject;
import com.springboot.springbootservices.model.Employee;
import com.springboot.springbootservices.request.SaveEmployeeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees();

    Page<Employee> getEmployees(Pageable pageable);

    Page<Employee> findByGender(Gender gender, Pageable pageable);

    List<Employee> findByDobBetween(Date startDate, Date endDate);

    List<Employee> findTopByGender(Gender gender);

    List<Employee> findTop5ByLastname(String lastname);

    List<Employee> findTop5ByLastnameOrderByEmpNoDesc(String lastname);

    List<Employee> findByFirstnameLikeAndGender(String firstname, Gender gender);

    Long countDistinctByGender(Gender gender);

    void addEmployee(Employee employee);

    void deleteEmployeeById(Long id);

    List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

    List<CustomObject> test();

    void saveEmployee(SaveEmployeeDTO employeeDTO);
}
