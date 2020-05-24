/*
 * This program takes the the name, sex, and the amount of people recorded
 * to have that name. The program will then organize the names, starting with the 
 * highest number of people with that name. Finally, the program will print the number of top 
 *names desired.
 */

public class Name implements Comparable<Name> {

	private String name;
	private String sex;
	private int number;

	// ************************************************************

	public Name(String name, String sex, int number) {

		this.setName(name);
		this.setSex(sex);
		this.setNumber(number);

	}

	// ************************************************************

	// Getters

	public String getName() {

		return name;

	}

	// ************************************************************

	public String getSex() {

		return sex;

	}

	// ************************************************************

	public int getNumber() {

		return number;

	}

	// ************************************************************

	// Setters

	public void setName(String name) {

		if (name == null || name.equals(""))

			throw new NameAppException("Blank name Setting Attempted");

		this.name = name;

	}

	// ************************************************************

	public void setSex(String sex) {

		if (sex == null || !sex.equalsIgnoreCase("M") && !sex.equalsIgnoreCase("F"))

			throw new NameAppException("Bad Gender Setting Attempted: " + sex);

		this.sex = sex;

	}

	// ************************************************************

	public void setNumber(int number) {

		if (number < 0)

			throw new NameAppException("Negative Number Setting Attempted: " + number);

		this.number = number;

	}

	// ************************************************************

	// System Utility Methods

	@Override

	public String toString() {

		return String.format("%15s, %1s, %,10d", this.name, this.sex, this.number);

	}

	// ************************************************************

	@Override

	public int hashCode() {

		final int prime = 31;
		int result = 1;

		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());

		return result;

	}

	// ************************************************************

	@Override

	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Name other = (Name) obj;

		if (name == null) {

			if (other.name != null)

				return false;

		}

		else if (!name.equals(other.name))

			return false;

		if (sex == null) {

			if (other.sex != null)

				return false;

		}

		else if (!sex.equals(other.sex))

			return false;

		return true;

	}

	// ************************************************************

	@Override

	public int compareTo(Name arg) {

		return arg.number - this.number;

	}

	// ************************************************************

	// General User Methods

	public void addToNumber(int number) {

		if (number < 0)

			throw new NameAppException("Negative Number Setting Attempted in addToNumber: " + number);

		this.setNumber(this.getNumber() + number);

	}

}