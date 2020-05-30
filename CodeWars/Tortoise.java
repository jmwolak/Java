/*
 *  Two tortoises named A and B must run a race.
 *  A starts with an average speed of 720 feet 
 *  per hour. Young B knows she runs faster than A, 
 *  and furthermore has not finished her cabbage.
 *	When she starts, at last, she can see that A
 *	has a 70 feet lead but B's speed is 850 feet 
 *	per hour. How long will it take B to catch A?
 */

import java.text.DecimalFormat;
import java.util.Arrays;

public class Tortoise {

	static double dec(double num) {

		DecimalFormat df = new DecimalFormat("#");
		df.setMaximumFractionDigits(3);
		num = Double.parseDouble(df.format(num));
		return num;
	}

//********************************************

	static String organize(int hr, int min, int sec) {

		int[] time = new int[] {hr, min, sec};
		return Arrays.toString(time);

	}

//********************************************

	static String findSec(int hr, int min, double sec) {
		sec = sec * 60;
		sec = dec(sec);

		return organize(hr, (int) Math.round(min),
				(int) Math.round(Double.parseDouble(String.valueOf(sec).substring(0, 2))));
	}

//********************************************

	static String findMin(int hr, double min) {
		min = min * 60;
		min = dec(min);	
		return findSec(hr, (int) Math.round(Double.parseDouble(String.valueOf(min).substring(0, 2))), min % 1);
	}

//********************************************

	static String findHour(double a, double b, double diff, double hr) {
		double turtle1 = a * hr + diff;
		double turtle2 = b * hr;

		while (turtle2 <= turtle1) {
			hr += 0.000015555;
			turtle1 = a * hr + diff;
			turtle2 = b * hr;
		}
		
		return findMin((int) Math.round(Double.parseDouble(String.valueOf(hr).substring(0, 2))), hr % 1);
	}

//********************************************

	static String race(int a, int b, int diff) {
		
		System.out.println(a + ", " + b + ", " + diff);
		double hr = 0.01;
		if(a >= b) {
			return null;
		}
		return findHour(a, b, diff, hr);
	}

//********************************************

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		System.out.println(Tortoise.race(720, 850, 70));
		System.out.println(Tortoise.race(80, 91, 37));
		System.out.println(Tortoise.race(80, 100, 40));
		System.out.println(Tortoise.race(720, 850, 37));
		System.out.println(Tortoise.race(720, 850, 370));
		System.out.println(Tortoise.race(120, 850, 37));
		System.out.println(Tortoise.race(602, 622, 92));
		System.out.println(Tortoise.race(252, 562, 132));
		long endTime = System.currentTimeMillis();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds: " + timeElapsed);
	}

}
