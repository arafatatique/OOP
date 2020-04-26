// ----------------------------------------------------
// Assignment 4
// Part 2
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// Due date: April 19, 2020
// Read through a list of cellphone information and create a LinkedList with that information
//-----------------------------------------------------

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
/**
 * This program uses linked lists, that manipulates a set of records of cell phones and performs some operations on these records.
 * 
 * @author Auvigoo Ahmed (40128901)
 * @author Arafat Atique (40132573)
 * @version 4.12.0
 * @see SubDictionary
 * @see CellList
 * @see CellPhone
 *
 */
public class CellListUtilization {
    public static void main(String[] args) {
        //Creating two CellLists
    	CellList list1 = new CellList();
        CellList list2;
        Scanner keyIn = new Scanner(System.in);
        CellPhone cpOP = new CellPhone(1231212,"Nokia",2018,500);
        int choice = 999;
        long serialNo= 0;
        
        //Welcome banner
        System.out.println("\nWelcome to the cellphone directory list!");

        try{
            FileInputStream fis = new FileInputStream("Cell_Info.txt"); //Source of CellList data
            Scanner sc = new Scanner(fis);
            //Storing all necessary data
            while (sc.hasNextLine()){
                long sn = sc.nextLong();
                String brand = sc.next();
                double price = sc.nextDouble();
                int year = sc.nextInt();

                CellPhone cp = new CellPhone(sn,brand,year,price);
                list1.addToStart(cp);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Printing the CellLists
        list1.showContents();
        list2 = new CellList(list1);
        list2.showContents();
        //Testing the validity of two lists
        System.out.println("List1 equals list2: "+list1.equals(list2));
        
        //Creating a loop to test all the methods 
        System.out.print("\nActions:\n" +
                "1. Find cell phones from the list with serial numbers.\n" +
                "2. Insert cell phone at list index.\n" +
                "3. Delete cell phone from index.\n" +
                "4. Check if list contains a cell phone from the serial number.\n" +
                "5. Replace at index.\n" +
                "6. Delete from start.\n" +
                "0. Quit\n" +
                "Please choose a number: ");
        choice = keyIn.nextInt();
        while (choice !=0){
            if (choice ==1) {
                System.out.print("Please enter a serial number (with a space in between and -1 to end) to search them through the list: ");
                while(keyIn.hasNextLong()){
                        serialNo = keyIn.nextLong();
                        if(serialNo == -1){
                            break;
                        }
                        CellList.CellNode that;
                        that = list1.find(serialNo);
                        if (that != null)
                            System.out.println(that.getCp() + " found with " + list1.getCtr() + " iterations.");
                        else
                            System.out.println("CellPhone with serial number " + serialNo + " not found.");
                }
            }else if (choice ==2){
                System.out.print("Please enter the index you want a cell phone to be added: ");
                int index;
                index = keyIn.nextInt();
                list1.showContents();
                try {
                    list1.insertAtIndex(cpOP,index);
                    list1.showContents();
                    System.out.println("HERE IS THE CONTENTS OF LIST 2 THAT WAS A DEEP COPY OF LIST 1");
                    list2.showContents(); //Deep copy proof 
                    //System.out.println("List1 equals list2: "+list1.equals(list2));
                }catch (NoSuchElementException e){
                    System.out.println("No such index in the list.");
                }
            }else if (choice ==3){
                System.out.print("Please enter the index you want a cell phone to be deleted: ");
                int index;
                index = keyIn.nextInt();
                list1.showContents();
                try {
                    list1.deleteFromIndex(index);
                    list1.showContents();
                }catch (NoSuchElementException e){
                    System.out.println("No such index in the list.");
                }
            }else if (choice ==4){
                System.out.print("Please enter the cell phone's serial number you want to check if the list contains: ");
                serialNo = keyIn.nextInt();
                list1.showContents();
                if (list1.contains(serialNo)){
                    System.out.println("The list contains the cell phone.");
                }else
                    System.out.println("The list does not contain the cell phone");
            }else if(choice == 5){
                System.out.print("Please enter the index you want a cell phone to be replaced: ");
                int index = keyIn.nextInt();
                if (index >=0 || index < list1.getSize()) {
                    list1.showContents();
                    list1.replaceAtIndex(cpOP, index);
                    list1.showContents();
                }else {
                    System.out.println("Invalid index. Cannot perform operation.");
                }
            }else if(choice == 6){
                list1.showContents();
                list1.deleteFromStart();
                list1.showContents();
            }
            System.out.print("\nActions:\n" +
                    "1. Find cell phones from the list with serial numbers.\n" +
                    "2. Insert cell phone at list index.\n" +
                    "3. Delete cell phone from index.\n" +
                    "4. Check if list contains a cell phone from the serial number.\n" +
                    "5. Replace at index.\n" +
                    "6. Delete from start.\n" +
                    "0. Quit\n" +
                    "Please choose a number: ");
            choice = keyIn.nextInt();
        }
        System.out.println("Program has terminated successfully.");
    }
}