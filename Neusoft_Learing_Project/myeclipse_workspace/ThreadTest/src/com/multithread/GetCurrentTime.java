package com.multithread;

//导入包用来获取当前系统时间
import java.util.Date;
//对于时间的格式化包
import java.text.SimpleDateFormat;

public class GetCurrentTime implements Runnable{
	static int i;
	//格式化时间
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void run(){
		for(i = 1;i < 10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//new Date()指的就是当前时间，通过SimpleDateFormat这个类来实现格式化，并且输出
			System.out.println(sim.format(new Date()));
			if(i == 5){
				return ;
//				thread.interrupt();
			}
		}
	}
	/**
	 * author：李天伟
	 * time ：2019/7/11 21:28:43
	 * location : 东软睿道A9楼 301教室
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetCurrentTime gettime = new GetCurrentTime();
		Thread thread  = new Thread(gettime);
		thread.start();
		
	}

}
