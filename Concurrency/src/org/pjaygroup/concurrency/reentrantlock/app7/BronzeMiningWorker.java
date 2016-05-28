/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app7;

import java.util.logging.Logger;

/**
 * @author Vijay Konduru
 *
 */
public class BronzeMiningWorker implements Runnable{
	
	private static final Logger LOGGER = Logger.getLogger(BronzeMiningWorker.class.getName());

	@Override
	public void run() {
		while(true){
			MetalVault.getInstance().getReentrantLock().lock();
			try{
				if(MetalVault.getInstance().getBronzeBars().get() <= 0){
					if(MetalVault.getInstance().getBronzeBars().get() < 0){break;}
					try {
						MetalVault.getInstance().getBronzeCondition().await();
						LOGGER.info(" :: Waking up BronzeMiningWorker :: ");
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}else{
					LOGGER.info("BronzeMiningWorker Taking " + MetalVault.getInstance().getBronzeBars().get() + " Bronze bars");
					MetalVault.getInstance().setBronzeBars(0);
				}
			} finally {
				MetalVault.getInstance().getReentrantLock().unlock();
			}
		}
	}

}
