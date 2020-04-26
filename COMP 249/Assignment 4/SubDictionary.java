//------------------------------------------------------------------------------------------------
// Assignment 4
// Part 1
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// Due date: April 19, 2020
// -----------------------------------------------------------------------------------------------
//This program  will accept any text file, as input, and create a sub-dictionary that includes 
//all the words found in that input file based on some rules. The input file may have zero 
//or more words, as well as specific limited set of other characters /punctuation that are used 
//in a specific and predetermined manner.


import java.util.ArrayList;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileOutputStream;
import java.io.FileInputStream; 
import java.io.FileNotFoundException;

/**
 * The purpose of this program is to create a sub-dictionary of a given text file. This will
 * sort all the words in the text file in alphabetical order and write each of these words 
 * separated by their first letters in another text file. The words will be written in caps,
 * and if there are duplicate words in the input text file, they will only be recorded once 
 * in the sub-dictionary.
 * 
 * @author Auvigoo Ahmed (40128901)
 * @author Arafat Atique (40132573)
 * @version 4.12.0
 * @see CellList
 * @see CellListUtilization
 * @see CellPhone
 *
 */
public class SubDictionary {
		
	/**
	 * This method will return an array list will all each of the words in the input text file
	 * @param sc : Scanner that will read the input text file to process
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> getAllWords(Scanner sc){
		
		ArrayList<String> list = new ArrayList<String>();
		
		while(sc.hasNext()) {
			list.add(sc.next());
		}
		sc.close();
		
		return list;	
	}
	
	public static void main(String[] args) {
		
		
		Scanner sc = null;//creating a scanner to read the input file
		ArrayList<String> listOfAllWords = null;//creating an array list that will store all the words from the input file
		
		//displaying a welcome message
		System.out.println("**************************************");
		System.out.println("* Welcome to Sub-Dictionary Creator! *");
		System.out.println("**************************************\n");

		
		Scanner keyIn = new Scanner(System.in);//creating a scanner to read user input from keyboard
		System.out.print("Please enter the name of the file that you want to be read: ");
		String fileName = keyIn.next();
		
		try {
			sc = new Scanner(new FileInputStream(fileName));//reading the input file
			listOfAllWords =getAllWords(sc);//storing the array list of words into listOfAllWords
			sc.close();//closing the scanner to read files
			keyIn.close();//closing the scanner to read from keyboard
			
		}
		catch(FileNotFoundException x) {//catches exception when the input file is not found
			System.out.println("File not found!");
			keyIn.close();
			System.exit(0);//exits program
			
		}
		
		//Make all words in the array list in uppercase
		for(int i = 0 ; i < listOfAllWords.size() ; i++) {
			listOfAllWords.set(i, listOfAllWords.get(i).toUpperCase());
		}
		
		
		//remove the symbols ? : , ; ! .
		for(int i = 0 ; i<listOfAllWords.size() ; i++) {
			if(listOfAllWords.get(i).contains("?") || listOfAllWords.get(i).contains(":") || listOfAllWords.get(i).contains(",") || listOfAllWords.get(i).contains(";") || listOfAllWords.get(i).contains("!") || listOfAllWords.get(i).contains(".")) {
				String wordWithQuestionMark = listOfAllWords.get(i);
				wordWithQuestionMark = wordWithQuestionMark.substring(0, wordWithQuestionMark.length()-1);
				listOfAllWords.set(i, wordWithQuestionMark);
				
			}
		}
		
		//remove all one character words except for I and a
		for(int i = 0; i<listOfAllWords.size(); i++) {
			if(listOfAllWords.get(i).length() == 1 && !listOfAllWords.get(i).equalsIgnoreCase("i") && !listOfAllWords.get(i).equalsIgnoreCase("a")) {
				listOfAllWords.remove(i);
				listOfAllWords.remove("="); //for some reason the if statement is not removing =
			}
		}
		
		//remove all words that contain numerical values except for MC²
		for(int i = 0; i<listOfAllWords.size(); i++) {
			if((listOfAllWords.get(i).contains("1") || listOfAllWords.get(i).contains("2") ||listOfAllWords.get(i).contains("3") || listOfAllWords.get(i).contains("4") || listOfAllWords.get(i).contains("5") ||listOfAllWords.get(i).contains("6") || listOfAllWords.get(i).contains("7") || listOfAllWords.get(i).contains("8") || listOfAllWords.get(i).contains("9")) && !listOfAllWords.get(i).equals("MC²")) {
				listOfAllWords.remove(i);
			}
		}
		
		//remove parts after apostrophe
		for(int i = 0; i<listOfAllWords.size(); i++) {
			if(listOfAllWords.get(i).contains("’")) {
				String wordWithApostrophe = listOfAllWords.get(i);
				int index = wordWithApostrophe.indexOf("’");
				wordWithApostrophe = wordWithApostrophe.substring(0, index);
				listOfAllWords.set(i, wordWithApostrophe);	
			}	
		}

		ArrayList<String> newList = new ArrayList<String>();//creating a new array list that will not contain duplicate words
		//removes duplicate words in the new array list
		for(String word : listOfAllWords) {
			
			if(!newList.contains(word)) {
				newList.add(word);
			}
		}

		//Sorts all the words in the new array list in alphabetical order
		newList.sort(String.CASE_INSENSITIVE_ORDER);
		
		
		PrintWriter pw = null;//creating print writer to print to output file	
		try {
			
			pw = new PrintWriter(new FileOutputStream("SubDictionary.txt"));
			
			pw.println("The document produced this sub-dictionary, which includes "+newList.size() +" entries.");//displays how many words are in the sub-dictionary
		
			char charBefore = 'a';//initialize the previous character that will be used to compare the current character that is being printed
		
			//printing each word and separating them by their first character
			for(String printWord : newList) {
			
				char firstChar = printWord.charAt(0);//getting the first character of the word
			
				if(firstChar != charBefore) {//if we're done with listOfAllWords letter, we go to the next letter
					charBefore = firstChar;
				
					pw.println("\n"+firstChar);
					pw.println("==");
				}
			pw.println(printWord);//printing the words to the output file
			
		}
			//closing message
			System.out.println("Writing to file SubDictionary.txt was successful.\nThank you for using the sub-dictionary creator!");
			pw.close();
		}
		//catches exception when the file is not found
		catch(FileNotFoundException e) {
			System.out.println("Error writing to file");
		}

	}//end of main
}//end of class
