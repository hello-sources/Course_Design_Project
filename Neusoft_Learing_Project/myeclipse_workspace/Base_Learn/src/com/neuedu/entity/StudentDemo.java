package com.neuedu.entity;
/**联系Java基础
 * 
 * @author 32458
 *
 */
class Student1{
	//基本数据类型，也叫成员变量
	byte b = 1;
	short s = 10;
	int i = 20;
	long l = 30;
	float f = 10.0f;
	double d = 10.0;
	char ch = 'a';
	boolean flag;
	/**
	 * 练习语法
	 */
	
	//引用类型,自定义类型属于引用类型
	String str = "aa";
	String str1 = new String("bb");
	int[] iArray = {1,2,3};  
	int[] iArray1 = new int[3];
	
	
	public void test(){
		l = (long)d;//上述用法是（上转型）
	}
}

class Student{
	//java有四种访问控制private，protected,public还有就是啥也不加默认方法
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
	//赋值，注入
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
		Student stu = new Student();//Java实例化对象
		stu.setUsername("张三");//访问Student类的setUsername
		System.out.println(stu.username);
	}

}
