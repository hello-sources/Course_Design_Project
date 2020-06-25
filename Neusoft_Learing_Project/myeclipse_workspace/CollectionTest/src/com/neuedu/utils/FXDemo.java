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
		
		//���ռ������б����ģ����ռ�������Ӧ�Ķ��Ǽ�
		User us = (User)map.get("hell");
		Set<String> ks = map.keySet();
		Iterator<String> its = ks.iterator();
		while(its.hasNext()){
			String key = its.next();
			User value = map.get(key);
			System.out.println("key   "+key+"ֵ  "+value.getId()+"���˺�  "+value.getPassword()+"������  "+value.getUsername()+"���û���");
		}
		
		
		
		//���ռ������б����ģ����ռ�������Ӧ�Ķ��Ǽ�
//		Set<Map.Entry<String, User>> es = map.entrySet();
//		Iterator<Map.Entry<String, User>> it = es.iterator();
//		while(it.hasNext()){
//			Map.Entry<String, User> en = it.next();
//			User value = en.getValue();
//			String key = en.getKey();
//			System.out.println("���ǣ�"+key+"ֵ�ǣ�"+value);
//		}
		
		
		//����ֵ���б�������Ҫ�õ�Collections�ӿڵķ���,���ж�Ӧ�Ķ��Ƕ�Ӧ��ֵ
		//������ֶ����е������������ڱ�����ʱ����Ҫ���嵽���о���ķ�����Ҫ��Ȼ����ľ��������ڵ�ַ�Ķ���
		Collection<User> co = map.values();
		Iterator<User> it = co.iterator();
		while(it.hasNext()){
			User value = it.next();
			System.out.println("��value��ID��"+value.getId()+"����"+value.getPassword()+"�û�����"+value.getUsername());
		}
		
		
		//��������һ�ַ������ǰ�Map�ŵ�List�������棬Ȼ����list�ı�������⣬�����Ӧ�Ļ��ǰ��ռ�ֵ�������б���
		List<Map<String,User>> list = new ArrayList<Map<String,User>>();
		list.add(map);
		for(Map<String,User> m:list){
			for(String key:m.keySet()){
				System.out.println(key+" : "+m.get(key).getId()+" : "+m.get(key).getPassword()+" : "+m.get(key).getUsername());
			}
		}
	}

}
