
/*
 * This program will display two array lengths and the arrays themselves.
   Although they are almost identical, one array is missing numbers that the array possesses.
   This program will print those missing numbers. If duplicates exist, the program will only print that
   number once.
 */

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class MissingNumbers {

	final static String TITLE = "Missing Numbers";
	final static String CONTINUE_PROMPT = "Do this again? [y/N] ";
	final static boolean PROCESS_USING_SCANNER = true;
	private static int arr[];
	private static int brr[];

//*************************************************************************

	private static int[] finalResult(int[] newArray, int count) {

		int finalArray[] = new int[count];
		int j = 0;

		for (int i = 1; i < count + 1; i++) {

			if (newArray[i] != newArray[i - 1]) {

				finalArray[j++] = newArray[i - 1];

			}

		}
		if (newArray[newArray.length - 1] != newArray[count - 1]) {

			if (finalArray[count - 1] == 0) {

				finalArray[count - 1] = newArray[newArray.length - 1];
			}

		}

		return finalArray;
	}

//*************************************************************************
	private static int[] removeDuplicate(int[] newArray) {

		int count = 0;
		int index = 0;

		for (int i = 0; i < newArray.length; i++) {

			if (newArray[i] != newArray[index + 1])

				count++;
		}

		return finalResult(newArray, count);
	}

//*************************************************************************	
	private static boolean isDuplicate(int[] newArray) {

		for (int i = 0; i < newArray.length - 1; i++) {

			if (newArray[i + 1] == newArray[i]) {

				return true;
			}
		}

		return false;

	}

//*************************************************************************	

	private static int[] newArray(int[] array, int count) {

		int newArray[] = new int[count];
		int k = 0;

		for (int i = 0; i < array.length; i++) {

			if (array[i] > 0) {

				newArray[k++] = array[i];

			}
		}

		Arrays.sort(newArray);
		return newArray;

	}
//*************************************************************************	

	private static int[] count(int[] array) {
		int count = 0;
		for (int i = 0; i < array.length; i++) {

			if (array[i] != -1) {

				count++;
			}
		}

		return newArray(array, count);

	}

//*************************************************************************	

	private static int[] linearSearch(int[] list1, int count1, int[] list2, int count2) {

		for (int i = 0; i < count2; i++) {

			for (int j = 0; j < count1; j++) {

				if (list2[i] == list1[j]) {

					list2[i] = -1;
					list1[j] = -1;

					break;

				}

			}

		}

		return count(list2);
	}

//*************************************************************************	

	public static int[] linearSearch(int[] arr, int[] brr) {

		return linearSearch(arr, arr.length, brr, brr.length);

	}

//*************************************************************************	

	private static void readFile(Scanner sc) {
		try {
			System.out.print("Enter Filename: ");
			String filename = sc.nextLine();
			Scanner fileInput = new Scanner(new File(filename));
			int aSize = fileInput.nextInt();
			arr = new int[aSize];
			for (int i = 0; i < arr.length; i++)
				arr[i] = fileInput.nextInt();
			int bSize = fileInput.nextInt();
			brr = new int[bSize];
			for (int i = 0; i < brr.length; i++)
				brr[i] = fileInput.nextInt();
			fileInput.close();
		} catch (Exception ex) {
		}
	}

//*************************************************************************
	private static void process(Scanner sc, String args[]) {
		int[] index;
		int[] remDup;
		String m = "Missing Numbers include:";
		boolean dupNums;

		readFile(sc);

		System.out.println(arr.length + "\n" + Arrays.toString(arr));
		System.out.println(brr.length + "\n" + Arrays.toString(brr));

		index = linearSearch(arr, brr);
		dupNums = isDuplicate(index);
		remDup = removeDuplicate(index);

		if (dupNums == false) {

			System.out.println(m + "\n" + Arrays.toString(index));

		} else {
			System.out.println(m + "\n" + Arrays.toString(remDup));

		}
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
