
// ------------------------------------------------
// Assignment 2
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: October 11 2019
// ------------------------------------------------

//This program will perform addition, subtraction, multiplication and division for the user based on his/her input 
import java.util.Scanner;
public class Question3 {

	public static void main(String[] args) 
	
	{
	//This will display a welcome message for the user 
	System.out.println("Hello to mini calculator program.");
	Scanner keyIn = new Scanner (System.in); //A scanner is being created in order to allow the user to enter the input
	double answer=0; //A double variable is being defined and initialized that will be needed later on in the program to store the answer
	
	//The following while loop will make sure the program keeps running and displaying the answer for the user.
	while (true)
		
	{	System.out.println("Please enter the numbers along operation (press q to exit):"); //A message prompting the user to enter an input 
		System.out.println();
		String input = keyIn.next(); //A string type is being defined to record the user's input 
		
		//This if-statement will make sure the loop breaks when the user enters the letter "q". 
		//This if-statement will also make sure the program ends when the user enters the letter "q" 
		if (input.equalsIgnoreCase("q"))
			break;
		
		//The following if-statement will apply when the user wants to perform a multiplication
		if (input.contains("x")) //This will verify if the user's string contains a multiplication operator
		{	int indexOfMul = input.indexOf('x'); //An integer variable is being defined to store the index of the multiplication operator 
			int inputLengthOfMul = input.length(); //An integer variable is being defined to store the length of the string input
	
			//The following lines of code will extract the operands and operator from the string input of the user
			String firstOperandOfMulString = input.substring(0, indexOfMul); //This will isolate the first operand in the string 
			String lastOperandOfMulString = input.substring(indexOfMul+1, inputLengthOfMul); //This will isolate the second operand in the string 
	
			int firstOperandOfMul = Integer.parseInt(firstOperandOfMulString); //This will convert the first operand from a string to an integer 
			int lastOperandOfMul = Integer.parseInt(lastOperandOfMulString); //This will convert the second operand from a string to an integer 
	
			char operatorOfMul = input.charAt(indexOfMul); //This will extract the multiplication operator from the user's string input 
			
			//The following switch statement will perform the multiplication that was desired by the user 
			switch (operatorOfMul)
			{case 'x': answer = firstOperandOfMul * lastOperandOfMul;
				break;
			}
			System.out.println();
			System.out.println("The answer is: " + answer); //This will display the user's answer 
			
		}
		
		
		//The following if-statement will apply when the user wants to perform an addition
		if (input.contains("+")) //This will verify if the user's string contains an addition operator
		{	int indexOfAdd = input.indexOf('+'); //An integer variable is being defined to store the index of the addition operator 
			int inputLengthOfAdd = input.length(); //An integer variable is being defined to store the length of the string input
	
			//The following lines of code will extract the operands and operator from the string input of the user
			String firstOperandOfAddString = input.substring(0, indexOfAdd); //This will isolate the first operand in the string 
			String lastOperandOfAddString = input.substring(indexOfAdd+1, inputLengthOfAdd); //This will isolate the second operand in the string
	
			int firstOperandOfAdd = Integer.parseInt(firstOperandOfAddString); //This will convert the first operand from a string to an integer
			int lastOperandOfAdd = Integer.parseInt(lastOperandOfAddString); //This will convert the second operand from a string to an integer 
	
			char operatorOfAdd = input.charAt(indexOfAdd); //This will extract the addition operator from the user's string input 
			
			//The following switch statement will perform the addition that was desired by the user 
			switch (operatorOfAdd)
			{case '+': answer = firstOperandOfAdd + lastOperandOfAdd;
					break;
			}
			System.out.println();
			System.out.println("The answer is: " + answer); //This will display the user's answer 
		
		}
			
				
		
		//The following if-statement will apply when the user wants to perform a division
		if (input.contains("/")) //This will verify if the user's string contains a division operator
		{	int indexOfDiv = input.indexOf('/'); //An integer variable is being defined to store the index of the division operator
			int inputLengthOfDiv = input.length(); //An integer variable is being defined to store the length of the string input
	
			//The following lines of code will extract the operands and operator from the string input of the user
			String firstOperandOfDivString = input.substring(0, indexOfDiv); //This will isolate the first operand in the string
			String lastOperandOfDivString = input.substring(indexOfDiv+1, inputLengthOfDiv); //This will isolate the second operand in the string
			
			int firstOperandOfDiv = Integer.parseInt(firstOperandOfDivString); //This will convert the first operand from a string to an integer
			int lastOperandOfDiv = Integer.parseInt(lastOperandOfDivString); //This will convert the second operand from a string to an integer 
	
			char operatorOfDiv = input.charAt(indexOfDiv); //This will extract the division operator from the user's string input
			
			//The following switch statement will perform the division that was desired by the user 
			switch (operatorOfDiv)
			{case '/': answer = firstOperandOfDiv / lastOperandOfDiv;
					break;
			}
			System.out.println();
			System.out.println("The answer is: " + answer); //This will display the user's answer 
			
		}
			
			
		
		//The following if-statement will apply when the user wants to perform a subtraction
		if (input.contains("-")) //This will verify if the user's string contains a subtraction operator
		{ 	int indexOfSub = input.indexOf('-'); //An integer variable is being defined to store the index of the subtraction operator
			int inputLengthOfSub = input.length(); //An integer variable is being defined to store the length of the string input
	
			String firstOperandOfSubString = input.substring(0, indexOfSub); //This will isolate the first operand in the string
			String lastOperandOfSubString = input.substring(indexOfSub+1, inputLengthOfSub); //This will isolate the second operand in the string
	
			int firstOperandOfSub = Integer.parseInt(firstOperandOfSubString); //This will convert the first operand from a string to an integer
			int lastOperandOfSub = Integer.parseInt(lastOperandOfSubString); //This will convert the second operand from a string to an integer 
	
			char operatorOfSub = input.charAt(indexOfSub); //This will extract the subtraction operator from the user's string input
	
			//The following switch statement will perform the subtraction that was desired by the user
			switch (operatorOfSub)
			{case '-': answer = firstOperandOfSub - lastOperandOfSub;
				break;
			}
			System.out.println();
			System.out.println("The answer is: " + answer); //This will display the user's answer 
	
			}	
	}
	
	//This will display a closing message for the user.
	System.out.println();
	System.out.println("Thanks for using mini calculator program.");
	
	keyIn.close();
	}
}
