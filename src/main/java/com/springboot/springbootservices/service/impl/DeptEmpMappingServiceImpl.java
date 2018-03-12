package com.springboot.springbootservices.service.impl;

import com.springboot.springbootservices.dao.DeptEmpMappingRepository;
import com.springboot.springbootservices.model.DeptEmpMapping;
import com.springboot.springbootservices.service.DeptEmpMappingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DeptEmpMappingServiceImpl implements DeptEmpMappingService{

    @Autowired
    private DeptEmpMappingRepository deptEmpMappingRepository;

    @Override
    public void addDeptEmpMapping(DeptEmpMapping deptEmpMapping) {
        deptEmpMappingRepository.save(deptEmpMapping);
    }
}
