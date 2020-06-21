package com.web.online.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.online.service.QuestionService;
import com.web.online.service.SubjectService;
 
 
@Controller 
public class SubjectController {
	@Autowired
	private SubjectService subjectService;
	 @RequestMapping("/querySubjects.action")
    public String querySubjects(Map  map)
    {		  
   	  map.put("subjects", subjectService.querySubjects());
   	  return "user/onlineexam";
    }
}
