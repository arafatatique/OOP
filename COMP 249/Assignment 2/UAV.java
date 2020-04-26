// ----------------------------------------------------------
// Assignment #2
// Question: Part I and later modified to satisfy the conditions of Part II.
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// ----------------------------------------------------------
/**
 * The UAV class is the father class of MAV and AgriculturalDrone classes; UAV objects can also be created for implementation
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
 * @see Helicopter
 * @see Quadcopter
 * @see Multirotor
 * @see Driver
 */

package uav; //The class has its own package 
import flying_objects.FlyingObjects; //Importing the package of its father class

public class UAV extends FlyingObjects{
	//Protected attributes that will be inherited by child classes 
	protected double weight;
	protected double price;
	/**
	 * Default constructor that will set the weight and price to zero. 
	 */
	//Default constructor 
	public UAV() {
		weight = 0;
		price = 0;
	}
	/**
	 * Constructor that creates a UAV object based on passed weight and price 
	 * @param weight Double value of weight value of the UAV
	 * @param price Double value of price of the UAV 
	 */
	//Parametrized constructor 
	public UAV(double weight, double price) {
		this.weight = weight;
		this.price = price;
	}
	/**
	 * Copy constructor that creates a copy of the passed UAV object 
	 * @param u UAV object 
	 */
	//Copy constructor 
	public UAV(UAV u) {
		this.weight = u.weight;
		this.price = u.price;
	}
	/**
	 * This method will return the weight of the UAV
	 * @return double Weight of the UAV
	 */
	//Mutators and accessors 
	public double getWeight() {
		return weight;
	}
	/**
	 * This method will set the weight of the UAV
	 * @param weight Double value of the weight of the UAV 
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}
	/**
	 * This method will return the price of the UAV 
	 * @return double Price of the UAV 
	 */
	
	public double getPrice() {
		return price;
	}
	/**
	 * This method will set the price of the UAV 
	 * @param price Double value of the price of the UAV 
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * This method will return the weight and price of the UAV object 
	 * @return String Information of the UAV object 
	 */
	//toString method to display information about the UAV 
	public String toString() {
		return "This UAV weighs "+weight+" pounds and costs "+price+"$.";
	}
	/**
	 * This method will compare two UAV objects to check for equality based on price and weight
	 * @return boolean 
	 */
	//Equals method 
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) { //Checking for null object and verifying it is of the same class
			return false;
		}
		else {
			UAV otherUAV = (UAV)o; //Casting object to UAV 
			return weight == otherUAV.weight && price == otherUAV.price; //Comparing attributes for equality 
			
		}
	}

}
