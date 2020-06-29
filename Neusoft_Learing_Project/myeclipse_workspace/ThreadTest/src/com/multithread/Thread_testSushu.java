package com.multithread;

public class Thread_testSushu {
	public static void main(String[] args){
		Sushu Sushu = new Sushu(1,1000);
		Sushu.setPriority(1);
		Sushu.start();
		
		Sushu Sushu2 = new Sushu(1001,2000);
		Sushu2.setPriority(5);
		Sushu2.start();
		
		Sushu Sushu3 = new Sushu(2001,3000);
		Sushu3.setPriority(10);
		Sushu3.start();
	}
}
