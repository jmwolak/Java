import java.util.ArrayList;

/*
 * The program determines which number within the program displays an odd amount of times
 */

public class FindOdd {

	private static int odd = 0;
	private static int count = 1;
	private static ArrayList<Integer> array;


//**************************************************************************************************

	public static int findIt(int[] a) {
		
		array = new ArrayList<Integer>();

		for (int i = 0; i < a.length; i++) {
			array.add(a[i]);
		}

		for (int j = 0; j < array.size(); j++) {
			for (int k = j + 1; k < array.size(); k++) {
				if (array.get(j) == array.get(k)) {
					array.remove(k);
					k--;
					count++;
				}
			}

			if ((count % 2) > 0) {
				odd = (int) array.get(j);
			}

			count = 1;
		}

		return odd;

	}
//**************************************************************************************************

	
public static boolean match(int num, int[] array) {
		
		return num == findIt(array);

	}

//**************************************************************************************************

	public static void findMatch() {

		printIt(match(5, new int[] { 20, 1, -1, 2, -2, 3, 3, 5, 5, 1, 2, 4, 20, 4, -1, -2, 5 }));
		printIt(match(-1, new int[] { 1, 1, 2, -2, 5, 2, 4, 4, -1, -2, 5 }));
		printIt(match(5, new int[] { 20, 1, 1, 2, 2, 3, 3, 5, 5, 4, 20, 4, 5 }));
		printIt(match(10, new int[] { 10 }));
		printIt(match(10, new int[] { 1, 1, 1, 1, 1, 1, 10, 1, 1, 1, 1 }));
		printIt(match(1, new int[] { 5, 4, 3, 2, 1, 5, 4, 3, 2, 10, 10 }));	
		

	}
	
//**************************************************************************************************
	
	public static void printIt(boolean match) {
		System.out.println(match);
	}
	
//**************************************************************************************************

	public static void main(String[] args) {

		
		findMatch();

	}
}