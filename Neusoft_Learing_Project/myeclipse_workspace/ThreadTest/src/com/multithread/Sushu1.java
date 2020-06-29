package com.multithread;

public class Sushu1 implements Runnable{
	private int a;
	private int b;
	public Sushu1(int a,int b){
		super();
		this.a = a;
		this.b = b;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if(a > b){
				return ;
			}
			if(isSushu1(a)){
				System.out.println(a);
			}
			a++;
		}
	}
	
	public boolean isSushu1(int a){
		if(a == 2)
			return true;
		for(int i = 2;i < a;i++){
			if(a % i  == 0){
				return false;
			}
		}
		return true;
	}
}
