package com.springboot.springbootservices.dao;

import com.springboot.springbootservices.model.Designation;
import org.springframework.data.repository.CrudRepository;

public interface DesignationRepository extends CrudRepository<Designation,Integer>{

    Designation findByName(String name);
}
