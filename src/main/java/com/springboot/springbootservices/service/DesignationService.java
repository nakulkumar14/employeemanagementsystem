package com.springboot.springbootservices.service;

import com.springboot.springbootservices.model.Designation;

import java.util.List;

public interface DesignationService {

    List<Designation> getAllDesignations();

    void save(Designation designation);
}
