/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app7;

/**
 * @author Vijay Konduru
 *
 */
public class MetalMiningApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Thread t1 = new Thread(new MetalMiningPlayStore());
		Thread t2 = new Thread(new GoldMiningWorker());
		Thread t3 = new Thread(new SilverMiningWorker());
		Thread t4 = new Thread(new BronzeMiningWorker());
		
		t1.start();t2.start();t3.start();t4.start();
		
		try {
			t1.join();t2.join();t3.join();t4.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
