package com.pattern.singleton;

import java.io.Serializable;

public class SingletonEagerSer implements Serializable{

	private static SingletonEagerSer instance = new SingletonEagerSer();

	private SingletonEagerSer() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static SingletonEagerSer getInstance() {
		return instance;
	}

	public void doSomething() {
		System.out.println("doSomething(): Singleton does something!");
	}
	
	protected Object readResolve() {
		return getInstance();
	}
}
