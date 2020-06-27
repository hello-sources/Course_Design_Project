package com.web.ltw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ltw.bean.Question;
import com.web.ltw.mapper.QuestionMapper;
import com.web.ltw.service.QuestionService;

@Service //在spring中会配置扫描此类
public class QuestionServiceImpl implements QuestionService {
	
	
	@Autowired//让spring自动装配注入实例化后的QuestionMapper对象
	private QuestionMapper questionMapper;
	public List<Question> queryQuestion(Integer sid) {
		// TODO Auto-generated method stub
		return questionMapper.queryQuestion(sid);
	}

}
