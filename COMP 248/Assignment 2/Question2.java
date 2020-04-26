
// ------------------------------------------------
// Assignment 2
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: October 11 2019
// ------------------------------------------------

//This program will output the circumference of the square of the desired length that the user inputs and also display a square of the same length
import java.util.Scanner;
public class Question2 {

	public static void main(String[] args) 
	
	{	//This will display a welcome message for the user 
		System.out.println("--------------------------------------------");
		System.out.println("\tCircumference Calculator");
		System.out.println("--------------------------------------------");
		
		Scanner keyIn = new Scanner (System.in); //A scanner is being created in order to allow the user to enter the input
		System.out.println("Please enter the length of a side!");  //A message prompting the user to enter an input 
		int length=keyIn.nextInt(); //An integer variable is defined in order to record the user's input of the length of the square
		int circumference = (length*4); //This equation will calculate the circumference of the square based on the user's input of the length
		System.out.println("The Circumference of the Square is " + circumference); //This will display the circumference of the square 
		
		//The following for-loop will draw a square based on the user's input of the length
		
		for (int i=1; i<=length; i++)
			{	System.out.print("\t\t\t\t\t");
				for (int j=1; j<=length; j++)
					
					{if (i==j)
						{System.out.print("\\ ");} //When the row and column have the same number, the program will output a "\" since it corresponds to the diagonal of the square
					else {System.out.print("X ");} //The system will output an "X" to draw the square except for the case of the diagonal 
						
					}
			
				System.out.println();
				
			}
		//This will display a closing message for the user.
		System.out.println();
		System.out.println("Thank you for using the program!");
		keyIn.close();
				
	}

}
