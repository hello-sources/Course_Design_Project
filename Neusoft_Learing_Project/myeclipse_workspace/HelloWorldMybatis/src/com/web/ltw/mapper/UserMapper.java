package com.web.ltw.mapper;

import com.web.ltw.bean.User;

public interface UserMapper {
	//�ҵķ�����һ��������Mapper.xmL�е�id =�����
	//��������һ����Mapper.xml�е�ĳ����ǩ��returType
	public Integer getRow();
	public User queryUserById(Integer id);
}
