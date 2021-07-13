package com.ss.jb.four;

import java.util.Random;

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
