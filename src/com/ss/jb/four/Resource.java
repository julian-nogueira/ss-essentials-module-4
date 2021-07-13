package com.ss.jb.four;

/**
 * The Resource class aids with Assignment 2, such that a Resource object can
 * be created, then accessed with a thread. Multiple threads can try to use
 * mutator functions to illustrate deadlock.
 */
public class Resource {
	private String name;
	private int quantity;
	
	public Resource(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	public String getName() {
		return name;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void decrementQuantity() {
		synchronized (this) {
			quantity--;
		}
		System.out.println(name + ": " + quantity);
	}
	
	public void incrementQuantity() {
		synchronized (this) {
			quantity++;
		}
		System.out.println(name + ": " + quantity);
	}
}
