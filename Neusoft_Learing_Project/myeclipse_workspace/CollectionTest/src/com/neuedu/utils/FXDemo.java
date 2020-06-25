package com.neuedu.utils;

import java.util.*;

public class FXDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,User> map = new HashMap();
		User user = new User();
		user.setId(1);
		user.setPassword("jack");
		user.setUsername("jack");
		
		User user1 = new User();
		user1.setId(1);
		user1.setPassword("rose");
		user1.setUsername("rose");
		
		map.put("hello",user);
		map.put("world",user1);
		
		map.get("hell");
		
		//按照键来进行遍历的，按照键遍历对应的都是键
		User us = (User)map.get("hell");
		Set<String> ks = map.keySet();
		Iterator<String> its = ks.iterator();
		while(its.hasNext()){
			String key = its.next();
			User value = map.get(key);
			System.out.println("key   "+key+"值  "+value.getId()+"是账号  "+value.getPassword()+"是密码  "+value.getUsername()+"是用户名");
		}
		
		
		
		//按照键来进行遍历的，按照键遍历对应的都是键
//		Set<Map.Entry<String, User>> es = map.entrySet();
//		Iterator<Map.Entry<String, User>> it = es.iterator();
//		while(it.hasNext()){
//			Map.Entry<String, User> en = it.next();
//			User value = en.getValue();
//			String key = en.getKey();
//			System.out.println("键是："+key+"值是："+value);
//		}
		
		
		//按照值进行遍历，需要用到Collections接口的方法,所有对应的都是对应的值
		//如果出现对于有的是类的情况，在遍历的时候需要具体到类中具体的方法，要不然输出的就是类似于地址的东西
		Collection<User> co = map.values();
		Iterator<User> it = co.iterator();
		while(it.hasNext()){
			User value = it.next();
			System.out.println("（value）ID是"+value.getId()+"密码"+value.getPassword()+"用户名是"+value.getUsername());
		}
		
		
		//最厉害的一种方法就是把Map放到List泛型里面，然后按照list的遍历来求解，后面对应的还是按照键值对来进行遍历
		List<Map<String,User>> list = new ArrayList<Map<String,User>>();
		list.add(map);
		for(Map<String,User> m:list){
			for(String key:m.keySet()){
				System.out.println(key+" : "+m.get(key).getId()+" : "+m.get(key).getPassword()+" : "+m.get(key).getUsername());
			}
		}
	}

}
