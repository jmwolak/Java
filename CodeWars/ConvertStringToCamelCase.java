/*
 * Complete the method/function so that it converts dash/underscore delimited words into camel casing. The first word within the 
 * output should be capitalized only if the original word was capitalized (known as Upper Camel Case, also often referred to as 
 * Pascal case).
 */
public class ConvertStringToCamelCase {

	static String toCamelCase(String s) {

		StringBuilder sb = new StringBuilder(s);

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '_' || s.charAt(i) == '-') {
				sb.replace(i + 1, i + 2, String.valueOf(s.charAt(i + 1)).toUpperCase());

			}
		}
		s = sb.toString();
		return s.replace("_", "").replace("-", "");

	}

	public static void main(String[] args) {
		String input1 = "You_have_chosen_to_translate_this_kata_For_your_convenience_we_have_provided_the_existing_test_cases_used_for_the_language_that_you_have_already_completed_as_well_as_all_of_the_other_related_fields";
		String input2 = "the-stealth-warrior";
		String input3 = "The_Stealth_Warrior";

		System.out.println(toCamelCase(input1));
		System.out.println(toCamelCase(input2));
		System.out.println(toCamelCase(input3));
	}

}
