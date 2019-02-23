package com.basic.concurrency;

public class CheckResults {
	static int counter = 0;

	public static void main(String[] args) throws InterruptedException {

		new Thread(() -> {
			for (int i = 0; i < 500; i++)
				CheckResults.counter++;
		}).start();

		while (CheckResults.counter < 100) {
			System.out.println("Not reached yet");
			Thread.sleep(1000); // 1 SECOND
		}
		System.out.println("Reached!");
	}
}