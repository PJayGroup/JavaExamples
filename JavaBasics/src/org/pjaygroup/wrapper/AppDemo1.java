/**
 * 
 */
package org.pjaygroup.wrapper;

/**
 * @author Vijay Konduru
 *
 */
public class AppDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Any String other than true (not case sensitive, all are considered true) will result in false 
		Boolean bool1 = new Boolean("true");
		Boolean bool2 = new Boolean("TRUE");
		Boolean bool3 = new Boolean("tRue");
		Boolean bool4 = new Boolean("TRUe");
		Boolean bool5 = new Boolean("Its correct");
		Boolean bool6 = new Boolean("trUE");
		Boolean bool7 = new Boolean("SomeThing");
		Boolean bool8 = new Boolean("False");
		Boolean bool9 = new Boolean("False Statement");
		
		System.out.println(" :: All Boolean Values :: " );
		System.out.println(" :: bool1 :: " + bool1);
		System.out.println(" :: bool2 :: " + bool2);
		System.out.println(" :: bool3 :: " + bool3);
		System.out.println(" :: bool4 :: " + bool4);
		System.out.println(" :: bool5 :: " + bool5);
		System.out.println(" :: bool6 :: " + bool6);
		System.out.println(" :: bool7 :: " + bool7);
		System.out.println(" :: bool8 :: " + bool8);
		System.out.println(" :: bool9 :: " + bool9);
	}

}
