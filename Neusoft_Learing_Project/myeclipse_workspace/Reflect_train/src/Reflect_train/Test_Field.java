package Reflect_train;

import java.lang.reflect.Field;

public class Test_Field {

	/**
	 * author ：李天伟
	 * time:2019/7/10
	 * location:东软睿道A9 301教室
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str = "Reflect_train.Student_2";
		Class cla = Class.forName(str);
		//获得所有公有的成员变量getFields
		//获得所有的成员变量 gerDeclaredFields
		//获取某个公有字段并且调用用getField
		//获取某个(可以是私有的)字段用getDeclaredField
		Field[] field = cla.getFields();
		for(Field f:field){
			System.out.println(f);
		}
		
		Field field1 = cla.getField("name");
		System.out.println(field1);
		Object obj = cla.getConstructor().newInstance();
		String str1 = "李天伟";
		field1.set(obj,str1);
		Student_2 stu = (Student_2)obj;
		System.out.println(stu.name);
	}

}
