// ----------------------------------------------------
// Assignment 4
// Part 2
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// Due date: April 19, 2020
// Read through a list of cellphone information and create a LinkedList with that information
//-----------------------------------------------------


import java.util.Objects;
import java.util.Scanner;
/**
 * This program uses linked lists, that manipulates a set of records of cell phones and performs some operations on these records.
 * 
 * @author Auvigoo Ahmed (40128901)
 * @author Arafat Atique (40132573)
 * @version 4.12.0
 * @see SubDictionary
 * @see CellList
 * @see CellListUtilization
 *
 */
public class CellPhone {
	//Attributes of the CellPhone class
    private long serialNum;
    private String brand;
    private int year;
    private double price;
    Scanner keyIn = new Scanner(System.in);
    /**
     * Parametrized constructor to create a cellphone with passed values 
     * @param serialNum Long value of serial number
     * @param brand String name of brand
     * @param year Integer value of year
     * @param price Double value of price
     */
    public CellPhone(long serialNum, String brand, int year, double price) {
        this.serialNum = serialNum;
        this.brand = brand;
        this.year = year;
        this.price = price;
    }
    /**
     * This method will return the serial number of a cellphone
     * @return long Value of serial number 
     */
    public long getSerialNum() {
        return serialNum;
    }
    /**
     * This method will set the serial number of the cellphone
     * @param serialNum Long value of serial number 
     */
    public void setSerialNum(long serialNum) {
        this.serialNum = serialNum;
    }
    /**
     * This method will return the brand name of the cellphone
     * @return String name of brand 
     */
    public String getBrand() {
        return brand;
    }
    /**
     * This method will set the brand of the cellphone 
     * @param brand String name of brand 
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }
    /**
     * This method will return the year of the cellphone
     * @return integer Value of year
     */
    public int getYear() {
        return year;
    }
    /**
     * his method will set the year of the cellphone
     * @param year Integer value of year 
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * This method will return the price of the cellphone
     * @return double Value of price
     */
    public double getPrice() {
        return price;
    }
    /**
     * This method will set the price of the cellphone
     * @param price Double value of price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * This method will create a copy of the cellphone
     * @param cp CellPhone object
     * @param sn Long value of serial number 
     */
    public CellPhone(CellPhone cp, long sn){
        this.brand = cp.getBrand();
        this.price = cp.getPrice();
        this.year = cp.getYear();
        this.serialNum = sn;
    }

    /**
     * This method will clone the cellphone with the passed serial number 
     * @return CellPhone object
     */
    protected Object clone() {
        System.out.println("Please enter a new serial number.");
        return new CellPhone(this, keyIn.nextLong());
    }

    /**
     * This method will print the serial number, price and year of the cellphone
     * @return String 
     */
    public String toString() {
        return "["+serialNum+": "+brand+" "+price+"$ "+year+"]";
    }

    /**
     * This method will check the equality of two cellphones 
     * @return boolean 
     */
    public boolean equals(Object o) {
        if (o == null || o.getClass() != this.getClass())
            return false;
        if (this == o)
            return true;
        CellPhone otherCellPhone = (CellPhone) o;
        return (this.year == otherCellPhone.getYear() && this.price == otherCellPhone.getPrice());
    }
}