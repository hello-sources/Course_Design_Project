package Reflect_train;

import java.lang.reflect.Constructor;

public class Test_Constructor {

	/**
	 * author :李天伟
	 * time :2019/7/9
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//注意区别对待getDeclaredConstructors(所有的构造方法),与getDeclaredConstructor(获取某个（包括私有的）构造方法)
		//以及getConstructor(默认获取某个公有的构造方法) getConstructors(获取所有公有的构造方法)之间不同的区别
		String str = "Reflect_train.Student";
		Class cla = Class.forName(str);
		
		Constructor[] con = cla.getDeclaredConstructors();
		for(Constructor c :con){
			System.out.println(c);
		}
		
		
		//由于无参数的构造方法所以类型是一个null，不写也可以，
		//返回的是描述这个无参构造函数的类对象
		Constructor con1 = cla.getConstructor(null);
		System.out.println("con1 = "+con1);
		Object obj = con1.newInstance();

		
		Constructor con2 = cla.getDeclaredConstructor(float.class);
		System.out.println(con2);
		//setAccessible是采用暴力破解的方法来获取私有类的权限的
		con2.setAccessible(true);
		obj = con2.newInstance(182.2f);
		//System.out.println(182.20);
	}

}
