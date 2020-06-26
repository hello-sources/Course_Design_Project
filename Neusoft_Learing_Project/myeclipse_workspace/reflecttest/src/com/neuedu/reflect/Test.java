package com.neuedu.reflect;

import java.lang.reflect.Method;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//表示类的全路字符串
		String strStu = "com.neuedu.reflect.Student";
		//方法名的字符串
		String strName = "setName";
		//1.全路径加载类
		//Student s = new Student();
		//s.getClass();
		//Class cc = Studnet.class;
		Class stuClass = Class.forName(strStu);//在不知道class内部的类型用
		Class[] strClass = {String.class};//注意就一个值，但是可以有多个，毕竟为数组
		//2.用setName签名，使用类获取setName方法
		//strName代表函数名，strClass代表参数是Class类型的数组
		Method setName = stuClass.getMethod(strName, strClass);
		//3.创建用于Studdent的对象，相当于new Student()
		Object stu = stuClass.getConstructor().newInstance();//工厂模式
		String[] str = {new String("bbbb")};
		//4.使用反射机制调用Student的setName方法（真正的反射机制）
		//stu代表对象，str代表setName方法的参数值
		setName.invoke(stu, str);
		//调用Student的getName方法，下溯
		//Student st = new Student();
		//st.getName();
		((Student)stu).getName();//并没有用到反射机制
	}
}
