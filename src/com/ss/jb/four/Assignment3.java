package com.ss.jb.four;

public class Assignment3 {
	public static void main(String[] args) {
		Integer capacity = 1;
		Warehouse warehouse = new Warehouse(capacity);
		Thread producer = new Thread(new Producer(warehouse));
		Thread consumer = new Thread(new Consumer(warehouse));
		Thread threadIndex = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					producer.join();
					consumer.join();
					System.out.println(warehouse.getIndex());
				} catch(InterruptedException e) {
					//
				}
			}
		});
		
		System.out.println("Starting index: " + warehouse.getIndex());
		producer.start();
		consumer.start();
		threadIndex.start();
	}
}
