package com.web.gjg.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.gjg.bean.User;
import com.web.gjg.service.UserService;
 
 
@Controller 
public class UserController {
	@Autowired
	private UserService userService;
	@RequestMapping("/register.action")
    public String register(User user)
    {		  
		if(userService.register(user))
		{
			System.out.println("添加成功！");
		}else{
			System.err.println("error!");
		}
   	    return "login";
    }
	
	@RequestMapping("/login.action")
    public String login(User user)
    {		
		if(user.getRole()==0)
		{
			if(userService.login(user))
			{
				return "admin";
			}else{
				return "login";
			}
		}else{			
			if(userService.login(user))
			{
				//重定向到科目控制器指定路径
				return "redirect:/querySubjects.action";
			}else{
				return "login";
			}
		} 
    }
	@RequestMapping("userPagination.action")
    public String userPagination(Map map,Integer pageIndex)
    {		  
		Integer pageSize=3;
		map.put("users", userService.pagination(pageIndex, pageSize));
		map.put("pageIndex", pageIndex);
		map.put("totalPages", userService.totalPages(pageSize));
   	    return "admin";
    }
	@RequestMapping("/remove.action")
    public String remove(Integer id)
    {		  
		userService.remove(id);
   	    return "login";
    }
	@RequestMapping("/queryUserById.action")
    public String queryUserById(Map map,Integer id)
    {		  
		map.put("user",userService.queryUserById(id));
   	    return "queryUserById";
    }
	@RequestMapping("/modify.action")
    public String modify(User user)
    {		  
		userService.modify(user);
   	    return "login";
    }
}
