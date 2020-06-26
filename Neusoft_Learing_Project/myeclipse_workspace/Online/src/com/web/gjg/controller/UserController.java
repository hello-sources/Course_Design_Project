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
			   return "admin/admin";
		   }else{
			   return "login";
		   }
	   }else{
		   if(userService.login(user)){
			   session.setAttribute("user", userService.queryUser(user));//jsp .action?uid=${user.id}
//			   session.setAttribute("u_id", userService.queryUser(user).getId());//jsp .action?uid=${u_id}
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
   
//   @RequestMapping("/queryGrade.action")
//   public String queryGrade(Model model,int id){
//		//向服务器发送数据
//		model.addAttribute("querygrade", userService.queryGrade(id));
//		return "user/querygrade";
//	}
	@RequestMapping("/insertGrade.action")
	public String insertGrade(Model model,String sId, String score, String uId){
		
		try {
			
			int score1 = Integer.parseInt(score);
			int uId1 = Integer.parseInt(uId);
			String subject = "";
			User user=new User();
			user.setId(uId1);
			if(sId.equals("101")){
				user.setCgrade(score1);
				model.addAttribute("queryallgrades", userService.insertCGrade(user));
			}else if(sId.equals("102")){
				user.setCppgrade(score1);
				model.addAttribute("queryallgrades", userService.insertCppGrade(user));
			}else if(sId.equals("103")){
				user.setJavagrade(score1);
				model.addAttribute("queryallgrades", userService.insertJavaGrade(user));
			}else if(sId.equals("104")){
				user.setNetgrade(score1);
				model.addAttribute("queryallgrades", userService.insertNetGrade(user));
			}else if(sId.equals("105")){
				user.setPythongrade(score1);
				model.addAttribute("queryallgrades", userService.insertPythonGrade(user));
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return "user/right";
	}
	
	//姓名查询成绩
	@RequestMapping("/queryInfoById.action")
	public String queryGradeById(Model model,int id){
		//向服务器发送数据
		model.addAttribute("queryinfobyid", userService.queryInfoById(id));
		model.addAttribute("querycgradebyid", userService.queryCGradeById(id));
		model.addAttribute("querycppgradebyid", userService.queryCppGradeById(id));
		model.addAttribute("queryjavagradebyid", userService.queryJavaGradeById(id));
		model.addAttribute("querynetgradebyid", userService.queryNetGradeById(id));
		model.addAttribute("querypythongradebyid", userService.queryPythonGradeById(id));
		
		return "user/querygrade";
	}
}