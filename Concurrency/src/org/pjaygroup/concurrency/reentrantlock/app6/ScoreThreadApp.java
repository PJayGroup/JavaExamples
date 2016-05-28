/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author Vijay Konduru
 * @source https://dzone.com/articles/java-concurrency-read-write-lo
 * According to above link. Read Write Access are given as below.
 * Read Access - If no threads are writing, and no threads have requested write access.
 * Write Access - If no threads are reading or writing.
 *
 */
public class ScoreThreadApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadSafeArrayList threadSafeArrayList = new ThreadSafeArrayList();
		ExecutorService addExecutor = Executors.newFixedThreadPool(3);
		ExecutorService maxExecutor = Executors.newFixedThreadPool(3);
		for(int i=0;i<3;i++){
			addExecutor.execute(new ScoreAddThread(threadSafeArrayList));
			maxExecutor.execute(new ScoreMaxThread(threadSafeArrayList));
		}
		try {
			addExecutor.shutdown();
			maxExecutor.shutdown();
			while(true){
				if(addExecutor.awaitTermination(20, TimeUnit.SECONDS) && maxExecutor.awaitTermination(20, TimeUnit.SECONDS)){
					break;
				}else{
					addExecutor.shutdownNow();
					maxExecutor.shutdownNow();
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
