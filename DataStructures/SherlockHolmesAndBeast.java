
/*
 * This program will ask the user to input a number length. The program will then print a Decent Number
 */
import java.util.Scanner;

public class SherlockHolmesAndBeast {
	final static String TITLE = "Sherlock Holmes and the Beast Extra Credit. ";
	final static String CONTINUE_PROMPT = "\nDo this again? [y/N]";
	final static boolean PROCESS_USING_SCANNER = true;

//******************************************************************

	private static int decentNum(int length) {
		String five = "5";
		String three = "3";
		int length2;
		int l;

		l = length;

		while (length % 3 != 0) {

			length -= 5;

		}

		for (int i = 0; i < length; i++) {

			System.out.print(five);

		}

		int lengthDiff = l - length;

		for (int i = 0; i < lengthDiff; i++) {

			System.out.print(three);
		}
		return length;

	}

//*************************************************************************	
	private static void process(Scanner sc, String args[]) {

		int num;

		System.out.println("Enter the length of the Decent number.");
		num = sc.nextInt();
		System.out.println("Decent number length:\n" + num);
		System.out.println("Decent Number:");

		decentNum(num);

	}

//*************************************************************************
	private static boolean doThisAgain(Scanner sc, String prompt) {

		System.out.print(prompt);

		if (PROCESS_USING_SCANNER && sc.hasNextLine())

			sc.nextLine();

		String doOver = sc.nextLine();

		return doOver.equalsIgnoreCase("Y");
	}

//*************************************************************************	
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
