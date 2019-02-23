package com.basic;

public class JoinTest {
	private static int  count =0;
	public static void main(String[] args) {
		Thread t1 = new Thread(new Thread(new Runnable() {
			public void run(){
				for (int i = 0; i < 1000; i++) {
					count++;
				}	
			}
		}));
		Thread t2 = new Thread(new Thread(new Runnable() {
			public void run(){
				for (int i = 0; i < 1000; i++) {
					count++;
				}	
			}
		}));
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(count);
	}

}
