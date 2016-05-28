/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app2;

/**
 * @author Vijay Konduru
 *
 */
public class DeadLockThread2 implements Runnable{

	private Object obj1;
	private Object obj2;
	
	public DeadLockThread2(Object obj1, Object obj2) {
		this.obj1 = obj1;
		this.obj2 = obj2;
	}

	@Override
	public void run() {
		synchronized (obj2) {
			System.out.println("Thread :: " + Thread.currentThread().getName() + " acquired monitor for obj2");
			synchronized (obj1) {
				System.out.println("Thread :: " + Thread.currentThread().getName() + " acquired monitor for obj1");
			}
		}
	}
}
