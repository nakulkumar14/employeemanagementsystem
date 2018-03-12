package com.springboot.springbootservices.service.impl;

import com.springboot.springbootservices.dao.TitleRepository;
import com.springboot.springbootservices.model.Employee;
import com.springboot.springbootservices.model.Title;
import com.springboot.springbootservices.service.EmployeeService;
import com.springboot.springbootservices.service.TitleService;
import com.springboot.springbootservices.vo.CustomTitleVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class TitleServiceImpl implements TitleService{

    @Autowired
    private TitleRepository titleRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public List<Title> getTitleForEmpId(Long id) {
        return titleRepository.findAllByEmployeeId(id);
    }

    @Override
    public void addTitle(Title title) {
        titleRepository.save(title);
    }
}
