package com.springboot.springbootservices.controller;

import com.springboot.springbootservices.model.Title;
import com.springboot.springbootservices.service.TitleService;
import com.springboot.springbootservices.vo.CustomTitleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/title")
public class TitleController {

    @Autowired
    private TitleService titleService;

    @RequestMapping(value = "/getTitleByEmpId/{id}", method = RequestMethod.GET)
    public List<Title> getTitleByEmpId(@PathVariable("id") Long id){
        return titleService.getTitleForEmpId(id);
    }
}
