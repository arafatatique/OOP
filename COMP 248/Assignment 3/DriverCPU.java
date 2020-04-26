// ------------------------------------------------
// Assignment 3
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: November 4 2019
// ------------------------------------------------

//This program will test the methods defined in the class named CPU
public class DriverCPU {

	public static void main(String[] args) {
		System.out.println("Welcome to the simple class example!");//Welcome message to notify the user the program is running
		System.out.println();
		
		//Defining new objects in order to test the program 
		CPU CPU1 = new CPU();
		CPU CPU2=new CPU(10, "i9", 449.00, 3.1, "Q2'19", "SGX is supported"); //This will also initialize the parameters as desired by the user 
		
		//Testing the toString method
		System.out.println("CPU 1: "+CPU1.toString());
		System.out.println("CPU 2: "+CPU2.toString());
		
		//Testing the getSeries, getPrice and setPrice methods
		System.out.println("CPU 1 Series: "+CPU1.getSeries());
		System.out.println("CPU 1 Suggested price: "+CPU1.getPrice()+" USD");
		System.out.println("CPU 1 Suggested price (after mutator call): "+ CPU1.setPrice(110.00) +" USD");
		
		//Testing the equals method by comparing CPU 1 with CPU 2
		System.out.print("Are CPU 1 and CPU 2 equal? ");
		CPU1.equals(CPU2);
		
		//Testing the isHigerGeneration method
		System.out.print("Is CPU 1 of higher generation than CPU 2? ");
		CPU1.isHigherGeneration(CPU2);
			
		//Testing and formatting the priceNow method for CPU1 and CPU2
		String formattedStringForCPU1=String.format("CPU 1 price at Q3'19 :%.2f", CPU1.priceNow("Q3'19"));
		System.out.println(formattedStringForCPU1+" USD");
		String formattedStringForCPU2=String.format("CPU 2 price at Q3'19 :%.2f", CPU2.priceNow("Q3'19"));
		System.out.println(formattedStringForCPU2+" USD");
		
		//Displaying a closing message
		System.out.println();
		System.out.println("Thank you for testing the simple class example!");
	}

}
