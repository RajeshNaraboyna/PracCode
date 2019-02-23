package com.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LambdasBasicTest {

	public static void main(String[] args) {
		// String str= ()->getSomeVal();
		System.out.println();

		List<String> listArr = Arrays.asList("Test1", "Test2", "Test3", "Test4", "Test5");

		listArr.stream().filter(e -> e.equals("Test1")).map(String::toString).collect(Collectors.toList())
				.forEach(e -> System.out.println(e));
		;
	}

	class SomeTest {

		void getSomeVal(String inpu) {
		}

		String getSomeVal() {
			return "PRICE";
		}

	}

}
