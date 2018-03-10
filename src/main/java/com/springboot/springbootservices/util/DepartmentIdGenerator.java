package com.springboot.springbootservices.util;

import com.springboot.springbootservices.dao.DepartmentRepository;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class DepartmentIdGenerator implements IdentifierGenerator {

    @Autowired
    private DepartmentRepository departmentRepository;

    private static final String PREFIX = "d";

    @Override
    public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        Long noOfDepartments = departmentRepository.countAllDepartments();
        String ZEROS = ((int) (Math.log10(noOfDepartments + 1) + 1) < 2) ? "00" : "0";
        String id = PREFIX + ZEROS + (noOfDepartments + 1);
        return id;
    }

}