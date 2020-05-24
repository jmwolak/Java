package rationalRegex;

/*
 * Rational Regex class
 * James Wolak
 * CSC-112  Intermediate Java
 * 02/29/20
 * This program takes a string which then uses Regular Expression to determine the numerator
 * and the denominator of a fraction.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RationalRegex extends Rational {

	private int num;
	private int den;
	private int mix;

//**********************************************************************

	public int getMix() {

		return mix;
	}

//**********************************************************************

	public int getNumerator() {

		return num;

	}

//**********************************************************************	

	public int getDenominator() {

		return den;

	}

//**********************************************************************

	public RationalRegex(String str) {

		final String regex = "^\\s*(?:(\\d+)\\s)?(-?\\d*)\\s*\\/?\\s*(-?\\d*)\\s*$";
		final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		final Matcher matcher = pattern.matcher(str);

		if (matcher.find()) {

			if (!matcher.group(1).isBlank()) {

				mix = Integer.parseInt(matcher.group(1));
				num = mixNum(mix, num, den);
			} else {

				num = Integer.parseInt(matcher.group(2));
			}

			if (matcher.group(3).isBlank()) {
				den = Integer.parseInt("1");
			} else {
				den = Integer.parseInt(matcher.group(3));
			}
		}

	}

//**********************************************************************

	public int mixNum(int mix, int num, int den) {

		return this.num = (mix * den) + num;

	}
}