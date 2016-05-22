/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app4;

import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Logger;

/**
 * @author Vijay
 *
 */
public class FisherManThread implements Runnable{
	
	private ThreadLocalRandom threadLocalRandom;
	private static final String CLASS_NAME = FisherManThread.class.getName();// Thread.currentThread().getStackTrace()[0].getClassName()
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);// Change level to log enter and exit details from logger 
	
	public FisherManThread() {
		threadLocalRandom = ThreadLocalRandom.current();
	}

	@Override
	public void run() {
		LOGGER.entering(CLASS_NAME, "entering run()");
		boolean fishesLock = false;
		int randomNumber;
		for(int i=1;i<=10000;i++){
			try {
				fishesLock = FishTank.getLockOnNumberOfFishes().tryLock();
				// If you have an use case that needs to trylock after certain interval you can use. "tryLock(2, TimeUnit.SECONDS);"
				if(!fishesLock){
					cleanFishTank();
				}else{
					randomNumber = threadLocalRandom.nextInt(5, 10);
					FishTank.getNumberOfFishes().addAndGet(randomNumber);
					LOGGER.info("No of fishes added to fish tank :: " + randomNumber);
				}
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				if(fishesLock){FishTank.getLockOnNumberOfFishes().unlock();}
				if(Thread.interrupted()){
					break;
				}
			}
		}
		System.out.println(" :: Fish Tank Data With Fisher Man ::" + FishTank.getInstance().toString());
		LOGGER.exiting(CLASS_NAME, "exiting run()");
	}
	
	private void cleanFishTank() {
		LOGGER.entering(CLASS_NAME, "entering cleanFishTank()");
		int randomNumber = threadLocalRandom.nextInt(1, 5);
		if(FishTank.getNumberOfSkeletons().get() >= randomNumber){
			for(int j=1;j<=randomNumber;j++){
				FishTank.getNumberOfSkeletons().decrementAndGet();
			}
			LOGGER.info("No of skeletons cleaned :: " + randomNumber);
		}
		LOGGER.exiting(CLASS_NAME, "exiting cleanFishTank()");
	}
}
