package com.multithread;

class ThreadTrain implements Runnable{
	private int trainCount =100;
	public void run() {
		//线程安全问题，多个线程共享一个全局变量，写的时候，会发生线程安全，读不会。
		while(trainCount>0){//trainCount=0时，两个线程同时进入while
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sale();
		}		
	}
	public void sale(){
		System.out.println(Thread.currentThread().getName()+
				",出售第"+(100-trainCount+1));
		trainCount--;//两个线程同时做--
	}
}
class ThreadTrain1 implements Runnable{
	private int trainCount =100;
	private static int trainCount1 =100;
	public boolean flag=true;
	public void run() {
		if(flag){
		//线程安全问题，多个线程共享一个全局变量，写的时候，会发生线程安全，读不会。
			while(trainCount>0){//trainCount=0时，两个线程同时进入while
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			sale();
			}
		}
		else{
			while(trainCount>0){//trainCount=0时，两个线程同时进入while
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			sale1();
		}
		}
	}
	//对象锁一个线程使用同步函数，一个线程使用同步锁，这两个线程如果同步，说明同步函数使用同步锁 
	public synchronized void sale(){
		
			if(trainCount>0){
				System.out.println(Thread.currentThread().getName()+
				",出售第"+(100-trainCount+1));
				trainCount--;
			}
		
	}
	public void sale1(){
		synchronized(this){
			if(trainCount>0){
				System.out.println(Thread.currentThread().getName()+
				",出售第"+(100-trainCount+1));
				trainCount--;
			}
		}
	}
	//类级锁
	public static synchronized void sale2(){
		
			if(trainCount1>0){
				System.out.println(Thread.currentThread().getName()+
				",出售第"+(100-trainCount1+1));
				trainCount1--;
			}
		
	}
	public static void sale3(){
		synchronized(ThreadTrain1.class){
			if(trainCount1>0){
				System.out.println(Thread.currentThread().getName()+
				",出售第"+(100-trainCount1+1));
				trainCount1--;
			}
		}
	}
	
}
	
public class MyThread {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		ThreadTrain1 threadTrain=new ThreadTrain1();
		Thread t1=new Thread(threadTrain,"窗口1");
		Thread t2=new Thread(threadTrain,"窗口2");
		t1.start();
		Thread.sleep(40);
		threadTrain.flag=false;
		t2.start();
	}
	

}
