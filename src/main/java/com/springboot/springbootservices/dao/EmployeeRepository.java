package com.springboot.springbootservices.dao;

import com.springboot.springbootservices.enums.Gender;
import com.springboot.springbootservices.model.CustomObject;
import com.springboot.springbootservices.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
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

    List<Employee> findByFirstnameAndLastname(String firstname,String lastname);

    @Query(value = "select NEW com.springboot.springbootservices.model.CustomObject(e.gender, count(e.gender)) from Employee e group by e.gender")
    List<CustomObject> findCustomObjects();
}
