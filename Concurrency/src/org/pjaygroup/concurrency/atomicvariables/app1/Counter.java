/**
 * 
 */
package org.pjaygroup.concurrency.atomicvariables.app1;

/**
 * @author Vijay Konduru
 *
 */
public class Counter {

	private int count;

	public void increment() {
		count++;
	}

	public int getCount() {
		return count;
	}
}
