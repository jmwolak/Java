/*
 * Given 2 strings, return their concatenation, 
 * except omit the first char of each. The 
 * strings will be at least length 1.
 */

public class NonStart {

	public static String nonStart(String a, String b) {
		
		return a.substring(1, a.length()) + b.substring(1, b.length());
		  
	}
	
	public static void main(String[] args) {
		System.out.println(nonStart("Hello", "There"));
		System.out.println(nonStart("java", "code"));
		System.out.println(nonStart("shotl", "java"));

	}

}
