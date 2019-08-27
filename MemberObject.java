// Library System - Members Object

import java.util.StringTokenizer;
import hsa.Stdout;
import hsa.TextInputFile;
import hsa.TextOutputFile;

public class MemberObject
{
    // ARRAYS declaration
    public static String[] name = new String [50];
    public static String[] DOB = new String [50];
    public static String[] title = new String [100];
    public static String[] author = new String [100];
    
    
    // USER-DEFINED METHODS
    public void Load ()
    {
	TextInputFile infile;
	String input;
	int index = 0;

	infile = new TextInputFile ("Books.txt");
	// FILE INPUT
	while (!infile.eof ())      // LOOP
	{
	    input = infile.readString ();
	    name [index] = input;
	    input = infile.readString ();
	    DOB [index] = input;
	    input = infile.readString ();
	    title [index] = input;
	    input = infile.readString ();
	    author [index] = input;
	    index++;
	}
    }


    public void Save ()
    {
	TextOutputFile outfile;
	int index = 0;

	outfile = new TextOutputFile ("Books.txt");
	// FILE OUTPUT
	while (!" ".equals (title [index]))      // LOOP
	{
	    outfile.print (name [index], 20);
	    outfile.print (" ", 2);
	    outfile.print (DOB [index], 10);
	    outfile.print (" ", 2);
	    outfile.print (title [index], 20);
	    outfile.print (" ", 2);
	    outfile.print (author [index], 10);
	    index++;
	}
    }


    public void Add (String firstName, String midName, String lastName, String inputDOB)     // USER-DEFINED METHOD WITH PARAMETERS
    {
	StringBuffer fullName = new StringBuffer ();

	fullName.append (lastName);
	fullName.append (", ");
	fullName.append (firstName);
	fullName.append (" ");
	fullName.append (midName);

	for (int counter = 0 ; counter < 50 ; counter++)
	{
	    if (name [counter].equals (" "))              // SIMPLE SELECTION
	    {
		String temp = fullName.toString ();
		name [counter] = temp;
		DOB [counter] = inputDOB;
	    }
	}
    }


    public void SearchMember (String lastName)     // USER-DEFINED METHOD WITH PARAMETERS       // SEARCHING
    {
	int first = 1, entryCounter = 0;
	entryCounter = 0;
	StringTokenizer tokenizer;
	String token;

	for (int counter = 0 ; counter < 50 ; counter++)
	{
	    tokenizer = new StringTokenizer (name [counter]);
	    token = tokenizer.nextToken ();
	    if (token.equalsIgnoreCase (lastName))          // SIMPLE SELECTION
	    {
		if (first == 1)          // SIMPLE SELECTION
		{
		    DisplayMemberHeadings ();
		    first = 0;
		}
		entryCounter++;
		DisplayMember (entryCounter, counter);
	    }
	    else if (name [counter].equals (" ") && first == 1)          // SIMPLE SELECTION
	    {
		System.out.println ("Member not found.");
	    }
	}
    }


    public void DeleteMember (String lastName, BookObject[] book)     // USER-DEFINED METHOD WITH PARAMETERS
    {
	int entryNum = 0, entryCounter = 0;
	String confirmation, token;
	StringTokenizer tokenizer;

	SearchMember (lastName);

	entryNum = IBIO.inputInt ("Enter the correct entry number: ");

	for (int counter = 0 ; counter < 50 ; counter++)
	{
	    tokenizer = new StringTokenizer (name [counter]);
	    token = tokenizer.nextToken ();
	    if (lastName.equalsIgnoreCase (token))          // SIMPLE SELECTION
	    {
		entryCounter++;
		if (entryCounter == entryNum)
		{
		    if (!title [counter * 2].equals (" "))          // SIMPLE SELECTION
		    {
			System.out.println ("This member still has a book checked out.");
		    }
		    else if (!title [counter * 2 + 1].equals (" "))          // SIMPLE SELECTION
		    {
			System.out.println ("This member still has a book checked out.");
		    }
		    confirmation = IBIO.inputString ("Are you sure you want to delete " + name [counter] + "?" + "Enter \"yes\" or \"no\": ");
		    if (confirmation.equalsIgnoreCase ("yes"))          // SIMPLE SELECTION
		    {
			name [counter] = " ";
			title [counter * 2] = " ";
			title [counter * 2 + 1] = " ";
			System.out.println ("Member was deleted from database.");
		    }
		}
	    }
	}
    }


    public void CheckOut (String lastName, BookObject book)     // USER-DEFINED METHOD WITH PARAMETERS
    {
	String input, token;
	int entryNum, entryCounter = 0;
	StringTokenizer tokenizer;

	SearchMember (lastName);

	entryNum = IBIO.inputInt ("Enter the correct entry number: ");
	input = IBIO.inputString ("Enter the book's title: ");

	for (int counter = 0 ; counter < 50 ; counter++)
	{
	    tokenizer = new StringTokenizer (name [counter]);
	    token = tokenizer.nextToken ();
	    if (token.equalsIgnoreCase (lastName))          // SIMPLE SELECTION
	    {
		entryCounter++;
		if (entryCounter == entryNum)          // SIMPLE SELECTION
		{
		    for (int counter2 = 0 ; counter2 < 50 ; counter2++)
		    {
			if (book.title [counter2].equalsIgnoreCase (input))
			{
			    if (!title [counter * 2].equals (" "))
			    {
				title [counter * 2] = book.title [counter2];
				author [counter * 2] = book.author [counter2];
			    }
			    else
			    {
				title [counter * 2 + 1] = book.title [counter2];
				author [counter * 2 + 1] = book.author [counter2];
			    }
			}
			System.out.println (book.title [counter2] + " was successfully checked out to " + name [counter]);
		    }
		}
	    }
	}
    }


    public void Return (String lastName)     // USER-DEFINED METHOD WITH PARAMETERS
    {
	int entryNum, entryCounter = 0;
	String input, token;
	StringTokenizer tokenizer;

	SearchMember (lastName);

	entryNum = IBIO.inputInt ("Enter the correct entry number: ");
	input = IBIO.inputString ("Enter the title of the book being returned: ");

	for (int counter = 0 ; counter < 50 ; counter++)
	{
	    tokenizer = new StringTokenizer (name [counter]);
	    token = tokenizer.nextToken ();
	    if (token.equalsIgnoreCase (lastName))
	    {
		entryCounter++;
		if (entryNum == entryCounter)
		{
		    if (title [counter * 2].equalsIgnoreCase (input))
		    {
			title [counter * 2] = " ";
		    }
		    else
		    {
			title [counter * 2 + 1] = " ";
		    }
		}
	    }
	}
    }


    public void Report ()     // USER-DEFINED METHOD
    {
	int first = 1, entryCounter = 0;

	for (int counter = 0 ; counter < 50 ; counter++)
	{
	    if (!name [counter].equals (" "))
	    {
		for (int counter2 = counter * 2 ; counter2 <= counter * 2 + 1 ; counter2++)
		{
		    if (!title [counter2].equals (" "))
		    {
			if (first == 1)
			{
			    DisplayMemberHeadings ();
			    first = 0;
			}
			entryCounter++;
			DisplayMember (entryCounter, counter);
		    }
		}
	    }
	}
    }


    public void DisplayMemberHeadings ()
    {
	Stdout.print (" ", 5);
	Stdout.print ("Full Name:", 20);
	Stdout.print (" ", 2);
	Stdout.print ("DOB:", 10);
	Stdout.print (" ", 2);
	Stdout.print ("Check-Outs:", 30);
    }


    public void DisplayMember (int entryNum, int index)
    {
	System.out.print (entryNum + ")");
	Stdout.print (name [index], 20);
	Stdout.print (" ", 2);
	Stdout.print (DOB [index], 10);
	Stdout.print (" ", 2);
	for (int counter = index * 2 ; counter <= index * 2 + 1 ; counter++)
	{
	    if (!title [counter].equals (" "))
	    {
		Stdout.print (title [counter] + " (" + author [counter] + ")", 20);
	    }
	}
    }
}
