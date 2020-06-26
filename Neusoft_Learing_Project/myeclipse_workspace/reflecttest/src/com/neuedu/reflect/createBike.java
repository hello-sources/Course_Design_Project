package com.neuedu.reflect;

interface Bike{
	void printBikename();
}

class Finifix implements Bike{
	public void printBikename(){
		System.out.println("À¬»ø°¡£¡");
	}
}

class Laji implements Bike{
	public void printBikename(){
		System.out.println("À¬»øÒª·ÖÀà°¡!");
	}
}

public class createBike{

	public static Bike fenlei(String ljfl){
		if(ljfl.equalsIgnoreCase("finifix")){
			//System.out.println("ÄãÊÇ¸ÉÀ¬»ø»¹ÊÇÊªÀ¬»ø£¿");
			return new Finifix();
		}
		else if(ljfl.equalsIgnoreCase("Laji")){
			//System.out.println("¹ö»ØÀ¬»øÕ¾!");
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
