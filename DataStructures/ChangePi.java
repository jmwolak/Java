
/*

 * Name: James Wolak

 * Date: 11/15/2019

 * Course Number: CSC-220

 * Course Name: Data Structures/ Algorithms

 * Problem Number: HW 8

 * Email: jmwolak0001@student.stcc.edu

 * Short Description of the Problem:
 * 
 * Given a string, using recursion, this program will replace all appearances of pi
 * with "3.14".

 */

import java.util.Scanner;

public class ChangePi {

	private final static String TITLE = "Replace Pi Test";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";

	// *****************************************************************

	public static String changePi(String str) {

		if (str.length() < 2)
			return str;

		if (str.substring(0, 2).equals("pi"))
			return "3.14" + changePi(str.substring(2));

		return str.charAt(0) + changePi(str.substring(1));
	}

	// *****************************************************************

	private static void process(Scanner sc, String args[]) {
		Scanner input = new Scanner(System.in);
		String str;
		String ans;

		System.out.println("Please enter a String with the inclusion of pi within that String");
		str = input.next();

		ans = changePi(str);

		System.out.println(ans);
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
