package com.web.ltw.mapper;

import java.util.List;

import com.web.ltw.bean.Question;

public interface QuestionMapper {
	public List<Question> queryQuestion(Integer sid);
	
	
}
