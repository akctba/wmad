package cli;

import java.util.Arrays;

public class CliExample {

	public static void main(String[] commandLineArguments) {
		
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


	}

}
