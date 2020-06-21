package com.web.gjg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gjg.encrypt.MyCipher;
import com.web.gjg.bean.User; 
import com.web.gjg.mapper.UserMapper;
import com.web.gjg.service.UserService;

@Service 
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper  userMapper;
	public Integer getRow() {		
		return userMapper.getRow();
	}

	public boolean login(User user) {  
		MyCipher mc=new MyCipher(); 
		String password=mc.decrypt(userMapper.login(user), "!"); 
		return user.getPwd().equals(password);
	}
	public User queryUser(User user) { 
		return userMapper.queryUser(user);
	}
	public List<User> pagination(Integer pageIndex, Integer pageSize) {
		Integer start=(pageIndex-1)*pageSize;
		return userMapper.pagination(start, pageSize);
	}

	public User queryUserById(Integer id) { 
		return userMapper.queryUserById(id);
	}

	public boolean register(User user) { 
		Boolean flag=false;
		try {
			MyCipher mc=new MyCipher(); 
			user.setPwd(mc.encrypt(user.getPwd(),"!"));//将明码加密存到数据库中
			//设置注册的角色只能是普通用户
			user.setRole(1);
			userMapper.register(user); 
			flag=true;
		} catch (Exception e) { 
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
			userMapper.remove(id); 
			flag=true;
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public boolean modify(User user) {
		Boolean flag=false;
		try {
			MyCipher mc=new MyCipher(); 
			user.setPwd(mc.encrypt(user.getPwd(),"!"));//将明码加密存到数据库中 
			userMapper.modify(user); 
			flag=true;
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}
		return flag;
	}

	public User lookinfo(Integer id) {
		return userMapper.lookinfo(id);
	}

	public List<User> queryInfoById(int id) {
		return userMapper.queryInfoById(id);
	}

	public boolean insertCGrade(User user) {
		return userMapper.insertCGrade(user);
	}

	public boolean insertCppGrade(User user) {
		return userMapper.insertCppGrade(user);
	}

	public boolean insertJavaGrade(User user) {
		return userMapper.insertJavaGrade(user);
	}

	public boolean insertNetGrade(User user) {
		return userMapper.insertNetGrade(user);
	}

	public boolean insertPythonGrade(User user) {
		return userMapper.insertPythonGrade(user);
	}

	public List<User> queryCGradeById(int id) {
		return userMapper.queryCGradeById(id);
	}

	public List<User> queryCppGradeById(int id) {
		return userMapper.queryCppGradeById(id);
	}

	public List<User> queryJavaGradeById(int id) {
		return userMapper.queryJavaGradeById(id);
	}

	public List<User> queryNetGradeById(int id) {
		return userMapper.queryNetGradeById(id);
	}

	public List<User> queryPythonGradeById(int id) {
		return userMapper.queryPythonGradeById(id);
	}

	

}
