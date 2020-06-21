package com.web.online.service;

import java.util.List;

import com.web.online.bean.Question;
import com.web.online.bean.User;


public interface QuestionService {
	public List<Question> queryQuestions(Integer sid);
	   public boolean addQuestion(Question newquestion);
	   public boolean deleteQuestion(int qId);
	   public List<Question> allQuestions();

}
