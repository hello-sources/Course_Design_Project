package com.web.ltw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.ltw.bean.Question;
import com.web.ltw.mapper.QuestionMapper;
import com.web.ltw.service.QuestionService;

@Service //��spring�л�����ɨ�����
public class QuestionServiceImpl implements QuestionService {
	
	
	@Autowired//��spring�Զ�װ��ע��ʵ�������QuestionMapper����
	private QuestionMapper questionMapper;
	public List<Question> queryQuestion(Integer sid) {
		// TODO Auto-generated method stub
		return questionMapper.queryQuestion(sid);
	}

}
