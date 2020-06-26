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
		
		
		//���ն���Field,�Լ�Constructor����⣬������ȵ�
		//getMethods��ȡ���й��еĹ��췽��
		//getMethod��ȡĳ�����еĹ��췽��
		//getDeclaredMethods��ȡ���еĹ��췽��
		//getDeclaredMethod��ȡĳ�����췽����������˽�еģ�
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
			System.out.println("��Ӧ�ķ���ֵ�ǣ�"+obj1);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
