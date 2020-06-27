package com.web.ltw.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.web.ltw.bean.Subject;
import com.web.ltw.mapper.SubjectMapper;
import com.web.ltw.service.SubjectService;
public class SubjectServiceImpl implements SubjectService{
    private SubjectMapper subjectMapper;
    //����ķ���������spring�����ļ����ע��
    //����˼��������
	public void setSubjectMapper(SubjectMapper subjectMapper) {
		this.subjectMapper = subjectMapper;
	}

	public List<Subject> querySubjects() { 
		PropertyPlaceholderConfigurer a;
		SqlSessionFactoryBean b;
		MapperFactoryBean c;
		return subjectMapper.querySubjects();
	}

}
