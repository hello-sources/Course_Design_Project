package com.web.gjg.service;

import java.util.List;

import com.web.gjg.bean.User;

public interface UserService {
	public Integer getRow();
    public User queryUserById(Integer id);
    public boolean modify(User user);
    public boolean register(User user);
    public boolean login(User user);
    public List<User> pagination(Integer pageIndex,Integer pageSize);
    public Integer totalPages(Integer pageSize);
    public boolean remove(Integer id);
}
