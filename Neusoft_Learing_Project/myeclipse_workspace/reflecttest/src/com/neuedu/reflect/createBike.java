package com.neuedu.reflect;

interface Bike{
	void printBikename();
}

class Finifix implements Bike{
	public void printBikename(){
		System.out.println("��������");
	}
}

class Laji implements Bike{
	public void printBikename(){
		System.out.println("����Ҫ���డ!");
	}
}

public class createBike{

	public static Bike fenlei(String ljfl){
		if(ljfl.equalsIgnoreCase("finifix")){
			//System.out.println("���Ǹ���������ʪ������");
			return new Finifix();
		}
		else if(ljfl.equalsIgnoreCase("Laji")){
			//System.out.println("��������վ!");
			return new Laji();
		}
		else 
			return null;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bike bike = createBike.fenlei("Finifix");
		bike.printBikename();
	}

}
