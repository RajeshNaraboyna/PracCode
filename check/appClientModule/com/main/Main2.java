package com.main;

import java.io.IOException;
import java.util.Stack;

public class Main2 {

	public static void main(String[] args) throws IOException {
		// System.getProperty("user.dir");
		// int proce=Runtime.getRuntime().availableProcessors();
		// System.out.println(proce);
		System.out.println((0.32124 * 1000) / (1000));
		System.out.println(Math.round(0.32124 * 1000.0) / 1000.0);
	}
}

class En<E> {
	Stack<E> st = new Stack<E>();

	public void push(E e) {
		st.push(e);
	}

	public E pop() {
		return st.pop();
	}

	private void m1() {
	}
}

class EnP<N> extends En<N> {
	private void m1() {
	}
}