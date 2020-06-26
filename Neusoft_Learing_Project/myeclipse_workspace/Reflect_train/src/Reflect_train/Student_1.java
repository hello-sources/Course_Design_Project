package Reflect_train;

public class Student_1 {
	public void show(String s){
		System.out.println("调用了公有的方法"+s);
	}
	
	protected void show1(){
		System.out.println("受保护的方法（无参）");
	}
	
	void show2(){
		System.out.println("默认的构造方法");
	}
	
	String show3(int age){
		System.out.println("私有的含参数的方法"+age);
		return "hello";
	}
}
