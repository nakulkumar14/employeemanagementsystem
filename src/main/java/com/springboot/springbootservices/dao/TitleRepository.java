package com.springboot.springbootservices.dao;

import com.springboot.springbootservices.model.Employee;
import com.springboot.springbootservices.model.Title;
import com.springboot.springbootservices.model.TitleId;
import com.springboot.springbootservices.vo.CustomTitleVO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TitleRepository extends CrudRepository<Title, TitleId>{

    List<Title> findAllByTitleId_Title(String title);

    @Query(value = "select NEW com.springboot.springbootservices.vo.CustomTitleVO(t.titleId.employee.empNo, t.titleId.title, t.titleId.fromDate, t.toDate) from Title t where t.titleId.employee.empNo = ?1")
    List<Title> findAllByEmployeeId(Long id);
}
