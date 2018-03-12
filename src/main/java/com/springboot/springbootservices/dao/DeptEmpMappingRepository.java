package com.springboot.springbootservices.dao;

import com.springboot.springbootservices.model.DeptEmpId;
import com.springboot.springbootservices.model.DeptEmpMapping;
import org.springframework.data.repository.CrudRepository;

public interface DeptEmpMappingRepository extends CrudRepository<DeptEmpMapping, DeptEmpId>{
}
