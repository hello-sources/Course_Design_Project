package com.web.online.service.impl;

import java.util.List;
 
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.stereotype.Service;

import com.web.online.bean.Subject;
import com.web.online.mapper.SubjectMapper;
import com.web.online.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
    private SubjectMapper subjectMapper; 
	public List<Subject> querySubjects() {  
		PropertyPlaceholderConfigurer a;
		SqlSessionFactoryBean b;
		MapperFactoryBean c;
		return subjectMapper.querySubjects();
	}

}
