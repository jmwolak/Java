import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import java.util.Scanner;

public class NamesSetup {

	final static String TITLE = "Names Project";
	final static String CONTINUE_PROMPT = "Do this again? [y/N] ";

	// **********************************************

	private static void process(Scanner sc, String args[]) throws IOException {
		Scanner input = new Scanner(System.in);
		int s, e, p;

		System.out.println("Please enter Starting Date");
		s = input.nextInt();
		System.out.println("Please enter Ending Date");
		e = input.nextInt();
		System.out.println("Please enter the number of Top Names Desired.");
		p = input.nextInt();

		NameStats stats = new NameStats(s, e, p);
		stats.createList();

	}

	// **********************************************

	private static boolean doThisAgain(Scanner sc, String prompt) {

		System.out.print(prompt);
		String doOver = sc.nextLine();
		return doOver.trim().equalsIgnoreCase("Y");

	}

	// **********************************************

	public static void main(String args[]) throws MalformedURLException, IOException {

		System.out.println("Welcome to " + TITLE);

		Scanner sc = new Scanner(System.in);

		do {

			process(sc, args);

		} while (doThisAgain(sc, CONTINUE_PROMPT));

		sc.close();

		System.out.println("Thank you for using " + TITLE);

	}

}
