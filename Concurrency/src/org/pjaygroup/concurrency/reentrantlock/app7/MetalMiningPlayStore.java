/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app7;

import java.util.Scanner;

/**
 * @author Vijay
 *
 */
public class MetalMiningPlayStore implements Runnable {

	Scanner in = new Scanner(System.in);
	final int SIGNAL_KILL = -1;

	public MetalMiningPlayStore() {
	}

	@Override
	public void run() {
		int consoleData = 0;
		for (int i = 5; i > 0; i--) {//use while(true) instead for loop Then app will keep running, until you trigger quit parameter
			try {
				System.out.println("Please enter values greater that zero to add it to corresponding vault and if you wish to quit add negative value");
				System.out.println("Enter number of Gold bars:: ");

				consoleData = in.nextInt();
				if (consoleData < 0) {
					break;
				} else {
					addGold(consoleData);
				}

				System.out.println("Enter number of Silver bars:: ");

				consoleData = in.nextInt();
				if (consoleData < 0) {
					break;
				} else {
					addSilver(consoleData);
				}

				System.out.println("Enter number of Bronze bars:: ");

				consoleData = in.nextInt();
				if (consoleData < 0) {
					break;
				} else {
					addBronze(consoleData);
				}

			} catch (Exception e) {
				System.out.println("Please enter a valid number");
				e.printStackTrace();
				break;
			} finally {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		signalKillToOtherThreads();
	}

	private void addBronze(int consoleData) {
		MetalVault.getInstance().getReentrantLock().lock();
		try {
			MetalVault.getInstance().setBronzeBars(consoleData);
			MetalVault.getInstance().getBronzeCondition().signal();
		} finally {
			MetalVault.getInstance().getReentrantLock().unlock();
		}
	}

	private void addSilver(int consoleData) {
		MetalVault.getInstance().getReentrantLock().lock();
		try {
			MetalVault.getInstance().setSilverBars(consoleData);
			MetalVault.getInstance().getSilverCondition().signal();
		} finally {
			MetalVault.getInstance().getReentrantLock().unlock();
		}
	}

	private void addGold(int consoleData) {
		MetalVault.getInstance().getReentrantLock().lock();
		try {
			MetalVault.getInstance().setGoldBars(consoleData);
			MetalVault.getInstance().getGoldCondition().signal();
		} finally {
			MetalVault.getInstance().getReentrantLock().unlock();
		}
	}

	private void signalKillToOtherThreads() {
		MetalVault.getInstance().getReentrantLock().lock();
		try {
			MetalVault.getInstance().setGoldBars(SIGNAL_KILL);
			MetalVault.getInstance().setSilverBars(SIGNAL_KILL);
			MetalVault.getInstance().setBronzeBars(SIGNAL_KILL);
			MetalVault.getInstance().getGoldCondition().signal();
			MetalVault.getInstance().getSilverCondition().signal();
			MetalVault.getInstance().getBronzeCondition().signal();
		} finally {
			MetalVault.getInstance().getReentrantLock().unlock();
		}
	}
}
