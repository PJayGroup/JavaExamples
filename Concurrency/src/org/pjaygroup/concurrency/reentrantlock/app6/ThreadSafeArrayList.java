/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Vijay
 *
 */
public class ThreadSafeArrayList{
	
	private List<Integer> scoreData;
	private ReentrantReadWriteLock readWriteLock;
	private Lock readLock;
	private Lock writeLock;
	
	public ThreadSafeArrayList() {
		this.scoreData = new ArrayList<>(Arrays.asList(new Integer[]{22,42,32,19,9}));
		this.readWriteLock = new ReentrantReadWriteLock();;
		readLock = this.readWriteLock.readLock();
		writeLock = this.readWriteLock.writeLock();
	}
	
	public void add(Integer i) {
		writeLock.lock();
		try {
			scoreData.add(i);
		} finally {
			writeLock.unlock();
		}
	}
	
	public Integer getMax() {
		int max = 0;
		readLock.lock();
		try {
			max = Collections.max(scoreData);
		} finally {
			readLock.unlock();
		}
		return max;
	}
}
