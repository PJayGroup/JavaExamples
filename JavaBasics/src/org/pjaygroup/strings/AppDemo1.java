/**
 * 
 */
package org.pjaygroup.strings;

/**
 * @author Vijay Konduru
 *
 */
public class AppDemo1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		long entryTime, exitTime;
		String str1 = "Value1";
		str1.concat("Value2");
		System.out.println(" :: str1 :: " + str1);//Value1
		
		String str2 = "Value1";
		String concat = str2.concat("Value2");
		System.out.println(" :: str2 :: " + str2);//Value1
		System.out.println(" :: concat :: " + concat);//Value1
		
		String str3 = "Value1";
		String str4 = "Value2";
		entryTime = System.currentTimeMillis();
		for (int i=0;i<=100000;i++) {
			// This code takes long time than below loop and significantly impacts performance 
			str3 = str3+str4;
		}
		exitTime = System.currentTimeMillis();
		System.out.println(" :: Time taken for Strings approach :: " + (exitTime - entryTime));

		StringBuffer buffer = new StringBuffer("Value1");
		String str5 = "Value2";
		entryTime = System.currentTimeMillis();
		for (int i=0;i<=100000;i++) {
			// This code takes less time than above loop
			buffer.append(str5);
		}
		exitTime = System.currentTimeMillis();
		System.out.println(" :: Time taken for StringBuffer approach :: " + (exitTime - entryTime));
		
		// Console output
		/**
			 :: Time taken for Strings approach :: 39174
			 :: Time taken for StringBuffer approach :: 9
		 */
		
		String str6 = "abcdefghijk";
		System.out.println(" :: str6.charAt(4) :: " + str6.charAt(4));
		System.out.println(" :: str6.length() :: " + str6.length());
		System.out.println(" :: str6.substring(3) :: " + str6.substring(3));
		System.out.println(" :: str6.substring(3, 7) :: " + str6.substring(3, 7));
	}

}
