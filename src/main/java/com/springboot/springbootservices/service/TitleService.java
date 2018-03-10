package com.springboot.springbootservices.service;

import com.springboot.springbootservices.model.Title;
import com.springboot.springbootservices.vo.CustomTitleVO;

import java.util.List;

public interface TitleService {

    List<Title> getTitleForEmpId(Long id);
}
