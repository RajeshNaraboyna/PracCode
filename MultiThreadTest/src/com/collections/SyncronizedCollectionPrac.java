package com.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SyncronizedCollectionPrac {

	public static void main(String[] arg){
		List<String> list = Collections.synchronizedList(new ArrayList<>());
	}
	
}
