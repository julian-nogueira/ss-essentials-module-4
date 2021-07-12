package com.ss.jb.four;

/**
 * Employ a thread-safe Singleton class. The only synchronization occurs at the
 * most critical section, that is at instantiation of the object. There are two
 * checks so that threads do not need to wait if the instance != null. 
 */
public class MySingleton {
    private static MySingleton instance;
    public static int myInstanceCount = 0;
    public static int myCallCount = 0;
    
    private MySingleton() {}
    
    public static MySingleton getInstance() {
        if(instance == null) {
            synchronized(MySingleton.class) {
                if(instance == null) {
                    instance = new MySingleton();
                    myInstanceCount++;
                }
            }
        }
        myCallCount++;
        return instance;
    }
}
