// ------------------------------------------------
// Assignment 4
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: December 2 2019
// ------------------------------------------------

//The purpose of this program is to create a warrior game that consists of 2 players 
import java.util.Random;
import java.util.Scanner;
public class WarriorGameMain {

	public static void main(String[] args)
	{	String namePlayer0,namePlayer1;//String variables for player names
		int userChoice=0,userLevel=3,userSize=4; //Defining variables to store the user choice, level and size
		//DIsplays a welcome banner 
		System.out.println("\t\t\t\t\t\t\t* * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("\t\t\t\t\t\t\t- - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println("\t\t\t\t\t\t\t*                                           *");
		System.out.println("\t\t\t\t\t\t\t*    WELCOME to Nancy's 3D Warrior Game!    *");
		System.out.println("\t\t\t\t\t\t\t*                                           *");
		System.out.println("\t\t\t\t\t\t\t* * * * * * * * * * * * * * * * * * * * * * *");
		System.out.println("\t\t\t\t\t\t\t- - - - - - - - - - - - - - - - - - - - - - -");
		System.out.println();
		
		//Informing the user about the default game setup 
		System.out.println("The default game board has 3 levels and each level has a 4x4 board.");
		System.out.println("You can use this default board size or change the size");
		System.out.println("\t 0 to use the default board size");
		System.out.println("\t -1 to enter your own size");
		
		System.out.print("==> What do you want to do? ");
		//Creating a scanner 
		Scanner keyIn = new Scanner(System.in);
		userChoice = keyIn.nextInt(); //Will save the user input for choice
		//Ensuring the user has entered a valid input for choice 
		while(true)
		{if (userChoice!=0 && userChoice!=-1)
			{System.out.println("Sorry but "+userChoice+" is not a legal choice.");
			userChoice = keyIn.nextInt();}
			
		else if (userChoice==0 || userChoice==-1)
				break;
		}
		if (userChoice==0 )
			{Board board = new Board();} //Will create default board if user wishes 
		if (userChoice==-1)
			{//Asking the user to enter a level 
			System.out.print("How many levels would you like? (minimum size 3, max 10) ");
			userLevel =keyIn.nextInt();
			while(true) //Ensuring the user has entered a valid input for level 
				{if (userLevel<3 || userLevel>10)
				{System.out.println("Sorry but "+userLevel+" is not a legal choice.");
				userLevel = keyIn.nextInt();}
				else 
					break;
				}
			System.out.println();
			System.out.println("What size do you want the nxn boards on each level to be?"); //Asking the user to enter a size
			System.out.println("Minimum size is 3x3, max is 10x10."); //Informing the user about the restrictions 
			System.out.print("==> Enter the value of n: ");
			userSize = keyIn.nextInt();
			//Ensuring the user has entered a valid input for size
			while(true)
				{if (userSize<3 || userSize>10)
				{System.out.println("Sorry but "+userSize+" is not a legal choice.");
				userSize = keyIn.nextInt();}
				else 
					break;
				}
			}
		Board board = new Board(userLevel,userSize); //Creating a board object based on user decisions
		System.out.println();
		System.out.println("Your 3D board has been set up and looks like this:"); 
		System.out.println();
		System.out.println(board); //Displaying the 3D board
		
		//Asking the user to enter player names 
		System.out.print("What is player 0's name? (one word only) : ");
		namePlayer0=keyIn.next();
		System.out.print("What is player 1's name? (one word only) : ");
		namePlayer1=keyIn.next();
		
		//Creating player objects and passing the user input names
		Player[] player = new Player[2];
		player[0] = new Player(namePlayer0);
		player[1] = new Player(namePlayer1);
		System.out.println();
		//Creating dice object
		Dice dice = new Dice();
	
		//Deciding which player goes first
		int firstPlayer, secondPlayer = 0;
		Random k= new Random();
		firstPlayer=k.nextInt(1); //Will generate randomly which player goes first
		if (firstPlayer==0)
			{secondPlayer = 1;
			System.out.println("The game has started "+namePlayer0+" goes first");
			}
		else if (firstPlayer==1)
			{secondPlayer = 0;
			System.out.println("The game has started "+namePlayer1+" goes first");
			}
		System.out.println("====================================================");
		System.out.println();
		
		System.out.println();
		
		while (!(player[0].won(board)) && !(player[1].won(board)) )
			{//Checking if player whose turn it is has <= 0 energy
				if (player[firstPlayer].getEnergy() <= 0)
					//Player will toss 3 times
					{	dice.rollDice();
						if (dice.isDouble())
							{player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()+2);} //Increases player energy by 2 if they roll a double
						dice.rollDice();
						if (dice.isDouble())
							{player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()+2);} //Increases player energy by 2 if they roll a double
						dice.rollDice();
						if (dice.isDouble())
							{player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()+2);} //Increases player energy by 2 if they roll a double
					}
			
	
			 //Turn 1
			 int turn1 = dice.rollDice();
			 System.out.println("It is "+player[firstPlayer].getName()+"'s turn");
			 System.out.println("\t"+player[firstPlayer].getName()+" you rolled "+dice.toString());
			 //Checking if player rolled a double
			 if (dice.isDouble())
			 	{System.out.println("\tCongratulations you rolled double "+dice.getDie1()+". Your energy went up by 2 units");
			 	 player[firstPlayer].setEnergy(player[firstPlayer].getEnergy() + 2);
			 	}
			 
			 //Finding coordinates for the location 
			 int addX = turn1 / board.getSize();
			 int addY = turn1 % board.getSize();
			 
			 //When the coordinate is not out of bounds and is on the same board
			 if ((player[firstPlayer].getX() + addX) < board.getSize() && (player[firstPlayer].getY() + addY) < board.getSize())
			 	{player[firstPlayer].setX(player[firstPlayer].getX() + addX);
			 	 player[firstPlayer].setY(player[firstPlayer].getY() + addY);
			 	 
			 	 //If the potential location is occupied by another player 
			 	 if (player[firstPlayer].equals(player[secondPlayer]))
			 	 	{
			 		 	System.out.println("Player "+player[secondPlayer].getName()+" is at your new location");
			 		 	System.out.println("What do you want to do?");
			 		 	System.out.println("\t0 - Challenge and risk losing 50% of your energy units if you lose or move to new location and get 50% of other player's energy units");
			 		 	System.out.println("\t1 - to move down one level or move to (0,0) if at level 0 and lose 2 energy");
			 		 	int conflictChoice = keyIn.nextInt();
			 		 	
			 		 	//Verify input is valid 
			 		 	while(true)
						{if (conflictChoice!=0 && userSize!=1)
						{System.out.println("Sorry but "+conflictChoice+" is not a legal choice.");
						userSize = keyIn.nextInt();}
						else 
							break;
						}
			 		 	
			 		 	//If the input is a challenge 
			 		 	if (conflictChoice == 0)
			 		 		{
			 		 			int result = k.nextInt(10);
			 		 			
			 		 			//If challenge is lost 
			 		 			if (result<6)
			 		 				{System.out.println("Sorry!! You lost the challenge. You lose 50% of you energy units.");
			 		 				player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()-((player[firstPlayer].getEnergy())/2));
			 		 				}
			 		 			//If challenge is won
			 		 			else 
			 		 			{
			 		 				System.out.println("Bravo!! You won the challenge.");
			 		 				player[firstPlayer].moveTo(player[secondPlayer]);
			 		 				player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()+((player[secondPlayer].getEnergy())/2));
			 		 				player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()-((player[secondPlayer].getEnergy())/2));
			 		 			}
			
			 		 		}
			 		 	if (conflictChoice ==1)
			 		 	{	
			 		 		//If the player is at level>0
			 		 		if (player[firstPlayer].getLevel()>0)
			 		 			{	
			 		 				player[firstPlayer].setX(player[firstPlayer].getX() + addX);
			 		 				player[firstPlayer].setY(player[firstPlayer].getY() + addY);
			 		 				player[firstPlayer].setLevel(player[firstPlayer].getLevel()-1);
			 		 			}
						 	//If player is already at level 0
			 		 		else if (player[firstPlayer].getLevel()==0)
			 		 			{
			 		 				player[firstPlayer].setX(0);
			 		 				player[firstPlayer].setY(0);
			 		 		
						 		}
			 		 		
			 		 	}
			 		 
			 	 	}
			 	 player[firstPlayer].setEnergy(player[firstPlayer].getEnergy() + board.getEnergyAdj(player[firstPlayer].getLevel(), player[firstPlayer].getX(), player[firstPlayer].getY()));
			 	 System.out.println("\t Your energy is adjusted by " + board.getEnergyAdj(player[firstPlayer].getLevel(), player[firstPlayer].getX(), player[firstPlayer].getY())+ " for landing at ("+player[firstPlayer].getX()+", "+player[firstPlayer].getY()+") at level "+player[firstPlayer].getLevel());
			 	}
			 
			 //If x coordinate is out of bounds
			 else if((player[firstPlayer].getX() + addX) >= board.getSize() && (player[firstPlayer].getY() + addY) < board.getSize())
			 	{player[firstPlayer].setLevel(player[firstPlayer].getLevel()+1);
			 	 int newX = (player[firstPlayer].getX() + addX) % board.getSize();
			 	 player[firstPlayer].setX(newX);
			 	 player[firstPlayer].setY(player[firstPlayer].getY() + addY);
			 	 
			 	 //If the potential location is occupied by another player 
			 	 if (player[firstPlayer].equals(player[secondPlayer]))
			 	 	{
			 		 	System.out.println("Player "+player[secondPlayer].getName()+" is at your new location");
			 		 	System.out.println("What do you want to do?");
			 		 	System.out.println("\t0 - Challenge and risk losing 50% of your energy units if you lose or move to new location and get 50% of other player's energy units");
			 		 	System.out.println("\t1 - to move down one level or move to (0,0) if at level 0 and lose 2 energy");
			 		 	int conflictChoice = keyIn.nextInt();
			 		 	
			 		 	//Verify input is valid 
			 		 	while(true)
						{if (conflictChoice!=0 && userSize!=1)
						{System.out.println("Sorry but "+conflictChoice+" is not a legal choice.");
						userSize = keyIn.nextInt();}
						else 
							break;
						}
			 		 	
			 		 	//If the input is a challenge 
			 		 	if (conflictChoice == 0)
			 		 		{
			 		 			int result = k.nextInt(10);
			 		 			
			 		 			//If challenge is lost 
			 		 			if (result<6)
			 		 				{System.out.println("Sorry!! You lost the challenge. You lose 50% of you energy units.");
			 		 				player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()-((player[firstPlayer].getEnergy())/2));
			 		 				}
			 		 			//If challenge is won
			 		 			else 
			 		 			{
			 		 				System.out.println("Bravo!! You won the challenge.");
			 		 				player[firstPlayer].moveTo(player[secondPlayer]);
			 		 				player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()+((player[secondPlayer].getEnergy())/2));
			 		 				player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()-((player[secondPlayer].getEnergy())/2));
			 		 			}
			
			 		 		}
			 		 	if (conflictChoice ==1)
			 		 	{	
			 		 		//If the player is not at level>0
			 		 		if (player[firstPlayer].getLevel()>0)
			 		 			{	
			 		 				player[firstPlayer].setX(newX);
			 		 				player[firstPlayer].setY(player[firstPlayer].getY() + addY);
			 		 				player[firstPlayer].setLevel(player[firstPlayer].getLevel()-1);
			 		 			}
						 	//If player is already at level 0
			 		 		else if (player[firstPlayer].getLevel()==0)
			 		 			{
			 		 				player[firstPlayer].setX(0);
			 		 				player[firstPlayer].setY(0);
			 		 		
						 		}
			 		 		
			 		 	}
			 		 
			 	 	}
			 	 
			 	 player[firstPlayer].setEnergy(player[firstPlayer].getEnergy() + board.getEnergyAdj(player[firstPlayer].getLevel(), player[firstPlayer].getX(), player[firstPlayer].getY()));
			 	 System.out.println("\t Your energy is adjusted by " + board.getEnergyAdj(player[firstPlayer].getLevel(), player[firstPlayer].getX(), player[firstPlayer].getY())+ " for landing at ("+player[firstPlayer].getX()+", "+player[firstPlayer].getY()+") at level "+player[firstPlayer].getLevel());
			 	}
			 
			 //If x and y coordinates are out of bounds 
			 else if ((player[firstPlayer].getX() + addX) >= board.getSize() && (player[firstPlayer].getY() + addY) >= board.getSize())
			 	{
				 	if (player[firstPlayer].getLevel()+1 >= board.getLevel())
				 		{System.out.println("\t!!! Sorry you need to stay where you are - that throw takes you off the grid and you lose 2 units of energy");
				 		 player[firstPlayer].setEnergy(player[firstPlayer].getEnergy() - 2);
				 		}
				 	
				 	else { 
				 			int newY = (player[firstPlayer].getY() + addY) % board.getSize();
				 			int badX = (player[firstPlayer].getX() + addX) + ((player[firstPlayer].getY() + addY) / board.getSize());
				 			int newX = badX % board.getSize();
				 			player[firstPlayer].setLevel(player[firstPlayer].getLevel() + 1);
				 			player[firstPlayer].setX(newX);
				 			player[firstPlayer].setY(newY);
				 		 	 
				 			//If the potential location is occupied by another player 
						 	 if (player[firstPlayer].equals(player[secondPlayer]))
						 	 	{
						 		 	System.out.println("Player "+player[secondPlayer].getName()+" is at your new location");
						 		 	System.out.println("What do you want to do?");
						 		 	System.out.println("\t0 - Challenge and risk losing 50% of your energy units if you lose or move to new location and get 50% of other player's energy units");
						 		 	System.out.println("\t1 - to move down one level or move to (0,0) if at level 0 and lose 2 energy");
						 		 	int conflictChoice = keyIn.nextInt();
						 		 	
						 		 	//Verify input is valid 
						 		 	while(true)
									{if (conflictChoice!=0 && userSize!=1)
									{System.out.println("Sorry but "+conflictChoice+" is not a legal choice.");
									userSize = keyIn.nextInt();}
									else 
										break;
									}
						 		 	
						 		 	//If the input is a challenge 
						 		 	if (conflictChoice == 0)
						 		 		{
						 		 			int result = k.nextInt(10);
						 		 			
						 		 			//If challenge is lost 
						 		 			if (result<6)
						 		 				{System.out.println("Sorry!! You lost the challenge. You lose 50% of you energy units.");
						 		 				player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()-((player[firstPlayer].getEnergy())/2));
						 		 				}
						 		 			//If challenge is won
						 		 			else 
						 		 			{
						 		 				System.out.println("Bravo!! You won the challenge.");
						 		 				player[firstPlayer].moveTo(player[secondPlayer]);
						 		 				player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()+((player[secondPlayer].getEnergy())/2));
						 		 				player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()-((player[secondPlayer].getEnergy())/2));
						 		 			}
						
						 		 		}
						 		 	if (conflictChoice ==1)
						 		 	{	
						 		 		
						 		 		if (player[firstPlayer].getLevel()>=1)
						 		 			{	
						 		 				player[firstPlayer].setX(newX);
						 		 				player[firstPlayer].setY(newY);
						 		 				player[firstPlayer].setLevel(player[firstPlayer].getLevel()-1);
						 		 			}
									 	//If player is already at level 0
						 		 		else if (player[firstPlayer].getLevel()==0)
						 		 			{
						 		 				player[firstPlayer].setX(0);
						 		 				player[firstPlayer].setY(0);
						 		 		
									 		}
						 		 		
						 		 	}
						 		 
						 	 	}

				 			player[firstPlayer].setEnergy(player[firstPlayer].getEnergy() + board.getEnergyAdj(player[firstPlayer].getLevel(), player[firstPlayer].getX(), player[firstPlayer].getY()));
				 			System.out.println("\t Your energy is adjusted by " + board.getEnergyAdj(player[firstPlayer].getLevel(), player[firstPlayer].getX(), player[firstPlayer].getY())+ " for landing at ("+player[firstPlayer].getX()+", "+player[firstPlayer].getY()+") at level "+player[firstPlayer].getLevel());
				 		} 
				 
			 	}
			 //Turn 2
			//Checking if player whose turn it is has <= 0 energy
				if (player[secondPlayer].getEnergy() <= 0)
					//Player will toss 3 times
					{dice.rollDice();
					 if (dice.isDouble())
					 	{player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()+2);} //Increases player energy by 2 if they roll a double
					 dice.rollDice();
					 if (dice.isDouble())
					 	{player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()+2);} //Increases player energy by 2 if they roll a double
					 dice.rollDice();
					 if (dice.isDouble())
					 	{player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()+2);} //Increases player energy by 2 if they roll a double
					}
				 
			 int turn2 = dice.rollDice();
			 System.out.println("It is "+player[secondPlayer].getName()+"'s turn");
			 System.out.println("\t"+player[secondPlayer].getName()+" you rolled "+dice.toString());
			 //Checking if player rolled a double
			 if (dice.isDouble())
			 	{System.out.println("\tCongratulations you rolled double "+dice.getDie1()+". Your energy went up by 2 units");
			 	 player[secondPlayer].setEnergy(player[secondPlayer].getEnergy() + 2);
			 	}
			 //Finding coordinates for the location 
			 int addXForP2= turn2 / board.getSize();
			 int addYForP2 = turn2 % board.getSize();
			 
			//When the coordinate is not out of bounds and is on the same board
			 if ((player[secondPlayer].getX() + addXForP2) < board.getSize() && (player[secondPlayer].getY() + addYForP2) < board.getSize())
			 	{player[secondPlayer].setX(player[secondPlayer].getX() + addXForP2);
			 	 player[secondPlayer].setY(player[secondPlayer].getY() + addYForP2);
			 	 
			 	 //If the potential location is occupied by another player 
			 	 if (player[secondPlayer].equals(player[firstPlayer]))
			 	 	{
			 		 	System.out.println("Player "+player[firstPlayer].getName()+" is at your new location");
			 		 	System.out.println("What do you want to do?");
			 		 	System.out.println("\t0 - Challenge and risk losing 50% of your energy units if you lose or move to new location and get 50% of other player's energy units");
			 		 	System.out.println("\t1 - to move down one level or move to (0,0) if at level 0 and lose 2 energy");
			 		 	int conflictChoice = keyIn.nextInt();
			 		 	
			 		 	//Verify input is valid 
			 		 	while(true)
						{if (conflictChoice!=0 && userSize!=1)
						{System.out.println("Sorry but "+conflictChoice+" is not a legal choice.");
						userSize = keyIn.nextInt();}
						else 
							break;
						}
			 		 	
			 		 	//If the input is a challenge 
			 		 	if (conflictChoice == 0)
			 		 		{
			 		 			int result = k.nextInt(10);
			 		 			
			 		 			//If challenge is lost 
			 		 			if (result<6)
			 		 				{System.out.println("Sorry!! You lost the challenge. You lose 50% of you energy units.");
			 		 				player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()-((player[secondPlayer].getEnergy())/2));
			 		 				}
			 		 			//If challenge is won
			 		 			else 
			 		 			{
			 		 				System.out.println("Bravo!! You won the challenge.");
			 		 				player[secondPlayer].moveTo(player[firstPlayer]);
			 		 				player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()+((player[firstPlayer].getEnergy())/2));
			 		 				player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()-((player[firstPlayer].getEnergy())/2));
			 		 			}
			
			 		 		}
			 		 	if (conflictChoice ==1)
			 		 	{	
			 		 		
			 		 		if (player[secondPlayer].getLevel()>=1)
			 		 			{	
			 		 				player[secondPlayer].setX(player[secondPlayer].getX() + addXForP2);
			 		 				player[secondPlayer].setY(player[secondPlayer].getY() + addYForP2);
			 		 				player[secondPlayer].setLevel(player[secondPlayer].getLevel()-1);
			 		 			}
						 	//If player is already at level 0
			 		 		else if (player[secondPlayer].getLevel()==0)
			 		 			{
			 		 				player[secondPlayer].setX(0);
			 		 				player[secondPlayer].setY(0);
			 		 		
						 		}
			 		 		
			 		 	}
			 		 
			 	 	}
			 	 
			 	 
			 	 player[secondPlayer].setEnergy(player[secondPlayer].getEnergy() + board.getEnergyAdj(player[secondPlayer].getLevel(), player[secondPlayer].getX(), player[secondPlayer].getY()));
			 	 System.out.println("\t Your energy is adjusted by " + board.getEnergyAdj(player[secondPlayer].getLevel(), player[secondPlayer].getX(), player[secondPlayer].getY())+ " for landing at ("+player[secondPlayer].getX()+", "+player[secondPlayer].getY()+") at level "+player[secondPlayer].getLevel());
			 	}
			 
			//If x coordinate is out of bounds
			 else if((player[secondPlayer].getX() + addXForP2) >= board.getSize() && (player[secondPlayer].getY() + addYForP2) < board.getSize())
			 	{player[secondPlayer].setLevel(player[secondPlayer].getLevel()+1);
			 	 int newXForP2 = (player[secondPlayer].getX() + addXForP2) % board.getSize();
			 	 player[secondPlayer].setX(newXForP2);
			 	 player[secondPlayer].setY(player[secondPlayer].getY() + addYForP2);
			 	 
			 	 //If the potential location is occupied by another player 
			 	 if (player[secondPlayer].equals(player[firstPlayer]))
			 	 	{
			 		 	System.out.println("Player "+player[firstPlayer].getName()+" is at your new location");
			 		 	System.out.println("What do you want to do?");
			 		 	System.out.println("\t0 - Challenge and risk losing 50% of your energy units if you lose or move to new location and get 50% of other player's energy units");
			 		 	System.out.println("\t1 - to move down one level or move to (0,0) if at level 0 and lose 2 energy");
			 		 	int conflictChoice = keyIn.nextInt();
			 		 	
			 		 	//Verify input is valid 
			 		 	while(true)
						{if (conflictChoice!=0 && userSize!=1)
						{System.out.println("Sorry but "+conflictChoice+" is not a legal choice.");
						userSize = keyIn.nextInt();}
						else 
							break;
						}
			 		 	
			 		 	//If the input is a challenge 
			 		 	if (conflictChoice == 0)
			 		 		{
			 		 			int result = k.nextInt(10);
			 		 			
			 		 			//If challenge is lost 
			 		 			if (result<6)
			 		 				{System.out.println("Sorry!! You lost the challenge. You lose 50% of you energy units.");
			 		 				player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()-((player[secondPlayer].getEnergy())/2));
			 		 				}
			 		 			//If challenge is won
			 		 			else 
			 		 			{
			 		 				System.out.println("Bravo!! You won the challenge.");
			 		 				player[secondPlayer].moveTo(player[firstPlayer]);
			 		 				player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()+((player[firstPlayer].getEnergy())/2));
			 		 				player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()-((player[firstPlayer].getEnergy())/2));
			 		 			}
			
			 		 		}
			 		 	if (conflictChoice ==1)
			 		 	{	
			 		 		
			 		 		if (player[secondPlayer].getLevel()>=1)
			 		 			{	
			 		 				player[secondPlayer].setX(newXForP2);
			 		 				player[secondPlayer].setY(player[secondPlayer].getY() + addYForP2);
			 		 				player[secondPlayer].setLevel(player[secondPlayer].getLevel()-1);
			 		 			}
						 	//If player is already at level 0
			 		 		else if (player[secondPlayer].getLevel()==0)
			 		 			{
			 		 				player[secondPlayer].setX(0);
			 		 				player[secondPlayer].setY(0);
			 		 		
						 		}
			 		 		
			 		 	}
			 		 
			 	 	}

			 	 
			 	 player[secondPlayer].setEnergy(player[secondPlayer].getEnergy() + board.getEnergyAdj(player[secondPlayer].getLevel(), player[secondPlayer].getX(), player[secondPlayer].getY()));
			 	 System.out.println("\t Your energy is adjusted by " + board.getEnergyAdj(player[secondPlayer].getLevel(), player[secondPlayer].getX(), player[secondPlayer].getY())+ " for landing at ("+player[secondPlayer].getX()+", "+player[secondPlayer].getY()+") at level "+player[secondPlayer].getLevel());
			 	}
			 //If x and y coordinates are out of bounds 
			 else if ((player[secondPlayer].getX() + addXForP2) >= board.getSize() && (player[secondPlayer].getY() + addYForP2) >= board.getSize())
			 	{
				 	if (player[secondPlayer].getLevel()+1 >= board.getLevel())
				 		{System.out.println("\t!!! Sorry you need to stay where you are - that throw takes you off the grid and you lose 2 units of energy");
				 		 player[secondPlayer].setEnergy(player[secondPlayer].getEnergy() - 2);
				 		}
				 	
				 	else { 
				 			int newYForP2 = (player[secondPlayer].getY() + addYForP2) % board.getSize();
				 			int badXForP2 = (player[secondPlayer].getX() + addXForP2) + ((player[secondPlayer].getY() + addYForP2) / board.getSize());
				 			int newXForP2 = badXForP2 % board.getSize();
				 			player[secondPlayer].setLevel(player[secondPlayer].getLevel() + 1);
				 			player[secondPlayer].setX(newXForP2);
				 			player[secondPlayer].setY(newYForP2);
				 			 
				 			//If the potential location is occupied by another player 
						 	 if (player[secondPlayer].equals(player[firstPlayer]))
						 	 	{
						 		 	System.out.println("Player "+player[firstPlayer].getName()+" is at your new location");
						 		 	System.out.println("What do you want to do?");
						 		 	System.out.println("\t0 - Challenge and risk losing 50% of your energy units if you lose or move to new location and get 50% of other player's energy units");
						 		 	System.out.println("\t1 - to move down one level or move to (0,0) if at level 0 and lose 2 energy");
						 		 	int conflictChoice = keyIn.nextInt();
						 		 	
						 		 	//Verify input is valid 
						 		 	while(true)
									{if (conflictChoice!=0 && userSize!=1)
									{System.out.println("Sorry but "+conflictChoice+" is not a legal choice.");
									userSize = keyIn.nextInt();}
									else 
										break;
									}
						 		 	
						 		 	//If the input is a challenge 
						 		 	if (conflictChoice == 0)
						 		 		{
						 		 			int result = k.nextInt(10);
						 		 			
						 		 			//If challenge is lost 
						 		 			if (result<6)
						 		 				{System.out.println("Sorry!! You lost the challenge. You lose 50% of you energy units.");
						 		 				player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()-((player[secondPlayer].getEnergy())/2));
						 		 				}
						 		 			//If challenge is won
						 		 			else 
						 		 			{
						 		 				System.out.println("Bravo!! You won the challenge.");
						 		 				player[secondPlayer].moveTo(player[firstPlayer]);
						 		 				player[secondPlayer].setEnergy(player[secondPlayer].getEnergy()+((player[firstPlayer].getEnergy())/2));
						 		 				player[firstPlayer].setEnergy(player[firstPlayer].getEnergy()-((player[firstPlayer].getEnergy())/2));
						 		 			}
						
						 		 		}
						 		 	if (conflictChoice ==1)
						 		 	{	
						 		 		//If the player is at level>0
						 		 		if (player[secondPlayer].getLevel()>=1)
						 		 			{	
						 		 				player[secondPlayer].setX(newXForP2);
						 		 				player[secondPlayer].setY(newYForP2);
						 		 				player[secondPlayer].setLevel(player[secondPlayer].getLevel()-1);
						 		 			}
									 	//If player is already at level 0
						 		 		else if (player[secondPlayer].getLevel()==0)
						 		 			{
						 		 				player[secondPlayer].setX(0);
						 		 				player[secondPlayer].setY(0);
						 		 		
									 		}
						 		 		
						 		 	}
						 		 
						 	 	}
		 			
				 			player[secondPlayer].setEnergy(player[secondPlayer].getEnergy() + board.getEnergyAdj(player[secondPlayer].getLevel(), player[secondPlayer].getX(), player[secondPlayer].getY()));
				 			System.out.println("\t Your energy is adjusted by " + board.getEnergyAdj(player[secondPlayer].getLevel(), player[secondPlayer].getX(), player[secondPlayer].getY())+ " for landing at ("+player[secondPlayer].getX()+", "+player[secondPlayer].getY()+") at level "+player[secondPlayer].getLevel());
				 		}
			 	}
			 
			 //Round summary 
			 System.out.println();
			 System.out.println("At the end of this round:");
			 System.out.println("\t"+player[firstPlayer].toString());
			 System.out.println("\t"+player[secondPlayer].toString());
			 
			 //Setting up user choice for continuing the round
			 String trigger = "";
			 System.out.println("Any key to continue to next round ...g");
			 trigger = keyIn.next();
			 if (trigger.length()>0)
				continue;
			 if (player[firstPlayer].won(board) || player[secondPlayer].won(board)) //The loop will break and declare the winner once a player has won
				 break;
			
			} //End of while loop
		
		//Display the winner
		System.out.println();
		if (player[firstPlayer].won(board))
			System.out.println("The winner is "+player[firstPlayer].getName()+". Well done!!!");
		else if (player[secondPlayer].won(board))
			System.out.println("The winner is "+player[secondPlayer].getName()+". Well done!!!");
		
	}//End of main method

}
