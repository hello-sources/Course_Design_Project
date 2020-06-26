package Reflect_train;

public class Student {
	/**
	 * author ：李天伟
	 * time：2019/7/9
	 * location:Neusoft G2宿舍22103寝室
	 * @param args
	 */
	//默认的构造方法
	Student(String str){
		System.out.println("这是默认的构造方法"+str);
	}
	
	//公有的，无参的构造方法
	public Student(){
		System.out.println("公有的，无参的构造方法。");
	}
	
	//公有的，有参的构造方法
	public  Student(char name){
		System.out.println("姓名："+name);
	}
	
	//受保护的构造方法
	protected Student(int id){
		System.out.println("学生的学号是："+id);
	}
	
	//私有的构造方法
	private Student(float heigth){
		System.out.println("学生的身高是："+heigth);
	}
	
}

