package com.web.gjg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.gjg.bean.Question;
import com.web.gjg.bean.User;
import com.web.gjg.mapper.QuestionMapper;
import com.web.gjg.service.QuestionService;


@Service  //在spring中会配置扫描此类
public class QuestionServiceImpl implements QuestionService {

	@Autowired //让spring自动装配注入实例化后的QuestionMapper对象
	private QuestionMapper questionMapper;
	public List<Question> queryQuestions(Integer sid) { 
		return questionMapper.queryQuestions(sid);
	}
	

}
