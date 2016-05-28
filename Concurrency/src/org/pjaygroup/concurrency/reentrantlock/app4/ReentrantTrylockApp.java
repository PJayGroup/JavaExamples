/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

/**
 * @author Vijay Konduru
 *
 */
public class ReentrantTrylockApp {
	
	private static final String CLASS_NAME = ReentrantTrylockApp.class.getName();
	private static final Logger LOGGER = Logger.getLogger(CLASS_NAME);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LOGGER.entering(CLASS_NAME, "entering main()");
		ExecutorService FisherManExtSrv = Executors.newSingleThreadExecutor();
		ExecutorService SharkExtSrv = Executors.newSingleThreadExecutor();
		FisherManExtSrv.submit(new FisherManThread());
		SharkExtSrv.submit(new SharkThread());
		FisherManExtSrv.shutdown();
		SharkExtSrv.shutdown();
		LOGGER.exiting(CLASS_NAME, "exiting main()");
	}

}
