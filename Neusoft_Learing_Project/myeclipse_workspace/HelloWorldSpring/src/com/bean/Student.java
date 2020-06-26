package com.bean;

public class Student {
	private Integer id = 123;//默认值，类的成员变量或者全局变量
	private String name = "匿名";
	
	
	
	
	@Override//重写Object类的toString()方法
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public Student() {
		//System.out.println("这是本来约定的默认构造器，不写也存在");
		//super();
		//调用父类构造
		// TODO Auto-generated constructor stub
	}
	
	//上下四个构造互相成为重载，普通方法相同
	//重载的特点是，只要参数不同即可
	//参数不同体现 两个方面，一类型不同，二参数不同
	public Student(Integer id, String name) {
		//this("您",2000);//调用当前类的其他构造器
		this.id = id;
		this.name = name;
	}
	
	public Student(Integer newid){
		id = newid;//无this
	}
	
	public Student(String name, Integer id) {
		this.id = id;
		this.name = name;
		System.out.println(toString());
	}
	
	public Integer getId() {
		return id;
	}
	public void setId100(Integer id) {
		if (id>1000||id<0){
			id = 123;
		}else{
			this.id = id;
		}
	}
	public String getName() {
		return name;
	}
	public void setName200(String name) {
		this.name = name;
	}
	
}
