
/*
 * Short Description of the Problem
	Using Recursion, this program will count take each character of a String 
	and count how many times it had been
 */

import java.util.ArrayList;
import java.util.Scanner;

public class RecursionWithArrayList {

	private final static String TITLE = "Recursion With ArrayList";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";

	// *****************************************************************

	public static ArrayList<RecursionInfo> array(String str) {
		ArrayList<RecursionInfo> a = new ArrayList<RecursionInfo>();
		char letter;
		int count;

		for (int i = 0; i < str.length(); i++) {

			letter = str.charAt(i);
			count = countChar(str, letter);

			RecursionInfo r = new RecursionInfo(letter, count);

			int index = a.indexOf(r);

			if (index < 0) {

				a.add(r);

			}

		}

		return a;
	}
	// *****************************************************************

	public static int countChar(String str, char letter) {

		if (str.length() == 0)
			return 0;

		if (str.charAt(0) == letter)
			return 1 + countChar(str.substring(1), letter);

		return countChar(str.substring(1), letter);

	}

	// *****************************************************************

	private static void process(Scanner sc, String args[]) {
		Recursion rec = new Recursion();
		ArrayList<RecursionInfo> a2 = new ArrayList<RecursionInfo>();

		Scanner input = new Scanner(System.in);
		int i = 0;
		String str;

		System.out.print("Please Enter your String: ");
		str = input.next();

		System.out.println(array(str));
	}

	// *****************************************************************

	private static boolean doThisAgain(Scanner sc, String prompt) {

		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");

	}

	// *****************************************************************

	public static void main(String[] args) {

		System.out.println("Welcome to " + TITLE);

		Scanner sc = new Scanner(System.in);

		do {

			process(sc, args);

		} while (doThisAgain(sc, CONTINUE_PROMPT));

		sc.close();

		System.out.println("Thank you for using " + TITLE);

	}

}
