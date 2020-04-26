// Assignment 3
// Question: 1 (Driver Class)
// Written by: Auvigoo Ahmed (ID:40128901) & Arafat Atique (ID:40132573)
// Due date: March 30, 2020
// ----------------------------------------------------
// The exception class to be used with the BibCreator class. 
// Contains constructors for a default message and a different message, as well as the getMessage method.


/**
 * To notify user that an error occurred if a file is invalid (i.e., one of the fields is empty).
 * @author Arafat Atique 
 * @author Auvigoo Ahmed 
 * @version 4.12.0
 * @see BibCreator 
 */
public class FileInvalidException extends Exception
{
	private static final long serialVersionUID = 1L;

	// Default error message.
	public FileInvalidException()
	{
		super("Error: Input file cannot be parsed due to missing information (i.e. month={}, title={}, etc.)");
	}
	
	// To pass a different message.
	public FileInvalidException(String message)
	{
		super(message);
	}
	
	// getMessage method.
	public String getMessage()
	{
		return super.getMessage();
	}
}