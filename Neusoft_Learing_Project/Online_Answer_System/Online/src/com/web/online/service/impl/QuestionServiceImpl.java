package com.web.online.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.online.bean.Question;
import com.web.online.bean.User;
import com.web.online.mapper.QuestionMapper;
import com.web.online.service.QuestionService;


@Service  //��spring�л�����ɨ�����
public class QuestionServiceImpl implements QuestionService {

	@Autowired //��spring�Զ�װ��ע��ʵ�������QuestionMapper����
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
