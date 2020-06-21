package com.web.gjg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.gjg.bean.Question;
import com.web.gjg.bean.User;
import com.web.gjg.mapper.QuestionMapper;
import com.web.gjg.service.QuestionService;


@Service  //��spring�л�����ɨ�����
public class QuestionServiceImpl implements QuestionService {

	@Autowired //��spring�Զ�װ��ע��ʵ�������QuestionMapper����
	private QuestionMapper questionMapper;
	public List<Question> queryQuestions(Integer sid) { 
		return questionMapper.queryQuestions(sid);
	}
	

}
