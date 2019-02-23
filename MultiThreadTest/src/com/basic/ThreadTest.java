package com.basic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

	public static void main(String[] args) {
		
		Thread t = Thread.currentThread();
		System.out.println(t.isDaemon());
		System.out.println(t.getName());
		for (int i = 0; i < 5; i++) {
			System.out.println("Print "+i);
			try {
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().isDaemon());
				System.out.println(t==Thread.currentThread());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	Thread run1 = new Thread(new	Bank());
	Thread run2 = new Thread(new	Bank());
	try {
		run1.start();
		run2.start();	
		run1.join();
		run2.join();	
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
//	ExecutorService executorService=	Executors.newFixedThreadPool(2);
//	executorService.execute(run1);
//	executorService.execute(run2);
		
	System.out.println("Alive "+t.isAlive());
	}
	
	static class Bank implements Runnable {
		
		
		public void run (){
			for(int i = 0 ; i< 5 ;i ++){
				System.out.println("Bank "+i);
				System.out.println(Thread.currentThread().getName());
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		}
	}
	

}
