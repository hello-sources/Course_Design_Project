package com.neuedu.utils;

import java.util.LinkedList;

class Dui{
	LinkedList<Object> date = new LinkedList<Object>();
	public void put(Object o){
		date.add(o);
	}
	
	public Object get(){
		Object obj = date.getLast();
		date.removeLast();
		return obj;
	}
	
	public boolean isEmpty(){
		return date.size()==0?true:false;
	}
}
public class LinkedList_test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dui dui = new Dui();
		dui.put("a");
		dui.put("b");
		dui.put("c");
		
		while(!dui.isEmpty()){
			Object k = dui.get();
			System.out.println(k);
		}
		
	}

}
