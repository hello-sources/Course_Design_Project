package com.thread;

public class ExThread extends Thread{
	//线程里面有一个run的方法
	public  void run(){
		for(int i = 0;i<20;i++){
			System.out.println("Exthread:"+i);
		}
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExThread exThread = new ExThread();
		exThread.start();
	}

}
