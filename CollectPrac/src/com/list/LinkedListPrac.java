package com.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListPrac {

	public static void main(String[] args) {
		LinkedList< String> list = new LinkedList<>();
		list.add("123");
		list.add("1234");
		list.add("12345");
		list.add("123456");
		list.add("1234567");
		Iterator<String > itr=list.iterator();
		while(itr.hasNext()){
			if(itr.next().equals("1234"))
			itr.remove();
		}
		
		System.out.println(list);
	}

}
