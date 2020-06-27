package com.web.ltw.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ltw.encrypt.MyCipher;
import com.web.ltw.bean.User;
import com.web.ltw.dao.BaseDAO;
import com.web.ltw.mapper.UserMapper;
import com.web.ltw.service.UserService;


public class UserServiceImpl implements UserService {
	//引用BaseDAO
	BaseDAO bd = new BaseDAO();
	//引用接口
	SqlSession sqlSession = bd.getSession();//myeclipse上需要加上这一句
	UserMapper um = sqlSession.getMapper(UserMapper.class);//注意此处有改动
	public Integer getRow(){
		return um.getRow();
	}
	public boolean login(User user){
		MyCipher mc = new MyCipher();	//注册加密
//		pwd = um.login(user); //通过用户名和角色得到暗码
		String password = mc.decrypt(um.login(user),"!");//明码
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
			user.setPwd(mc.encrypt(user.getPwd(), "!"));//将明码加密存到数据库中
			//设置注册的角色只是普通用户
			user.setRole(1);
			um.register(user);
			sqlSession.commit();//myeclipse其他版本需要加上
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			sqlSession.rollback();//回滚
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
			sqlSession.commit();//myeclipse其他版本需要加上
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			sqlSession.rollback();//回滚
			System.out.println(e.getMessage());
		}
		return flag;
	}
	public boolean modify(User user) {
		Boolean flag = false;
		try {
			MyCipher mc = new MyCipher();
			user.setPwd(mc.encrypt(user.getPwd(), "!"));//将明码加密存到数据库中
			//设置注册的角色只是普通用户
			um.modify(user);
			sqlSession.commit();//myeclipse其他版本需要加上
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			sqlSession.rollback();//回滚
			System.out.println(e.getMessage());
		}
		return flag;
	}

}
