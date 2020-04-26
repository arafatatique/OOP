// ----------------------------------------------------
// Assignment 3
// Question: 1 (Driver Class)
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// Due date: March 30, 2020
// ----------------------------------------------------
// This program searches .bib files containing information about articles, then displays the information in a readable format in new files, following precise bibliography specifications.
// The information is printed in new .json files for ACM, NJ, and IEEE formats.
// Any invalid files (a field of the info of the article is missing) will cause the created ACM, NJ, and IEEE files to be removed.
// Once the files have been displayed, the user has 2 opportunities to enter a valid file, which the program will then re-read and display for them.

import java.util.Scanner;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;


/**
 * Reads files and creates new .json files using the information within the original files. 
 * Each original file causes three new files to be created; one for a IEEE bibliography, one of ACM format and one for NJ bibliography.
 * Then allows the user to view the contents of one of the created files.
 * @author Arafat Atique 
 * @author Auvigoo Ahmed 
 * @version 4.12.0
 * @see FileInvalidException
 */
public class BibCreator 
{
	// Arrays for each of the file types.
	static File [] ieeeFiles = new File [10];
	static File [] acmFiles = new File [10];
	static File [] njFiles = new File [10];
	
	// Static so can be accessed by everything in the class.
	static Scanner scanner;
	static PrintWriter writer;
	
	// Arrays to store the information of each article in the files.
	static String [] authorsArray;
	static String [] journalArray;
	static String [] titleArray;
	static String [] yearArray;
	static String [] volumeArray;
	static String [] numberArray;
	static String [] pagesArray;
	static String [] keywordsArray;
	static String [] doiArray;
	static String [] issnArray;
	static String [] monthArray;
	
	// Specifically for ACM format which requires only one author.
	static String [] acmAuthorsArray;
	
	static String [] filesToDelete = new String [30]; // Worst case, all 30 .json files will need to be deleted, so create an array of 30.
	static int numberToDelete = 0;
	
	// To store the properties of the articles.
	static String authors;
	static String journal;
	static String title;
	static String year;
	static String volume;
	static String number;
	static String pages;
	static String keywords;
	static String doi;
	static String issn;
	static String month;
	
	public static void main (String [] args)
	{///Users/arafatatique/Desktop/
		System.out.println("Welcome to the BibCreator Program!");
		
		scanner = null;
		File [] bibFiles = new File [10]; // An array to store the Latex_.bib files.
		
		for (int counter = 0; counter < bibFiles.length; counter++)
		{
			String fileName = ("Latex" + (counter + 1) + ".bib");
			
			// Opens all the files ("Latex1.bib" through "Latex10.bib");
			try
			{
				scanner = new Scanner (new FileInputStream(fileName));
				bibFiles[counter] = new File(fileName);
			}
			// Displays message that file could not be opened, closes the Scanner to close files and exits.
			catch (FileNotFoundException e)
			{
				System.out.println("Could not open input file \"" + fileName + "\" for reading. Please check if file exists!");
				System.out.println("Program will terminate after closing any opened files.");
				scanner.close();
				System.exit(0);
			}
		}	
		
		boolean needToDeleteAll = false; // Used to see if there was an error creating .json files and we need to delete all created.
		
		// Creating .json files and storing in the array designated for IEEE records.
		for (int counter = 0; counter < 10; counter++)
		{
			String fileName = "IEEE" + (counter + 1) + ".json";
			
			createAFile(fileName);
			File createdFile = new File (fileName);
			
			ieeeFiles[counter] = createdFile;
			
			if(createAFile(fileName) == false) // Sees if file was created successfully and modifies needToDeleteAll if not.
				needToDeleteAll = true;
		}
		
		// Creating .json files and storing in the array designated for ACM ecords.
		for (int counter = 0; counter < 10; counter++)
		{
			String fileName = "ACM" + (counter + 1) + ".json";
			
			createAFile(fileName);
			File createdFile = new File (fileName);
			
			acmFiles[counter] = createdFile;
			
			if(createAFile(fileName) == false) // Sees if file was created successfully and modifies needToDeleteAll if not.
				needToDeleteAll = true;
		}
		
		// Creating .json files and string them in the array designated for NJ records.
		for (int counter = 0; counter < 10; counter++)
		{
			String fileName = "NJ" + (counter + 1) + ".json";
			
			createAFile(fileName);
			File createdFile = new File (fileName);
			
			njFiles[counter] = createdFile;
			
			if(createAFile(fileName) == false) // Sees if file was created successfully and modifies needToDeleteAll if not.
				needToDeleteAll = true;
		}
		
		// Goes through all three arrays of files and deletes them, but only in the case there was a file that could not be created.
		if (needToDeleteAll == true)
		{
			for (int counter = 0; counter < ieeeFiles.length; counter++)
				ieeeFiles[counter].delete();
			
			for (int counter = 0; counter < acmFiles.length; counter++)
				acmFiles[counter].delete();
			
			for (int counter = 0; counter < njFiles.length; counter++)
				njFiles[counter].delete();
			
			System.exit(0); // Exits the program after the created files have been deleted.
		}
		
		for (int counter = 0; counter < bibFiles.length; counter++)
		{
			processFilesForValidation(bibFiles[counter]);
		}
		
		int invalidBibFiles = numberToDelete / 3;
		
		System.out.println("\nFINISHED PROCESSING\nA total of " + invalidBibFiles + " files were invalid, and could not be processed. The other "
				+ (10 - invalidBibFiles) + " \"valid\" files have been created.");
		
		BufferedReader reader = null;
		Scanner keyboard = new Scanner(System.in);
		int numberOfAttempts = 0;
		
		while(numberOfAttempts < 2) // Will repeat only twice since user is allowed only 2 attempts.
		{
			System.out.print("\nPlease enter the name of one of the files you need to review: ");
			String fileToView = keyboard.nextLine();
			System.out.println("\n");
			
			try
			{
				reader = new BufferedReader(new FileReader(fileToView));
				
				String line = "";
				
				while(line != null) // Reads each line of the file using BufferedReader class.
				{
					line = reader.readLine();
		
					if (line == null) // Exits the loop if last line is reached.
						break;
					
					System.out.println(line);
				}
				
				System.out.println("\nFile has been displayed successfully.");
				System.out.println("Thank you for using this program, goodbye!");
				reader.close();
				keyboard.close();
				System.exit(0);
			}
			catch (FileNotFoundException e)
			{
				System.out.println("Could not open input file. File does not exist; possibly it could not be created!");
				numberOfAttempts++;
			
				if(numberOfAttempts == 2) // 
				{
					System.out.println("Cannot open this file! Program will exit. Goodbye!");
					System.exit(0);
					try 
					{
						reader.close();
						scanner.close();
					} 
					catch (IOException e1) 
					{
						System.out.println("Error closing the BufferedReader.");
					}
				}
				
				System.out.println("However, you will be allowed another chance to enter another file name.");
			}
			catch (IOException e)
			{
				System.out.println("An error has occured while reading from the file.");
				break;
			}
		}
		
		try 
		{
			reader.close(); // Closing the reader.
		} 
		catch (IOException e) 
		{
			System.out.println("Error occured.");
		}
		
		System.out.println("\nThank you for using this program, goodbye!");
		
	}
	
	// END OF MAIN METHOD.
	
	// Method to create a file of specified name. Will also true if the file was created successfully.
	/**
	 * Method used to create a file of a given name and verify the file was created without issue.
	 * @param fileName The name of the file that is to be created using this method.
	 * @return boolean To signify if the file was created successfully (true) or if there was an error (false).
	 */
	public static boolean createAFile(String fileName)
	{
		PrintWriter writer = null;
		
		try
		{
			writer = new PrintWriter(new FileOutputStream(fileName));
			writer.close();
			
			return true; // To signify that the file was created without issue.
		}
		catch (FileNotFoundException e)
		{
			System.out.println("The output file \"" + fileName + "\" could not be created.");
			System.out.println("Program will terminate after deleting any created files.");
			
			return false; // To signify that the file was not created.
		}
	}
	
	// Method to remove a file of specified name.
	/**
	 * Will delete a file specified.
	 * @param fileName The name of the file that is to be deleted.
	 */
	public static void removeAFile(String fileName)
	{
		File fileToDelete = new File(fileName);
		fileToDelete.delete();	
	}
	
	// Verifies files and puts information into json files.
	/**
	 * This method does a number of things: the .bib file will be specified, then the method will see how many articles are contained within.
	 * New files are created to store the infomation in IEEE, NJ, and ACM formats.
	 * For each article, the properties (title, author, journal, etc.) will be stored and it will be verified that no properties are missing information.
	 * If invalid files, the name of the property will be displayed and the created files will be removed.
	 * Once all verified, the program will print the bibliography information in each of the three files following the format.
	 * @param file The name of the original .bib file to be processed.
	 */
	public static void processFilesForValidation(File file)
	{
		int numberOfArticles = searchForArticles(file);
		
		// The arrays are created to the specified length for this file and how many articles it contains.
		authorsArray = new String [numberOfArticles];
		journalArray = new String [numberOfArticles];
		titleArray = new String [numberOfArticles];
		yearArray = new String [numberOfArticles];
		volumeArray = new String [numberOfArticles];
		numberArray = new String [numberOfArticles];
		pagesArray = new String [numberOfArticles];
		keywordsArray = new String [numberOfArticles];
		doiArray = new String [numberOfArticles];
		issnArray = new String [numberOfArticles];
		monthArray = new String [numberOfArticles];
		
		// For the authors in ACM format (only the first is required).
		acmAuthorsArray = new String [numberOfArticles];
		
		try
		{
			scanner = new Scanner(new FileInputStream(file));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not open input file \"" + file.getName() + "\" for reading. Please check if file exists!");
			System.out.println("Program will terminate after closing any opened files.");
			scanner.close();
			System.exit(0);
		}
		
		// Each attribute needs a counter to work.
		int count1 = 0, count2 = 0, count3 = 0, count4 = 0, count5 = 0, count6 = 0, count7 = 0, count8 = 0, count9 = 0, count10 = 0, count11 = 0;
			
		while (scanner.hasNextLine())
		{
			String currentLine = scanner.nextLine();
			
			if (currentLine.contains("author=")) // Checks if this line specifies the author.
			{
				String [] stringParts = currentLine.split("\\{"); // Trims the line to only show the material between the {curly braces}.
				stringParts = stringParts[1].split("\\}");
				authors = stringParts[0];
				authorsArray[count1] = authors; // Stores the trimmed author string in an array, at the index specified by the counter for this attribute.
				count1++; // Increments the counter, so the next time author is encountered the information is stored in the next position of the array.
			}
			else if (currentLine.contains("journal=")) // Process the same as above.
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				journal = stringParts[0];
				journalArray [count2] = journal;
				count2++;
			}
			else if (currentLine.contains("title=")) // Process for this and the remaining properties of the article are the same as described for the author.
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				title = stringParts[0];
				titleArray [count3] = title;
				count3++;
			}
			else if (currentLine.contains("year="))
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				year = stringParts[0];
				yearArray [count4] = year;
				count4++;
			}
			else if (currentLine.contains("volume="))
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				volume = stringParts[0];
				volumeArray [count5] = volume;
				count5++;
			}
			else if (currentLine.contains("number="))
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				number = stringParts[0];
				numberArray [count6] = number;
				count6++;
			}
			else if (currentLine.contains("pages="))
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				pages = stringParts[0];
				pagesArray [count7] = pages;
				count7++;
			}
			else if (currentLine.contains("keywords="))
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				keywords = stringParts[0];
				keywordsArray [count8] = keywords;
				count8++;
			}
			else if (currentLine.contains("doi="))
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				doi = stringParts[0];
				doiArray [count9] = doi;
				count9++;
			}
			else if (currentLine.contains("ISSN="))
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				issn = stringParts[0];
				issnArray [count10] = issn;
				count10++;
			}
			else if (currentLine.contains("month="))
			{
				String [] stringParts = currentLine.split("\\{");
				stringParts = stringParts[1].split("\\}");
				month = stringParts[0];
				monthArray [count11] = month;
				count11++;
			}
		}
		
		for (int counter = 0; counter < numberOfArticles; counter++) // For each element of the article, checks if the recorded data is empty.
		{
			if (authorsArray[counter].equals("") || 
					journalArray[counter].equals("") ||
					titleArray[counter].equals("") ||
					yearArray[counter].equals("") ||
					volumeArray[counter].equals("") ||
					numberArray[counter].equals("") ||
					pagesArray[counter].equals("") ||
					keywordsArray[counter].equals("") ||
					doiArray[counter].equals("") ||
					issnArray[counter].equals("") ||
					monthArray[counter].equals(""))
			{
				try // Throws exception if there is an empty field.
				{
					throw new FileInvalidException ("\nError: Detected Empty Field.");
				}
				catch (FileInvalidException e)
				{
					String message = e.getMessage();
					System.out.println(message);
				}
				
				String emptyField = null; // To store the field that is empty.
				
				// Determines which of the fields is empty (the first one to occur).
				if (authorsArray[counter].equals(""))
					emptyField = "author";
				else if (titleArray[counter].equals(""))
					emptyField = "title";
				else if (yearArray[counter].equals(""))
					emptyField = "year";
				else if (volumeArray[counter].equals(""))
					emptyField = "volume";
				else if (numberArray[counter].equals(""))
					emptyField = "number";
				else if (pagesArray[counter].equals(""))
					emptyField = "pages";
				else if (keywordsArray[counter].equals(""))
					emptyField = "keywords";
				else if (doiArray[counter].equals(""))
					emptyField = "doi";
				else if (issnArray[counter].equals(""))
					emptyField = "ISSN";
				else if (monthArray[counter].equals(""))
					emptyField = "month";
				
				String name = file.getName(); // To get the name of the file that is invalid.
				
				System.out.println("Problem detected with file: \"" + name + "\"."); // Telling user there is an error with this file.
				System.out.println("\"" + emptyField + "\" field is emtpy. Processing stopped at this point. Other empty fields may be present as well!\n"); // Informing user which field is empty.
				
				String fileNumber = name.substring(5, name.length() - 4); // Gets the number of the file that is invalid.
				
				// Specifies file name of files to be deleted.
				String ieeeToDelete = "IEEE" + fileNumber + ".json";
				String acmToDelete = "ACM" + fileNumber + ".json";
				String njToDelete = "NJ" + fileNumber + ".json";
				
				// The file names are stored in an array to be removed later with method.
				filesToDelete[numberToDelete] = ieeeToDelete;
				numberToDelete++;
				filesToDelete[numberToDelete] = acmToDelete;
				numberToDelete++;
				filesToDelete[numberToDelete] = njToDelete;
				numberToDelete++;
				
				break; // Breaks out of loop.
			}	
		}
		
		// All the files stored in the array of files to delete are now deleted.
		for (int counter = 0; counter < numberToDelete; counter++)
		{
			removeAFile(filesToDelete[counter]);
		}

		// Goes through the array storing months, changes the value to the full month name if the month is abbreviated (to satisfy IEEE record standards).
		for (int counter = 0; counter < monthArray.length; counter++)
			{
			if (monthArray[counter].equals("Jan"))
				monthArray[counter] = "September";
			if (monthArray[counter].equals("Feb"))
				monthArray[counter] = "February";
			if (monthArray[counter].equals("Mar"))
				monthArray[counter] = "March";
			if (monthArray[counter].equals("Apr"))
				monthArray[counter] = "April";
			if (monthArray[counter].equals("Aug"))
				monthArray[counter] = "August";
			if (monthArray[counter].equals("Sept"))
				monthArray[counter]  = "September";
			if (monthArray[counter].equals("Oct"))
				monthArray[counter] = "October";
			if (monthArray[counter].equals("Nov"))
				monthArray[counter] = "November";
			if (monthArray[counter].equals("Dec"))
				monthArray[counter] = "December";
		}
		
		// Ran into the issue of no " and" found if a single author.
		// Only the first author will be stored in the file since that is all that is required for ACM.
		for (int counter = 0; counter < authorsArray.length; counter++)
		{
			acmAuthorsArray[counter] = authorsArray[counter];
			
			if (acmAuthorsArray[counter].contains(" and"))
				acmAuthorsArray[counter] = acmAuthorsArray[counter].substring(0, acmAuthorsArray[counter].indexOf(" and")) + " et al";
		}
		
		String fileName = file.getName();
		String fileNumber = fileName.substring(5, fileName.length() - 4);
		
		String ieeeFileName = "IEEE" + fileNumber + ".json";
		String acmFileName = "ACM" + fileNumber + ".json";
		String njFileName = "NJ" + fileNumber + ".json";
		
		writer = null;
		
		// To create the IEEE files.
		try
		{
			writer = new PrintWriter (new FileOutputStream(ieeeFileName));
			
			for (int counter = 0; counter < numberOfArticles; counter++) // Repeats for as many times as there were @ARTICLES detected.
			{
				writer.println(authorsArray[counter].replace(" and ", ", ") + ". \"" + titleArray[counter] + "\", " + journalArray[counter] + ", vol. "
						+ volumeArray[counter] + ", no. " + numberArray[counter] + ", " + pagesArray[counter] + ", " + monthArray[counter] + " "
						+ yearArray[counter] + "."); // Writes the information in the specified format.
				writer.println(""); // Prints another line for formatting.
			}
			
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not open this file.");
		}
		
		// To create the ACM files.
		try
		{
			writer = new PrintWriter (new FileOutputStream(acmFileName));
			
			for (int counter = 0; counter < numberOfArticles; counter++) // Repeats for as many times as there were @ARTICLES detected.
			{
					writer.println("[" + (counter + 1) + "]\t" + acmAuthorsArray[counter] + ". " + yearArray[counter] + ". " + titleArray[counter] 
							+ ". " + journalArray[counter] + ". " + volumeArray[counter] + ", " + numberArray[counter] + " (" + yearArray[counter] + "), " 
							+ pagesArray[counter] + ". DOI:https://doi.org/" + doiArray[counter] + "."); // Writes the information following ACM record guidelines.
					writer.println(""); // Prints another line for formating.
			}
			
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not open this file.");
		}
		
		// To create NJ files.
		try
		{
			writer = new PrintWriter (new FileOutputStream(njFileName));
			
			for (int counter = 0; counter < numberOfArticles; counter++) // Repeats for as many times as there were @ARTICLES detected.
			{
				writer.println(authorsArray[counter].replace(" and ", " & ") + ". " + titleArray[counter] + ". " + journalArray[counter]
						+ ". " + volumeArray[counter] + ", " + pagesArray[counter] + "(" + yearArray[counter] + ")."); // Writes the information following NJ record guidelines.
				writer.println(""); // Prints another line for formating.
			}
			
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not open this file.");
		}
	}
	
	// To see how many articles are in a file. 
	/**
	 * Searches for occurences of "@ARTICLE" in the file to see how many articles are described in this file.
	 * @param file The file to be searched.
	 * @return int Signifies the number of times "@ARTICLE" appears.
	 */
	public static int searchForArticles(File file)
	{
		int numberOfArticles = 0;
		
		try
		{
			scanner = new Scanner(new FileInputStream(file));
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Could not open input file \"" + file.getName() + "\" for reading. Please check if file exists!");
			System.out.println("Program will terminate after closing any opened files.");
			scanner.close();
			System.exit(0);
		}
		
		while(scanner.hasNextLine())
		{
			String currentLine = scanner.nextLine();
			
			if (currentLine.contains("@ARTICLE")) // Checks for the "@ARTICLE" which specifies a new article.
				numberOfArticles++; // Increments.
		}
		
		return numberOfArticles;
	}
}