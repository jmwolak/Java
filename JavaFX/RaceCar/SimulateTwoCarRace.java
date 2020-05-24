/*

 * Name: Antonio Silvestri 

 * Date: 12/19/2016

 * Course Number: CSC-111

 * Course Name: Intro to Java Programming

 * Problem Number: HW 10

 * Email: silvestri@stcc.edu

 * Two Car Race Simulation for a maximum of 10 points

 */



package vehicle;



import java.util.Scanner;



public class SimulateTwoCarRace {

	final static String TITLE = "Two Car Race Simulation V2.0";

	final static String CONTINUE_PROMPT = "Race again? [y/N] ";

	final static double DISTANCE = 500;



	private static void reportResults(int countMin, Vehicle car1, Vehicle car2) {

		System.out.printf("Race Done in %d mins\n", countMin);

		double car1Dist = car1.getDistance();

		double car2Dist = car2.getDistance();

		if (car1Dist > car2Dist) {

			System.out.printf("%s won the race and travelled %.3f miles\n", car1, car1Dist);

			System.out.printf("%s lost and travelled %.3f miles\n", car2, car2Dist);

		}

		else if (car2Dist > car1Dist) {

			System.out.printf("%s won the race and travelled %.3f miles\n", car2, car2Dist);

			System.out.printf("%s lost and travelled %.3f miles\n", car1, car1Dist);

		}

		else

			System.out.printf("It's a tie!!! Both cars travelled %.3f miles\n", car1Dist);



	}



	// **********************************************



	private static void raceThemCars(Vehicle car1, Vehicle car2) {

		int countMin = 0;

		while (car1.getDistance() < DISTANCE && car2.getDistance() < DISTANCE) {

			car1.adjustCarSpeed();

			car2.adjustCarSpeed();

			car1.setDistance(1);

			car2.setDistance(1);

			countMin++;

		}

		reportResults(countMin, car1, car2);

	}



	// **********************************************



	private static Vehicle buildCar(Scanner sc, String prompt) {

		System.out.print(prompt);

		int year = sc.nextInt();

		String make = sc.next();

		String model = sc.next();

		sc.nextLine(); // Clears out the keyboard

		return new Vehicle(make, model, year);

	}



	// **********************************************



	private static void process(Scanner sc, String args[]) {

		Vehicle car1 = buildCar(sc, "Enter Year, Make, Model for Car 1: ");

		Vehicle car2 = buildCar(sc, "Enter Year, Make, Model for Car 2: ");

		raceThemCars(car1, car2);

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

