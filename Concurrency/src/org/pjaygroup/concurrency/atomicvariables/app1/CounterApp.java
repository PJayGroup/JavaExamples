/**
 * 
 */
package org.pjaygroup.concurrency.atomicvariables.app1;

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
		// We will rarely get 20000 as result, due to concurrent access.
		// We will try solving this problem using volatile and atomic integer in our next apps
		System.out.println("Count value :: " + counter.getCount());
	}

}
