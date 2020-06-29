package com.multithread;

public class Thread_testSushu1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sushu1 sushu = new Sushu1(1,1000);
		Thread thread = new Thread(sushu);
		thread.start();
		
		Sushu1 sushu2 = new Sushu1(1001,2000);
		Thread thread1 = new Thread(sushu2);
		thread1.start();
		
		Sushu1 sushu3 = new Sushu1(2001,3000);
		Thread thread2 = new Thread(sushu3);
		thread2.start();
	}

}
