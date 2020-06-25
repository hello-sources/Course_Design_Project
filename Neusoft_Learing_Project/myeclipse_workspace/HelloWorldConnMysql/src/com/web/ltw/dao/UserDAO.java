package com.web.ltw.dao;

import java.util.List;

import com.web.ltw.bean.User;

public interface UserDAO {
	/*
	 * ������һ���׼��ֻ�ܶ��峣������û��ʵ�ֵĳ���Ĺ����ķ���
	 * 
	 */
	public List<User> queryUsers() throws Exception ;
	public void register(User user) throws Exception ;
	public Integer login(User user) throws Exception ;
	
}
