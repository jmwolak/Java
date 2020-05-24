import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class NameStats {

	private static final String BASE_URL = "https://cs.stcc.edu/~silvestri/names/";

	private int startYear;
	private int endYear;
	private int top;

	private Map<String, Integer> mNames;
	private Map<String, Integer> fNames;

	// ************************************************************

	public NameStats(int startYear, int endYear, int top) {

		this.setStartEndYears(startYear, endYear);
		this.setTop(top);

	}

	// ************************************************************
	// Getters

	public int getStartYear() {

		return startYear;

	}

	// ************************************************************

	public int getEndYear() {

		return endYear;

	}

	// ************************************************************

	public int getTop() {

		return top;

	}

	// ************************************************************

	// Setters

	public void setStartEndYears(int startYear, int endYear) {

		if (startYear > endYear)

			throw new NameAppException(

					String.format("StartYear %d passed must be <= EndYear %d passed", startYear, endYear));

		if (startYear < 1880)

			throw new NameAppException(String.format("StartYear %d passed must be >= 1880", startYear));

		if (endYear > 2018)

			throw new NameAppException(String.format("EndYear %d passed must be <= 2018", endYear));

		this.startYear = startYear;

		this.endYear = endYear;

		this.mNames = null; // Invalidate the names list

		this.fNames = null;
	}

	// ************************************************************

	public void setTop(int top) {

		if (top <= 0)

			throw new NameAppException(String.format("Top %d passed must be > 0", top));

		this.top = top;

	}

	// ************************************************************

	public void generateStats() throws MalformedURLException, IOException {

		this.mNames = new TreeMap<String, Integer>();
		this.fNames = new TreeMap<String, Integer>();

		for (int year = startYear; year <= endYear; year++) {

			System.out.print(".");

			if ((year + 1 - startYear) % 10 == 0)

				System.out.println();

			try (Scanner sc = new Scanner(new URL(BASE_URL + "yob" + year + ".txt").openStream())) {

				sc.useDelimiter("\\s*,\\s*|\\s+");

				while (sc.hasNextLine()) {

					String name = sc.next();

					String sex = sc.next();

					int number = sc.nextInt();

					sc.nextLine();

					if (sex.equals("M")) {

						if (!mNames.containsKey(name)) {

							mNames.put(name, number);

						} else {

							mNames.put(name, number + this.mNames.get(name));

						}
					} else {

						if (!fNames.containsKey(name)) {

							fNames.put(name, number);

						} else {

							fNames.put(name, number + this.fNames.get(name));

						}
					}

				}

			}

		}

		System.out.println();

		getTopNames("M", sortByValues(mNames));
		getTopNames("F", sortByValues(fNames));
	}

// ************************************************************

	private static <K, V extends Comparable<V>> TreeMap<K, V> sortByValues(Map<K, V> map) {

		Comparator<K> valueComparator = new Comparator<K>() {

			public int compare(K k1, K k2) {

				int compare = map.get(k1).compareTo(map.get(k2));

				return -compare;

			}

		};

		TreeMap<K, V> sortedByValues = new TreeMap<>(valueComparator);

		sortedByValues.putAll(map);

		return sortedByValues;

	}

// ************************************************************

	private ArrayList<Name> getTopNames(String sex, TreeMap<String, Integer> list) {

		ArrayList<Name> topNames = new ArrayList<>();

		int count = 0;

		for (Map.Entry<String, Integer> entry : list.entrySet()) {

			String key = entry.getKey();

			int value = entry.getValue();

			if (count >= top)

				break;

			topNames.add(new Name(key, sex, value));

			count++;

		}

		return topNames;

	}

	// ************************************************************

	public ArrayList<Name> getTopMaleNames() {

		return getTopNames("M", sortByValues(mNames));

	}
	// ************************************************************

	public ArrayList<Name> getTopFemaleNames() {

		return getTopNames("F", sortByValues(fNames));

	}

}
