package com.neuedu.utils;

import java.util.*;

public class MapDemo {
	public static void main(String[] args){
		Map map = new HashMap();
		User user = new User();
		user.setId(1);
		user.setUsername("ÕÅÈı");
		user.setPassword("yes");
		map.put("id",user);
		map.put("user","hello");
		map.get("id");
		User us = (User)map.get("id");
		System.out.println(us.getId()+"  "+us.getPassword()+"  "+us.getUsername());
		System.out.println("×Ö·û´®"+map.get("user"));
	}
}
