// The "Library System" class

import java.util.StringTokenizer;
import hsa.Stdout;

public class LibrarySystem
{
    // USER-DEFINED OBJECTS declaration
    private static MemberObject member = new MemberObject ();
    private static BookObject book = new BookObject ();

    // USER-DEFINED METHODS
    public static void main (String[] args)
    {
	int choice, numOfCopies, search;
	String title, authorLast, authorFirst, genre, firstName, midName, lastName, DOB;

	do      // LOOP
	{
	    DisplayMenu ();
	    choice = IBIO.inputInt ("Enter your selection: ");
	    if (choice < 1 || choice > 10)          // SIMPLE SELECTION
	    {
		System.out.println ("Please enter a number shown on the menu.");
		continue;
	    }
	    else if (choice == 1)          // SIMPLE SELECTION
	    {
		title = IBIO.inputString ("Enter the title: ");
		authorLast = IBIO.inputString ("Enter the author's last name: ");
		authorFirst = IBIO.inputString ("Enter the author's first name: ");
		genre = IBIO.inputString ("Enter the genre: ");
		numOfCopies = IBIO.inputInt ("Enter the number of copies available: ");
		book.AddBook (title, authorLast, authorFirst, genre, numOfCopies);
	    }
	    else if (choice == 2)          // COMPLEX SELECTION
	    {
		do      // NESTED LOOP
		{
		    System.out.println ("1 - Search by title");
		    System.out.println ("2 - Search by author's last name");
		    search = IBIO.inputInt ("Enter you selection: ");
		    if (search == 1)
		    {
			title = IBIO.inputString ("Enter the title: ");
			book.SearchTitle (title);
		    }
		    else if (search == 2)          // COMPLEX SELECTION
		    {
			authorLast = IBIO.inputString ("Enter the author's last name: ");
			book.SearchAuthor (authorLast);
		    }
		    else
		    {
			System.out.println ("Invalid input. Please enter either 1 or 2.");
		    }
		}
		while (search < 1 || search > 2);
	    }
	    else if (choice == 3)          // COMPLEX SELECTION
	    {
		title = IBIO.inputString ("Enter the title: ");
		book.DeleteBook (title);
	    }
	    else if (choice == 4)          // COMPLEX SELECTION
	    {
		firstName = IBIO.inputString ("Enter first name: ");
		midName = IBIO.inputString ("Enter middle name: ");
		lastName = IBIO.inputString ("Enter last name: ");
		DOB = IBIO.inputStrign ("Enter the date of birth in mm-dd-yy format: ");
	    }
	}
	while (choice != 10);
    }


    public static void DisplayMenu ()     // USER-DEFINED METHOD
    {
	System.out.println ("Options:");
	System.out.println ("   " + "1 - Add a new book");
	System.out.println ("   " + "2 - Search for a book");
	System.out.println ("   " + "3 - Delete a book");
	System.out.println ("   " + "4 - Add a new member");
	System.out.println ("   " + "5 - Search for a member");
	System.out.println ("   " + "6 - Delete a member");
	System.out.println ("   " + "7 - Checkout a book");
	System.out.println ("   " + "8 - Return a book");
	System.out.println ("   " + "9 - Report");
	System.out.println ("   " + "10 - Exit");
    }
}


