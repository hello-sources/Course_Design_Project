package com.web.gjg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.gjg.service.QuestionService;
 
 
@Controller//由springMVC完成扫描
public class QuestionController {
  
   @Autowired//由springMVC完成自动装配
   private QuestionService questionService;
   @RequestMapping("/question.action")
   public String queryQuestions(Model model,Integer sid)
   {
	   //向服务器发送数据
	   model.addAttribute("questions", questionService.queryQuestions(sid));
	   return "question";//怕个名称将由springMVC拼接成 /question.jsp
   }
}
