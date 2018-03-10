package com.springboot.springbootservices.dao;

import com.springboot.springbootservices.model.Department;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department,Integer>{

    @Query(value = "select  count(*) from departments", nativeQuery = true)
    Long countAllDepartments();

    Department findByDeptName(String name);
}
