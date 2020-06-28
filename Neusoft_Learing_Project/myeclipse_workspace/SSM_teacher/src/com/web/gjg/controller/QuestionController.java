package com.web.gjg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.gjg.service.QuestionService;
 
 
@Controller//��springMVC���ɨ��
public class QuestionController {
  
   @Autowired//��springMVC����Զ�װ��
   private QuestionService questionService;
   @RequestMapping("/question.action")
   public String queryQuestions(Model model,Integer sid)
   {
	   //���������������
	   model.addAttribute("questions", questionService.queryQuestions(sid));
	   return "question";//�¸����ƽ���springMVCƴ�ӳ� /question.jsp
   }
}
