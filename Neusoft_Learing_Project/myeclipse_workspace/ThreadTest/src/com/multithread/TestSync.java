package com.multithread;

class Timer{
	private static int num=0;
	public  void add(String name){
			
		num++;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(name+":是你第"+num+"个使用的线程");
	}
}

public class TestSync implements Runnable{
	Timer timer=new Timer();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSync ts=new TestSync();
		Thread t1= new Thread(ts);
		Thread t2=new Thread(ts);
		t1.setName("t1");
		t2.setName("t2");
		t1.start();
		t2.start();
	}

	public void run() {
		// TODO Auto-generated method stub
		timer.add(Thread.currentThread().getName());
	}

}
