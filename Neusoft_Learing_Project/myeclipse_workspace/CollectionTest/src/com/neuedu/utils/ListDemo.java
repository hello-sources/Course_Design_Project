package com.neuedu.utils;

import java.util.*;

public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		//接口不能实例化
//		List list = new ArrayList();
//		//基本数据类型放成包装类
//		list.add("11");
//		list.add("22");
//		list.add("33");
//		for(int i = 0;i < list.size();i++){
//			System.out.println("第"+(i+1)+"个元素"+list.get(i));
//		}
//		//注意for循环函数里面的东西
//		int j = 0;
//		for(Object obj:list){
//			j++;
//			System.out.println("第"+j+"个元素"+list.get(j));
//		}
		
		
		
		
		List<User> list = new ArrayList();
		User user = new User();
		User user1  =new User();
		User user2 = new User();
		user.setId(1);
		user.setPassword("lalal");
		user.setUsername("zhangsan");
		user1.setId(2);
		user1.setPassword("lalala");
		user1.setUsername("zhangsan2");
		user2.setId(3);
		user2.setPassword("lalalal");
		user2.setUsername("zhangsan3");
		list.add(user);
		list.add(user1);
		list.add(user2);
		for(User u:list){
			System.out.println(u.getId()+":"+u.getPassword()+":"+u.getUsername());
		}
	}
}
