/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app1;

import java.util.concurrent.locks.Lock;

/**
 * @author Vijay
 *
 */
public class ReentrantLockThread implements Runnable{
	
	private Lock lock;
	
	public ReentrantLockThread(Lock lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		for(int i=0;i<5;i++){
			lock.lock();
			try {
				System.out.println("Thread Name :: " + Thread.currentThread().getName() + " :: has acquired the lock");
			} finally {
				lock.unlock();
			}
		}
	}

}
