// ----------------------------------------------------------
// Assignment #2
// Question: Part I and later modified to satisfy the conditions of Part II.
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// ----------------------------------------------------------
// The driver class to test the toString, equals methods, and to search an array for the flying objects

/**
 * The Helicopter class is the father class of Multirotor and Quadcopter classes; Helicopter objects can also be created for implementation
 * 
 * @author Arafat Atique
 * @author Auvigoo Ahmed
 * 
 * @version 4.12.0
 * 
 * @see FlyingObjects
 * @see Airplane
 * @see MAV
 * @see AgriculturalDrone
 * @see UAV
 * @see Quadcopter
 * @see Multirotor
 * @see Helicopter
 */

package driver; //This driver file has its own package 
//Importing all necessary packages 
import airplane.Airplane;
import flying_objects.FlyingObjects;
import helicopter_quadcopter.Helicopter;
import helicopter_quadcopter.Quadcopter;
import multirotor.Multirotor;
import uav.UAV;
import agricultural_mav.AgriculturalDrone;
import agricultural_mav.MAV;


public class Driver {

	/**
	 * This method will copy of the passed flying object array; Misbehavior is expected as polymorphism is not triggered 
	 * @param flyingObjects FlyingObjects array 
	 * @return array FlyingObjects array
	 */
	// This is a method written for Part II of the assignment. This was added after Part I was written.
	public static FlyingObjects[] copyFlyingObjects(FlyingObjects[] flyingObjects) {
	       
		FlyingObjects[] flyingObjectCopy = new FlyingObjects[flyingObjects.length]; //New array will be the same size as passed array

	    for (int i = 0; i < flyingObjects.length; i++) 
	    	{
			// The method takes only flying objects so only the FlyingObjects copy constructor is used.
			// Polymorphism is no longer active since we are looking only at flying objects and as such, Java will not use the correct copy constructor for the different classes.
			// The program will only return flying objects, not Airplane, UAV, etc.
			// So with this implementation, the program will misbehave. The copying is NOT correct.
			// Correct way to do it would be with the clone methods.
		
	    		flyingObjectCopy[i] = new FlyingObjects(flyingObjects[i]);
	        }

	        return flyingObjectCopy;
	    }
		

	public static void main(String[] args) {
		
		//Creating objects from classes 
		System.out.println("*****TESTING THE AIRPLANE CLASS*****");
		//Airplane objects being created using different types of constructors 
		Airplane a1 = new Airplane(); //Default constructor
		Airplane a2 = new Airplane("Boeing", 1000000, 9999); //Parametrized constructor 
		Airplane a3 = new Airplane("Air Canada", 987654, 1234);
		
		//testing toString() for Airplane
		System.out.println(a1+"\n");
		System.out.println(a2+"\n");
		System.out.println(a3+"\n");
		
		System.out.println("*****TESTING THE HELICOPTER CLASS*****");
		//Helicopter objects being created using different types of constructors 
		Helicopter h1 = new Helicopter();//Default constructor 
		Helicopter h2 = new Helicopter("US Navy", 123456.99, 98723, 5, 1995, 6); //Parametrized constructors
		Helicopter h3 = new Helicopter("Marine", 98000.05, 43256,4,2002,5);
		
		//testing toString() for Helicopter
		System.out.println(h1+"\n");
		System.out.println(h2+"\n");
		System.out.println(h3+"\n");
		
		System.out.println("*****TESTING THE QUADCOPTER CLASS*****");
		//Quadcopter objects being created using different types of constructors
		Quadcopter q1 = new Quadcopter(); //Default constructor 
		Quadcopter q2 = new Quadcopter("Bombardier", 43241.54,1232,6,1981,7,100); //Parametrized constructor
		Quadcopter q3 = new Quadcopter("Amazon", 65478.32,6547,6,2009,6,98);
		
		//testing toString() for Quadcopter
		System.out.println(q1+"\n");
		System.out.println(q2+"\n");
		System.out.println(q3+"\n");
		
		System.out.println("*****TESTING THE MULTIROTOR CLASS*****");
		//Multirotor objects being created using different types of constructors
		Multirotor m1 = new Multirotor(); //Default constructor
		Multirotor m2 = new Multirotor("XYZ", 23423.23,5424, 7,2005, 6, 4); //Parametrized constructor 
		Multirotor m3 = new Multirotor("DJI", 34256.66,9845,6,2012,5,6);
		
		//testing toString() for Multirotor
		System.out.println(m1+"\n");
		System.out.println(m2+"\n");
		System.out.println(m3+"\n");
		
		System.out.println("*****TESTING THE UAV CLASS*****");
		//UAV objects being created using different types of constructors
		UAV u1 = new UAV(); //Default constructor 
		UAV u2 = new UAV(12.4, 50); //Parametrized constructors
		UAV u3 = new UAV(14.8, 46);
		UAV u4 = new UAV();
		
		//testing toString() for UAV
		System.out.println(u1+"\n");
		System.out.println(u2+"\n");
		System.out.println(u3+"\n");
		
		System.out.println("*****TESTING THE AGRICULTURAL DRONE CLASS*****");
		//Agricultural drone objects being created using different types of constructors
		AgriculturalDrone aG1 = new AgriculturalDrone(); //Default constructor 
		AgriculturalDrone aG2 = new AgriculturalDrone(32.5,68,"CAT", 4); //Parametrized constructors 
		AgriculturalDrone aG3 = new AgriculturalDrone(78.6,56,"Aerobotics", 6);
		
		//testing toString() for Agricultural drone
		System.out.println(aG1+"\n");
		System.out.println(aG2+"\n");
		System.out.println(aG3+"\n");
		
		System.out.println("*****TESTING MAV CLASS*****");
		//MAV objects being created using different types of constructors
		MAV mA1 = new MAV(); //Default constructor 
		MAV mA2 = new MAV(54.2,75,"latest", 12); //Parametrized constructors 
		MAV mA3 = new MAV(78.5,58,"RQ-16", 15);
		
		//testing toString() for MAV
		System.out.println(mA1+"\n");
		System.out.println(mA2+"\n");
		System.out.println(mA3+"\n");

			
		//testing the equals method
		System.out.println("*****TESTING EQUALS METHOD*****");
		System.out.println("a1 equals a3 gives: "+a1.equals(a3)); //Comparing two airplane objects 
		System.out.println("a1 equals h3 gives: "+a1.equals(h3)); //Comparing an airplane with a helicopter 
		System.out.println("u1 equals u4 gives: "+u1.equals(u4)); //Comparing two UAV objects
		System.out.println("mA3 equals ma1 gives: "+ mA3.equals(mA1)); //Comparing two MAV objects 
		System.out.println("q1 equals m2 gives: "+q1.equals(m2)); //Comparing a quadcopter with a multirotor 
		System.out.println("aG2 equals aG3 gives: "+aG2.equals(aG3)); //Comparing two agricultural drones
		
		//Creating flying object array
		FlyingObjects[] flyingObjects = new FlyingObjects[15];
		
		flyingObjects[0] = a2;
		flyingObjects[1] = a3;
		flyingObjects[2] = h2;
		flyingObjects[3] = h3;
		flyingObjects[4] = q2;
		flyingObjects[5] = q3;
		flyingObjects[6] = m2;
		flyingObjects[7] = m3;
		flyingObjects[8] = u2;
		flyingObjects[9] = u3;
		flyingObjects[10] = aG2;
		flyingObjects[11] = aG3;
		flyingObjects[12] = mA1;
		flyingObjects[13] = mA2;
		flyingObjects[14] = mA3;
		
		
		//Searching for two objects with the least price and their location in that array 
		double d = Double.MAX_VALUE;
		
		double smallest = d;
		double secondSmallest = d;
		
		int smallestIndex = 0, secondSmallestIndex = 0;
		
		for(int i = 0; i < flyingObjects.length; i++) {
			
			if(flyingObjects[i].getPrice() < smallest) {
				secondSmallest = smallest;
				smallest = flyingObjects[i].getPrice();
				secondSmallestIndex = smallestIndex;
				smallestIndex = i;
				
			}
			
			else if(flyingObjects[i].getPrice() < secondSmallest && flyingObjects[i].getPrice() != smallest) {
				secondSmallestIndex = i;
				secondSmallest = flyingObjects[i].getPrice();
				
			}
		}
		//Displaying the information about the cheapest flying objects and their location in the array 
		System.out.println("\nThe cheapest flying objects in the array are located at indices "+smallestIndex +" and "+secondSmallestIndex+".");
		System.out.println("The objects are:\n\tIndex "+smallestIndex+": "+flyingObjects[smallestIndex].toString()+
				"\n\tIndex "+secondSmallestIndex+": "+flyingObjects[secondSmallestIndex].toString());
		System.out.println();
		System.out.println("---------END OF PART I OF THE ASSIGNMENT---------");
		System.out.println();
		System.out.println("*********BEGINNING OF PART II OF THE ASSIGNMENT*********");
		System.out.println();
		//Testing copyFlyingObjects method
		FlyingObjects[] fo = copyFlyingObjects(flyingObjects); //Calling the copy method 
		//Displaying the information about the original array 
		System.out.println("CONTENTS OF THE ORIGINAL ARRAY:");
		System.out.println();
		for (int i=0;i<flyingObjects.length;i++) {
			System.out.println(flyingObjects[i].toString());
			
		}
		//Displaying the information about the copied array 
		System.out.println();
		System.out.println("CONTENTS OF THE COPIED ARRAY:");
		System.out.println();
		
		for (int i=0;i<flyingObjects.length;i++) {
			System.out.println(fo[i].toString());	
		}
		/**The program misbehaves. We expect the method to copy the original array exactly how it is, because of polymorphism.
		However, polymorphism works on methods of the same name, not constructors. So polymorphism was not active, and did not try and use the correct copy constructor for each class.
		Only the FlyingObjects' copy constructor was used, since the method took an array of FlyingObjects. This is why the copied array contains only flying objects.
		Much information was lost as this only copies the three attributes in the parent class FlyingObjects and not the additional attributes within the child classes.
		Correct way would be to use the clone method. It is a method, so with the same name in each class, it will be recognized by polymorphism.*/
	}

}
