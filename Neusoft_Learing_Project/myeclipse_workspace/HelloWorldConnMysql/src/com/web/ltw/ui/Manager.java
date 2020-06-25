package com.web.ltw.ui;

import com.ltw.encrypt.MyCipher;
import com.web.ltw.bean.User;
import com.web.ltw.service.UserService;
import com.web.ltw.service.impl.UserServiceImpl;

public class Manager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//引用Service层
//		UserService us = new  UserServiceImpl();
//		try {
//			for(User user:us.queryUsers()){
//				System.out.println(user.getName()+user.getRealname());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
		
		//测试加密，把程序加密成jar包,着样就可以进行文件传输，加密解密
//		MyCipher mc = new MyCipher();
//		String pwd = "admin";
//		String mima = mc.encrypt(pwd, "!");//加密 ！是密钥
//		System.out.println(mima);
//		System.out.println(mc.decrypt(mima, "!"));//解密 
		
		
		UserService us = new  UserServiceImpl();
		User user = new User();
//		user.setName("李四光");
//		user.setPwd("44444");
//		user.setPhone("12345678910");
//		user.setRealname("李四");
//		user.setMark("programer");
//		user.setRole(1);
//		user.setRegdt("lalala");
//		us.register(user);
		
		user.setName("李四光");
		user.setPwd("44444");
		user.setRole(1);
		boolean flag = us.login(user);
		System.out.println(flag?"登陆成功":"登陆失败");
		
	}

}
