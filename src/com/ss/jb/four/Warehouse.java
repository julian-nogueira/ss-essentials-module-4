package com.ss.jb.four;

/**
 * The Warehouse class is designed for Producer and Consumer objects, such that
 * items can be stored in a shared array with a capacity determined at
 * instantiation. The Producer can add items to the array while processing is
 * not taking place. If processing is taking place, the Producer will wait
 * until it is notified by the Consumer. The reverse is true for the Consumer.
 */
public class Warehouse {
	private Integer[] items;
	private Integer capacity;
	private Integer index = -1;
	private Boolean processing = false;
	
	public Warehouse(int capacity) {
		items = new Integer[capacity];
		this.capacity = capacity;
	}
	
	public int getIndex() {
		return index;
	}
	
	public synchronized void produce(int item) {
		while(processing) {
			try {
				wait();
			} catch(InterruptedException e) {
				//
			}
		}
		if(index < capacity - 1) {
			processing = true;
			index++;
			items[index] = item;
			notifyAll();
		}
	}
	
	public synchronized int consume() {
		while(!processing) {
			try {
				wait();
			} catch(InterruptedException e) {
				//
			}
		}
		processing = false;
		int consumedItem = items[index];
		items[index] = null;
		index--;
		notifyAll();
		return consumedItem;
	}
}
