// ------------------------------------------------
// Assignment 4
// Written by: Arafat Atique 40132573
// For COMP 248 Section P - Fall 2019
// Due: December 2 2019
// ------------------------------------------------
public class Player {
	
	//Defining attributes of the player 
	private String name;
	private int level;
	private int x;
	private int y;
	private int energy;
	
	//A default constructor assigning values as indicated in the instructions 
	public Player()
	{
		name = "";
		energy = 10;
		level =0;
		x=0;
		y=0;
	}
	
	//A constructor to assign a name as passed 
	public Player(String name)
	{
		this.name=name;
		energy=10;
		level =0;
		x=0;
		y=0;
	}
	//A constructor overload assigning values as passed through the arguments 
	public Player(int level, int x, int y)
	{
		name= "";
		this.level=level;
		this.x=x;
		this.y=y;
		energy=10;
	}
	//A copy constructor to duplicate the passed player object 
	public Player(Player player)
	{
		this.name=player.name;
		this.x=player.x;
		this.y=player.y;
		this.energy=player.energy;
	}
	//Mutator and accessor methods for all attributes
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public int getLevel()
	{
		return level;
	}
	public void setLevel(int level)
	{
		this.level=level;
	}
	public int getX()
	{
		return x;
	}
	public void setX(int x)
	{
		this.x=x;
	}
	public int getY()
	{
		return y;
	}
	public void setY(int y)
	{
		this.y=y;
	}
	public int getEnergy()
	{
		return energy;
	}
	public void setEnergy(int energy)
	{
		this.energy=energy;
	}
	//Method to move the calling Player object to the passed Player's object location 
	public void moveTo(Player p)
	{
		this.x=p.x;
		this.y=p.y;
		
	}
	//A boolean method which return true if the calling object is at the last location of the board and false otherwise
	public boolean won(Board b) 
	{
		return (b.getSize()-1 == x && b.getSize()-1 == y && b.getLevel()-1 == level);
	}
	//A boolean method which returns true if the location of the calling object is the same as the location of the passed object
	public boolean equals(Player p)
	{
		return this.level == p.getLevel() && this.x == p.getX() && this.y == p.getY();
	}
	//A method which returns a String containing the values of all attributes of the calling Player object in a descriptive message
	public String toString()
	{
		return getName()+" is on level "+getLevel()+" at location (" + getX() +","+ getY() + ") and has "+getEnergy()+" units of energy.";
	}
	
	
	
	
	
	
	
}
