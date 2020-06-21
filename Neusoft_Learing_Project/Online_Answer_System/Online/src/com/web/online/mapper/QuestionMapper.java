package com.web.online.mapper;

import java.util.List;

import com.web.online.bean.Question;
import com.web.online.bean.User;
public interface QuestionMapper {
   public List<Question> queryQuestions(Integer sid);
   public boolean addQuestion(Question newquestion);
   public boolean deleteQuestion(int qId);
   public List<Question> allQuestions();
  
}
