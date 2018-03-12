package com.springboot.springbootservices.request;

import com.springboot.springbootservices.enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class SaveEmployeeDTO {

    private Long empNo;
    private Date dob;
    private String firstname;
    private String lastname;
    private Date hireDate;
    private Gender gender;
    private String deptName;
    private Integer deptId;
    private String title;
    private Integer salary;

}
