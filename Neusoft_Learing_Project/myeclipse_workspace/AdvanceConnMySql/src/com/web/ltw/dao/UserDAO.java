package com.web.ltw.dao;

import java.util.List;
import com.web.ltw.bean.User;

public interface UserDAO {

		public void register(User user);
		public String login(User user);
		public Integer totalRow();//ͳ������
		/*��ҳ��Ϊʵ�ֵķ�����pageIndexΪ�ڼ�ҳ����ҳ������pageSizeΪҳ��С*/
		public List<User> pagination(Integer pageIndex,Integer pageSize);
		
}
