/* This is the Input and Output method IB wants you to use.
 *You can still use System.out.print() for output, but this
 *must be the method of input. No more Stdin.
 *
 *You do not need to understand how these methods work, but it is really neat and
 *would be to your benefit to look them over and see how they work anyway.
 *
 *To output something, just use: output([variable name or string literal])
 *To input something just use: input[Datatype](String prompt);
 *For example, I want the user to input thier age, so I use the line
 *
 *				inputInt("Enter your age: ");
 *
 *When using these methods, you can either copy and paste them into your program,
 *or use this class seperately. To use this class, you need to add IBIO to the front
 *of each method call. For example my inputInt reference from earlier would be
 *
 *				IBIO.inputInt("Enter your age: ");
 *
 *Keep in mind that you must have this class in the same folder as the class you
 *are programming with it.
 */

public class IBIO	// makes a IBIO class
{
	static void output(String info)
	{
		System.out.println(info);
	}	// outputs strings
	static void output(char info)
	{
		System.out.println(info);
	}	// outputs a char
	static void output(byte info)
	{
		System.out.println(info);
	}	// outputs a byte
	static void output(int info)
	{
		System.out.println(info);
	}	// outputs an integer
	static void output(long info)
	{
		System.out.println(info);
	}	// outputs a long
	static void output(double info)
	{
		System.out.println(info);
	}	// outputs a double
	static void output(boolean info)
	{
		System.out.println(info);
	}	// outputs a boolean
	
	static String input(String prompt)
	{	// used for string input
		String inputLine = "";
		System.out.print(prompt);
		try
		{	// uses the buffered reader class and input stream reader to read a line
			inputLine = (new java.io.BufferedReader(new java.io.InputStreamReader(System.in))).readLine();
		}
		catch(Exception e)
		{	// catches exceptions
			String err = e.toString();
			System.out.println(err);	// outputs the error
			inputLine = "";
		}
		return inputLine;	// returns what is read in
		
	}
	
	static String inputString(String prompt)
	{
		return input(prompt);	// returns what is intered
	}
	
	static String input()
	{
		return input("");	// sets the input to string input
	}
	
	static int inputInt()	// passes the integer to inputint
	{
		return inputInt("");
	}
	
	static double inputDouble()	// inputs a double
	{
		return inputDouble("");
	}
	
	static char inputChar(String prompt)	// inputs a char
	{
		char result = (char)0;
		try
		{
			result=input(prompt).charAt(0);
		}
		catch (Exception e)	// if there is an error
		{
			result = (char)0;
		}
		return result;
	}
	
	static byte inputByte(String prompt)
	{	// inputs a byte from the string that was read in
		byte result = 0;
		try
		{
			result=Byte.valueOf(input(prompt).trim()).byteValue();
		}
		catch(Exception e)
		{
			result = 0;
		}
		return result;
	}
	
	static int inputInt(String prompt)
	{	// inputs an integer from the string that was read in
		int result=0;
		try
		{
			result=Integer.valueOf(input(prompt).trim()).intValue();
		}
		catch (Exception e)
		{
			result = 0;
		}
		return result;
	}
	
	static long inputLong(String prompt)
	{	// inputs a long from the string that was read in
		long result=0;
		try
		{
			result=Long.valueOf(input(prompt).trim()).longValue();
		}
		catch (Exception e)
		{
			result = 0;
		}
		return result;
	}
	
	static double inputDouble(String prompt)
	{	// inputs a double from the string that was entered
		double result=0;
		try
		{
			result=Double.valueOf(input(prompt).trim()).doubleValue();
		}
		catch (Exception e)
		{
			result = 0;
		}
		return result;
	}
	
	static boolean inputBoolean(String prompt)
	{	// inputs a boolean from the string that was entered
		boolean result=false;
		try
		{
			result = Boolean.valueOf(input(prompt).trim()).booleanValue();
		}
		catch(Exception e)
		{
			result = false;
		}
		return result;
	}
}