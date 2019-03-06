package com.unsafetest;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class UnsafeMain {
	public static void main(String[] arg) {
		System.out.println("Unsafe Main Method Calls");
		System.out.println();
		ConcurrentHashMap<String, String > concurrentHashMap= new ConcurrentHashMap<>();
		CopyOnWriteArrayList< String> arrayList= new CopyOnWriteArrayList<>();
	}
}
