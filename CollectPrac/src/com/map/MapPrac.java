package com.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class MapPrac {

	public static void main(String[] args) {
		HashMap<String, String> map = new HashMap<>();
		map.put("test2", "test");
		map.put("test", "test");
		map.put("test4", "test");
		map.put("test4", "t5est");
		map.put("tes2t", "test");
		map.put("t1est", "test");
		map.toString();
		System.out.println(map);
		LinkedHashMap<String, String> maplinked = new LinkedHashMap<>();
		maplinked.put("test2", "test");
		maplinked.put("test1", "test");
		maplinked.put("test4", "test");
		maplinked.put("test5", "test");
		maplinked.put("test0", "test");
		maplinked.put("test7", "test");
		maplinked.put("test2", "test");
		maplinked.toString();
		System.out.println(maplinked);
		TreeMap<String, String> treemap = new TreeMap<>();
		treemap.put("test", "test");
		treemap.put("test3", "test");
		treemap.put("test2", "test");
		treemap.put("test1", "test");
		treemap.put("test0", "test");
		treemap.put("test7", "test");
		treemap.put("test4", "test");
		treemap.toString();
		System.out.println(treemap);
		
		Collections.synchronizedList(new ArrayList<>());
		
	}
}
