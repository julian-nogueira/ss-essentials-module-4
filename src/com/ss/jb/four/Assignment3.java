package com.ss.jb.four;

/**
 * The Assignment3 class creates a Warehouse object with a capacity of one.
 * Producer and Consumer objects are also created, each using a different
 * thread. There is also a thread that is purely used to get the value of the
 * index after the Consumer and Producer threads are finished executing,
 * primarily for testing purposes.
 * 
 * The Producer will add an integer to an array, and the Consumer will retrieve
 * it. This process will continue until the Producer adds a terminating integer
 * to the array, in which the Consumer will stop consuming when this integer is
 * retrieved.
 */
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
