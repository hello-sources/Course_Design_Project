package com.web.gjg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.gjg.bean.Question;
import com.web.gjg.service.QuestionService;
 
 
@Controller//��springMVC���ɨ��
public class QuestionController {
  
   @Autowired//��springMVC����Զ�װ��
   private QuestionService questionService;
   
   //�������Ա���ȡ�����źʹ�
   List<Question> questions;
   //������ż�
   List<Integer> qids=new ArrayList<Integer>();
   //��ȷ�𰸼�
   List<String> correctAnswers=new ArrayList<String>();   
    //��ѡ�𰸽����
   List<String> selectAnswers=new ArrayList<String>();
   
   @RequestMapping("/question.action")
   public String queryQuestions(Model model,Integer sid)
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
	   model.addAttribute("questions", questions);
	   return "question";//�¸����ƽ���springMVCƴ�ӳ� /question.jsp
   }
   @RequestMapping("/reply.action")
   public String reply(Model model,HttpServletRequest req)
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
	   return "result"; 
   }
}
