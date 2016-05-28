/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app6;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Vijay Konduru
 *
 */
public class ScoreAddThread implements Runnable{
	
	private ThreadSafeArrayList threadSafeArrayList;
	private ThreadLocalRandom threadLocalRandom;
	
	public ScoreAddThread(ThreadSafeArrayList threadSafeArrayList) {
		this.threadSafeArrayList = threadSafeArrayList;
	}

	@Override
	public void run() {
		threadLocalRandom = ThreadLocalRandom.current();
		int randomNum = threadLocalRandom.nextInt(5, 100);
		try {
			for(;;){
				if(Thread.interrupted()){break;}
				threadSafeArrayList.add(randomNum);
				System.out.println("Write Lock acquired by :: " + Thread.currentThread().getName() + " Added score :: " + randomNum);
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
