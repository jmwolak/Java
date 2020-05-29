/*
 * Given two strings, a and b, 
 * return the result of putting 
 * them together in the order abba, 
 * e.g. "Hi" and "Bye" returns "HiByeByeHi".
 */

public class MakeAbba {

	public static String makeAbba(String str1, String str2) {

		return str1 + str2 + str2 + str1;

	}

	public static void main(String[] args) {

		System.out.println(makeAbba("Hi", "Bye"));
		System.out.println(makeAbba("Yo", "Alice"));
		System.out.println(makeAbba("What", "Up"));
	}

}
