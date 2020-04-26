// ----------------------------------------------------------
// Assignment #2
// Question: Part I and later modified to satisfy the conditions of Part II.
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// ----------------------------------------------------------
/**
 * The Helicopter class is the father class of Multirotor and Quadcopter classes; Helicopter objects can also be created for implementation
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
 * @see Quadcopter
 * @see Multirotor
 * @see Driver
 */


package helicopter_quadcopter; //It belongs to a package that also includes the Quadcopter class
import airplane.Airplane; //Importing the package of its father class 

public class Helicopter extends Airplane{
	//Protected attributes that will be inherited by child classes 
	protected int numOfCylinders;
	protected int creationYear;
	protected int passengerCapacity;
	
	/**
	 * Default constructor that initializes all attributes to 0 
	 */
	//Default constructor 
	public Helicopter() {
		
		super();
		numOfCylinders = 0;
		creationYear = 0;
		passengerCapacity = 0;
	}
	/**
	 * Constructor that creates a helicopter based on the passed brand, price, number of cylinders, creation year and passenger capacity
	 * @param brand String name of the brand 
	 * @param price Double value of the price 
	 * @param hp Integer value of the horse power
	 * @param numOfCylinders Integer value of the number of cylinders
	 * @param creationYear Integer value of the creation year 
	 * @param passengerCapacity Integer value of the passenger capacity 
	 */
	//Parametrized constructor 
	public Helicopter(String brand, double price, int hp, int numOfCylinders, int creationYear, int passengerCapacity) {
		
		super(brand, price, hp);
		this.numOfCylinders = numOfCylinders;
		this.creationYear = creationYear;
		this.passengerCapacity = passengerCapacity;
	}
	/**
	 * Copy constructor that creates a copy of the passed helicopter object 
	 * @param h Helicopter object 
	 */
	//Copy constructor 
	public Helicopter(Helicopter h) {
		
		super(h);
		this.numOfCylinders = h.numOfCylinders;
		this.creationYear = h.creationYear;
		this.passengerCapacity = h.passengerCapacity;
	}
	/**
	 * This method will return the number of cylinders of the helicopter 
	 * @return integer Value of the number of cylinders 
	 */
	//Mutators and accessors 
	public int getNumOfCylinders() {
		return numOfCylinders;
	}
	/**
	 * This method will set the number of cylinders of the helicopter 
	 * @param numOfCylinders Integer value of the number of cylinders 
	 */
	public void setNumOfCylinders(int numOfCylinders) {
		this.numOfCylinders = numOfCylinders;
	}
	/**
	 * This method will return the year of creation of the helicopter
	 * @return integer Value of the year of creation 
	 */
	public int getCreationYear() {
		return creationYear;
	}
	/**
	 * This method will set the creation year of the helicopter 
	 * @param creationYear Integer value of the creation year 
	 */
	public void setCreationYear(int creationYear) {
		this.creationYear = creationYear;
	}
	/**
	 * This method will return the passenger capacity of the helicopter
	 * @return integer Value of the passenger capacity 
	 */
	public int getPassengerCapacity() {
		return passengerCapacity;
	}
	/**
	 * This method will set the passenger capacity of the helicopter 
	 * @param passengerCapacity Integer value of passenger capacity 
	 */
	public void setPassengerCapacity(int passengerCapacity) {
		this.passengerCapacity = passengerCapacity;
	}
	/**
	 * This method will display the brand, price, hp, number of cylinders, creation year and passenger capacity of the helicopter
	 * @return String  
	 */
	//toString method to display info about the helicopter 
	public String toString() {
		return "This Helicopter is manufactured by "+brand+". It costs "+price+"$ and has a horse power of "+hp+" hp."
				+ "\nIt has "+numOfCylinders+" cylinders and was created in "+creationYear+". It can carry "+passengerCapacity+" passengers.";
				
	}
	/**
	 * This method will compare two helicopter objects for equality based on the brand, price, hp, number of cylinders, creation year and passenger capacity
	 * @return boolean 
	 */
	//Equals method 
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) { //Checking for null object and verifying it is of the same class
			return false;
		}
		else {
			Helicopter otherHelicopter = (Helicopter)o; //Casting the object to helicopter 
			return brand == otherHelicopter.brand && price == otherHelicopter.price && hp == otherHelicopter.hp //Comparing all attributes for equality 
					&& numOfCylinders == otherHelicopter.numOfCylinders && creationYear == otherHelicopter.creationYear
					&& passengerCapacity == otherHelicopter.passengerCapacity;
		}
	}
}
