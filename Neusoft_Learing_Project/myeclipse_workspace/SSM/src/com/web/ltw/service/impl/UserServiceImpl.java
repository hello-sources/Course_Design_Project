package com.web.ltw.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ltw.encrypt.MyCipher;
import com.web.ltw.bean.User;
import com.web.ltw.dao.BaseDAO;
import com.web.ltw.mapper.UserMapper;
import com.web.ltw.service.UserService;


public class UserServiceImpl implements UserService {
	//����BaseDAO
	BaseDAO bd = new BaseDAO();
	//���ýӿ�
	SqlSession sqlSession = bd.getSession();//myeclipse����Ҫ������һ��
	UserMapper um = sqlSession.getMapper(UserMapper.class);//ע��˴��иĶ�
	public Integer getRow(){
		return um.getRow();
	}
	public boolean login(User user){
		MyCipher mc = new MyCipher();	//ע�����
//		pwd = um.login(user); //ͨ���û����ͽ�ɫ�õ�����
		String password = mc.decrypt(um.login(user),"!");//����
		return  user.getPwd().equals(password);
	}
	public List<User> pagination(Integer pageIndex,Integer pageSize){
		Integer start = (pageIndex - 1)*pageSize;
		return um.pagination(start, pageSize);
		
	}
	public User queryUserById(Integer id){
		return um.queryUserById(id);
	}
	public boolean register(User user){
		Boolean flag = false;
		try {
			MyCipher mc = new MyCipher();
			user.setPwd(mc.encrypt(user.getPwd(), "!"));//��������ܴ浽���ݿ���
			//����ע��Ľ�ɫֻ����ͨ�û�
			user.setRole(1);
			um.register(user);
			sqlSession.commit();//myeclipse�����汾��Ҫ����
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			sqlSession.rollback();//�ع�
			System.out.println(e.getMessage());
		}
		return flag;
	}
	public Integer totalPages(Integer pageSize) {
		Integer row = getRow();
		if (row%pageSize ==0) {
			return row/pageSize;
		}else{
			return row/pageSize+1;
		}
		//Math.ceil(a);
	}
	public boolean remove(Integer id) {
		Boolean flag = false;
		try {
			um.remove(id);
			sqlSession.commit();//myeclipse�����汾��Ҫ����
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			sqlSession.rollback();//�ع�
			System.out.println(e.getMessage());
		}
		return flag;
	}
	public boolean modify(User user) {
		Boolean flag = false;
		try {
			MyCipher mc = new MyCipher();
			user.setPwd(mc.encrypt(user.getPwd(), "!"));//��������ܴ浽���ݿ���
			//����ע��Ľ�ɫֻ����ͨ�û�
			um.modify(user);
			sqlSession.commit();//myeclipse�����汾��Ҫ����
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			sqlSession.rollback();//�ع�
			System.out.println(e.getMessage());
		}
		return flag;
	}

}
