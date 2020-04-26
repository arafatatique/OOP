/**
 * The Airplane class is the father class of Helicopter class; Airplane objects can also be created for implementation
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
 * @see Multirotor
 * @see Driver
 */

//It is part of the airplane package
package airplane;

import flying_objects.FlyingObjects; //Importing the package of its father class which is Flying Objects 

public class Airplane extends FlyingObjects{
	
	//All protected attributes because the child classes will require access
	protected String brand;
	protected double price;
	protected int hp;
	
	//Default constructor 
	/**
	 * This is a default constructor that takes no parameters and initializes all appropriate variables to default.
	 */
	public Airplane() {

	}
	/**
	 * This constructor will create an Airplane object based on the passed brand, price and horsepower
	 * @param brand String brand of the Airplane
	 * @param price double price of the Airplane
	 * @param hp integer value of the horse power 
	 */
	//Parametrized constructor 
	public Airplane(String brand, double price, int hp) {
		this.brand = brand;
		this.price = price;
		this.hp = hp;
	}
	/**
	 * This method creates a copy of the passed airplane object
	 * @param a Airplane object
	 */
	//Copy constructor 
	public Airplane(Airplane a) {
		this.brand = a.brand;
		this.price = a.price;
		this.hp = a.hp;
	}
	/**
	 * This method will return the brand of the airplane
	 * @return String brand of the airplane
	 */
	//Mutators and accessors 
	public String getBrand() {
		return brand;
	}
	
	/**
	 * This method will set the brand of the airplane 
	 * @param brand String name of the brand 
	 */
	
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * This method will get the price of the airplane 
	 * @return double Price of the airplane 
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * This method will set the price of the airplane
	 * @param price Double price of the airplane
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * This method will return the horse power of the airplane 
	 * @return integer Value of the horse power
	 */
	public int getHp() {
		return hp;
	}
	/**
	 * This method will set the horse power of the airplane 
	 * @param hp Integer value of the horse power 
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}
	
	/**
	 * This method will return the brand, price and horse power of the airplane 
	 * @return String Information of the airplane object 
	 */
	//toString method to display information about the airplane 
	public String toString() {
		String className = getClass().toString().substring(15);
		return "This "+className+" is manufactured by "+brand+". It costs "+price+"$ and has a horse power of "+hp+" hp.";
	}
	/**
	 * This method will compare two airplanes to check for equality based on brand, price and horsepower
	 * @return boolean 
	 */
	//Equals method 
	public boolean equals(Object o) {
		if (o == null || this == null || getClass() != o.getClass()) { //Checking for null object and verifying it is of the same class
			return false;
		}
		else {
			Airplane otherAirplane = (Airplane)o; //Casting the passed object to an Airplane 
			return (brand == otherAirplane.brand && price == otherAirplane.price && hp == otherAirplane.hp); //Comparing attributes to see if they are equal
		}
	}
}
