/**
 * 
 */
package org.pjaygroup.concurrency.atomicvariables.app3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Vijay
 *
 */
public class Counter {

	private AtomicInteger count = new AtomicInteger();

	public void increment() {
		count.incrementAndGet();
	}

	public int getCount() {
		return count.get();
	}
}
