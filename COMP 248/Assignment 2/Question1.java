// ------------------------------------------------
// Assignment 2
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: October 11 2019
// ------------------------------------------------

//This program will inform (output) the user what month we are in followed by the season (Persian calendar) based on the user's input
import java.util.Scanner;
public class Question1 {

	public static void main(String[] args) 
	
	{	//This will display a welcome message for the user 
		System.out.println("***************************************************");
		System.out.println("   Welcome to the Persian Month & Season Display");
		System.out.println("***************************************************");
		System.out.println();
		
		Scanner keyIn = new Scanner (System.in); //A scanner is being created in order to allow the user to enter the input
		int monthINT; //An integer variable is defined to store the number of the month that the user will enter
		System.out.print("Please enter the Month as a number 1-12: "); //A message prompting the user to enter an input 
		monthINT = keyIn.nextInt(); 
		
		
		//This if-statement will make sure if the user enters an integer that is not between 1-12, an error-message will be displayed. 
		//This if-statement will also remind the user to enter an integer between 1-12 inclusive 
		if (monthINT>12 && monthINT<=0)
		{System.out.print("It is not a valid month.");}
		
		
		//The following series of if-statements will display the name of the month and the season we are in that corresponds to the user's input. 
		if (monthINT==1)
			{System.out.println("We are in Farvardin, Happy Spring");}
		else if (monthINT==2)
			{System.out.println("We are in Ordibehesht, Happy Spring");}
		else if (monthINT==3)
			{System.out.println("We are in Khordad, Happy Spring");}
		else if (monthINT==4)
			{System.out.println("We are in Tir. Have Fun in summer");}
		else if (monthINT==5)
			{System.out.println("We are in Mordad. Have Fun in summer");}
		else if (monthINT==6)
			{System.out.println("We are in Shahrivar. Have Fun in summer");}
		else if (monthINT==7)
			{System.out.println("We are in Mehr, Ready for Fall");}
		else if (monthINT==8)
			{System.out.println("We are in Aban, Ready for Fall");}
		else if (monthINT==9)
			{System.out.println("We are in Azar, Ready for Fall");}
		else if (monthINT==10)
			{System.out.println("We are in Dey, Keep warm Yourself in Winter");}
		else if (monthINT==11)
			{System.out.println("We are in Bahman, Keep warm Yourself in Winter");}
		else if (monthINT==12)
			{System.out.println("We are in Esfand, Keep warm Yourself in Winter");}
		
		//This will display a closing message for the user.
		System.out.println();
		System.out.println("Thank you for using the program!");
		keyIn.close();
		
	}

}
