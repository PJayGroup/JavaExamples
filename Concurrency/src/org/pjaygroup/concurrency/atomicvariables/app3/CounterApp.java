/**
 * 
 */
package org.pjaygroup.concurrency.atomicvariables.app3;

/**
 * @author Vijay
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
		// Always gives 20000
		System.out.println("Count value :: " + counter.getCount());
	}

}
