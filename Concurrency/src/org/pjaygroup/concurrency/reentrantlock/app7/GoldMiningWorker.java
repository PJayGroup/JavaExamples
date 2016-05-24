/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app7;

import java.util.logging.Logger;

/**
 * @author Vijay
 *
 */
public class GoldMiningWorker implements Runnable{
	
	private static final Logger LOGGER = Logger.getLogger(GoldMiningWorker.class.getName());

	@Override
	public void run() {
		while(true){
			MetalVault.getInstance().getReentrantLock().lock();
			try{
				if(MetalVault.getInstance().getGoldBars().get() <= 0){
					if(MetalVault.getInstance().getGoldBars().get() < 0){break;}
					try {
						MetalVault.getInstance().getGoldCondition().await();
						LOGGER.info(" :: Waking up GoldMiningWorker :: ");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					LOGGER.info("GoldMiningWorker Taking " + MetalVault.getInstance().getGoldBars().get() + " Gold bars");
					MetalVault.getInstance().setGoldBars(0);
				}
			} finally {
				MetalVault.getInstance().getReentrantLock().unlock();
			}
		}
	}

}
