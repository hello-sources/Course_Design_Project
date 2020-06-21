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
 
 
@Controller//��springMVC���ɨ��
public class QuestionController {
  
   @Autowired//��springMVC����Զ�װ��
   private QuestionService questionService;
   @Autowired//��springMVC����Զ�װ��
   private UserService userService;
   //�������Ա���ȡ�����źʹ�
   List<Question> questions;
   //������ż�
   List<Integer> qids=new ArrayList<Integer>();
   //��ȷ�𰸼�
   List<String> correctAnswers=new ArrayList<String>();   
    //��ѡ�𰸽����
   List<String> selectAnswers=new ArrayList<String>();
   
   @RequestMapping("/question.action")
   public String queryQuestions(HttpSession session,int sid)
   { 
	   //�������
	   qids.clear();
	   correctAnswers.clear();
	   selectAnswers.clear();
	   questions=questionService.queryQuestions(sid);
	  
	   for(Question q:questions)
	   {
		   qids.add(q.getQid()); 
		   correctAnswers.add(q.getAnswer()); 
	   }
	   //���������������
	   session.setAttribute("questions", questions);
	   session.setAttribute("s_id", sid);
	   return "user/question";//�¸����ƽ���springMVCƴ�ӳ� /question.jsp
   }
   @RequestMapping("/reply.action")
   public String reply(Model model,HttpServletRequest req,String sId, String score, String uId)
   { 
		
	   System.out.print("\nѡ��𰸣�");
	   for(int i=0;i<qids.size();i++)
	   {
		   selectAnswers.add(req.getParameter("a"+qids.get(i))); 
		   System.out.print(selectAnswers.get(i));
	   }
	   Integer result=0; 
	   System.out.println("\n===========================");
	   //�жϽ��
	   System.out.print("��ȷ�𰸣�");
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
