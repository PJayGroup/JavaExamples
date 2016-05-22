/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app2;

/**
 * @author Vijay
 *
 */
public class DeadLockThreadApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// This app easily creates dead lock between two threads, To avoid this locks should be acquired and released in the same order
		// This can be avoided in a better way using reentrant locks, we will see that in next app
		Object obj1 = new Object();
		Object obj2 = new Object();
		
		Thread thread1 = new Thread(new DeadLockThread1(obj1, obj2));
		Thread thread2 = new Thread(new DeadLockThread2(obj1, obj2));
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
