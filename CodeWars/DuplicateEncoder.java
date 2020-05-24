import java.util.Scanner;

/*
 * The goal of this exercise is to convert a string to a new string where each 
 * character in the new string is "(" if that character appears only once in 
 * the original string, or ")" if that character appears more than once in the 
 * original string. Ignore capitalization when determining if a character is a duplicate.
 */

public class DuplicateEncoder {

	static int index = 0;

//***************************************************************

	static String modifyIndex(String word) {

		StringBuffer sb = new StringBuffer(word);

		if (index > 0) {
			word = sb.replace(index, index + 1, "(").toString();
		}
		return word;
	}

//***************************************************************

	static String matches(String word) {

		for (int i = 0; i < word.length(); i++) {
			for (int j = i + 1; j < word.length(); j++) {
				if ((word.charAt(i) == word.charAt(j))) {
					word = word.replace(word.charAt(i), ')');
				}
			}
			if (word.charAt(i) != ')') {
				word = word.replace(word.charAt(i), '(');
			}

			if (word.length() == 1) {
				word = "(";
			}

		}
		return word;
	}

//***************************************************************

	static String singleParenthesis(char p, String word) {

		if (word.indexOf(p) == word.lastIndexOf(p)) {
			index = word.indexOf(p);
		}

		if (word.charAt(index) == ')') {
			word = word.replace(word.charAt(index), '(');
		}
		return word;
	}

//***************************************************************

	static String findParenthesis(String word) {

		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == '(' || word.charAt(i) == ')' || word.charAt(i) == ' ') {
				word = singleParenthesis(word.charAt(i), word);
			}
		}
		return word;
	}

//***************************************************************

	static String encode(String word) {

		return modifyIndex(matches(findParenthesis(word.toLowerCase())));
	}

//***************************************************************

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String ans = "yes";

		while (ans != "n") {
			System.out.println("Please enter a word");
			ans = input.next();
			System.out.println(encode(ans));
			System.out.println("Try again (y/n)");
			ans = input.next();

		} System.out.println("Thank you for participating in this useless string conversion");
	}

}
