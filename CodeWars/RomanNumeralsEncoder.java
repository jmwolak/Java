/*
* Create a function taking a positive integer as its parameter and returning 
* a string containing the Roman Numeral representation of that integer.
* Modern Roman numerals are written by expressing each digit separately starting
* with the left most digit and skipping any digit with a value of zero. 
* In Roman numerals 1990 is rendered: 1000=M, 900=CM, 90=XC; resulting in MCMXC. 
* 2008 is written as 2000=MM, 8=VIII; or MMVIII. 
* 1666 uses each Roman symbol in descending order: MDCLXVI.
 */

public class RomanNumeralsEncoder {

	public static String solution(int n) {
		String letter = "";
		int i = 1000;

		if (n >= 1 && n <= 3999) {
			while (i <= n) {
				letter += "M";
				i += 1000;
			}
			n = n % 1000;
		}

		if (n >= 900) {
			letter = letter + "CM";
			n = n % 100;
		} else if (n >= 500) {
			i = 100;
			letter += "D";
			n -= 500;
			while (i <= n) {
				letter += "C";
				i += 100;
			}
			n = n % 100;
		} else if (n >= 400) {
			letter += "CD";
			n = n % 100;
		} else if (n > 100) {
			i = 100;
			while (i <= n) {
				letter += "C";
				i += 100;
			}
			n = n % 100;

		}

		if (n >= 90) {
			letter += "XC";
			n = n % 10;
		} else if (n >= 50) {
			i = 10;
			letter += "L";
			n -= 50;
			while (i <= n) {
				letter += "X";
				i += 10;
			}
			n = n % 10;
		} else if (n >= 40) {
			letter += "XL";
			n = n % 10;
		} else if (n < 40 && n > 10) {
			i = 10;
			while (i <= n) {
				letter = letter + "X";
				i += 10;
			}
			n = n % 10;
		}

		if(n == 10) {
			letter += "X";
		}else if (n == 9) {
			letter += "IX";
		} else if (n > 5) {
			i = 5;
			letter += "V";
			while (i < n) {
				letter += "I";
				i++;
			}
		} else if (n == 5) {
			letter += "V";
		} else if (n == 4) {
			letter += "IV";
		} else if (n > 0) {
			i = 1;
			while (i <= n) {
				letter += "I";
				i++;
			}

		}

		return letter;
	}

	public static void main(String[] args) {
		
		int num = (int) (Math.random() * 3999);

		System.out.println("Arabic Numeral: " + num + "\n" + "Roman Numeral: " + solution(num));

	}

}
