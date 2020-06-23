package com.web.ltw.service;

import java.util.List;

import com.web.ltw.bean.User;

public interface UserService {
	public boolean register(User user);
	public boolean login(User user);
	public Integer totalRow();//统计行数
	public List<User> pagination(Integer pageIndex,Integer pageSize);
	public Integer totalPages(Integer pageSize);//计算总页数

}
