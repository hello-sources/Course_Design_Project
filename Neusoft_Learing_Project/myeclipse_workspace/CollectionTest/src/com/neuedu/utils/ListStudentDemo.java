package com.neuedu.utils;

import java.util.*;

public class ListStudentDemo {
	public static void main(String[] args) throws Exception{
		List<Student> list = new ArrayList();
		Student stu = new Student();
		Student stu1 = new Student();
		Student stu2 = new Student();
		stu.setName("¸ÉÀ¬»ø");
		stu.setAge(10);
		stu.setId("¸ÉÀ¬»øÊÇÀ¬»ø");
		
		stu1.setName("ÊªÀ¬»ø");
		stu1.setAge(20);
		stu1.setId("ÊªÀ¬»øÒ²ÊÇÀ¬»ø");
		list.add(stu);
		list.add(stu1);
		for(Student us:list){
			System.out.println(us.getAge()+us.getName()+us.getId());	
		}
	
	}
}
