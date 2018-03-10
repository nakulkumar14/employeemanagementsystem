package com.springboot.springbootservices.vo;

import com.springboot.springbootservices.model.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.Date;

@Data
@NoArgsConstructor
public class CustomTitleVO {
    private Long empNo;
    private String title;
    private Date fromDate;
    private Date toDate;

    public CustomTitleVO(Long empNo, String title, Date fromDate, Date toDate) {
        this.empNo = empNo;
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }
}
