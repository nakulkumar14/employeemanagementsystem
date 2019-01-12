package com.springboot.springbootservices.service.impl;

import com.springboot.springbootservices.dao.DesignationRepository;
import com.springboot.springbootservices.model.Designation;
import com.springboot.springbootservices.service.DesignationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class DesignationServiceImpl implements DesignationService{

    private static final String CLASS = DesignationServiceImpl.class.getSimpleName();

    @Autowired
    private DesignationRepository designationRepository;

    @Override
    public List<Designation> getAllDesignations() {
        return (List<Designation>) designationRepository.findAll();
    }

    @Override
    public void save(Designation designation) {
        designation.setName(designation.getName().toUpperCase());
        designationRepository.save(designation);
    }

    @Override
    public Designation getById(Integer id) {
        return designationRepository.findOne(id);
    }

    @Override
    public Designation getByName(String name) {
        return designationRepository.findByName(name);
    }

    @Override
    public void removeDesignationById(Integer id) {
        designationRepository.delete(id);
    }

    @Override
    public void removeDesignationByName(String name) {
        Designation designation = designationRepository.findByName(name);
        designationRepository.delete(designation.getId());
    }
}
