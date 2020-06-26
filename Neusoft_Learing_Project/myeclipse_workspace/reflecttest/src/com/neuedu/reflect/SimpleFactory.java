package com.neuedu.reflect;

//简单工厂模式

interface Car{
	void printCarName();
}

class Baoma implements Car{
	public void printCarName(){
		System.out.println("I am a Baoma car!");
	}
}

class Nmsl implements Car{
	public void printCarName(){
		System.out.println("I am Nmsl!");
	}
}

public class SimpleFactory {
	//静态方法使用静态变量
	public static Car createCar(String carStr){
		if(carStr.equalsIgnoreCase("baoma")){
			return new Baoma();
		}
		else if(carStr.equalsIgnoreCase("Nmsl")){
			return new Nmsl();
		}
		else
			return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car car = SimpleFactory.createCar("baoma");
		car.printCarName();
	}

}
