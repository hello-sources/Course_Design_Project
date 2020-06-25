package com.web.ltw.dao;

import java.util.List;

import com.web.ltw.bean.User;

public interface UserDAO {
	/*
	 * 定义了一组标准，只能定义常量或者没有实现的抽象的公共的方法
	 * 
	 */
	public List<User> queryUsers() throws Exception ;
	public void register(User user) throws Exception ;
	public Integer login(User user) throws Exception ;
	
}
