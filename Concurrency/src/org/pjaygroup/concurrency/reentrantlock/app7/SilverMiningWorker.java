/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app7;

import java.util.logging.Logger;

/**
 * @author Vijay Konduru
 *
 */
public class SilverMiningWorker implements Runnable{
	
	private static final Logger LOGGER = Logger.getLogger(SilverMiningWorker.class.getName());

	@Override
	public void run() {
		while(true){
			MetalVault.getInstance().getReentrantLock().lock();
			try{
				if(MetalVault.getInstance().getSilverBars().get() <= 0){
					if(MetalVault.getInstance().getSilverBars().get() < 0){break;}
					try {
						MetalVault.getInstance().getSilverCondition().await();
						LOGGER.info(" :: Waking up SilverMiningWorker :: ");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					LOGGER.info("SilverMiningWorker Taking " + MetalVault.getInstance().getSilverBars().get() + " Silver bars");
					MetalVault.getInstance().setSilverBars(0);
				}
			} finally {
				MetalVault.getInstance().getReentrantLock().unlock();
			}
		}
	}

}
