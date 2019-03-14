package com.basic;

public class SynchronizedInteger {

	private int value;

	public static void main(String[] args) {

	}

	public synchronized int getValue() {
		return value;
	}

	public synchronized void setValue(int value) {
		this.value = value;
	}

}
