package com.web.gjg.service;

import java.util.List;

import com.web.gjg.bean.Question;

public interface QuestionService {
	public List<Question> queryQuestions(Integer sid);
}
