package com.thread;

 class ThreadTrain implements Runnable {
	 private int trainCount = 100;
	@Override
	public void run() {
		//线程安全问题，多个线程共享一个全局变量，写的时候会发生线程安全，读不全
		// TODO Auto-generated method stub
		while(trainCount>0){
			try{
				Thread.sleep(50);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			sale();
		}
	}
	
	 public void sale(){
		 System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount+1));
		 trainCount--;
		 //两个线程同时做--
	 }
}

 class ThreadTrain1 implements Runnable{
	 private int trainCount = 100;
	 private static int trainCount1 = 100;
	 public boolean flag = true;
	 public void run(){
		 if(flag){
			 //线程安全问题，多个线程共享一个全局变量，写的时候，会发生线程安全，读不会。
			 while(trainCount >0){//trainCount = 0时，两个线程同时进入while
				 try{
					 Thread.sleep(50);
				 }catch(InterruptedException e){
					 e.printStackTrace();
				 }
			sale();
			 }
		 }
		 else{
			 while(trainCount>0){
				 try{
					 Thread.sleep(50);
				 }catch(InterruptedException e){
					 e.printStackTrace();
				 }
				 sale1();
			 }
		 }
	 }
	 //对象锁一个线程使用同步函数，一个线程使用同步锁，如果两个线程同步，说明函数使用同步锁
	 public synchronized void sale(){
		 if(trainCount>0){
			 System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount+1));
			 trainCount--;
		 }
	 }
	 
	 public void sale1(){
		 synchronized(this){
			 if(trainCount>0){
				 System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount+1));
				 trainCount--;
			 }
		 }
	 }
	 //类级别的锁
	 public static synchronized void sale2(){
		 if(trainCount1>0){
			 System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount1+1));
			 trainCount1--;
		 }
	 }
	 
	 public static synchronized void sale3(){
		 synchronized(ThreadTrain1.class){
			 if(trainCount1>0){
				 System.out.println(Thread.currentThread().getName()+",出售第"+(100-trainCount1+1));
				 trainCount1--;
			 }
		 }
	 }
 } 
public class MyThread{
		 public static void main(String[] args) throws Exception{
			 ThreadTrain1 threadTrain = new ThreadTrain1();
			 Thread t1 = new Thread(threadTrain,"窗口1");
			 Thread t2 = new Thread(threadTrain,"窗口2");
			 t1.start();
			 Thread.sleep(40);
			 threadTrain.flag = false;
			 t2.start();
		 }
}
