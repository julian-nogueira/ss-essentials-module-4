package com.ss.jb.four;

import java.util.Random;

/**
 * The Consumer object works with a Warehouse object, such that the Consumer
 * can consume items, in the form of integers, from the Warehouse. Prior to
 * consuming an item, the Consumer will sleep for up to two seconds to exhibit
 * some delay within the program.
 */
public class Consumer implements Runnable {
	private Warehouse warehouse;
	
	public Consumer(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	@Override
	public void run() {
		Random random = new Random();
		
		for(int consumedItem = warehouse.consume(); consumedItem != -1; consumedItem = warehouse.consume()) {
			System.out.println("Consumer consumed: " + consumedItem);
			
			try {
				Thread.sleep(random.nextInt(2000));
			} catch(InterruptedException e){
				//
			}
		}
		System.out.println("Consumer finished consuming.");
	}
}
