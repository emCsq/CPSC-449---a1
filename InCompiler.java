/**
 * @author Emily Chow		10103742
 * @author Shelly Sicat		10078650
 * @author Angela Sicat		10058190
 * @author Sartaj Hargopal Singh Hundal		10032181
 * @author Jeremy Kyle Delima	10109442
 * 
 * */

package a2;

import java.util.Scanner;

public class InCompiler {

	/*
	 * A list of the global variables that we'll be implementing,
	 * as well as whatever methods we'll need to breach other classes for.
	 * */
	boolean keepRunningParser = true;
	String userInput = "";
	String finalAnswer;
	boolean validBrackets, validInput;
	
	Scanner input = new Scanner(System.in);

	public ProcessMethods methods;
	public Trees tree;

	public InCompiler() {
		tree = new Trees();
		methods = new ProcessMethods();
	}
	
	/**
	 * This is the primary compiler part of the program after the correct
	 * command has been called from the other class. This will loop infinitely
	 * until the program is quit via the escape key 'q' being taken in as input.
	 */
	public void mainMenu() {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< mainMenu() >>>");
		}
		
		startUp();	//runs the startup message
		while (keepRunningParser == true) {
			System.out.print("> ");
			userInput = input.nextLine();
			if (userInput.equals("q")) {			//'q' quits the program
				keepRunningParser = false;
			} else if (userInput.equals("v")) {		//'v' toggles verbose mode on/off
				if (Flags.getVerbose() == true) {	//if verbose is on
					Flags.setVerbose(false);		//turn it off
				} else {
					Flags.setVerbose(true);			// else vice-versa
				}
			} else if (userInput.equals("f")) {		//'f' displays the functions available
				this.functions();
			} else {
				validBrackets = this.checkBrackets(userInput); //first checks the brackets on the input
				validInput = this.invalidFunc(userInput); //then checks if the input is valid at all
				if (validBrackets == false) {
					System.out.println("Matching braces error.");
				} else if (validInput == false) {
					System.out.println("Input to be calculated is invalid.");
				} else { 								//if both tests pass, then input will be processed through recursion tree
					finalAnswer = this.treeTime(userInput);
					//if (finalAnswer != null) {
						System.out.println(finalAnswer);
						Errors.setInput(userInput); //gets input from user for error handling
					//}
				}
			}
		}

	}

	/**
	 * The purpose of this function is to ensure that there is a valid/even number of brackets
	 * in the calculation that the user has specified. 
	 * <p>
	 * This function will also check to see whether or not a right brace will exist before
	 * a left brace. If so, then a false value will return. Otherwise it should return true.
	 * 
	 * @param userIn the calculation that the user has entered as input
	 * @return The boolean value that will inform whether or not the brackets check is valid or not.
	 */
	public boolean checkBrackets (String userIn) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< checkBrackets() >>>");
		}
		
		int balancedBraces = 0;
		char[] userIn_charArray = userIn.toCharArray();
		
		//for every ( add 1, for every ) subtract one. If it ever goes below 0, break and return false.
		for (int i = 0; i < userIn_charArray.length; i++){
			if (userIn_charArray[i] == '(') {
				balancedBraces++;
			} else if (userIn_charArray[i] == ')') {
				balancedBraces--;
				if (balancedBraces < 0) {
					return false;
				}
			}
		}
		if (balancedBraces != 0) {
			return false; //if by the end the variable is NOT 0, return false.
		}
		return true;
	}
	
	/**
	 * Method for checking if a user's input of a function resembles the proper syntax
	 * Takes care of certain special cases, such as parentheses surrounding arguments, balanced
	 * brackets but more than legally allowed (i. e. ((add 2 5)) is balanced, but incorrect)
	 * @param userIn A string representing the user's input on the shell
	 * @return A true or false value denoting the correspondence of the user's input with the BNF syntax for a function call of N-dimensional size
	 */
	public boolean invalidFunc(String userIn) {
		//if verbose is on, track code
			if (Flags.verboseOn) {
				System.out.println("<<< invalidFunc() >>>");
			}
		// Array of strings containing the provided function names for our mini-language
		String[] fList = {"add", "sub", "mul", "div", "len", "dec"};
		// Turn the user input into a char array to process parentheses
		char[] userInAsArray = userIn.toCharArray();
		// Alphabet pattern to be matched against for condition check downstream (is a part of the input illegal after a left parenthesis?)
		char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
		
		// Simple case: check if one function call is balanced and has proper syntax
		if (checkBrackets(userIn) == true && tree.funcall(userIn)) {
			return true;
		} 
		
		// Negative definition of a function call. If a function name from fList is not found at all, immediately return false
		for (String f : fList) {
			if (!userIn.contains(f)) {
				return false;
				// Check if a number or alphabetical character comes after a left parenthesis and break the program
			} else {
				for (int i = 0; i < Integer.MAX_VALUE; i++) {
					for (int j = 0; j < userInAsArray.length; j++ ) {
						if (userInAsArray[j] == '(' && (userInAsArray[j+1] == i || userInAsArray[j+1] == alphabet[j])) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}
	
	/**
	 * The recursion tree where the user input will be processed and calculated 
	 * through the {@link ProcessMethods} methods and the final result will be returned.
	 * 
	 * @param userIn The calculation that the user wishes to have executed. 
	 * @return The result of the inner calculations. Eventually the final result will be returned.
	 */
	public String treeTime(String userIn) {
		char[] userInAsArray = userIn.toCharArray(); 		//turns the user input into a character array
		char[] newArray = null;								//initializes an empty character array
		String concatedResult, recurseResult;
		boolean arrayStillContainsBraces = true;
		boolean arrayStillContainsSpaces = true;
		
		for (int i = 0; i < userInAsArray.length; i++) {	
			if (userInAsArray[i] == '(') {					//checks for the left brace
				//recursion where everything to the right of this bracket will be sent through this method again and stored into recurseResult.
				recurseResult = this.treeTime(new String(userInAsArray, i+1, userInAsArray.length-(i+1)));	
				concatedResult = new String(userInAsArray, 0, i) + recurseResult; 		//a concatanated result of the recursed result and everything prior to it.
				newArray = concatedResult.toCharArray(); 		//turns it into a new array
				arrayStillContainsBraces = arrayHasBraces(newArray); 		//verifies if the result has braces
				arrayStillContainsSpaces = arrayHasSpaces(newArray); 		//verifies if the result has spaces (aka more items than 1)
				if ((arrayStillContainsBraces != true) || (arrayStillContainsSpaces != true)) {
					return concatedResult;		 //if result doesn't contain braces or spaces, return the result.
				} else {
					return treeTime(concatedResult); 	//otherwise return the result sent through the method again.
				}
			} else if (userInAsArray[i] == ')') { 		//checks for right brace
				String thingToProcess = new String(userInAsArray, 0, i); //processes the everything in between the last known ( and )			
				String result = methods.timeToEvaluateStuff(thingToProcess); //evaluates the inner function
				return result + (new String(userInAsArray, i+1, userInAsArray.length-(i+1))); //returns the result and whatever comes after it.
			}
		}
		return null;
	}
	
	/**
	 * This method checks whether or not braces still exist in the input Char array.
	 * 
	 * @param inArray A character array that is to be checked for braces.
	 * @return Returns a boolean value specifying whether the input array still contains braces.
	 */
	public boolean arrayHasBraces(char[] inArray) {
		for (int i=0; i<inArray.length; i++) {
			//if left or right bracket exists, return true
			if ((inArray[i] == '(') || (inArray[i] == ')')) {	
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method checks whether or not spaces still exist in the input Char array.
	 * 
	 * @param inArray A character array that is to be checked for spaces.
	 * @return Returns a boolean value specifying whether the input arrray still contains spaces. 
	 */
	public boolean arrayHasSpaces(char[] inArray) {
		for (int i=0; i<inArray.length; i++) {
			//if a space exists, return true
			if((inArray[i] == ' ')) {
				return true;
			}
		}
		return false;
	}

	/**
	 * A method that just contains the startup text that specifies the user's options
	 * in running this compiler.
	 */
	public void startUp() {
		System.out.println("q \t : Quit the program.\n"
				+ "v \t : Toggle verbose mode (stack traces).\n"
				+ "f \t : List all known functions.\n"
				+ "? \t : Print this helpful text.\n"
				+ "<expression>: Evaluate the expression."
				+ "Expressions can be integers, floats, strings (surrounded in double quotes) or function\n"
				+ "calls of the form '(identifier {expression}*)'");
	} 
    
	/**
	 * A method that displays the list of functions that are available in this compiler.
	 */
	public void functions() {
		System.out.println("Function List:\n"
				+ "(add string string) : string\n"
				+ "(add float float) : float\n"
				+ "(add int int) : int\n"
				+ "(sub float float) : float\n"
				+ "(sub int int) : int\n"
				+ "(div int int) : int\n"
				+ "(div float float) : float\n"
				+ "(mul float float) : float\n"
				+ "(mul int int) : int\n"
				+ "(inc float) : float\n"
				+ "(inc int) : int\n"
				+ "(dec int) : int\n"
				+ "(dec float) : float\n"
				+ "(len string) : int\n");
	}
	
	
	
}
