package com.neuedu.utils;

import java.util.*;

public class ListStudentDemo {
	public static void main(String[] args) throws Exception{
		List<Student> list = new ArrayList();
		Student stu = new Student();
		Student stu1 = new Student();
		Student stu2 = new Student();
		stu.setName("������");
		stu.setAge(10);
		stu.setId("������������");
		
		stu1.setName("ʪ����");
		stu1.setAge(20);
		stu1.setId("ʪ����Ҳ������");
		list.add(stu);
		list.add(stu1);
		for(Student us:list){
			System.out.println(us.getAge()+us.getName()+us.getId());	
		}
	
	}
}
