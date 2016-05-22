/**
 * 
 */
package org.pjaygroup.concurrency.reentrantlock.app5;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Vijay
 *
 */
public class EvenAndOddPrintReentrantLockConditionApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Please a number for printing even and odd numbers");
		Long start = System.currentTimeMillis();
		try {
			PrinterDetails printerDetails = new PrinterDetails();
			Integer counter = in.nextInt();
			EvenAndOddPrintRunnable oddThreadObject = new EvenAndOddPrintRunnable(printerDetails, counter, false);
			EvenAndOddPrintRunnable evenThreadObject = new EvenAndOddPrintRunnable(printerDetails, counter, true);
			Thread oddThread = new Thread(oddThreadObject, "Odd Thread");
			Thread evenThread = new Thread(evenThreadObject, "Even Thread");
			oddThread.start();
			evenThread.start();
			try {
				oddThread.join();
				evenThread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.out.println("Please enter a valid number");
		}
		Long end = System.currentTimeMillis();
		System.out.println("Time taken is:: " + (end - start));
		in.close();
	}

}

class EvenAndOddPrintRunnable implements Runnable{

	PrinterDetails printer = null;
	Integer maxPrintNum = null;
	boolean isEven = false;
	
	public EvenAndOddPrintRunnable(PrinterDetails printer, Integer maxPrintNum, boolean isEven) {
		this.printer = printer;
		this.maxPrintNum = maxPrintNum;
		this.isEven = isEven;
	}
	
	@Override
	public void run() {
		int count = isEven?2:1;
		while(count <= maxPrintNum){
			if(isEven){
				printer.printEven(count);
			}else{
				printer.printOdd(count);
			}
			count+=2;
		}
	}
}

class PrinterDetails{
	
	private volatile boolean printOdd = true;
	private ReentrantLock lock = new ReentrantLock();
	private Condition condOdd = lock.newCondition();
	private Condition condEven = lock.newCondition();
	
	public void printOdd(int count) {
		lock.lock();
		try{
			if(!printOdd){
				try {
					// Wait on even condition to signal you, as we are not supposed to print odd number now
					condEven.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Thread name:: " + Thread.currentThread().getName() +" Printing Odd Number:: " + count);
			printOdd = false;
			condOdd.signal();
		}finally{
			lock.unlock();
		}
	}
	
	public void printEven(int count) {
		lock.lock();
		try{
			if(printOdd){
				try {
					// Wait on odd condition to signal you, as we are not supposed to print even number now
					condOdd.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("Thread name:: " + Thread.currentThread().getName() +" Printing Even Number:: " + count);
			printOdd = true;
			condEven.signal();
		}finally{
			lock.unlock();
		}
	}
}