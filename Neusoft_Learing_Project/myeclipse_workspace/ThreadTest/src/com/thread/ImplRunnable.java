package com.thread;

class ImRunnable implements Runnable{
	//�߳�������һ��run�ķ���
		public void run(){
			for(int i = 0;i<20;i++){
				System.out.println("ImplRunnable:"+i);
			}
		}
}

public class ImplRunnable{
	//û�м̳���Thread�࣬Ҳû������Runnable�ӿڣ�Ҳ���߳�
	public static void main(String[] args){
		ImRunnable iRunnable = new ImRunnable();
		Thread th = new Thread(iRunnable);
		th.start();
		//������������߼������߳�����ʱ����ʹ
		th.setPriority(10);
		System.out.println("���ȼ�"+th.getPriority());
		for(int i = 0;i<20;i++){
			System.out.println("mian:"+i);
		}
		
	}
	//���������߳����ڷֱ�ռ����Դ���������н�����ֽ���
}