import java.util.ArrayList;

public class Recursion {

	public static ArrayList<RecursionInfo> array2(String str, ArrayList<RecursionInfo> a2) {

		char letter;
		int count;

		letter = str.charAt(0);
		count = countChar(str, letter);

		RecursionInfo r = new RecursionInfo(letter, count);

		int index = a2.indexOf(r);

		if (str.length() == 0)
			return a2;

		if (index < 0)
			;

		a2.add(r);

		return array2(str.substring(1), a2);

	}

	// *****************************************************************

	public static int countChar(String str, char letter) {

		if (str.length() == 0)
			return 0;

		if (str.charAt(0) == letter)
			return 1 + countChar(str.substring(1), letter);

		return countChar(str.substring(1), letter);

	}

}
