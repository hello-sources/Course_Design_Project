package Reflect_train;

public class Reflect_Class {

	/**
	 * author :����ΰ
	 * time :2019/7/10
	 * location : �����A9ʵѵ����301����
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//����getClass()����ȡClass����
		Student stu = new Student();
		Class cla = stu.getClass();
		System.out.println(cla.getName());
		
		//���վ�̬��ķ�����ֱ�����ô���ķ�������.class
		Class cla2 = Student.class;
		System.out.println(cla2.getName());
		
		//���յ����ַ�����ȡClass����
		try{
			String str = "Reflect_Train.Student";
			Class cla3 = Class.forName(str);
			System.out.println(cla3);	
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}

}
