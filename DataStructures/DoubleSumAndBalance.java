
/*
 * This problem will ask the user for an array length. The program will then ask the user to input 
 * numbers into that array. A method will determine if there is an existing element of the array
 * such that the sum of all elements to the left is equal to the sum of all elements to the right.
 */
import java.util.Arrays;
import java.util.Scanner;

public class DoubleSumAndBalance {

	private static String result;
	final static String TITLE = "Double Sum and Balance";
	final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	final static boolean PROCESS_USING_SCANNER = true;

//***********************************************************************	

	private static String balancedSums(int arr[], int length) {

		int[] prefix = new int[length];
		prefix[0] = arr[0];
		for (int i = 1; i < length; i++) {
			prefix[i] = prefix[i - 1] + arr[i];
		}

		int[] suffix = new int[length];
		suffix[length - 1] = arr[length - 1];
		for (int i = length - 2; i >= 0; i--) {
			suffix[i] = suffix[i + 1] + arr[i];
		}

		for (int i = 1; i < length - 1; i++)
			if (prefix[i] == suffix[i]) {

				result = "Yes";
				return result;
			}
		result = "No";
		return result;

	}

//***********************************************************************	
	private static void process(Scanner sc, String args[]) {

		System.out.println("Please enter the size of Array");
		int length = sc.nextInt();
		int array[] = new int[length];

		System.out.println("Please insert the numbers you would like in the array.");

		for (int i = 0; i < length; i++) {

			int n = sc.nextInt();
			array[i] = n;

			System.out.println("Array[" + i + "] = " + array[i] + "\nInsert next number.");

		}
		System.out.println("\nArray Length: " + length + "\nArray: " + Arrays.toString(array));
		System.out.println(balancedSums(array, length));
	}

//***********************************************************************	
	private static boolean doThisAgain(Scanner sc, String prompt) {

		System.out.print(prompt);

		if (PROCESS_USING_SCANNER && sc.hasNextLine())

			sc.nextLine();

		String doOver = sc.nextLine();

		return doOver.trim().equalsIgnoreCase("Y");

	}

	// **********************************************************************
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
