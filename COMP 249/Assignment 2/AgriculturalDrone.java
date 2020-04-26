// ----------------------------------------------------------
// Assignment #2
// Question: Part I and later modified to satisfy the conditions of Part II.
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// ----------------------------------------------------------
/**
 * The AgriculturalDrone class is the child class of UAV; Agricultural drone objects can also be created for implementation
 * 
 * @author Arafat Atique
 * @author Auvigoo Ahmed
 * 
 * @version 4.12.0
 * 
 * @see FlyingObjects
 * @see Airplane
 * @see Quadcopter
 * @see MAV
 * @see UAV
 * @see Helicopter 
 * @see Multirotor
 * @see Driver
 */

package agricultural_mav; //Shares a package with MAV class
import uav.UAV; //Importing the package from father class

public class AgriculturalDrone extends UAV {
	//Attributes 
	private String brand;
	private int carryCapacity;
	/**
	 * Default constructor that creates an agricultural drone with default attributes 
	 */
	//Default constructor 
	public AgriculturalDrone() {
		super();
		brand = null;
		carryCapacity = 0;
	}
	/**
	 * Constructor that creates an agricultural drone based on passed weight, price, brand and carrying capacity
	 * @param weight Double value of weight
	 * @param price Double value of price
	 * @param brand	String name of brand 
	 * @param carryCapacity Integer value of carrying capacity 
	 */
	//Parametrized constructor 
	public AgriculturalDrone(double weight, double price, String brand, int carryCapacity) {
		super(weight, price);
		this.brand = brand;
		this.carryCapacity = carryCapacity;
	}
	/**
	 * This method creates a copy of the passed agricultural drone object 
	 * @param a Agricultural drone
	 */
	//Copy constructor 
	public AgriculturalDrone(AgriculturalDrone a) {
		super(a);
		brand = a.brand;
		carryCapacity = a.carryCapacity;
	}
	/**
	 * This method will return the brand name of the agricultural drone 
	 * @return String Name of brand
	 */
	//Mutator and accessors 
	public String getBrand() {
		return brand;
	}
	/**
	 * This method will set the brand of the agricultural drone
	 * @param brand String name of brand 
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * This method will return the carrying capacity of the agricultural drone 
	 * @return integer Value of carrying capacity 
	 */
	public int getCarryCapacity() {
		return carryCapacity;
	}
	/**
	 * This method will set the carrying capacity of the agricultural drone
	 * @param carryCapacity Integer value of carrying capacity
	 */
	public void setCarryCapacity(int carryCapacity) {
		this.carryCapacity = carryCapacity;
	}
	/**
	 * This method will display the attribute information of the agricultural drone 
	 * @return String Information 
	 */
	//toString method to display all the information about the attributes 
	public String toString() {
		return "This Agricultural Drone is manufactured by "+brand+". It weighs "+weight+" pounds and costs "+price+"$."
				+ "\nIt can carry up to "+carryCapacity+" kg.";
	}
	/**
	 * This method will compare two agricultural drone objects for equality based on weight, price, brand and carrying capacity
	 * @return boolean 
	 */
	//Equals method 
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) { //Checking for null object and verifying it is of the same class 
			return false;
		}
		else {
			AgriculturalDrone otherAgricultural = (AgriculturalDrone)o; //Casting the object to Agricultural drone 
			return weight == otherAgricultural.weight && price == otherAgricultural.price && brand == otherAgricultural.brand
					&& carryCapacity == otherAgricultural.carryCapacity; //Comparing attributes for equality 
		}
	}
	

	
	
}
