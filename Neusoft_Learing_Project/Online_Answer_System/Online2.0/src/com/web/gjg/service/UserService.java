package com.web.gjg.service;

import java.util.List;

import com.web.gjg.bean.User;

public interface UserService {
	public Integer getRow();
    public User queryUserById(Integer id);
    public boolean modify(User user);
    public boolean register(User user);
    public boolean login(User user);
    public User queryUser(User user);
    public List<User> pagination(Integer pageIndex,Integer pageSize);
    public Integer totalPages(Integer pageSize);
    public boolean remove(Integer id);
	public User lookinfo(Integer id);
	public List<User> queryGrade(int id);
	public boolean updateCGrade(User user);
	public boolean updateCppGrade(User user);
	public boolean updateJavaGrade(User user);
	public boolean updateNetGrade(User user);
	public boolean updatePythonGrade(User user);

}
