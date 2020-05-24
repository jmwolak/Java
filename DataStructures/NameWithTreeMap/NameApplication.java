import java.util.ArrayList;

import java.util.InputMismatchException;

import java.util.Scanner;

public class NameApplication {

	private static final String TITLE = "Name Application V1.0";
	private static final String CONTINUE_PROMPT = "Do this again? [y/N] ";

	// ************************************************************

	private static void outputResults(ArrayList<Name> malePop, ArrayList<Name> femalePop) {

		System.out.println("Top " + malePop.size() + " Male names:");

		for (int i = 0; i < malePop.size(); i++) {

			System.out.println(malePop.get(i));

		}

		System.out.println();

		System.out.println("Top " + femalePop.size() + " Female names:");

		for (int i = 0; i < femalePop.size(); i++) {

			System.out.println(femalePop.get(i));

		}

		System.out.println();

	}

	// **********************************************

	private static int getStartYear(Scanner sc) {

		do {

			try {

				System.out.print("Enter Start Year: ");

				return sc.nextInt();

			} catch (InputMismatchException ex) {

				System.out.println("Start Year must be integers!");

			} finally {

				sc.nextLine();

			}

		} while (true);

	}

	// **********************************************

	private static int getEndYear(Scanner sc) {

		do {

			try {

				System.out.print("Enter End Year: ");

				return sc.nextInt();

			} catch (InputMismatchException ex) {

				System.out.println("Start Year must be integers!");

			} finally {

				sc.nextLine();

			}

		} while (true);

	}

	// **********************************************

	private static int getTopNames(Scanner sc) {

		do {

			try {

				System.out.print("Enter Top Number of Names: ");

				return sc.nextInt();

			} catch (InputMismatchException ex) {

				System.out.println("Top Number of Names must be integers!");

			} finally {

				sc.nextLine();

			}

		} while (true);

	}

	// **********************************************

	private static void process(Scanner sc, String args[]) {

		try {

			int startYear = getStartYear(sc);

			int endYear = getEndYear(sc);

			int topNames = getTopNames(sc);

			System.out.println("Patience Please!");

			System.out.println("V1.0 might take some time to generate results.");

			System.out.println("V2.0 is in the works and will produce faster results.");

			NameStats stats = new NameStats(startYear, endYear, topNames);

			stats.generateStats();

			ArrayList<Name> malePop = stats.getTopMaleNames();
			ArrayList<Name> femalePop = stats.getTopFemaleNames();

			outputResults(malePop, femalePop);

		}

		catch (NameAppException ex) {

			System.out.println("Name Exception: " + ex.getMessage());

		}

		catch (Exception ex) {

			ex.printStackTrace();

		}

	}

	// **********************************************

	private static boolean doThisAgain(Scanner sc, String prompt) {

		System.out.print(prompt);

		String doOver = sc.nextLine();

		return doOver.equalsIgnoreCase("Y");

	}

	// **********************************************

	public static void main(String args[]) {

		System.out.println("Welcome to " + TITLE);

		Scanner sc = new Scanner(System.in);

		do {

			process(sc, args);

		} while (doThisAgain(sc, CONTINUE_PROMPT));

		sc.close();

		System.out.println("Thank you for using " + TITLE);

	}

}
