package com.pattern.singleton;

public class SingletonSync {
	private static SingletonSync instance;

	private SingletonSync() {
		System.out.println("Singleton(): Initializing Instance");
	}

	public static SingletonSync getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					System.out.println("getInstance(): First time getInstance was invoked!");
					instance = new SingletonSync();
				}
			}
		}

		return instance;
	}

	public void doSomething() {
		System.out.println("doSomething(): Singleton does something!");
	}
}
