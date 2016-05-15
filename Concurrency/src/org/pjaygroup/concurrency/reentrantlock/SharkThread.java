/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

/**
 * @author Vijay
 *
 */
public class SharkThread implements Runnable{
	
	private ThreadLocalRandom threadLocalRandom;
	private static final String CLASS_NAME = SharkThread.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);
	
	public SharkThread() {
		threadLocalRandom = ThreadLocalRandom.current();
	}

	@Override
	public void run() {
		LOGGER.entering(CLASS_NAME, "entering run()");
		boolean fishesLock = false;
		int randomNumber = 0;
		for(int i=1;i<=10000;i++){
			try {
				fishesLock = FishTank.getLockOnNumberOfFishes().tryLock();
				if(fishesLock){
					randomNumber = threadLocalRandom.nextInt(1, 5);
					if(FishTank.getNumberOfFishes().get() >= randomNumber){
						for(int j=1;j<=randomNumber;j++){
							// Lets eat the fish
							FishTank.getNumberOfFishes().decrementAndGet();
							// Lets spit the skeleton
							FishTank.getNumberOfSkeletons().incrementAndGet();
						}
						LOGGER.info("No of fishes or skeletons created :: " + randomNumber);
					}
				}
				// Lets take some rest before attacking another set of fishes
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				if(fishesLock){
					FishTank.getLockOnNumberOfFishes().unlock();
				}
				if(Thread.interrupted()){
					break;
				}
			}
		}
		System.out.println(" :: Fish Tank Data With Shark ::" + FishTank.getInstance().toString());
		LOGGER.exiting(CLASS_NAME, "exiting run()");
	}

}
