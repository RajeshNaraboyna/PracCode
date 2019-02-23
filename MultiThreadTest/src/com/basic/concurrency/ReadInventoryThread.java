package com.basic.concurrency;

public class ReadInventoryThread extends Thread {
	public void run() {
		System.out.println("Printing zoo inventory" + this.getName());
		try {
			Thread.sleep(1000);
			Thread.yield();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Printing zoo inventory- Exit" + this.getName());
		try {
			this.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		(new ReadInventoryThread()).start();
		(new ReadInventoryThread()).start();
		(new ReadInventoryThread()).start();
		(new ReadInventoryThread()).start();
		(new ReadInventoryThread()).start();
		(new ReadInventoryThread()).start();
		(new ReadInventoryThread()).start();
		(new ReadInventoryThread()).start();
		System.out.println("Exit main");
	}
}