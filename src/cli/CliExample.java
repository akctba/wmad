package cli;

import java.util.Arrays;

/**
 * 
 * @author alexkayser
 *
 */
public class CliExample {

	public static void main(String[] commandLineArguments) {
		
		/* ##### FIRST SLIDE ##### */
		
		//Check if there are any command line arguments passed to the application
		if(commandLineArguments == null || commandLineArguments.length == 0) {
			//If there is no arguments, display, “Hello World” to the screen
			System.out.println("Hello world");
		} else {
			//If there is, print the message “Arguments: <length>” 
			System.out.printf("Arguments quantity: %d\nPrinted below:\n", commandLineArguments.length);
			//print the arguments to the screen
			Arrays.stream(commandLineArguments).forEach(System.out::println);
		}
		
		//Create an integer variable and display it to screen
		int x = 0;
		System.out.println(x);
		
		//Create a variable without assigning the value, then assign the value later and display it to screen
		String s;
		s = "originalem";
		System.out.println(s);
		
		//Overwrite an existing value and display it to screen
		s = "alterum";
		System.out.println(s);
		
		//Copy a variable and display it to screen
		String n = s;
		System.out.println(n);
		
		//Create a final variable (read only) and display it to screen
		final String IMMUTABILIS = "valorem immutabilis est finalem ";
		System.out.println(IMMUTABILIS);
		
		//Add a variable to another and display it to screen
		System.out.println(IMMUTABILIS + s);
		
		/* ##### SECOND SLIDE ##### */
		System.out.println("\nSecond slide\n");

		//Create a byte type and display it to screen
		byte vByte = Byte.MAX_VALUE;
		System.out.println(vByte);
		
		//Create a short type and display it to screen
		short vShort = Short.MAX_VALUE;
		System.out.println(vShort);
		
		//Create an int type and display it to screen
		int vInt = Integer.MAX_VALUE;
		System.out.println(vInt);
		
		//Create a long type and display it to screen
		long vLong = Long.MAX_VALUE;
		
		//Create a float type and display it to screen
		float vFloat = Float.MAX_VALUE;
		System.out.println(vFloat);
		
		//Create a double type and display it to screen
		double vDouble = Double.MAX_VALUE;
		System.out.println(vDouble);
		
		//Create a boolean type and display it to screen
		boolean vBoolean = Boolean.TRUE || Boolean.parseBoolean("true") || true;
		System.out.println(vBoolean);
		
		//Create a char type and display it to screen
		char vChar = 'ã';
		System.out.println(vChar);


	}

}
