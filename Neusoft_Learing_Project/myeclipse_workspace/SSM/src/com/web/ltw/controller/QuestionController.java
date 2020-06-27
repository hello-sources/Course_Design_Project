package com.web.ltw.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.ltw.service.QuestionService;

@Controller//��springmvc���ɨ��
public class QuestionController {
	
	@Autowired//��springmvc����Զ�װ��
	private QuestionService questionService;
	@RequestMapping("/question.action")
	public String queryQuestion(Model model,Integer sid){
		//���������������
		model.addAttribute("question",questionService.queryQuestion(sid));
		return "question";//������ƽ���springMVCƴ�Ӷ��� /question.jsp
	}
}
