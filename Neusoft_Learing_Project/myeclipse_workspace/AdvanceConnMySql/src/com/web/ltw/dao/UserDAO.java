package com.web.ltw.dao;

import java.util.List;
import com.web.ltw.bean.User;

public interface UserDAO {

		public void register(User user);
		public String login(User user);
		public Integer totalRow();//统计行数
		/*分页的为实现的方法：pageIndex为第几页或者页的索引pageSize为页大小*/
		public List<User> pagination(Integer pageIndex,Integer pageSize);
		
}
