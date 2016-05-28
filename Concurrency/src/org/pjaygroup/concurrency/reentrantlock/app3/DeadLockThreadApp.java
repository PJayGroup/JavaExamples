/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vijay Konduru
 *
 */
public class DeadLockThreadApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// This app easily creates dead lock between two threads, To avoid this locks should be acquired and released in the same order
		// This can be avoided in a better way using reentrant locks, we will see that in next app
		Lock lock1 = new ReentrantLock();
		Lock lock2 = new ReentrantLock();
		
		Thread thread1 = new Thread(new DeadLockThread1(lock1, lock2));
		Thread thread2 = new Thread(new DeadLockThread2(lock1, lock2));
		thread1.setName("thread1");
		thread2.setName("thread2");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
