package Reflect_train;

public class Student {
	/**
	 * author ������ΰ
	 * time��2019/7/9
	 * location:Neusoft G2����22103����
	 * @param args
	 */
	//Ĭ�ϵĹ��췽��
	Student(String str){
		System.out.println("����Ĭ�ϵĹ��췽��"+str);
	}
	
	//���еģ��޲εĹ��췽��
	public Student(){
		System.out.println("���еģ��޲εĹ��췽����");
	}
	
	//���еģ��вεĹ��췽��
	public  Student(char name){
		System.out.println("������"+name);
	}
	
	//�ܱ����Ĺ��췽��
	protected Student(int id){
		System.out.println("ѧ����ѧ���ǣ�"+id);
	}
	
	//˽�еĹ��췽��
	private Student(float heigth){
		System.out.println("ѧ��������ǣ�"+heigth);
	}
	
}

