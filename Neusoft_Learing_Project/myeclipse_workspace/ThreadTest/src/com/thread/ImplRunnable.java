package com.thread;

class ImRunnable implements Runnable{
	//线程里面有一个run的方法
		public void run(){
			for(int i = 0;i<20;i++){
				System.out.println("ImplRunnable:"+i);
			}
		}
}

public class ImplRunnable{
	//没有继承自Thread类，也没有利用Runnable接口，也是线程
	public static void main(String[] args){
		ImRunnable iRunnable = new ImRunnable();
		Thread th = new Thread(iRunnable);
		th.start();
		//单纯的引入最高级别，在线程运行时不好使
		th.setPriority(10);
		System.out.println("优先级"+th.getPriority());
		for(int i = 0;i<20;i++){
			System.out.println("mian:"+i);
		}
		
	}
	//对于两个线程由于分别占据资源，导致运行结果出现交错
}