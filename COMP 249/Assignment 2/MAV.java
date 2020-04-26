// ----------------------------------------------------------
// Assignment #2
// Question: Part I and later modified to satisfy the conditions of Part II.
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// ----------------------------------------------------------
/**
 * The MAV class is the child class of UAV; MAV objects can also be created for implementation
 * 
 * @author Arafat Atique
 * @author Auvigoo Ahmed
 * 
 * @version 4.12.0
 * 
 * @see FlyingObjects
 * @see Airplane
 * @see Quadcopter
 * @see AgriculturalDrone
 * @see UAV
 * @see Helicopter 
 * @see Multirotor
 * @see Driver 
 */

package agricultural_mav; //Shares a package with AgriculturalDrone class
import uav.UAV; //Importing the package of father class

public class MAV extends UAV{
	//Attributes 
	private String model;
	private double size;
	/**
	 * Default constructor that creates an MAV object with attributes set to default 
	 * 
	 */
	//Default constructor 
	public MAV() {
		super();
		model = null;
		size = 0.0;
	}
	/**
	 * Constructor that creates an MAV object with passed weight, price, model and size 
	 * 
	 * @param weight Double value of weight 
	 * @param price Double value of price 
	 * @param model String name of brand 
	 * @param size Double value of size 
	 */
	//Parametrized constructor 
	public MAV(double weight, double price, String model, double size) {
		super(weight, price);
		this.model = model;
		this.size = size;
	}
	/**
	 * This method will create a copy of the passed MAV object 
	 * @param m MAV object 
	 */
	//Copy constructor 
	public MAV(MAV m) {
		super(m);
		model = m.model;
		size = m.size;
	}
	/**
	 * This method will return the model of the MAV 
	 * @return String name of model 
	 */
	//Mutators and accessors 
	public String getModel() {
		return model;
	}
	/**
	 * This method will set the model of the MAV 
	 * @param model String name of model 
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * This method will return the size of the MAV 
	 * @return double Value of size 
	 */
	public double getSize() {
		return size;
	}
	/**
	 * This method will set the size of the MAV 
	 * @param size Double value of size 
	 */
	public void setSize(double size) {
		this.size = size;
	}
	/**
	 * This method will display the attribute information of MAV 
	 * @return String Information
	 */
	//toString method to display info about the MAV
	public String toString() {
		return "This MAV is the model "+model+" and its size is "+size+". It weighs "+weight+" and costs "+price+"$.";
	}
	/**
	 * This method will compare two MAV objects for equality based on price, weight, model and size
	 * @return boolean 
	 */
	//Equals method 
	public boolean equals(Object o) {
		if (o == null || o.getClass() != getClass()) { //Checking for null object and verifying it is of the same class
			return false;
		}
		else {
			MAV otherMAV = (MAV)o; //Casting the object to MAV
			return weight == otherMAV.weight && price == otherMAV.price && model == otherMAV.model //Comparing attributes for equality
					&& size == otherMAV.size;
		}
	}


}
