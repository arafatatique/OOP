// ------------------------------------------------
// Assignment 3
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: November 4 2019
// ------------------------------------------------

//This class will be used to define functions in order to display CPU properties and specifications 
public class CPU {
	//Private instance variables are being defined to store CPU specifications 
	private int cpuGeneration;
	private String cpuSeries;
	private double suggestedPrice;
	private double cpuSpeed;
	private String launchDate;
	private String sgxSupport;
	
	
	//Constructor with no argument to initialize variables 
	public CPU() {
		cpuGeneration = 1;
		cpuSeries = "i3";
		suggestedPrice = 117;
		cpuSpeed = 2.93;
		launchDate = "Q1'10";
		sgxSupport = "SGX is not supported";	
	}
	//6 argument constructor that sets variables as supplied 
	public CPU(int generation, String series, double price, double speed, String date, String sgx)
	{ cpuGeneration = generation;
	  cpuSeries = series;
	  suggestedPrice = price;
	  cpuSpeed = speed;
	  launchDate = date;
	  sgxSupport = sgx;
	}
	
	//6 accessor methods to return the value of each variable 
	public int getGen()
	{return cpuGeneration;}
	
	public String getSeries()
	{return cpuSeries;}
	
	public double getPrice()
	{return suggestedPrice;}
	
	public double getSpeed()
	{return cpuSpeed;}
	
	public String getDate()
	{return launchDate;}
	
	public String getSGXsupport()
	{return sgxSupport;}
	
	//Mutator method to set the suggested price 
	public double setPrice (double price)
	{return suggestedPrice = price;}
	
	//A method that returns the estimated price of the CPU based on the supplied Quarter variable 
	public double priceNow(String sQuarterYear)
	{String quarterString = launchDate.substring(1,2); //Isolating the launch date in quarters
	 int quarter = Integer.parseInt(quarterString); 	//Converting string to integer 
	 String yearString = launchDate.substring(3,5);		//Isolating the launch date in years 
	 int year = Integer.parseInt(yearString);			//Converting string to integer 
	 int yearInQuarters=year*4;							//Number of quarters based on years 
	 int totalQuarters=yearInQuarters+quarter;			//Total number of quarters
	 
	 String quarterStringNew = sQuarterYear.substring(1,2);	//Isolating the input date in quarters
	 int quarterNew = Integer.parseInt(quarterStringNew);	//Converting string to integer 
	 String yearStringNew = sQuarterYear.substring(3,5);	//Isolating the input date in years 
	 int yearNew = Integer.parseInt(yearStringNew);			//Converting string to integer 
	 int yearNewInQuarters=yearNew*4;						//Number of quarters based on years
	 int totalNewQuarters=yearNewInQuarters+quarterNew;		//Total number of quarters
	 
	 
	 //If statement to make sure if the the supplied date is before the launch date, there is no price difference 
	 if (totalQuarters>totalNewQuarters)
	 	{return suggestedPrice;}
	 //Else statement to calculate the price difference 
	 else {
		 	int quarterDifference = totalNewQuarters-totalQuarters;
		 	double subtractionFactor=suggestedPrice*0.02;
		 	for (int i=1;i<=quarterDifference;i++)
		 	{suggestedPrice-=subtractionFactor;}
		 	return suggestedPrice;
	 		}
		}
	
		//Returns all the values of a CPU object
	public String toString()
	{return "This CPU is "  +cpuGeneration+ "th generation "+ cpuSeries + " (" + cpuSpeed + " GHz"+"), launched: " + launchDate + " with price: "+ suggestedPrice +" USD. "+ sgxSupport;}
	
	//Test for equality of two CPU objects 
	public void equals(CPU obj)
		{CPU other = (CPU) obj;
		if (this.cpuGeneration==other.cpuGeneration && this.cpuSeries.equalsIgnoreCase(other.cpuSeries) && this.sgxSupport.equalsIgnoreCase(other.sgxSupport))		
		{System.out.println("YES");}
		else {System.out.println("NO");}
		}
	
	
	//Compares two CPU objects based on generations 
	public void isHigherGeneration(CPU cpu)
	{if (this.cpuGeneration>cpu.cpuGeneration)
		{System.out.println("YES");}
	else {System.out.println("NO");}	
	}
	

//This program will test the methods defined in the class named CPU

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













