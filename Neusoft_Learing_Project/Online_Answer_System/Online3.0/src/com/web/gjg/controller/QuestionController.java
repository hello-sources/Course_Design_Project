package com.web.gjg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.gjg.bean.Question;
import com.web.gjg.bean.User;
import com.web.gjg.service.QuestionService;
import com.web.gjg.service.UserService;
 
 
@Controller//由springMVC完成扫描
public class QuestionController {
  
   @Autowired//由springMVC完成自动装配
   private QuestionService questionService;
   @Autowired//由springMVC完成自动装配
   private UserService userService;
   //保存题以备提取随机题号和答案
   List<Question> questions;
   //随机题编号集
   List<Integer> qids=new ArrayList<Integer>();
   //正确答案集
   List<String> correctAnswers=new ArrayList<String>();   
    //单选答案结果集
   List<String> selectAnswers=new ArrayList<String>();
   
   @RequestMapping("/question.action")
   public String queryQuestions(HttpSession session,int sid)
   { 
	   //清空数据
	   qids.clear();
	   correctAnswers.clear();
	   selectAnswers.clear();
	   questions=questionService.queryQuestions(sid);
	  
	   for(Question q:questions)
	   {
		   qids.add(q.getQid()); 
		   correctAnswers.add(q.getAnswer()); 
	   }
	   //向服务器发送数据
	   session.setAttribute("questions", questions);
	   session.setAttribute("s_id", sid);
	   return "user/question";//怕个名称将由springMVC拼接成 /question.jsp
   }
   @RequestMapping("/reply.action")
   public String reply(Model model,HttpServletRequest req,String sId, String score, String uId)
   { 
		
	   System.out.print("\n选择答案：");
	   for(int i=0;i<qids.size();i++)
	   {
		   selectAnswers.add(req.getParameter("a"+qids.get(i))); 
		   System.out.print(selectAnswers.get(i));
	   }
	   Integer result=0; 
	   System.out.println("\n===========================");
	   //判断结果
	   System.out.print("正确答案：");
	   for(int i=0;i<correctAnswers.size();i++)
	   {
		   String ca=correctAnswers.get(i);
		   System.out.print(""+ca);
		   String sa=selectAnswers.get(i);
		   if(ca.equals(sa))
		   {
			   result+=2;
		   }
	   } 
		
	   model.addAttribute("nums", qids.size()); 
	   model.addAttribute("result", result);
	   model.addAttribute("correctAnswers",correctAnswers);
	   model.addAttribute("selectAnswers", selectAnswers);
	   return "user/result"; 
   }
   
}
