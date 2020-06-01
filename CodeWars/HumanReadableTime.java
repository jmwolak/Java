import java.text.DecimalFormat;

public class HumanReadableTime {
	

	public static String makeReadable(int seconds) {
		
		if (seconds < 0)
			return null;
		
		return String.format("%02d", seconds/3600) + ":" + String.format("%02d", (seconds%3600)/60) + ":" + String.format("%02d", ((seconds%3600)%60));

	}
	

//********************************************
	
	public static void main(String[] args) {
		System.out.println(HumanReadableTime.makeReadable(359999));
	}

}
