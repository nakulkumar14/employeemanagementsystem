package com.springboot.springbootservices.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class CustomSalaryVO {
    private Long empNo;
    private Date fromDate;
    private Integer salary;
    private Date toDate;

    public CustomSalaryVO(Long empNo, Date fromDate, Integer salary, Date toDate) {
        this.empNo = empNo;
        this.fromDate = fromDate;
        this.salary = salary;
        this.toDate = toDate;
    }

    public CustomSalaryVO(Date fromDate, Integer salary, Date toDate) {
        this.fromDate = fromDate;
        this.salary = salary;
        this.toDate = toDate;
    }

    public CustomSalaryVO(Integer salary, Date toDate) {
        this.salary = salary;
        this.toDate = toDate;
    }
}
