package com.springboot.springbootservices.dao;

import com.springboot.springbootservices.model.Salary;
import com.springboot.springbootservices.model.SalaryId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SalaryRepository extends CrudRepository<Salary,SalaryId> {

    @Query(value = "select NEW com.springboot.springbootservices.vo.CustomSalaryVO(s.salaryId.employee.empNo, s.salaryId.fromDate, s.salary, s.toDate) from Salary s where s.salaryId.employee.empNo = ?1")
    List<Salary> findAllByEmployeeId(Long id);
}
