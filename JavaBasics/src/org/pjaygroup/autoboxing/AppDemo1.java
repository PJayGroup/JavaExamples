/**
 * 
 */
package org.pjaygroup.autoboxing;

/**
 * @author Vijay Konduru
 *
 */
public class AppDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer int1 = new Integer(16);
		Integer int2 = new Integer(16);
		System.out.println(" :: int1 == int2 :: " + (int1 == int2));
		System.out.println(" :: int1.equals(int2) :: " + int1.equals(int2));
		
		Integer int3 = 120;
		Integer int4 = 120;
		System.out.println(" :: int3 == int4 :: " + (int3 == int4));
		
		Integer int5 = 127;
		Integer int6 = 127;
		System.out.println(" :: int5 == int6 :: " + (int5 == int6));
		
		Integer int7 = -128;
		Integer int8 = -128;
		System.out.println(" :: int7 == int8 :: " + (int7 == int8));
		
		Integer int9 = 136;
		Integer int10 = 136;
		System.out.println(" :: int9 == int10 :: " + (int9 == int10));
		
		Integer int11 = -136;
		Integer int12 = -136;
		System.out.println(" :: int11 == int12 :: " + (int11 == int12));
		
		// Check Integer.valueOf(int i) for better understanding
	}

}
