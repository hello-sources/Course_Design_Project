package com.neuedu.reflect;

import java.lang.reflect.Method;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//��ʾ���ȫ·�ַ���
		String strStu = "com.neuedu.reflect.Student";
		//���������ַ���
		String strName = "setName";
		//1.ȫ·��������
		//Student s = new Student();
		//s.getClass();
		//Class cc = Studnet.class;
		Class stuClass = Class.forName(strStu);//�ڲ�֪��class�ڲ���������
		Class[] strClass = {String.class};//ע���һ��ֵ�����ǿ����ж�����Ͼ�Ϊ����
		//2.��setNameǩ����ʹ�����ȡsetName����
		//strName����������strClass���������Class���͵�����
		Method setName = stuClass.getMethod(strName, strClass);
		//3.��������Studdent�Ķ����൱��new Student()
		Object stu = stuClass.getConstructor().newInstance();//����ģʽ
		String[] str = {new String("bbbb")};
		//4.ʹ�÷�����Ƶ���Student��setName�����������ķ�����ƣ�
		//stu�������str����setName�����Ĳ���ֵ
		setName.invoke(stu, str);
		//����Student��getName����������
		//Student st = new Student();
		//st.getName();
		((Student)stu).getName();//��û���õ��������
	}
}
