package com.web.ltw.service;

import java.util.List;

import com.web.ltw.bean.User;

public interface UserService {
	public List<User> queryUsers() ;
	public boolean register(User user);
	public boolean login(User user);
}
