
/*
 * This program will display a 2D array of numbers. The program will then look at each number
 * within the array. I the sum of the selected number and its surrounding numbers divided by 5 is 
 * greater than 6.0, that selected number will display '*'.
 */

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class StarLocater {

	final static String TITLE = "Star Locater";
	final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	final static boolean PROCESS_USING_SCANNER = false;
	private static int stars[][];
	private static int aSize;
	private static int bSize;

//****************************************************************************
	private static void outputStarData(char[][] star, int[][] a) {

		System.out.print("+");

		for (int i = 0; i < a[0].length; i++) {

			System.out.print("---+");
		}
		System.out.println();

		for (int i = 0; i < a.length; i++) {

			System.out.print("| ");

			for (int j = 0; j < a[0].length; j++) {

				System.out.print(star[i][j] + " | ");
			}
			System.out.println();
			System.out.print("+");

			for (int k = 0; k < a[0].length; k++) {

				System.out.print("---+");
			}

			System.out.println();
		}

	}

//****************************************************************************
	private static boolean isStar(int num) {

		if (num > 6) {

			return true;
		}
		return false;

	}

//****************************************************************************
	private static char[][] analyzeData(int[][] a) {

		char[][] star = new char[a.length][a[0].length];
		int num;

		for (int i = 1; i < a.length - 1; i++) {

			for (int j = 1; j < a[0].length - 1; j++) {

				num = ((a[i - 1][j - 1] + a[i - 1][j] + a[i - 1][j + 1] + a[i][j - 1] + a[i][j] + a[i][j + 1]
						+ a[i + 1][j - 1] + a[i + 1][j] + a[i + 1][j + 1]) / 5);

				boolean s = isStar(num);

				if (s == true) {

					star[i][j] = '*';

				}

			}
		}

		outputStarData(star, a);
		return star;
	}

//**********************************************************
	private static void readStarData(Scanner sc) {
		try {
			System.out.print("Enter Filename: ");
			String filename = sc.nextLine();
			Scanner fileInput = new Scanner(new File(filename));
			aSize = fileInput.nextInt();
			bSize = fileInput.nextInt();

			System.out.printf("%4d%4d\n", aSize, bSize);

			stars = new int[aSize][bSize];

			for (int i = 0; i < stars.length; i++) {
				for (int j = 0; j < stars[0].length; j++) {

					stars[i][j] = fileInput.nextInt();

					System.out.printf("%4d", stars[i][j]);
				}
				System.out.println("");

			}

			System.out.println();

			fileInput.close();

		} catch (Exception ex) {
		}
	}

//**********************************************************
	private static void process(Scanner sc, String args[]) {

		char[][] s;

		readStarData(sc);
		System.out.println("From the given 2D array, This program will now locate the Stars.");
		s = analyzeData(stars);

	}
	// *************************************************************************

	private static boolean doThisAgain(Scanner sc, String prompt) {

		System.out.print(prompt);

		if (PROCESS_USING_SCANNER && sc.hasNextLine())

			sc.nextLine();

		String doOver = sc.nextLine();

		return doOver.trim().equalsIgnoreCase("Y");

	}

	// *************************************************************************

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
