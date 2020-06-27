package com.web.ltw.service;

import java.util.List;

import com.web.ltw.bean.Question;

public interface QuestionService {
	public List<Question> queryQuestion(Integer sid);
}
