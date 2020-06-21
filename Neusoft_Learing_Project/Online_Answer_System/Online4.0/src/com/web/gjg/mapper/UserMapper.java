package com.web.gjg.mapper;
/*����һ���ӿ�,����ʵ���ļ���UserMapper.xml
 * 
 * */

import java.util.List;

import com.web.gjg.bean.User;

public interface UserMapper { 
    public Integer getRow();
    public User queryUserById(Integer id);//�޸�ǰ�Ĳ�ѯ
    public void modify(User user);
    public void register(User user);
    public String login(User user);
    public User queryUser(User user);
    public List<User> pagination(Integer start,Integer pageSize);
    public void remove(Integer id);//����ɾ������,ͨ��idɾ��
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

}
