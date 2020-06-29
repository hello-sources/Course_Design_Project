package com.multithread;

class ThreadDemo implements Runnable{
	public void run(){
		for(int i=0;i<20;i++){
			System.out.println("ThreadDemo:"+i);
		}
	}
}

public class ThreadTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadDemo t=new ThreadDemo();
		Thread test=new Thread(t);
		test.start();
		for(int i=0;i<20;i++){
			System.out.println("ThreadTest:"+i);
		}

	}

}
