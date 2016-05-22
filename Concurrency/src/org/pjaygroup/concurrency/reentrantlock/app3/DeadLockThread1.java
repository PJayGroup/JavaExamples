/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app3;

import java.util.concurrent.locks.Lock;

/**
 * @author Vijay
 *
 */
public class DeadLockThread1 implements Runnable{

	private Lock lock1;
	private Lock lock2;
	
	public DeadLockThread1(Lock lock1, Lock lock2) {
		this.lock1 = lock1;
		this.lock2 = lock2;
	}

	@Override
	public void run() {
		while(true){
			boolean acqLock1 = lock1.tryLock();
			boolean acqLock2 = lock2.tryLock();
			try {
				if(acqLock1 && acqLock2){
					System.out.println("Thread :: " + Thread.currentThread().getName() + " acquired both lock1 and lock2");
					System.out.println("Thread :: " + Thread.currentThread().getName() + " has finished the job");
					break;
				}
			} finally {
				if(acqLock1){lock1.unlock();}
				if(acqLock2){lock2.unlock();}
			}
		}
	}
}
