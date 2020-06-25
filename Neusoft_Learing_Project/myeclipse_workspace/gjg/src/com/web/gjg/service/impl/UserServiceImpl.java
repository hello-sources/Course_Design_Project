package com.web.gjg.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.gjg.encrypt.MyCipher;
import com.web.gjg.bean.User;
import com.web.gjg.dao.BaseDAO;
import com.web.gjg.mapper.UserMapper;
import com.web.gjg.service.UserService;

public class UserServiceImpl implements UserService {
    //����BaseDAO
	BaseDAO bd=new BaseDAO();
	//���ýӿ�
	SqlSession sqlSession=bd.getSession();//myeclipse�����汾����ϣ�1��
	UserMapper  um=sqlSession.getMapper(UserMapper.class);//ע��˴��иĶ�
	public Integer getRow() {		
		return um.getRow();
	}

	public boolean login(User user) {  
		MyCipher mc=new MyCipher(); 
		String password=mc.decrypt(um.login(user), "!"); 
		return user.getPwd().equals(password);
	}

	public List<User> pagination(Integer pageIndex, Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		return um.pagination(start, pageSize);
	}

	public User queryUserById(Integer id) { 
		return um.queryUserById(id);
	}

	public boolean register(User user) { 
		Boolean flag=false;
		try {
			MyCipher mc=new MyCipher(); 
			user.setPwd(mc.encrypt(user.getPwd(),"!"));//��������ܴ浽���ݿ���
			//����ע��Ľ�ɫֻ������ͨ�û�
			user.setRole(1);
			um.register(user);
			sqlSession.commit();//myeclipse�����汾����ϣ�2��
			flag=true;
		} catch (Exception e) {
			sqlSession.rollback();//�ع�
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public Integer totalPages(Integer pageSize) {
		Integer row=getRow();
		if(row%pageSize==0)
		{
			return row/pageSize;
		}else{
			return row/pageSize+1;		
		}
		//Math.ceil(a)
	}

	public boolean remove(Integer id) {
		Boolean flag=false;
		try {  
			um.remove(id);
			sqlSession.commit();//myeclipse�����汾����ϣ�2��
			flag=true;
		} catch (Exception e) {
			sqlSession.rollback();//�ع�
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public boolean modify(User user) {
		Boolean flag=false;
		try {
			MyCipher mc=new MyCipher(); 
			user.setPwd(mc.encrypt(user.getPwd(),"!"));//��������ܴ浽���ݿ��� 
			um.modify(user);
			sqlSession.commit();//myeclipse�����汾����ϣ�2��
			flag=true;
		} catch (Exception e) {
			sqlSession.rollback();//�ع�
			System.out.println(e.getMessage());
		}
		return flag;
	}

}
