/*

 * Name: James Wolak

 * Date: 2/5/2020

 * Course Number: CSC-112

 * Course Name: Java 2

 * Problem Number: HW1 Vehicle Application

 * Email: jmwolak0001@student.stcc.edu

 * Short Description of the Problem: Using getter and setter methods, the Vehicle class obtains information. 
 * The accelerate and brake methods modify that information to help display the car race.

 * 

 */

package vehicle;

public class Vehicle {

	private String make;
	private String model;
	private int year;
	private double speed = 0;
	private double distance = 0;

	public Vehicle(String make, String model, int year) {

		this.setMake(make);
		this.setModel(model);
		this.setYear(year);

	}

//******************************************************

	public String getMake() {

		return make;

	}

//******************************************************

	public String getModel() {

		return model;

	}

//******************************************************

	public int getYear() {

		return year;

	}

//******************************************************

	public double getSpeed() {

		return speed;

	}
//******************************************************

	public double getDistance() {

		return distance;

	}

//******************************************************

	public void setMake(String make) {

		if (make == null)

			throw new RuntimeException("Make nonexistent");

		this.make = make;

	}

//******************************************************

	public void setModel(String model) {

		if (model == null)

			throw new RuntimeException("Model nonexistent");

		this.model = model;

	}

//******************************************************

	public void setYear(int year) {

		if (year < 0 || year > 2020)

			throw new RuntimeException("Year cannot be found");

		this.year = year;

	}

//******************************************************

	public void setSpeed(double speed) {

		this.speed = speed;

	}

//******************************************************

	public void setDistance(double minutes) {

		this.distance = speed * minutes;

	}

//******************************************************

	public void accelerate() {

		double fasterSpeed = this.getSpeed() + 10;

		if (fasterSpeed >= 120)

			this.setSpeed(120);

		this.setSpeed(fasterSpeed);

	}

//******************************************************

	public void brake() {

		double slowerSpeed = this.getSpeed() - 10;

		if (slowerSpeed < 0)

			this.setSpeed(0);

	}

//******************************************************

	public void adjustCarSpeed() {

		double x = Math.random() * 100;

		if (x >= 0 && x <= 50) {

			accelerate();

		} else if (x > 50 && x <= 75) {

			this.getSpeed();

		} else {

			brake();

		}

	}

//******************************************************
	@Override
	public String toString() {

		return "Vehicle [make=" + make + ", model=" + model + ", year=" + year + "]";

	}

}
