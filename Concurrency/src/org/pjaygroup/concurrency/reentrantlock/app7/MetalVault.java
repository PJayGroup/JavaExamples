/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vijay
 *
 */
public class MetalVault {

	private static MetalVault metalVault = new MetalVault();

	private AtomicInteger goldBars = new AtomicInteger();
	private AtomicInteger silverBars = new AtomicInteger();
	private AtomicInteger bronzeBars = new AtomicInteger();

	private Lock reentrantLock;
	private Condition goldCondition;
	private Condition silverCondition;
	private Condition bronzeCondition;

	private MetalVault() {
		reentrantLock = new ReentrantLock();
		goldCondition = reentrantLock.newCondition();
		silverCondition = reentrantLock.newCondition();
		bronzeCondition = reentrantLock.newCondition();
	}

	public static MetalVault getInstance() {
		return metalVault;
	}

	public void setGoldBars(int goldBars) {
		this.goldBars.set(goldBars);
	}

	public void setSilverBars(int silverBars) {
		this.silverBars.set(silverBars);
	}

	public void setBronzeBars(int bronzeBars) {
		this.bronzeBars.set(bronzeBars);
	}

	public AtomicInteger getGoldBars() {
		return goldBars;
	}

	public AtomicInteger getSilverBars() {
		return silverBars;
	}

	public AtomicInteger getBronzeBars() {
		return bronzeBars;
	}

	public Lock getReentrantLock() {
		return reentrantLock;
	}

	public Condition getGoldCondition() {
		return goldCondition;
	}

	public Condition getSilverCondition() {
		return silverCondition;
	}

	public Condition getBronzeCondition() {
		return bronzeCondition;
	}
}
