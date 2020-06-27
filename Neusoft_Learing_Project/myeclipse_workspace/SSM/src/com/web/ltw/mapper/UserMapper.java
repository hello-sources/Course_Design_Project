package com.web.ltw.mapper;

import java.util.List;

import com.web.ltw.bean.User;

public interface UserMapper {
	//�ҵķ�����һ��������Mapper.xmL�е�id =�����
	//��������һ����Mapper.xml�е�ĳ����ǩ��returType
	public Integer getRow();
	public User queryUserById(Integer id);//�޸�ǰ�Ĳ�ѯ
	public void modify(User user);
	public void register(User user);
	public String login(User user);
	public List<User> pagination(Integer start,Integer pageSize);
	public void remove(Integer id);
}
