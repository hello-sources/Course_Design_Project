package com.web.gjg.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
   public String queryQuestions(Model model,int sid)
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
	   model.addAttribute("s_id", sid);
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
   
   @RequestMapping("/updateGrade.action")
   public String updateGrade(Model model,String sId, String score, String uId){
		
		try {
			
			int score1 = Integer.parseInt(score);
			int uId1 = Integer.parseInt(uId);
			String subject = "";
			User user=new User();
			user.setId(uId1);
			if(sId.equals("101")){
				user.setCgrade(score1);
				model.addAttribute("queryallgrades", userService.updateCGrade(user));
			}else if(sId.equals("102")){
				user.setCppgrade(score1);
				model.addAttribute("queryallgrades", userService.updateCppGrade(user));
			}else if(sId.equals("103")){
				user.setJavagrade(score1);
				model.addAttribute("queryallgrades", userService.updateJavaGrade(user));
			}else if(sId.equals("104")){
				user.setNetgrade(score1);
				model.addAttribute("queryallgrades", userService.updateNetGrade(user));
			}else if(sId.equals("105")){
				user.setPythongrade(score1);
				model.addAttribute("queryallgrades", userService.updatePythonGrade(user));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "admin/updategrade";
	}
}
