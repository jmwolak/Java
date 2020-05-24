
/*
 * This program will ask the user for starting and end point ranges. The program will then 
 * print out the Twin Prime numbers within that range.
 */
import java.util.Scanner;

public class TwinPrimes {

	final static String TITLE = "Twin Primes program";

	final static String CONTINUE_PROMPT = "Do this again? [y/N] ";

	final static boolean PROCESS_USING_SCANNER = true;

	private static int start;
	private static int end;
	private static int twin;

//************************************************************************
	private static boolean isPrime(int num) {

		if (num == 1 || num == 0)

			return false;

		for (int i = 2; i <= (int) (Math.sqrt(num)); i++)

			if (num % i == 0)

				return false;

		return true;

	}

//************************************************************************
	private static int twinPrimeBack(int num1, int num2) {

		while (num1 > num2) {

			twin = num1 + 2;

			if (isPrime(num1) && isPrime(twin)) {

				System.out.printf("(%,d, %,d)\n", num1, twin);

			}

			num1--;

		}

		return num1;

	}

//*****************************************************************

	private static int twinPrime(int num1, int num2) {

		while (num1 < num2) {

			twin = num1 + 2;

			if (isPrime(num1) && isPrime(twin)) {

				System.out.printf("(%,d, %,d)\n", num1, twin);

			}

			num1++;

		}

		return num1;
	}

//*************************************************************************
	private static void process(Scanner sc, String args[]) {

		System.out.println("Please enter starting and ending point ranges.");
		System.out.println("Enter starting point:");
		start = sc.nextInt();

		while (start < 0) {

			System.out.println("Because negative integers cannot be Prime, starting point cannot be negative");
			System.out.println("Enter starting point:");
			start = sc.nextInt();

		}

		System.out.println("Enter ending point:");
		end = sc.nextInt();

		if (start < end)
			twinPrime(start, end);
		else
			twinPrimeBack(start, end);

	}
//*************************************************************************

	private static boolean doThisAgain(Scanner sc, String prompt) {

		System.out.print(prompt);

		if (PROCESS_USING_SCANNER && sc.hasNextLine())

			sc.nextLine();

		String doOver = sc.nextLine();

		return doOver.trim().equalsIgnoreCase("Y");

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
