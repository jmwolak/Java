import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class NameStats {

	private int start;
	private int end;
	private int people;

	// *****************************************

	public int organize(ArrayList<Name> men, ArrayList<Name> women) {

		System.out.println("Men:");
		for (int i = 0; i < people; i++) {

			System.out.print(i + 1 + ".");
			System.out.println(men.get(i));

		}

		System.out.println("Women:");
		for (int j = 0; j < people; j++) {

			System.out.print(j + 1 + ".");
			System.out.println(women.get(j));
		}
		return people;

	}

	// *****************************************

	public ArrayList<Name> getTopFemaleNames(ArrayList<Name> array) {

		ArrayList<Name> womenArray = new ArrayList<Name>();

		int count = 0;
		int i = 0;

		while (count < people) {

			if (array.get(i).getSex().equals("F")) {
				womenArray.add(array.get(i));
				count++;
			}
			i++;

		}
		return womenArray;

	}

	// *****************************************

	public ArrayList<Name> getTopMaleNames(ArrayList<Name> array) {

		ArrayList<Name> menArray = new ArrayList<Name>();

		int count = 0;
		int i = 0;

		while (count < people) {

			if (array.get(i).getSex().equals("M")) {
				menArray.add(array.get(i));
				count++;
			}
			i++;

		}

		return menArray;

	}

	// ****************************************

	public void createList() throws IOException {
		ArrayList<Name> array = new ArrayList<Name>();

		for (int i = start; i <= end; i++) {
			Scanner sc = new Scanner(new URL("https://cs.stcc.edu/~silvestri/names/yob" + i + ".txt").openStream());
			sc.useDelimiter("\\s*,\\s*|\\s+");
			System.out.print(".");
			while (sc.hasNextLine()) {

				String name = sc.next();
				String sex = sc.next();
				int number = sc.nextInt();
				sc.nextLine();
				Name n = new Name(name, sex, number);

				int j = array.indexOf(n);

				if (j < 0) {

					array.add(n);

				} else {

					Name n2 = array.get(j);
					n2.addToNumber(number);
					n2.compareTo(n);
				}

			}
			Collections.sort(array);

			sc.close();
		}
		System.out.println();
		organize(getTopMaleNames(array), getTopFemaleNames(array));

	}

	// ****************************************

	public int getEndingDate() {

		return end;
	}

	// ****************************************

	public void setEndingDate(int end, int start) {

		if ((end > 2018) || (start < 1880))
			throw new RuntimeException("Ending date must be less than or equal to 2018 and greater than 1880");
		if (end < start)
			throw new RuntimeException("Ending date must be greater than Starting date");
		this.end = end;

	}

	// ****************************************

	public int getStartingDate() {

		return start;
	}

	// ****************************************

	public void setStartingDate(int start, int end) {

		if ((start < 1880) || (start > 2018))
			throw new RuntimeException("Starting number must be greater or equal to 1880 and less than 2018.");
		if ((start > end) || (start == end))
			throw new RuntimeException("Starting number must be less than Ending number");
		this.start = start;
	}

	// ****************************************
	public NameStats(int start, int end, int people) {

		this.start = start;
		this.end = end;
		this.people = people;

		setStartingDate(start, end);
		setEndingDate(end, start);

	}
}
