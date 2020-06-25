package com.neuedu.service.impl;

import com.neuedu.service.IStudent;
import com.neuedu.service.ITeacher;

public class StudentImpl implements IStudent,ITeacher{
	public String getUsername(){
		return null;
	}
	
	public String getTeacher(){
		return null;
	}
	public static void main(String[] args) throws Exception{
		ITeacher iteacher = new StudentImpl();
		IStudent istu = new StudentImpl();
		StudentImpl stu = new StudentImpl();
		iteacher = stu;//上溯
		stu = (StudentImpl)iteacher;//下溯强制转换
		try{
			IStudent is = null;
			is.getUsername();//空指针异常
		}catch(NullPointerException e){
			e.printStackTrace();
		}
		int[] iArray = new int[3];
		iArray[0] = 1;
		iArray[1] = 2;
		iArray[2] = 3;
		//iArray[3] = 4;
		int num = 0;
		while(num < 3){
			System.out.println(iArray[num]);
			num++;
		}
	}
}
