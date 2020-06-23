package com.web.ltw.ui;

import com.web.ltw.bean.User;
import com.web.ltw.service.UserService;
import com.web.ltw.service.impl.UserServiceImpl;

public class Manager {
	public static void registerAdmin(){
		UserService us = new UserServiceImpl();
		User user = new User();
		user.setName("admin2");
		user.setPwd("admin");
		user.setPhone("12345678910");
		user.setRealname("����");
		user.setMark("��������Ա");
		user.setRole(0);
		Boolean flag = us.register(user);
		System.out.println(flag?"yes":"no");
	}
	
	public static void registerUser(){
		UserService us = new UserServiceImpl();
		User user = new User();
		user.setName("����1");
		user.setPwd("3333");
		user.setPhone("12345678910");
		user.setRealname("����");
		user.setMark("����Ա");
		user.setRole(1);
		Boolean flag = us.register(user);
		System.out.println(flag?"yes":"no");
	}
	
	public static void loginAdmin(){
		UserService us = new UserServiceImpl();
		User user = new User();
		user.setName("admin");
		user.setPwd("admin");
		user.setRole(0);
		Boolean flag = us.register(user);
		if(flag){
			System.out.println("��½�ɹ�");
		}else{
			System.out.println("��½ʧ��");
		}
	}
	
	public static void main(String[] srgs){
//		registerAdmin();
//		registerUser();
//		loginAdmin();
		UserService us = new UserServiceImpl();
		Integer pageIndex = 3;
		Integer pageSize = 2;
		for(User user:us.pagination(pageIndex, pageSize)){
			System.out.println(user.getName());
		}
		
	}
}
