package com.web.online.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.online.bean.Question;
import com.web.online.bean.User;
import com.web.online.mapper.QuestionMapper;
import com.web.online.service.QuestionService;


@Service  //在spring中会配置扫描此类
public class QuestionServiceImpl implements QuestionService {

	@Autowired //让spring自动装配注入实例化后的QuestionMapper对象
	private QuestionMapper questionMapper;
	public List<Question> queryQuestions(Integer sid) { 
		return questionMapper.queryQuestions(sid);
	}
	public boolean addQuestion(Question newquestion) {
		return questionMapper.addQuestion(newquestion);
	}
	public boolean deleteQuestion(int qId) {
		return questionMapper.deleteQuestion(qId);
	}
	public List<Question> allQuestions() {
		return questionMapper.allQuestions();
	}
	

}
