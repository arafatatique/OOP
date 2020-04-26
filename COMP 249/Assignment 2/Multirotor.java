// ----------------------------------------------------------
// Assignment #2
// Question: Part I and later modified to satisfy the conditions of Part II.
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// ----------------------------------------------------------
/**
 * The Multirotor class is the child class of Helicopter class; Multirotor objects can also be created for implementation
 * 
 * @author Arafat Atique
 * @author Auvigoo Ahmed
 * 
 * @version 4.12.0
 * 
 * @see FlyingObjects
 * @see UAV
 * @see MAV
 * @see AgriculturalDrone
 * @see Helicopter
 * @see Quadcopter
 * @see Airplane
 * @see Driver
 */
package multirotor;//This class belongs to its own package 
import helicopter_quadcopter.Helicopter; //Importing the package of its father class

public class Multirotor extends Helicopter{
private int numOfRotors; //Attributes 
	/**
	 * This method will create a multirotor with attributes set to default 
	 * 
	 */
	//Default constructor 
	public Multirotor() {
		super();
		numOfRotors = 0;
	}
	/**
	 * This method will create a multirotor based on passed brand, price, horsepower, number of cylinders, creation year, passenger capacity and number of rotors 
	 * @param brand String name of brand
	 * @param price Double value of price 
	 * @param hp Integer value of horsepower 
	 * @param numOfCylinders Integer value of number of cylinders 
	 * @param creationYear Integer value of creation year
	 * @param passengerCapacity Integer value of passenger capacity 
	 * @param numOfRotors Integer value of number of rotors 
	 */
	//Parametrized constructor 
	public Multirotor(String brand, double price, int hp, int numOfCylinders, int creationYear, int passengerCapacity, int numOfRotors) {
		super(brand, price, hp, numOfCylinders, creationYear, passengerCapacity);
		this.numOfRotors = numOfRotors;
	}
	/**
	 * This method will create a copy of the passed multirotor object 
	 * @param m Multirotor object 
	 */
	//Copy constructor 
	public Multirotor(Multirotor m) {
		super(m);
		numOfRotors = m.numOfRotors;
	}
	/**
	 * This method will return the number of rotors of the multirotor
	 * @return integer Value of number of rotors 
	 */
	//Mutators and accessors 
	public int getNumOfRotors() {
		return numOfRotors;
	}
	/**
	 * This method will set the number of rotors of the multirotor 
	 * @param numOfRotors Integer value of number of rotors 
	 */
	public void setNumOfRotors(int numOfRotors) {
		this.numOfRotors = numOfRotors;
	}
	/**
	 * This method will display attribute information of the multirotor 
	 * @return String Information 
	 */
	//toString method to display information about the multirotor 
	public String toString() {
		return "This Multirotor is manufactured by "+brand+". It costs "+price+"$ and has a horse power of "+hp+" hp."
				+ "\nIt has "+numOfCylinders+" cylinders and was created in "+creationYear+". It can carry "+passengerCapacity+" passengers."
						+ " It has "+numOfRotors+" rotors.";
		
	}
	/**
	 * This method will compare two multirotor objects for equality based on passed brand, price, horsepower, number of cylinders, creation year, passenger capacity and number of rotors
	 * @return boolean 
	 */
	//Equals method 
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) { //Checking for null object and verifying it is of the same class 
			return false;
		}
		else {
			Multirotor otherMultirotor = (Multirotor)o; //Casting the object to multirotor 
			return brand == otherMultirotor.brand && price == otherMultirotor.price && hp == otherMultirotor.hp //Comparing attributes for equality 
					&& numOfCylinders == otherMultirotor.numOfCylinders && creationYear == otherMultirotor.creationYear
					&& passengerCapacity == otherMultirotor.passengerCapacity && numOfRotors == otherMultirotor.numOfRotors;
		}
	}
	

}
