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
    private UserMapper userMapper;  
	public Integer getRow() {		
		return userMapper.getRow();
	}

	public boolean login(User user) {  
		MyCipher mc=new MyCipher(); 
		String password=mc.decrypt(userMapper.login(user), "!"); 
		return user.getPwd().equals(password);
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
			user.setPwd(mc.encrypt(user.getPwd(),"!")); 
			userMapper.modify(user); 
			flag=true;
		} catch (Exception e) { 
			System.out.println(e.getMessage());
		}
		return flag;
	}

}
