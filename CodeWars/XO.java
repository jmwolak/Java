import java.util.ArrayList;


/*
 * This program will check to see if a string has the same amount of 'x's and 'o's. 
 * The method will return a boolean and be case insensitive. The string can contain any char.
 */

public class XO {
	
	public static boolean getXO(String str) {
		
		ArrayList<Character> x = new ArrayList<Character>();
		ArrayList<Character> o = new ArrayList<Character>();
			
		for(int i = 0; i < str.length(); i++) {
			
			if(str.charAt(i) == 'x' || str.charAt(i) == 'X') {
				x.add(str.charAt(i));
			} 
			
			if (str.charAt(i) == 'o' || str.charAt(i) == 'O') {
				o.add(str.charAt(i));
			}
		}
		
		return x.size() == o.size(); 
		
	}
//*****************************************************

	public static void main(String[] args) {
		
		XO.getXO("xxxooo");
		XO.getXO("xxxXooOo");
		XO.getXO("xxx23424esdsfvxXXOOooo");
		XO.getXO("xXxxoewrcoOoo");
		XO.getXO("XxxxooO");
		XO.getXO("zssddd");
		XO.getXO("Xxxxertr34");
		XO.getXO("ooxx");
		XO.getXO("xooxx");
		XO.getXO("ooxXm");
		XO.getXO("zpzpzpp");
		XO.getXO("zzoo");


	}

}