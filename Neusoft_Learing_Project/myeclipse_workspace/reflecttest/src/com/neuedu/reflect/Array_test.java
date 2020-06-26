package com.neuedu.reflect;

import java.lang.reflect.Array;

public class Array_test {
	public static void main(String[] args) throws Exception{
		Class<?> classtype = Class.forName("java.lang.String");
		//创建一个长度为10的字符串数组
		Object obj = Array.newInstance(classtype,10);
		//把索引位置为5元素设置为“hello”
		Array.set(obj,5,"hello");
		String s = (String)Array.get(obj,5);
		System.out.println(s);
	}

}
