/**
 * The Appliance class will implement methods that help business entrepreneurs to manage their business by adding new stock, change prices,
 * type, finding appliances, etc. 
 * 
 * 
 * @author Auvigoo Ahmed 
 * @author Arafat Atique
 * 
 * @version 4.12.0
 * 
 * @see Main 
 *
 */
public class Appliance {
	//Attributes for the appliance 
	private String type;
	private String brand;
	private long SN;
	private double price;
	private static int numOfAppliances = 0;
	
	/**
	 * This is a constructor method that will create an Appliance object based on the passed type, brand and price
	 * @param type Type of appliance 
	 * @param brand Brand of appliance 
	 * @param price Price of appliance 
	 * 
	 * 
	 */

	//Constructor 
	public Appliance(String type, String brand, double price) {
		this.type = type;
		this.brand = brand;
		this.SN = 1000000 + numOfAppliances;
		this.price = price;
		numOfAppliances++;		
	}
	/**
	 * This will return the type of the appliance 
	 * @return String Type of the appliance 
	 */
	public String getType() {
		return type;
	}
	/**
	 * This will return the brand of the appliance 
	 * @return String Brand of the appliance 
	 */
	public String getBrand() {
		return brand;
	}
	/**
	 * This will return the serial number of the appliance 
	 * @return long Serial number of the appliance 
	 */
	public long getSN() {
		return SN;
	}
	/**
	 * This will return the price  of the appliance 
	 * @return double Price of the appliance 
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * This method will set the type of the appliance 
	 * @param type String type of the appliance 
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * This method will set the brand of the appliance 
	 * @param brand String brand name of the appliance 
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}
	/**
	 * This method will set the price of the appliance 
	 * @param price double price of the appliance 
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * This method will Display the serial number, brand, type and price of the appliance
	 * @return String 
	 */

	public String toString() {
		return "Appliance Serial # "+SN+"\nBrand: "+brand+"\nType: "+type+"\nPrice: "+price;
	}
	/**
	 * This method will return the total number of appliances created 
	 * @return integer total number of appliances 
	 */
	public static int findNumberOfCreatedAppliances() {
		return numOfAppliances;
	}
	/**
	 * This method will verify if two appliances are equal 
	 * @param a Appliance object 
	 * @return boolean 
	 */
	public boolean equals(Appliance a) {
		return type.equals(a.getType()) && brand.equals(a.getBrand()) && price == a.getPrice();
	}
	
}
