package com.ss.jb.four;

/**
 * Create an instance of MySingleton. Then, run a few threads that will
 * call the getInstance method. Check the myInstanceCount attribute to
 * ensure that only one object was created.
 */
public class Assignment1 {
    public static void main(String[] args) {
        MySingleton mySingleton = MySingleton.getInstance();
        
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                MySingleton instance1 = MySingleton.getInstance();
            }
        };
        
        Runnable runnable2 = new Runnable() {
            @Override
            public void run() {
                MySingleton instance2 = MySingleton.getInstance();
            }
        };
        
        Runnable runnable3 = new Runnable() {
            @Override
            public void run() {
                MySingleton instance3 = MySingleton.getInstance();
            }
        };
        
        (new Thread(runnable1)).start();
        (new Thread(runnable2)).start();
        (new Thread(runnable3)).start();
        
        System.out.println("MySingleton instance count: " + MySingleton.myInstanceCount);
        System.out.println("MySingleton get instance call count: " + MySingleton.myCallCount);
    }
}
