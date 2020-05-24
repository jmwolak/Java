
/*This program will ask the user to input a number. 
 * The program will then tell if the input is a Prime number or not
 */

import java.util.Scanner;

public class Prime {

	public static boolean isPrime(int num) {

		for (int i = 2; i <= (int) Math.sqrt(num); i++) {

			int isPrime = num % i;
			
			if (isPrime == 0)

				return false;

		}
		return true;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Please insert a number to determine if it is Prime.");
		int number = input.nextInt();

		System.out.println(isPrime(number));
	}

}
