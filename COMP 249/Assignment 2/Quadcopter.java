// ----------------------------------------------------------
// Assignment #2
// Question: Part I and later modified to satisfy the conditions of Part II.
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// ----------------------------------------------------------
/**
 * The Quadcopter class is the child class of Helicopter; Quadcopter objects can also be created for implementation
 * 
 * @author Arafat Atique
 * @author Auvigoo Ahmed
 * 
 * @version 4.12.0
 * 
 * @see FlyingObjects
 * @see Airplane
 * @see MAV
 * @see AgriculturalDrone
 * @see UAV
 * @see Helicopter 
 * @see Multirotor
 * @see Driver
 */

package helicopter_quadcopter; //This class shares a package with helicopter 

public class Quadcopter extends Helicopter {

	//Attributes 
private int maxFlyingSpeed; 
	/**
	 * Default constructor that initializes all attributes of the quadcopter to zero. 
	 */
	//Default constructor 
	public Quadcopter() {
		super();
		maxFlyingSpeed = 0;
	}
	/**
	 * Constructor that creates a quadcopter based on passed brand, price, number of cylinders, creation year, passenger capacity and max flying speed. 
	 * @param brand String name of the brand 
	 * @param price Double value of price
	 * @param hp Integer value of horse power 
	 * @param numOfCylinders Integer value of number of cylinders 
	 * @param creationYear Integer value of creation year 
	 * @param passengerCapacity Integer value of passenger capacity
	 * @param maxFlyingSpeed Integer value of max flying speed 
	 */
	//Parametrized constructor 
	public Quadcopter(String brand, double price, int hp, int numOfCylinders, int creationYear, int passengerCapacity, int maxFlyingSpeed) {
		super(brand, price, hp, numOfCylinders, creationYear, passengerCapacity);
		this.maxFlyingSpeed = maxFlyingSpeed;
	}
	/**
	 * This method will create a copy of the passed quadcopter 
	 * @param q Quadcopter object 
	 */
	//Copy constructor 
	public Quadcopter(Quadcopter q) {
		super(q);
		this.maxFlyingSpeed = q.maxFlyingSpeed;
	}
	/**
	 * This method will return the maximum flying speed of the quadcopter 
	 * @return integer Value of max flying speed
	 */
	//Mutators and accessors 
	public int getMaxFlyingSpeed() {
		return maxFlyingSpeed;
	}
	/**
	 * This method will set the max flying speed of the quadcopter 
	 * @param maxFlyingSpeed Integer value of maximum flying speed 
	 */
	public void setMaxFlyingSpeed(int maxFlyingSpeed) {
		this.maxFlyingSpeed = maxFlyingSpeed;
	}
	/**
	 * This method will display the information about the quadcopter 
	 * @return String Information 
	 */
	//toString method to display info about the quadcopter 
	public String toString() {
		return "This Quadcopter is manufactured by "+brand+". It costs "+price+"$ and has a horse power of "+hp+" hp."
				+ "\nIt has "+numOfCylinders+" cylinders and was created in "+creationYear+". It can carry "+passengerCapacity+" passengers."
						+ " Its maximum flying speed is "+maxFlyingSpeed+".";
		
	}
	/**
	 * This method will compare two quadcopters to check for equality based on brand, price, number of cylinders, creation year and passenger capacity and maximum speed.
	 * @return boolean 
	 */
	//Equals method 
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) { //Checking for null object and verifying it is of the same class 
			return false;
		}
		else {
			Quadcopter otherQuadcopter = (Quadcopter)o; //Casting the object to quadcopter 
			return brand == otherQuadcopter.brand && price == otherQuadcopter.price && hp == otherQuadcopter.hp //Comparing attributes for equality 
					&& numOfCylinders == otherQuadcopter.numOfCylinders && creationYear == otherQuadcopter.creationYear
					&& passengerCapacity == otherQuadcopter.passengerCapacity && maxFlyingSpeed == otherQuadcopter.maxFlyingSpeed;
		}
	}

}
