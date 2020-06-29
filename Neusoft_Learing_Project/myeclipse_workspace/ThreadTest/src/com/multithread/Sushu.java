package com.multithread;

public class Sushu extends Thread{
	private int a;
	private int b;
	
	public Sushu(int a,int b){
		super();
		this.a = a;
		this.b = b;
	}
	
	public void run(){
		while(true){
			if(a>b){
				return ;
			}
			if(isSushu(a)){
				System.out.println(a);
			}
			a++;
		}
	}
	
	public boolean isSushu(int a){
		if(a == 2)
			return true;
		for(int i = 2;i < a;i++){
			if(a%i == 0){
				return false;
			}
		}
		return true;
	}
}

