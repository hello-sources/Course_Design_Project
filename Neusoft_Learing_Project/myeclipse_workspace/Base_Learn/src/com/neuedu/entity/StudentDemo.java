package com.neuedu.entity;
/**��ϵJava����
 * 
 * @author 32458
 *
 */
class Student1{
	//�����������ͣ�Ҳ�г�Ա����
	byte b = 1;
	short s = 10;
	int i = 20;
	long l = 30;
	float f = 10.0f;
	double d = 10.0;
	char ch = 'a';
	boolean flag;
	/**
	 * ��ϰ�﷨
	 */
	
	//��������,�Զ�������������������
	String str = "aa";
	String str1 = new String("bb");
	int[] iArray = {1,2,3};  
	int[] iArray1 = new int[3];
	
	
	public void test(){
		l = (long)d;//�����÷��ǣ���ת�ͣ�
	}
}

class Student{
	//java�����ַ��ʿ���private��protected,public���о���ɶҲ����Ĭ�Ϸ���
	protected int id;
	String username;
	private String password;
	
	/**
	 * public Student(int id,String username,String password){
	 * 	this.id = id;
		this.username = username;
		this.password = password;
	}
	 */
	
	public int getId() {
		return id;
	}
	//��ֵ��ע��
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}


public class StudentDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student stu = new Student();//Javaʵ��������
		stu.setUsername("����");//����Student���setUsername
		System.out.println(stu.username);
	}

}
