package com.neuedu.reflect;

import java.lang.reflect.Array;

public class Array_test {
	public static void main(String[] args) throws Exception{
		Class<?> classtype = Class.forName("java.lang.String");
		//����һ������Ϊ10���ַ�������
		Object obj = Array.newInstance(classtype,10);
		//������λ��Ϊ5Ԫ������Ϊ��hello��
		Array.set(obj,5,"hello");
		String s = (String)Array.get(obj,5);
		System.out.println(s);
	}

}
