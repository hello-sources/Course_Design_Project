package com.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bean.Student;
import com.bean.Teacher;

public class SpringManager {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext ac = 
			new ClassPathXmlApplicationContext("spring.xml");
		//为啥要强制类型转换
		String str = (String)ac.getBean("str");
//		System.out.println(str);
//		Student stu1 = ac.getBean("stu1",Student.class);
//		System.out.println(stu1);
		//默认调用.toString()，可以写也可以不写
		
//		Student stu2 = ac.getBean("stu2",Student.class);
//		System.out.println(stu2);
		
//		Student stu3 = ac.getBean("stu3",Student.class);
//		System.out.println(stu3);
		
		Teacher tea = ac.getBean(Teacher.class);
		System.out.println(tea.getStudent());
		
	}

}
