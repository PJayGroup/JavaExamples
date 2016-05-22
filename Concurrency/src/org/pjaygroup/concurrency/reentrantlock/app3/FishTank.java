/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app3;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vijay
 *
 */
public class FishTank {
	
	private static FishTank fishTank = new FishTank();
	private AtomicInteger numberOfFishes;
	private AtomicInteger numberOfSkeletons;
	private Lock lockOnNumberOfFishes;
	
	private FishTank() {
		// Lets start with default values for fishes and skeletons
		numberOfFishes = new AtomicInteger(0);
		numberOfSkeletons = new AtomicInteger(0);
		lockOnNumberOfFishes = new ReentrantLock(true);
	}
	
	public static FishTank getInstance() {
		return fishTank;
	}

	public static AtomicInteger getNumberOfFishes() {
		return getInstance().numberOfFishes;
	}

	public static AtomicInteger getNumberOfSkeletons() {
		return getInstance().numberOfSkeletons;
	}

	public static Lock getLockOnNumberOfFishes() {
		return getInstance().lockOnNumberOfFishes;
	}

	@Override
	public String toString() {
		return "FishTank [numberOfFishes=" + numberOfFishes + ", numberOfSkeletons=" + numberOfSkeletons
				+ ", lockOnNumberOfFishes=" + lockOnNumberOfFishes + "]";
	}

}
