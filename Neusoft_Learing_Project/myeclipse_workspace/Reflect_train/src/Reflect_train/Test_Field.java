package Reflect_train;

import java.lang.reflect.Field;

public class Test_Field {

	/**
	 * author ������ΰ
	 * time:2019/7/10
	 * location:�����A9 301����
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str = "Reflect_train.Student_2";
		Class cla = Class.forName(str);
		//������й��еĳ�Ա����getFields
		//������еĳ�Ա���� gerDeclaredFields
		//��ȡĳ�������ֶβ��ҵ�����getField
		//��ȡĳ��(������˽�е�)�ֶ���getDeclaredField
		Field[] field = cla.getFields();
		for(Field f:field){
			System.out.println(f);
		}
		
		Field field1 = cla.getField("name");
		System.out.println(field1);
		Object obj = cla.getConstructor().newInstance();
		String str1 = "����ΰ";
		field1.set(obj,str1);
		Student_2 stu = (Student_2)obj;
		System.out.println(stu.name);
	}

}
