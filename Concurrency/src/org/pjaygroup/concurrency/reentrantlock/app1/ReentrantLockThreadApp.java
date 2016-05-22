/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app1;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vijay
 *
 */
public class ReentrantLockThreadApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Lock lock = new ReentrantLock(true);
		Thread t1 = new Thread(new ReentrantLockThread(lock));
		Thread t2 = new Thread(new ReentrantLockThread(lock));
		t1.setName("thread-t1");
		t2.setName("thread-t2");
		t1.start();
		t2.start();
		try {
			t1.join();t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
