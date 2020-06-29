package com.multithread;

class ThreadTrain implements Runnable{
	private int trainCount =100;
	public void run() {
		//�̰߳�ȫ���⣬����̹߳���һ��ȫ�ֱ�����д��ʱ�򣬻ᷢ���̰߳�ȫ�������ᡣ
		while(trainCount>0){//trainCount=0ʱ�������߳�ͬʱ����while
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
				",���۵�"+(100-trainCount+1));
		trainCount--;//�����߳�ͬʱ��--
	}
}
class ThreadTrain1 implements Runnable{
	private int trainCount =100;
	private static int trainCount1 =100;
	public boolean flag=true;
	public void run() {
		if(flag){
		//�̰߳�ȫ���⣬����̹߳���һ��ȫ�ֱ�����д��ʱ�򣬻ᷢ���̰߳�ȫ�������ᡣ
			while(trainCount>0){//trainCount=0ʱ�������߳�ͬʱ����while
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
			while(trainCount>0){//trainCount=0ʱ�������߳�ͬʱ����while
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
	//������һ���߳�ʹ��ͬ��������һ���߳�ʹ��ͬ�������������߳����ͬ����˵��ͬ������ʹ��ͬ���� 
	public synchronized void sale(){
		
			if(trainCount>0){
				System.out.println(Thread.currentThread().getName()+
				",���۵�"+(100-trainCount+1));
				trainCount--;
			}
		
	}
	public void sale1(){
		synchronized(this){
			if(trainCount>0){
				System.out.println(Thread.currentThread().getName()+
				",���۵�"+(100-trainCount+1));
				trainCount--;
			}
		}
	}
	//�༶��
	public static synchronized void sale2(){
		
			if(trainCount1>0){
				System.out.println(Thread.currentThread().getName()+
				",���۵�"+(100-trainCount1+1));
				trainCount1--;
			}
		
	}
	public static void sale3(){
		synchronized(ThreadTrain1.class){
			if(trainCount1>0){
				System.out.println(Thread.currentThread().getName()+
				",���۵�"+(100-trainCount1+1));
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
		Thread t1=new Thread(threadTrain,"����1");
		Thread t2=new Thread(threadTrain,"����2");
		t1.start();
		Thread.sleep(40);
		threadTrain.flag=false;
		t2.start();
	}
	

}
