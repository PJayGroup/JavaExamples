/**
 * 
 */
package org.pjaygroup.concurrency.atomicvariables.app1;

/**
 * @author Vijay
 *
 */
public class IncrementThread implements Runnable {

	private Counter counter;

	public IncrementThread(Counter counter) {
		this.counter = counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10000; i++) {
			counter.increment();
		}
	}

}
