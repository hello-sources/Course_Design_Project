package com.web.gjg.ui;

import com.web.gjg.bean.User;
import com.web.gjg.service.UserService;
import com.web.gjg.service.impl.UserServiceImpl;

public class Manager { 
	public static void registerAdmin()
	{
		UserService us=new UserServiceImpl();
		User user=new User();
		user.setName("admin");
		user.setPwd("admin");
		user.setPhone("13000000000");
		user.setRealname("张磊");
		user.setMark("超级管理员");
		user.setRole(0);
		Boolean flag=us.register(user);
		System.out.println(flag?"ok":"no");
	}
	public static void registerUser()
	{
		UserService us=new UserServiceImpl();
		User user=new User();
		user.setName("zhaoliu");
		user.setPwd("666");
		user.setPhone("13666666666");
		user.setRealname("赵六");
		user.setMark("名人之4");
		user.setRole(1);
		Boolean flag=us.register(user);
		System.out.println(flag?"ok":"no");
	}
	public static void loginAdmin()
	{
		UserService us=new UserServiceImpl();
		User user=new User();
		user.setName("admin");
		user.setPwd("admin"); 
		user.setRole(0);
		Boolean flag=us.login(user);
		if(flag)
		{
		    System.out.println("登录成功");	
		}else{
			System.out.println("登录失败");
		}
	}
	public static void main(String[] args) {
		//registerAdmin();
		//registerUser();
		//loginAdmin();
		UserService us=new UserServiceImpl();
		Integer pageIndex=1;
		Integer pageSize=5;
		for(User user:us.pagination(pageIndex, pageSize))
		{
			System.out.println(user.getRealname());
		} 
	}

}
