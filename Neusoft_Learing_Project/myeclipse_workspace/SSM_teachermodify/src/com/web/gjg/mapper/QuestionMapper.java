package com.web.gjg.mapper;

import java.util.List;
import com.web.gjg.bean.Question;
public interface QuestionMapper {
   public List<Question> queryQuestions(Integer sid);
}
