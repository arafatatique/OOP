import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		//Creating a scanner 
		Scanner keyIn = new Scanner(System.in);
		
		//Displaying a welcome message 
		System.out.println("************************************");
		System.out.println("* Welcome to the Appliance Tracker *");
		System.out.println("************************************");
		
		//Asking the user for the amount of appliances
		System.out.print("\nPlease enter the maximum number of appliances that your store can contain: ");
		int maxAppliances = keyIn.nextInt();
		
		//Creating an array of the desired size based on user input 
		Appliance[] inventory = new Appliance[maxAppliances];
		
		
		int choice; //Variable that will be used to record user input for menu 
		final String password = "c249";	//Password needed to access menu options 	
		int attempt = 0; //Variable to record attempts 
		int consecutiveAttempt = 0;//to count how many cycles of 3 failed attempts
		String userPass; //Variable to record the passed password 
		boolean programWork = true; 
		int numOfAppliancesToAdd;

		while(programWork) {
			//Displaying the main menu 
			do {
				System.out.println("\nWhat do you want to do?");
				System.out.print("\t1. Enter new appliances (password required)\n"
						+ "\t2. Change information of an appliance (password required)\n"
						+ "\t3. Display all appliances by a specific brand\n"
						+ "\t4. Display all appliances under a certain price\n"
						+ "\t5. Quit\nPlease enter your choice >");

				choice = keyIn.nextInt(); //Prompting the user for his/her choice 
			}while(choice < 1 || choice >5); //Verifying the validity of the user input 

			//Condition for when the user enters choice 1 
			if(choice == 1) {
				while(attempt <= 12) {
					//After 12 failed password attempts the system will exit 
					if(attempt == 12) {
						System.out.println("Program detected suspicious activities and will terminate now!");
						System.exit(0);
					}
					//After 3 incorrect attempts, the user will go back to the main menu 
					if(attempt == 3 && consecutiveAttempt != 1|| attempt == 6 && consecutiveAttempt != 2|| attempt == 9 && consecutiveAttempt != 3) {
						consecutiveAttempt++;
						System.out.println("Three incorrect password attempts. Returning back to main manu.");
						break;
					}
					//Prompting the user to enter the password 
					System.out.print("Please enter your password: ");
					userPass = keyIn.next();
					
					//Verifying if the password was correct 
					if(!userPass.equals(password)) {
						attempt++;
						System.out.println("Wrong password.");
					}
					//If the password is correct 
					else {
						attempt = 0;
						System.out.print("How many appliances would you like to enter?");
						numOfAppliancesToAdd = keyIn.nextInt();
						//case 1:there is enough space in the array to add these appliances
						if( inventory.length >= numOfAppliancesToAdd + Appliance.findNumberOfCreatedAppliances() ) {
							for(int i = 0; i<numOfAppliancesToAdd; i++) {
								System.out.print("Please enter the type of appliance "+i+": ");
								String type = keyIn.next(); //Recording type 
								System.out.print("Please enter the brand of the appliance "+i+": ");
								String brand = keyIn.next(); //Recording brand 
								System.out.print("Please enter the price of the appliance "+i+": ");
								double price = keyIn.nextDouble(); //Recording price
								inventory[i] = new Appliance(type, brand, price); //Adding appliances in the array 
							}
							System.out.println("You have successfully entered the appliances. Returning back to main menu.");
							break;
						}
						//case 2: there is not enough space in the array to add these appliances
						else {	
							int numOfAppliancesLeft = inventory.length - Appliance.findNumberOfCreatedAppliances();
							System.out.println("There is not enough space in the inventory to add "+numOfAppliancesToAdd+" appliances.\n"
									+ "You can add "+numOfAppliancesLeft+" appliances instead.");


							if(numOfAppliancesLeft <= 0) {
								System.out.println("There is no more space in the inventory to add appliances. Returning back to main menu.");
								break;
							}
							else {
								int currentNumOfAppliances = Appliance.findNumberOfCreatedAppliances();
								for(int i=0; i< numOfAppliancesLeft; i++) {
									int currentIndex = i+currentNumOfAppliances;
									System.out.print("Please enter the type of appliance "+currentIndex+": ");
									String type = keyIn.next(); //Recording type 
									System.out.print("Please enter the brand of the appliance "+currentIndex+": ");
									String brand = keyIn.next(); //Recording brand 
									System.out.print("Please enter the price of the appliance "+currentIndex+": ");
									double price = keyIn.nextDouble(); //Recording price
									inventory[currentIndex] = new Appliance(type, brand, price);
								}
							}
							System.out.println("You have successfully entered the appliances. Returning back to main menu.");
							break;

						}

					}

				}
			}
			
			//When user enters choice two 
			if(choice == 2) {
				attempt = 0;
				while (attempt <= 3) {
					//Verifying the user enters the correct password without wasting attempts 
					if(attempt == 3) {
						System.out.println("Three incorrect password attempts. Returning back to main manu.");
						break;
					}
					System.out.print("Please enter your password: ");
					userPass = keyIn.next();

					if(!userPass.equals(password)) {
						attempt++;
						System.out.println("Wrong password.");
						continue;
					}

					//password is correct
					else {
						boolean choice2=true;
						//Asking the user for its choice of action 
						while(choice2) {
							System.out.print("Please enter the serial number of the appliance that you wish to update: ");
							long snToUpdate = keyIn.nextLong();
							
							boolean inInventory = true;

							//If the serial number doesnt exist in the inventory
							if(!snInventory(inventory, snToUpdate)) {
								while(inInventory) {
									//Prompt the user to choose an option as long as the passed SN doesnt exist in the inventory 
									System.out.println("There is no appliance in the inventory with that serial Number.\n"
											+ "What would you like to do?\n"
											+ "\t1- Re-enter another serial number\n"
											+ "\t2- Go back to the main menu");
									int userInputSN = keyIn.nextInt();
									if(userInputSN<1 || userInputSN>2) {
										System.out.println("Invalid selection"); //Making sure the user chooses a correct option 
									}
									else if(userInputSN == 1) {
										break;
									}
									else if(userInputSN == 2) {
										choice2 = false;
										break;
									}

								}
							}
							//when the SN exists
							else {
								int indexOfApplianceToUpdate = indexSNInventory(inventory, snToUpdate);
								System.out.println("Here is the description of that appliance: ");
								System.out.println(inventory[indexOfApplianceToUpdate].toString()); //Displaying the information of the appliance with the passed SN 
								
								boolean changeMenu = true;
								while(changeMenu) { 
									System.out.print("What information would you like to change?\n" //Asking the user what they would like to change about the corresponding appliance 
											+ "\t1. Brand\n"
											+ "\t2. Type\n"
											+ "\t3. Price\n"
											+ "\t4. Quit\n"
											+ "Enter your choice> ");
									int changeDecision = keyIn.nextInt();
									if(changeDecision < 1 || changeDecision > 4) { //Making sure the user enters a valid choice 
										System.out.println("Invalid input");
									}
									else if(changeDecision == 4) { 
										System.out.println("Returning back to main menu."); //User returns back to main menu 
										choice2 = false;
										break;
									}
									else if(changeDecision == 3) { //User decides to change price of the appliance 
										System.out.print("Please enter the new desired price of the appliance: ");  
										double newPrice = keyIn.nextDouble();
										inventory[indexOfApplianceToUpdate].setPrice(newPrice);
										System.out.println("The price has been updated to "+newPrice+". Here is the description of that appliance:");
										System.out.println(inventory[indexOfApplianceToUpdate].toString());
									}
									else if(changeDecision == 2) { //User decides to change the type of the appliance 

										boolean correctType = true;
										while(correctType){
											System.out.println("Please enter the new desired type of the appliance\n"
													+ "(Fridge, Air Conditioner, Washer, Dryer, Freezer, Stove, Dishwasher, Water Heaters or Microwave): ");

											String newType = keyIn.nextLine();

											 if(newType.equals("")) {
												 continue;
											 }
											 //THIS DOESN'T WORK WELL
											//Making sure the user enters a valid type of appliance 
											if(newType.equalsIgnoreCase("Fridge") || newType.equalsIgnoreCase("Air Conditioner") ||
													newType.equalsIgnoreCase("Washer") || newType.equalsIgnoreCase("Dryer") || 
													newType.equalsIgnoreCase("Freezer") || newType.equalsIgnoreCase("Stove") || 
													newType.equalsIgnoreCase("Dishwasher") || newType.equalsIgnoreCase("Water Heaters") ||
													newType.equalsIgnoreCase("Microwave")) {
												inventory[indexOfApplianceToUpdate].setType(newType);
												System.out.println("The type of the appliance has been updated to "+ newType+". Here is the description of that appliance:");
												System.out.println(inventory[indexOfApplianceToUpdate].toString());
												correctType = false;
											}
											else {

												System.out.println("Sorry! That is not a valid type of appliance.");
												correctType = true;
											}
										}
									} //User decides to change the brand of the appliance 
									else if(changeDecision == 1) {
										System.out.print("Please enter the new desired brand of the appliance: ");
										String newBrand = keyIn.next();
										inventory[indexOfApplianceToUpdate].setBrand(newBrand);
										System.out.println("The brand of the appliance has been updated to "+ newBrand+". Here is the description of that appliance:");
										System.out.println(inventory[indexOfApplianceToUpdate].toString());

									}
								}
							}

						}
						break;//this is to go back to the main menu. Should be placed at the END.
					}



				}
			}
			//When user enters choice 3 
			if (choice == 3) {
				System.out.println("Please enter the brand name of appliances you would like to display: ");
				String brand = keyIn.next();
				//Making sure appliances with the passed brand exists in the inventory 
				if(brandExists(inventory, brand)) {
					System.out.println("Here is the information of all appliances with brand "+brand);
					int[] indexOfBrand = findAppliancesBy(inventory, brand); //Finding all appliances with the passed brand name and storing them in an integer array 
					for(int i = 0; i<Appliance.findNumberOfCreatedAppliances(); i++) {
						System.out.println(inventory[indexOfBrand[i]].toString()); //Displaying all the corresponding appliances 
					}
				}
				else {
					System.out.println("There are no appliances with that brand name"); //Informing user appliances with the passed brand name dont exist 
				}

			}
			//When user enters choice 4 
			if (choice == 4) {
				System.out.println("Please enter an upper limit of price to display the appliances that fall within that price range:");
				double price = keyIn.nextDouble(); //Asking the user the price margin 

				if(priceExists(inventory, price)) { //Verifying if appliances lower than the margin price exists 
					System.out.println("Here is the information of all appliances that are cheaper than "+price);
					int[] indexOfPrice = findCheaperThan(inventory, price);  //Finding all appliances with prices lower than the margin price and storing them in an integer array 
					for(int i = 0; i<Appliance.findNumberOfCreatedAppliances(); i++) {
						System.out.println(inventory[indexOfPrice[i]].toString()); //Displaying all the corresponding appliances 
					}
				}
				else {
					System.out.println("There are no appliances that fall within that price range"); //Informing user appliances with the passed brand name dont exist 
				}
			}

			if (choice == 5) { //If the user decides to exit the program 
				System.out.println("Thank you for using the Appliance Tracker. Goodbye! :)"); //Displaying a closing message 
				System.exit(0);
			}

		}

	}
	/**
	 * This method will check if an appliance with the passed serial number exists in the array 
	 * @param a Appliance array 
	 * @param snToUpdate long value of serial number 
	 * @return boolean 
	 */
	public static boolean snInventory(Appliance[] a, long snToUpdate) {//to check if an appliance with that SN exists in the array
		boolean existsInInventory = false;
		for(int i=0;i<Appliance.findNumberOfCreatedAppliances();i++) { //Verifying if an appliance exists with the passed SN 
			if(a[i].getSN() == snToUpdate) {
				existsInInventory = true;
				break;  //The loop will break if the information is found 
			}
			else
				existsInInventory = false; //Method will return false if the desired appliance does not exist 
		}
		return existsInInventory;
	}
	/**
	 * This method will return the index position of the appliance in the array that has the passed serial number 
	 * @param a Appliance array 
	 * @param snToUpdate long value of serial number 
	 * @return integer value of the index position 
	 */
	public static int indexSNInventory(Appliance [] a, long snToUpdate) {//to return the index of the appliance with the corresponding SN
		int indexOfAppliance = 0;
		for(int i=0;i<Appliance.findNumberOfCreatedAppliances();i++) { //This loop will find the index position of the desired appliance with the passed SN 
			if(a[i].getSN() == snToUpdate) {
				indexOfAppliance = i;
			}
		}
		return indexOfAppliance; //Returning the index of the corresponding appliance 
	}
	/**
	 * This method will find the appliance in the array based on the passed brand 
	 * @param a Appliance array 
	 * @param brand String name of the brand 
	 * @return integer array containing the indexes of the appliance array corresponding to the passed brand 
	 */
	public static int[] findAppliancesBy(Appliance[] a,String brand) { 

		int sizeOfIndexArray = 0;
		for(int i = 0; i<Appliance.findNumberOfCreatedAppliances(); i++) { //This loop will find all the appliances with the desired brand name 
			if(a[i].getBrand().equals(brand)) {
				sizeOfIndexArray++;
			}
		}
		int[] indexOfCorrespondingAppliancesBrands = new int[sizeOfIndexArray]; //New array is created to store all the corresponding appliances 

		int i;
		int j;
		for(i = 0; i<sizeOfIndexArray; i++) { //This loop will store all the corresponding appliances in a new integer array 
			for(j = 0; j<Appliance.findNumberOfCreatedAppliances(); j++) {
				if(a[j].getBrand().equals(brand)) {
					break; //Loop breaks every time a desired appliance is found 
				}
			}
			indexOfCorrespondingAppliancesBrands[i]=j; //Storing the new indexes 
		}
		return indexOfCorrespondingAppliancesBrands;//This array contains the indexes of "inventory" which have the desired brand
	}
	/**
	 * This method will check if an appliance with the passed brand name exists in the array of appliances 
	 * @param a Appliance array 
	 * @param brand String brand name of the appliance 
	 * @return boolean 
	 */
	public static boolean brandExists(Appliance[] a,String brand) {
		boolean exists = true;
		for(int i = 0; i<Appliance.findNumberOfCreatedAppliances(); i++) { //This loop will verify if an appliance with the passed brand exists 
			if(a[i].getBrand().equals(brand)) {
				exists = true;
				break;
			}
			else {
				exists = false; //It will return false if there is no appliance with the passed brand name 
			}
		}
		return exists;
	}
	/**
	 * This method will find the all the appliances that are cheaper than the passed price 
	 * @param a Appliance array 
	 * @param price double value of the passed price 
	 * @return integer array containing the indexes of the appliance array that are lower than the passed price 
	 */
	public static int[] findCheaperThan(Appliance[] a, double price) {
		int sizeOfIndexArray = 0;
		for(int i = 0; i<Appliance.findNumberOfCreatedAppliances(); i++) { //This loop will find all the appliances with a price lower than passed price 
			if(a[i].getPrice() < price) {
				sizeOfIndexArray++; //Storing the number of corresponding appliances 
			}
		}
		int[] indexOfCorrespondingAppliancesPrices = new int[sizeOfIndexArray]; //Creating new array to store the corresponding appliances 
		int i, j;
		for(i = 0; i < sizeOfIndexArray; i++) {
			for(j = 0; j < Appliance.findNumberOfCreatedAppliances(); j++) {
				if(a[j].getPrice() < price) {
					break; //The loop breaks every time a desired appliance is found 
				}
			}
			indexOfCorrespondingAppliancesPrices[i] = j; //Storing the new indexes 
		}
		return indexOfCorrespondingAppliancesPrices;
	}
	/**
	 * This method will verify if an appliance with a price lower than the passed price exists or not 
	 * @param a Appliance array 
	 * @param price Double value of passed price 
	 * @return boolean 
	 */
	public static boolean priceExists(Appliance[] a, double price) {
		boolean exists = true;
		for(int i = 0; i<Appliance.findNumberOfCreatedAppliances(); i++) { //Verifying if an appliance with a price lower than passed price exists 
			if(a[i].getPrice() < price) {
				exists = true;
				break;
			}
			else {
				exists = false; //Returns false when no corresponding appliances are found 
			}
		}
		return exists;


	}

}
