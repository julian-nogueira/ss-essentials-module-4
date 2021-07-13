package com.ss.jb.four;

/**
 * Create an instance of Resource 1 and Resource 2. Then, start two threads,
 * such that both threads will try to access the resources in reverse order.
 * While Thread 1 is accessing the Resource 1, we force the Thread 1 to sleep.
 * While Thread 1 is sleeping, Thread 2 will try to access Resource 1. However,
 * it is locked since Thread 1 is still holding onto it. When Thread 1 wakes
 * up, it tries to access Resource 2, but this resource is being held onto by
 * Thread 2. Therefore, both threads are suspended, waiting for each other to
 * release a resource.
 */
public class Assignment2 {
	public static void main(String[] args) {
		Resource resource1 = new Resource("Pens", 200);
		Resource resource2 = new Resource("Paper", 1000);
		
		(new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (resource1) {
					System.out.println("\nUsing resource: " + resource1.getName());
					resource1.decrementQuantity();
					System.out.println("Finished using resource: " + resource1.getName());
					
					try {
						Thread.sleep(3000);
					} catch(InterruptedException e) {
						System.out.println("Thread was interrupted.");
					}
					
					System.out.println("\nWaiting to use resource: " + resource2.getName());
					
					synchronized (resource2) {
						resource2.decrementQuantity();
						System.out.println("Finished using resource: " + resource2.getName());
					}
				}
			}
		})).start();
		
		(new Thread(new Runnable() {
			@Override
			public void run() {
				synchronized (resource2) {
					System.out.println("\nUsing resource: " + resource2.getName());
					resource2.decrementQuantity();
					System.out.println("Finished using resource: " + resource2.getName());
					
					System.out.println("\nWaiting to use resource: " + resource1.getName());
					
					synchronized (resource1) {
						resource1.decrementQuantity();
						System.out.println("Finished using resource: " + resource1.getName());
					}
				}
			}
		})).start();
	}
}
