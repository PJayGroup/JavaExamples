/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app6;

/**
 * @author Vijay Konduru
 *
 */
public class ScoreMaxThread implements Runnable{
	
	private ThreadSafeArrayList threadSafeArrayList;
	
	public ScoreMaxThread(ThreadSafeArrayList threadSafeArrayList) {
		this.threadSafeArrayList = threadSafeArrayList;
	}

	@Override
	public void run() {
		try {
			for(;;){
				if(Thread.interrupted()){break;}
				System.out.println("Max in collection is :: " + threadSafeArrayList.getMax() + " Thread name :: " + Thread.currentThread().getName());
				Thread.sleep(1);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
