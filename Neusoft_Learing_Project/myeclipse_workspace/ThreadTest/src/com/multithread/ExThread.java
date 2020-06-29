package com.multithread;

public class ExThread extends Thread {
	
	public void run(){
		
		for(int i=0;i<20 ;i++){
			System.out.println("ExThread:"+i);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExThread exThread=new ExThread();
		exThread.start();
	}

}
