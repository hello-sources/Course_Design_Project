package com.multithread;

//�����������ȡ��ǰϵͳʱ��
import java.util.Date;
//����ʱ��ĸ�ʽ����
import java.text.SimpleDateFormat;

public class GetCurrentTime implements Runnable{
	static int i;
	//��ʽ��ʱ��
	SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public void run(){
		for(i = 1;i < 10; i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//new Date()ָ�ľ��ǵ�ǰʱ�䣬ͨ��SimpleDateFormat�������ʵ�ָ�ʽ�����������
			System.out.println(sim.format(new Date()));
			if(i == 5){
				return ;
//				thread.interrupt();
			}
		}
	}
	/**
	 * author������ΰ
	 * time ��2019/7/11 21:28:43
	 * location : �����A9¥ 301����
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GetCurrentTime gettime = new GetCurrentTime();
		Thread thread  = new Thread(gettime);
		thread.start();
		
	}

}
