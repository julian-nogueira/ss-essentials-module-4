package com.ss.jb.four;

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
