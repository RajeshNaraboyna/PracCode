package com.collections;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueuerac {

	public static void main(String[] args) {
		ArrayBlockingQueue<String> blockingQueue= new ArrayBlockingQueue<>(20);
		blockingQueue.add("test");
	}

}
