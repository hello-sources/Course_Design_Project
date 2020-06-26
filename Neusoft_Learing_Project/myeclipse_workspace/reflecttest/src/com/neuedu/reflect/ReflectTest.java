package com.neuedu.reflect;

public class ReflectTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//第一种方法
		Student stu = new Student();
		Class cs = stu.getClass();
		cs.getName();
		System.out.println(cs.getName());
	}

}
