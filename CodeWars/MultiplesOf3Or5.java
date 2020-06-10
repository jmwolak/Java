/*
 * If we list all the natural numbers below 10 that 
 * are multiples of 3 or 5, we get 3, 5, 6 and 9. The 
 * sum of these multiples is 23. Finish the solution 
 * so that it returns the sum of all the multiples of 
 * 3 or 5 below the number passed in.
 */

public class MultiplesOf3Or5 {
	private static int solution(int number) {
		
		int sum = 0;

		for (int i = 1; i < number; i++) {
			sum += i % 3 == 0 || i % 5 == 0? i:0;
		}
		return sum;
	}

	public static void main(String[] args) {

		System.out.println(MultiplesOf3Or5.solution(10));
		System.out.println(MultiplesOf3Or5.solution(20));
		System.out.println(MultiplesOf3Or5.solution(30));

	}

}
