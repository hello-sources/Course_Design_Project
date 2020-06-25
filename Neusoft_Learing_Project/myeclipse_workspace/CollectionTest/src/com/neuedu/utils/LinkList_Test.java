package com.neuedu.utils;

import java.util.LinkedList;

class  Queue{
	LinkedList<Object> data = new LinkedList();
	
	public boolean isEmpty(){
		return data.size()==0?true:false;
	}
	
	public void put(Object o){
		data.add(o);
	}
	
	public Object get(){
		Object obj = data.getFirst();
		data.removeFirst();
		return obj;
	}
}
public class LinkList_Test {
	public static void main(String[] args){
		Queue que = new Queue();
		que.put("a");
		que.put("b");
		que.put("c");
		
		while(!que.isEmpty()){
			Object k = que.get();
			System.out.println(k);
		}
	}	
	
}
