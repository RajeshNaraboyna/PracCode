package com.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapPrac {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("test","test");
		
		ConcurrentHashMap<String, String> concurrentHashMap= new ConcurrentHashMap<String, String>();
		concurrentHashMap.put("test", "test");
	}

}
