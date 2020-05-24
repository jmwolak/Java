
/*
 * Given a string, using recursion, this program will compute the
 * number of times lowercase "hi" appears in the String. It will
 * not, however, count a "hi" that has an 'x' immediately before it 
 */
import java.util.Scanner;

public class CountHi2 {

	private final static String TITLE = "Count hi in String Test";
	private final static String CONTINUE_PROMPT = "Do this again? [y/N] ";

	// *****************************************************************
	public static int countHi2(String str) {

		if (str.length() < 2)
			return 0;

		if ((str.charAt(0) == 'x') && (str.substring(1, 2).equals("x")))
			return countHi2(str.substring(1));

		if ((str.charAt(0) == 'x') && (str.substring(1, 3).equals("hi")))
			return countHi2(str.substring(3));

		if (str.substring(0, 2).equals("hi"))
			return 1 + countHi2(str.substring(1));

		return countHi2(str.substring(1));
	}

	// *****************************************************************

	private static void process(Scanner sc, String args[]) {
		Scanner input = new Scanner(System.in);
		String str;
		int ans;

		System.out.println("Please enter your String");
		str = input.next();

		ans = countHi2(str);

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
