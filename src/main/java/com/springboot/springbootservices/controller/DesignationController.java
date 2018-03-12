package com.springboot.springbootservices.controller;

import com.springboot.springbootservices.model.Designation;
import com.springboot.springbootservices.service.DesignationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/designation")
public class DesignationController {

    private static final String CLASS = DesignationController.class.getSimpleName();

    @Autowired
    private DesignationService designationService;

    @RequestMapping(value = "/getAllDesignations",method = RequestMethod.GET)
    public List<Designation> getAllDesignations(){
        return designationService.getAllDesignations();
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public void save(@RequestBody Designation designation){
        designationService.save(designation);
    }
}
