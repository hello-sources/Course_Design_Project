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
		//����Service��
//		UserService us = new  UserServiceImpl();
//		try {
//			for(User user:us.queryUsers()){
//				System.out.println(user.getName()+user.getRealname());
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
		
		//���Լ��ܣ��ѳ�����ܳ�jar��,�����Ϳ��Խ����ļ����䣬���ܽ���
//		MyCipher mc = new MyCipher();
//		String pwd = "admin";
//		String mima = mc.encrypt(pwd, "!");//���� ������Կ
//		System.out.println(mima);
//		System.out.println(mc.decrypt(mima, "!"));//���� 
		
		
		UserService us = new  UserServiceImpl();
		User user = new User();
//		user.setName("���Ĺ�");
//		user.setPwd("44444");
//		user.setPhone("12345678910");
//		user.setRealname("����");
//		user.setMark("programer");
//		user.setRole(1);
//		user.setRegdt("lalala");
//		us.register(user);
		
		user.setName("���Ĺ�");
		user.setPwd("44444");
		user.setRole(1);
		boolean flag = us.login(user);
		System.out.println(flag?"��½�ɹ�":"��½ʧ��");
		
	}

}
