package com.springboot.springbootservices.dao;

import com.springboot.springbootservices.enums.Gender;
import com.springboot.springbootservices.model.Employee;
import com.sun.tools.javah.Gen;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

    Page<Employee> findAll(Pageable pageable);

    Page<Employee> findByGender(Gender gender, Pageable pageable);

    List<Employee> findByDobBetween(Date startDate, Date endDate);

    List<Employee> findTopByGender(Gender gender);

    List<Employee> findTop5ByLastname(String lastname);

    List<Employee> findTop5ByLastnameOrderByEmpNoDesc(String lastname);

    List<Employee> findByFirstnameLikeAndGender(String firstname, Gender gender);

    Long countDistinctByGender(Gender gender);

}
