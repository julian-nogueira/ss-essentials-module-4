package com.ss.jb.four;

import java.util.Random;

/**
 * The Producer object works with a Warehouse object, such that the Producer
 * can add items, in the form of integers, to the Warehouse. Prior to adding an
 * item, the Producer will sleep for up to two seconds to exhibit some delay
 * within the program.
 */
public class Producer implements Runnable {
	private Warehouse warehouse;

	public Producer(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	@Override
	public void run() {
		Integer[] items = {
				1, 2, 3, 4, 5, 6, -1
		};
		
		Random random = new Random();
		
		for(int i = 0; i < items.length; i++) {
			warehouse.produce(items[i]);
			
			if(items[i] != -1) {
				System.out.println("Producer produced: " + items[i]);
			} else {
				System.out.println("Producer finished producing.");
			}
			
			try {
				Thread.sleep(random.nextInt(2000));
			} catch(InterruptedException e) {
				//
			}
		}
	}
}
