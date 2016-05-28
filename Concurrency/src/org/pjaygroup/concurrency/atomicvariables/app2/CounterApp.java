/**
 * 
 */
package org.pjaygroup.concurrency.atomicvariables.app2;

/**
 * @author Vijay Konduru
 *
 */
public class CounterApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Counter counter = new Counter();
		Thread t1 = new Thread(new IncrementThread(counter));
		Thread t2 = new Thread(new IncrementThread(counter));
		t1.start();
		t2.start();
		try {
			t1.join();t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// Still no guarantee of 20000 result. Though the threads don't read from cache, chance that different states in threads are committed one after other threads
		System.out.println("Count value :: " + counter.getCount());
	}

}
