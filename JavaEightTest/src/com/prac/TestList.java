package com.prac;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestList {

	public static void main(String[] args) {
		Integer[] integer={1,2,3,4,5,6,7,8,9};
		List<Integer> integersLIst= new ArrayList<>(Arrays.asList(integer));
		for (int i = 0; i < integersLIst.size(); i++) {
			System.out.println(integersLIst.get(i));
		}
		integersLIst.add(10);
		integersLIst.add(11);
		integersLIst.add(12);
		integersLIst.add(13);
		integersLIst.add(14);
		integersLIst.add(15);
		
			while(integersLIst.size()>12){
				integersLIst.remove(0);
			}
			
			for (int i = 0; i < integersLIst.size(); i++) {
				System.out.println(integersLIst.get(i));
			}
	}

}
