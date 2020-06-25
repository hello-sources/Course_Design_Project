package com.neuedu.utils;

import java.util.*;

public class LinkedListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList lk = new LinkedList();
		lk.add(0,"aa");
		lk.add(1,"bb");
		lk.addFirst("lalala");
		lk.addLast("gagaga");
		System.out.println(lk.get(0));
		System.out.println(lk.get(1));
		System.out.println(lk.get(2));
		System.out.println(lk.get(3));
	}

}
