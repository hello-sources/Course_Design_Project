package com.neuedu.reflect;

public class Student {
//	public Student(){
//		
//	}
//	public String getName(){
//		System.out.println("I am in Student.getName()");
//		return "";
//	}
	String name;
	
	public String getName(){
		System.out.println(name);
		return name;
	}
	
	public void setName(String name){
		System.out.println("000000");
		this.name = name;
	}
}
