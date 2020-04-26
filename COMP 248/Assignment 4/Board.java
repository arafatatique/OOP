// ------------------------------------------------
// Assignment 4
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: December 2 2019
// ------------------------------------------------
public class Board {
	
	private int board[][][]; //A 3D array called board 
	   private static int MIN_LEVEL = 3; //A static constant for minimum level  
	   private static int MIN_SIZE = 3; //A static constant for minimum size 
	   private int level; //integer variable for levels of the board 
	   private int size; //integer variable for the dimensions of the board 
	  
	   //A default constructor 
	   public Board()
	   {
	       level = 3; //Set level to 3 
	       size = 4; //Set size to 4
	       createBoard(level,size); //Calls createBoard with level and size as arguments 
	   }
	  
	   //A constructor overload with parameters 
	   public Board(int l, int x)
	   {
	       level = l;
	       size = x;
	       createBoard(l,x);
	   }
	  
	   //A private method to create board with passed arguments 
	   private void createBoard(int level, int size)
	   {
	       board = new int[level][][];
	       for(int l=0;l<level;l++)
	       {
	           board[l] = new int[size][];
	           for(int x=0;x<size;x++ )
	           {
	               board[l][x] = new int[size];
	              
	               for(int y=0;y<size;y++)
	               {
	            	 //Initializing the board according to the conditions presented
	            	   if((l+x+y) == 0)
	                       board[l][x][y] = 0;
	            	   else if((l+x+y)%3 == 0)
	                       board[l][x][y] = -3;
	                   else if((l+x+y)%5 == 0)
	                       board[l][x][y] = -2;
	                   else if((l+x+y)%7 == 0)
	                       board[l][x][y] = 2;
	                   else
	                       board[l][x][y] = 0;
	               }
	           }
	       }
	   }
	  
	   //Returns the level of the board
	   public int getLevel()
	   {
	       return level;
	   }
	  
	   //Returns the size of the board 
	   public int getSize()
	   {
	       return size;
	   }
	  
	   //Method to return the energy adjustment value for given level, x and y values 
	   public int getEnergyAdj(int l, int x, int y)
	   {
	       //if-statement to make sure the entry is valid 
	       if(l >=0 && l < level && x >=0 && x < size && y >=0 && y < size)
	           return board[l][x][y]; //When the entry is valid, it will return the value stored in board[l][x][y]
	      
	       return -1 ; // When the entry is invalid 
	   }
	  
	   //Method to return the string description of the board 
	   public String toString()
	   {
	       String str = "";
	       for(int l=0;l<level;l++)
	       {
	           str += "Level "+(l)+":\n--------\n";
	           for(int x=0;x<size;x++)
	           {	
	               for(int y=0;y<size;y++)
	               {
	                   str+= String.format("%2d",board[l][x][y])+" ";
	               }
	               str += "\n";
	           }
	           str += "\n";
	       }
	          
	       return str;
	   }

}

