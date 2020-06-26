package Reflect_train;

import java.lang.reflect.Method;

public class Test_Method {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str = "Reflect_train.Student_1";
		Class cla = Class.forName(str);
		
		
		//按照对于Field,以及Constructor的理解，可以类比到
		//getMethods获取所有公有的构造方法
		//getMethod获取某个公有的构造方法
		//getDeclaredMethods获取所有的构造方法
		//getDeclaredMethod获取某个构造方法（可以是私有的）
		cla.getMethods();
		Method[] method = cla.getMethods();
		for(Method m:method){
			System.out.println(m);
		}
		
		Method[] method1 = cla.getDeclaredMethods();
		for(Method m1:method1){
			System.out.println(m1);
		}
		try{
			Method method2 = cla.getDeclaredMethod("show3", int.class);
			System.out.println(method2);
			method2.setAccessible(true);
			Object obj = cla.newInstance();
			Object obj1 = method2.invoke(obj,666);
			//method2.invoke(obj, 666);
			//((Student_1)obj).show3(666);
			System.out.println("对应的返回值是："+obj1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
