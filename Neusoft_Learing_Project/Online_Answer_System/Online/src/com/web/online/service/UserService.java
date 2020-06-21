package com.web.online.service;

import java.util.List;

import com.web.online.bean.User;

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
	public List<User> queryInfoById(int id);
	public boolean insertCGrade(User user);
	public boolean insertCppGrade(User user);
	public boolean insertJavaGrade(User user);
	public boolean insertNetGrade(User user);
	public boolean insertPythonGrade(User user);
	public List<User> queryCGradeById(int id);
	public List<User> queryCppGradeById(int id);
	public List<User> queryJavaGradeById(int id);
	public List<User> queryNetGradeById(int id);
	public List<User> queryPythonGradeById(int id);
	public boolean deleteUser(int u_id);
}
