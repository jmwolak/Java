
public class RecursionInfo {

	private char letter;
	private int count;

	// *****************************************

	public RecursionInfo(char letter, int count) {

		this.setLetter(letter);
		this.setCount(count);

	}

	// *****************************************

	public char getLetter() {
		return letter;
	}

	// *****************************************

	public void setLetter(char letter) {

		if (letter == 0)
			throw new RuntimeException("Blank Letter Setting Attempted");

		this.letter = letter;
	}

	// *****************************************

	public int getCount() {
		return count;
	}

	// *****************************************

	public void setCount(int count) {

		if (count < 0)
			throw new RuntimeException("Negative Number Setting Attempted: " + count);

		this.count = count;
	}

	// *****************************************

	public String toString() {

		return String.format("{%c, %1d}", this.letter, this.count);

	}

	// *****************************************

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RecursionInfo other = (RecursionInfo) obj;
		return count == other.count && letter == other.letter;
	}

}
