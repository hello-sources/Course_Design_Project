package com.bean;

public class Student {
	private Integer id = 123;//Ĭ��ֵ����ĳ�Ա��������ȫ�ֱ���
	private String name = "����";
	
	
	
	
	@Override//��дObject���toString()����
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

	public Student() {
		//System.out.println("���Ǳ���Լ����Ĭ�Ϲ���������дҲ����");
		//super();
		//���ø��๹��
		// TODO Auto-generated constructor stub
	}
	
	//�����ĸ����컥���Ϊ���أ���ͨ������ͬ
	//���ص��ص��ǣ�ֻҪ������ͬ����
	//������ͬ���� �������棬һ���Ͳ�ͬ����������ͬ
	public Student(Integer id, String name) {
		//this("��",2000);//���õ�ǰ�������������
		this.id = id;
		this.name = name;
	}
	
	public Student(Integer newid){
		id = newid;//��this
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
