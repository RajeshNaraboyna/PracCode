package com.concurrency;

public class NoVisibleConcurrency {

	private static boolean ready=false;
	private static int num;

	private static class ReadyClass extends Thread {
		public void run() {
			System.out.println(ready);
			while (!ready) {
				System.out.println();
				Thread.yield();
			}
			System.out.println(num);
		}
	}

	public static void main(String[] args) {
		new ReadyClass().start();
		ready = true;
		num = 32;
	}

}
