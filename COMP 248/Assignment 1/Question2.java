
// ------------------------------------------------
// Assignment 1
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// ------------------------------------------------

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) 
	
	{	//I am giving a title to my program which gives a brief description of it's function.
		//Displaying a welcome message
		System.out.println("***************************************************");
		System.out.println("\tWelcome to Time Converter Program");
		System.out.println("***************************************************");
		
		Scanner keyIn = new Scanner (System.in); //I am creating a new scanner that will be needed throughout my time converter program.
		System.out.print("\n\nPlease enter the seconds which will be converted: "); //I am prompting the user to enter a 5 digit integer number.
		final int NUM_SECONDS_IN_HOUR=3600; //A constant is being defined to store the number of seconds in an hour.
		final int NUM_SECONDS_IN_MIN=60; //A constant is being defined to store the number of seconds in a minute.
		int totalSeconds = keyIn.nextInt(); 
		
		//The three following lines shows the calculation used to convert the 5 digit integer number input by the user into hours, seconds and minutes.
		
		int seconds = totalSeconds % 60; //This is the seconds variable.
		int hours = totalSeconds / NUM_SECONDS_IN_HOUR; //This is the hours variable.
		int minutes = (totalSeconds%NUM_SECONDS_IN_HOUR)/NUM_SECONDS_IN_MIN; //This is the minutes variable. 
		
		//This will display the user input as hours, minutes, seconds.
		System.out.println("\nThe corresponding hours, minutes, seconds is " + hours + " hrs, " + minutes + " mins, "  + seconds + " secs.");
		
		//The following if-statements will make sure the correct format is followed when the valid time is displayed. The format was given in the assignment instructions.
		
		if (totalSeconds<=86400)
		{
			if (hours==0&&minutes==0&&seconds==0)
				System.out.println("\nThe valid time is: " + hours + "0" + ":" + minutes + "0" + ":" + seconds + "0" +".");
			else if (hours!=0&&minutes==0&&seconds==0)
				System.out.println("\nThe valid time is: " + hours + ":" + minutes + "0" + ":" + seconds + "0" +".");
			else if (hours!=0&&minutes!=0&&seconds==0)
				System.out.println("\nThe valid time is: " + hours + ":" + minutes + ":" + seconds + "0" +".");
			else if (hours!=0&&minutes==0&&seconds!=0)
				System.out.println("\nThe valid time is: " + hours + ":" + minutes + "0" + ":" + seconds +".");
			else if (hours==0&&minutes!=0&&seconds==0)	
				System.out.println("\nThe valid time is: " + hours + "0" + ":" + minutes + ":" + seconds + "0" +".");
			else if (hours==0&&minutes!=0&&seconds!=0)
				System.out.println("\nThe valid time is: " + hours + "0" + ":" + minutes + ":" + seconds +".");
			else if (hours==0&&minutes==0&&seconds!=0)
				System.out.println("\nThe valid time is: " + hours + "0" + ":" + minutes + "0" + ":" + seconds +".");
			else if (hours!=0&&minutes!=0&&seconds!=0)
				System.out.println("\nThe valid time is: " + hours + ":" + minutes + ":" + seconds + ".");
		}
		
		//The next few lines of code will deal with the issue when the user input is an integer that corresponds to more than 24 hours.
		
		if (totalSeconds>86400)
		{
			System.out.println("\nThere is no valid time for your input.");
			//I am introducing new variables and calculations in order to convert user input into a valid time by swapping the first and last digits.	
			int firstDigit= (totalSeconds/10000); //This isolates the first digit of the user input.
			int lastDigit= (totalSeconds%10); //This isolates the last digit of the user input.
			int middleDigits= (totalSeconds-(firstDigit*10000)-(lastDigit))/10; //This isolates the three middle digits of the user input.
			int swappedSeconds= ((firstDigit)+(middleDigits*10)+(lastDigit*10000)); //This will swap the user input into a valid 5-digit integer that is less that 24 hours.
			System.out.println("\nThe swapped sequence of the input time is: "+ swappedSeconds); //This is display the swapped sequence of the user input.
			//Same calculation used initially to convert user input into hours, minutes and seconds but with the swapped sequence.
			int newSeconds = swappedSeconds % 60;
			int newHours = swappedSeconds / NUM_SECONDS_IN_HOUR;
			int newMinutes = (swappedSeconds%NUM_SECONDS_IN_HOUR)/60;
			System.out.println("\nThe corresponding hours, minutes, seconds is " + newHours + " hrs, " + newMinutes + " mins, "  + newSeconds + " secs.");
			keyIn.close();
					
		}
		
		//Displaying a closing message
		System.out.println("\nThank you for using the Time Converter Program!");

	}
	

}
