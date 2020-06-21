package com.web.gjg.mapper;
/*这是一个接口,它的实现文件是UserMapper.xml
 * 
 * */

import java.util.List;

import com.web.gjg.bean.User;

public interface UserMapper { 
    public Integer getRow();
    public User queryUserById(Integer id);//修改前的查询
    public void modify(User user);
    public void register(User user);
    public String login(User user);
    public User queryUser(User user);
    public List<User> pagination(Integer start,Integer pageSize);
    public void remove(Integer id);//增加删除功能,通过id删除
	public User lookinfo(Integer id);
	public List<User> queryGrade(int id);
	public boolean updateCGrade(User user);
	public boolean updateCppGrade(User user);
	public boolean updateJavaGrade(User user);
	public boolean updateNetGrade(User user);
	public boolean updatePythonGrade(User user);

}
