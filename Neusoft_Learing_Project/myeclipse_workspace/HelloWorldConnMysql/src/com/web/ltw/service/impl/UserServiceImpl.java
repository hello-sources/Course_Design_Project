package com.web.ltw.service.impl;

import java.util.List;

import com.ltw.encrypt.MyCipher;
import com.web.ltw.bean.User;
import com.web.ltw.dao.UserDAO;
import com.web.ltw.dao.impl.UserDAOImpl;
import com.web.ltw.service.UserService;

public class UserServiceImpl implements UserService {
	//引用DAOImpl接口，实例化其实现类
	private UserDAO ud = new UserDAOImpl();
	public List<User> queryUsers(){
		List<User> users = null;
		try{
			users = ud.queryUsers();
		}catch(Exception e){
			System.out.println("service:"+e.getMessage());
		}
		return users;
	}
	
	public boolean login(User user) {
		Integer r = 0;
		MyCipher mc = new MyCipher();
		user.setPwd(mc.encrypt(user.getPwd(), "!"));
		try{
			r = ud.login(user);
		}catch(Exception e){
			r = 0;
		}
		return r == 1;
	}
	
	public boolean register(User user) {
		boolean flag = false;
		MyCipher mc = new MyCipher();
		user.setPwd(mc.encrypt(user.getPwd(), "!"));
		try {
			ud.register(user);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		flag = true;//无异常时为真
		
		return flag;
	}

}
