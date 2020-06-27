package com.web.ltw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.ltw.service.QuestionService;

@Controller//有springmvc完成扫描
public class QuestionController {
	
	@Autowired//有springmvc完成自动装配
	private QuestionService questionService;
	@RequestMapping("/question.action")
	public String queryQuestion(Model model,Integer sid){
		//向服务器发送数据
		model.addAttribute("question",questionService.queryQuestion(sid));
		return "question";//这个名称将由springMVC拼接而成 /question.jsp
	}
}
