package com.springboot.springbootservices.controller;

import com.springboot.springbootservices.model.Department;
import com.springboot.springbootservices.model.Designation;
import com.springboot.springbootservices.service.DesignationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "/getById/{id}")
    public Designation getById(@PathVariable("id") Integer id){
        return designationService.getById(id);
    }

    @GetMapping(value = "/getByName/{name}")
    public Designation getByName(@PathVariable("name") String name){
        return designationService.getByName(name);
    }

    @GetMapping(value = "/removeDesignationById/{id}")
    public void removeDesignationById(@PathVariable("id") Integer id){
        designationService.removeDesignationById(id);
    }

    @GetMapping(value = "/removeDesignationByName/{name}")
    public void removeDesignationByName(@PathVariable("name") String name){
        designationService.removeDesignationByName(name);
    }


}
