package com.web.ltw.service.impl;

import java.util.List;


import com.ltw.encrypt.MyCipher;
import com.web.ltw.bean.User;
import com.web.ltw.dao.UserDAO;
import com.web.ltw.dao.impl.UserDAOImpl;
import com.web.ltw.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO ud=null;//成员对象
    //构造器或构造方法或构造函数：
    //特点：1,与类同名 2，无返回类型 3通常是public
    //作用：初始化成员变量(对象)
    public UserServiceImpl()
    {
        ud=new UserDAOImpl();	
    }
	public boolean login(User user) {
		String pwd="";
		MyCipher mc=new MyCipher();
		pwd=ud.login(user);//通过用户名和角色得到暗码
		String password=mc.decrypt(pwd, "!");//明码
		if(user.getPwd().equals(password))
		{
			return true;
		}else{
		   return false;
		}
	}

	public List<User> pagination(Integer pageIndex, Integer pageSize) {		
		return ud.pagination(pageIndex, pageSize);
	}
	
	public boolean register(User user) {
		boolean flag=false;
		MyCipher mc=new MyCipher();
		user.setPwd(mc.encrypt(user.getPwd(),"!"));
		try {
			ud.register(user);
			flag=true;//无异常时为真
		} catch (Exception e) {
			flag=false;
		}
		return flag;
	}
	public Integer totalPages(Integer pageSize) {
		Integer row=totalRow();//首先得到总行数
		return row%pageSize==0?row/pageSize:row/pageSize+1;
	}

	public Integer totalRow() {		
		return ud.totalRow();
	}

}
