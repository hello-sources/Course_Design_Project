package com.web.gjg.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.gjg.bean.User;
import com.web.gjg.service.QuestionService;
import com.web.gjg.service.SubjectService;
import com.web.gjg.service.UserService;
 
 
@Controller 
public class UserController {
  
   @Autowired 
   private UserService userService;
   @Autowired 
   private SubjectService subjectService;
   @RequestMapping("/login.action")
   public String login(HttpSession session,User user)
   {
	   if(user.getRole()==0)
	   {
		   if(userService.login(user))
		   {
			   return "user";
		   }else{
			   return "login";
		   }
	   }else{
		   if(userService.login(user)){
			   session.setAttribute("user", userService.queryUser(user));
			   return "user/homepage";
		   }
		   return "login";
	   }
   }
   
   @RequestMapping("/register.action")
   public String register(User user)
    {		  
		if(userService.register(user))
		{
			System.out.println("添加成功！");
		}else{
			System.err.println("添加失败!");
		}
   	    return "login";
    }
   
   @RequestMapping("/queryUserById.action")
   public String queryUserById(Map map,Integer id)
   {		  
		map.put("user",userService.queryUserById(id));
  	    return "user/queryUserById";
   } 
   
   @RequestMapping("/lookinfo.action")
   public  String  lookinfo(Map map,Integer id)
   {
	   map.put("user", userService.lookinfo(id));
	   return "user/lookinfo";
   }
   
   @RequestMapping("/modify.action")
   public String modify(User user)
   {		  
		userService.modify(user);
  	    return "user/right";
   }
   
   @RequestMapping("/queryGrade.action")
   public String queryGrade(Model model,int id){
		//向服务器发送数据
		model.addAttribute("querygrade", userService.queryGrade(id));
		return "user/querygrade";
	}
     
}