package com.pattern.singleton;

public class SingletonEager {

	private static SingletonEager instance = new SingletonEager();

	private SingletonEager() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static SingletonEager getInstance() {
		return instance;
	}

	public void doSomething() {
		System.out.println("doSomething(): Singleton does something!");
	}
}
