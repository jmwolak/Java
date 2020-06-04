import java.util.TreeMap;

/*
 * Write a function that will return the count of 
 * distinct case-insensitive alphabetic characters 
 * and numeric digits that occur more than once in 
 * the input string. The input string can be assumed
 *  to contain only alphabets (both uppercase and lowercase) 
 *  and numeric digits.
 */
public class CountingDuplicates {
	
	public static int duplicateCount(String text) {
		int count = 1;
		TreeMap<Character, Integer> list = new TreeMap<Character, Integer>();
		text = text.toLowerCase();
		
		for (int i = 0; i < text.length(); i++) {
			for (int j = i + 1; j < text.length(); j++) {
				count += text.charAt(i) == text.charAt(j)? 1 : 0;
				if (count > 1) {
					list.put(text.charAt(i), count);
				}

			}
			count = 1;
		}
		return list.values().size();

	}

	public static void main(String[] args) {

		System.out.println(CountingDuplicates.duplicateCount("abcde"));
		System.out.println(CountingDuplicates.duplicateCount("abcdea"));
		System.out.println(CountingDuplicates.duplicateCount("indivisibility"));
		System.out.println(CountingDuplicates.duplicateCount("aabBcde"));
		System.out.println(CountingDuplicates.duplicateCount("Indivisibilities"));
		System.out.println(CountingDuplicates.duplicateCount("aA11"));
		System.out.println(CountingDuplicates.duplicateCount("ABBA"));
		System.out.println(CountingDuplicates.duplicateCount("aabbcde"));

	}

}
