package com.web.ltw.mapper;

import com.web.ltw.bean.User;

public interface UserMapper {
	//我的方法名一定出现在Mapper.xmL中的id =“这里”
	//返回类型一定是Mapper.xml中的某个标签的returType
	public Integer getRow();
	public User queryUserById(Integer id);
}
