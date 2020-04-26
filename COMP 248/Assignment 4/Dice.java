// ------------------------------------------------
// Assignment 4
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: December 2 2019
// ------------------------------------------------
import java.util.Random;
public class Dice {
	
	int die1; //Integer variable that will store the role of 1st die
	int die2; //Integer variable that will store the role of 2nd die 
	
	public Dice(){}// Default constructor 
	
	//Accessor method for die 1 attribute
	public int getDie1() 
	{return die1;}
	
	//Accessor method for die 2 attribute 
	public int getDie2() 
	{return die2;}
	
	//Simulates the rolling of 2 dice and assigns a value to die 1 and die 2
	public int rollDice()
	{
		Random r = new Random(); //Generates a random number 
		die1 = r.nextInt(6)+1; //Random number between 1 and 6 assigned for die 1
		die2 = r.nextInt(6)+1;	//Random number between 1 and 6 assigned for die 2
		return die1+die2;       //Returns sum of die1 and die2
	}
	
	//Returns the boolean value true if die 1 is equal to die 2; false otherwise
	public boolean isDouble()
	{return die1==die2;}
	
	//Returns a string containing the values of both attributes in a descriptive message 
	public String toString()
	{
		return "Die1: "+die1+" Die2: "+die2;
	}
	

}
