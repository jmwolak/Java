//Instead of using a series of if/else statements, it's way easier to use Arrays

public class ImprovedRomanNumeralsEncoder {

	public static String solution(int n) {

		String[] thousands = { "", "M", "MM", "MMM" };
		String[] hundreds = { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
		String[] tens = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
		String[] units = { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };

		return thousands[n / 1000] + hundreds[(n % 1000) / 100] + tens[(((n % 1000) % 100)) / 10]
				+ units[((n % 1000) % 100) % 10];

	}

	public static void main(String[] args) {

		int num = (int) (Math.random() * 3999);

		System.out.println("Arabic Numeral: " + num + "\n" + "Roman Numeral: " + solution(num));
	}

}
