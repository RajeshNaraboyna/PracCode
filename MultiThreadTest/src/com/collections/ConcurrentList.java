package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentList {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<>();
		list.add("test");
		list.add("tes1t");
		list.add("test2");
		list.add("test3");
		list.add("test4");
		list.toString();
		Iterator<String> itr = list.iterator();

		String str = new String("test");
		str.hashCode();
		while (itr.hasNext()) {
			String string = (String) itr.next();
			list.remove(string);
		}

		System.out.println(list);

		CopyOnWriteArrayList<String> arrayList = new CopyOnWriteArrayList<>();
		arrayList.add("test");
	}

}
