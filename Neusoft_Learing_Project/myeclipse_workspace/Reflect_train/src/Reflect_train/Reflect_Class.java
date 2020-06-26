package Reflect_train;

public class Reflect_Class {

	/**
	 * author :李天伟
	 * time :2019/7/10
	 * location : 东软睿道A9实训中心301教室
	 * @param args
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		//按照getClass()来获取Class对象
		Student stu = new Student();
		Class cla = stu.getClass();
		System.out.println(cla.getName());
		
		//按照静态类的方法，直接引用从类的方法即类.class
		Class cla2 = Student.class;
		System.out.println(cla2.getName());
		
		//按照第三种方法获取Class对象
		try{
			String str = "Reflect_Train.Student";
			Class cla3 = Class.forName(str);
			System.out.println(cla3);	
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
	}

}
