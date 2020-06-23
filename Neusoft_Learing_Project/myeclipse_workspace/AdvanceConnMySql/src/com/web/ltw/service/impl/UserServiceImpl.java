package com.web.ltw.service.impl;

import java.util.List;


import com.ltw.encrypt.MyCipher;
import com.web.ltw.bean.User;
import com.web.ltw.dao.UserDAO;
import com.web.ltw.dao.impl.UserDAOImpl;
import com.web.ltw.service.UserService;

public class UserServiceImpl implements UserService {
    private UserDAO ud=null;//��Ա����
    //���������췽�����캯����
    //�ص㣺1,����ͬ�� 2���޷������� 3ͨ����public
    //���ã���ʼ����Ա����(����)
    public UserServiceImpl()
    {
        ud=new UserDAOImpl();	
    }
	public boolean login(User user) {
		String pwd="";
		MyCipher mc=new MyCipher();
		pwd=ud.login(user);//ͨ���û����ͽ�ɫ�õ�����
		String password=mc.decrypt(pwd, "!");//����
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
			flag=true;//���쳣ʱΪ��
		} catch (Exception e) {
			flag=false;
		}
		return flag;
	}
	public Integer totalPages(Integer pageSize) {
		Integer row=totalRow();//���ȵõ�������
		return row%pageSize==0?row/pageSize:row/pageSize+1;
	}

	public Integer totalRow() {		
		return ud.totalRow();
	}

}
