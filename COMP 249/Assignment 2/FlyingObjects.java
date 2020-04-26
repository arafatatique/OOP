// ----------------------------------------------------------
// Assignment #2
// Question: Part I and later modified to satisfy the conditions of Part II.
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// ----------------------------------------------------------
/**
 * The FlyingObject class was created for the sole purpose of having a common hierarchy between the Airplane and UAV classes
 * 
 * @author Arafat Atique
 * @author Auvigoo Ahmed
 * 
 * @version 4.12.0
 * 
 * @see Airplane
 * @see UAV
 * @see MAV
 * @see AgriculturalDrone
 * @see Helicopter
 * @see Quadcopter
 * @see Multirotor
 * @see Driver
 */

package flying_objects; //This class has its own package


public class FlyingObjects {
	//Attributes 
	protected double price; 
	protected double weight;
	protected String brand;
	/**
	 * This is a default constructor that takes no parameters and initializes all appropriate variables to default.
	 *
	 */
	
	//Default constructor
	public FlyingObjects() {
	}
	
	//Method to return the price
	
	/**
	 * This method will return the price of the object belonging to the Flying Object class
	 * @return double Price of the flying object
	 */
	public double getPrice() {
		return price;};
	//Copy constructor
	/**
	 * This method will create a copy of the flying object that was passed as an argument
	 * @param fo Flying object
	 */
	//Copy constructor 
	public FlyingObjects(FlyingObjects fo) {
		this.price=fo.price;
	}
	/**
	 * This method will return the attribute information of the flying object 
	 * @return String Information 
	 */
	//toString method to display infor about the array
	public String toString() {
		return "The flying object of brand "+brand+" has a price of "+price+"$"+" and the weight is "+weight+"kg.";
	}
	
	
}
