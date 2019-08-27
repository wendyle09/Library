// Library System - Books Object

import hsa.Stdout;
import java.util.StringTokenizer;
import hsa.TextInputFile;
import hsa.TextOutputFile;

public class BookObject
{
    // ARRAYS declaration
    public static String[] title = new String [50];
    public static String[] author = new String [50];
    public static String[] genre = new String [50];
    public static int[] numOfCopies = new int [50];


    public void Load ()     // USER-DEFINED METHOD
    {
	TextInputFile infile;
	String input;
	int inputNum, index = 0;

	infile = new TextInputFile ("Books.txt");
	// FILE INPUT
	while (!infile.eof ())      // LOOP
	{
	    input = infile.readString ();
	    title [index] = input;
	    input = infile.readString ();
	    author [index] = input;
	    input = infile.readString ();
	    genre [index] = input;
	    inputNum = infile.readInt ();
	    numOfCopies [index] = inputNum;
	    index++;
	}
    }


    public void Save ()     // USER-DEFINED METHOD
    {
	TextOutputFile outfile;
	int index = 0;

	outfile = new TextOutputFile ("Books.txt");
	// FILE OUTPUT
	while (!" ".equals (title [index]))      // LOOP
	{
	    outfile.print (title [index], 20);
	    outfile.print (" ", 2);
	    outfile.print (author [index], 10);
	    outfile.print (" ", 2);
	    outfile.print (genre [index], 10);
	    outfile.print (" ", 2);
	    outfile.print (numOfCopies [index], 5);
	    index ++;
	}
    }


    public void AddBook (String inputTitle, String firstName, String lastName, String inputGenre, int inputCopies)     // USER-DEFINED METHOD WITH PARAMETERS
    {
	StringBuffer edit = new StringBuffer ();
	String editedAuthor;

	edit.append (lastName);
	edit.append (", ");
	edit.append (firstName);
	editedAuthor = edit.toString ();

	for (int counter = 0 ; counter < 50 ; counter++)      // LOOP
	{
	    if (" ".equals (title [counter]))
	    {
		title [counter] = inputTitle;
		author [counter] = editedAuthor;
		genre [counter] = inputGenre;
		numOfCopies [counter] = inputCopies;
		System.out.println ("Book added to database.");
		System.out.println (title [counter]);
	    }
	}
    }


    public void SearchTitle (String input)     // USER-DEFINED METHOD WITH PARAMETERS       // SEARCHING
    {
	int first = 1, entryCounter = 0;

	for (int counter = 0 ; counter < 50 ; counter++)      // LOOP
	{
	    if (title [counter].equalsIgnoreCase (input))
	    {
		if (first == 1)
		{
		    DisplayBookHeadings ();
		    first = 0;
		}
		entryCounter++;
		DisplayBook (entryCounter, counter);
	    }
	    if (" ".equals (title [counter]) && first == 1)
	    {
		System.out.println ();
		System.out.println ("No book with that title was found.");
	    }
	}
    }


    public void SearchAuthor (String input)     // USER-DEFINED METHOD WITH PARAMETERS
    {
	int first = 1, entryCounter = 0;
	StringTokenizer tokenizer;
	String lastName;

	for (int counter = 0 ; counter < 50 ; counter++)      // LOOP
	{
	    tokenizer = new StringTokenizer (author [counter]);
	    lastName = tokenizer.nextToken ();
	    if (lastName.equalsIgnoreCase (input))
	    {
		if (first == 1)
		{
		    DisplayBookHeadings ();
		    first = 0;
		}
		entryCounter++;
		DisplayBook (entryCounter, counter);
	    }
	    if (" ".equals (title [counter]) && first == 1)
	    {
		System.out.println ();
		System.out.println ("No book with that author was found.");
	    }
	}
    }


    public void DeleteBook (String input)     // USER-DEFINED METHOD WITH PARAMETERS
    {
	int entryNum = 0, entryCounter = 0;
	String confirmation;

	SearchTitle (input);

	entryNum = IBIO.inputInt ("Enter the correct entry number: ");

	for (int counter = 0 ; counter < 50 ; counter++)      // LOOP
	{
	    if (input.equalsIgnoreCase (title [counter]))
	    {
		entryCounter++;
		if (entryCounter == entryNum)
		{
		    confirmation = IBIO.inputString ("Are you sure you want to delete " + title [counter] + "? Enter \"yes\" or \"no\": ");
		    if (confirmation.equalsIgnoreCase ("yes"))
		    {
			title [counter] = " ";
			author [counter] = " ";
			System.out.println ("Member was deleted from database.");
		    }
		}
	    }
	}
    }


    public void DisplayBookHeadings ()     // USER-DEFINED METHOD
    {
	Stdout.print (" ", 5);
	Stdout.print ("Title:", 20);
	Stdout.print (" ", 2);
	Stdout.print ("Author:", 10);
	Stdout.print (" ", 2);
	Stdout.print ("Genre:", 10);
	Stdout.print (" ", 2);
	Stdout.println ("# of Copies:", 5);
    }


    public void DisplayBook (int entryNum, int index)     // USER-DEFINED METHOD WITH PARAMETERS
    {
	System.out.print (entryNum + ")");
	Stdout.print (title [index], 20);
	Stdout.print (" ", 2);
	Stdout.print (author [index], 10);
	Stdout.print (" ", 2);
	Stdout.print (genre [index], 10);
	Stdout.print (" ", 2);
	Stdout.println (numOfCopies [index], 5);
    }
}
