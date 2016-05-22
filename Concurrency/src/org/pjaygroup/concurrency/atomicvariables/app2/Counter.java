/**
 * 
 */
package org.pjaygroup.concurrency.atomicvariables.app2;

/**
 * @author Vijay
 *
 */
public class Counter {

	private volatile int count;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}
