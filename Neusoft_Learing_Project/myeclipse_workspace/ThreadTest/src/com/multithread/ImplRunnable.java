package com.multithread;

class ImRunnable implements Runnable {
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<20;i++){
			System.out.println("ImplRunnable:"+i);
		}
	}
}
public class ImplRunnable{
	
	public static void main(String[] args){
		ImRunnable imRunnable=new ImRunnable();
		Thread th=new Thread(imRunnable);
		th.start();
		th.setPriority(10);
	//	System.out.println("ÓÅÏÈ¼¶"+th.getPriority());
		for(int i=0;i<20;i++){
			System.out.println("Main:"+i);
			
		}
	}
}
	
	


