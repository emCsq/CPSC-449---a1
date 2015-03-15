package a2;

import java.util.Scanner;

public class InCompiler {

	boolean keepRunningParser = true;
	String userInput = "";
	String finalAnswer;
	boolean validBrackets;
	
	Scanner input = new Scanner(System.in);

	public ProcessMethods methods;

	public InCompiler() {
		methods = new ProcessMethods();
	}
	
	
	public void mainMenu() {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< mainMenu() >>>");
		}
		
		startUp();
		while (keepRunningParser == true) {
			System.out.print("> ");
			userInput = input.nextLine();
			Errors.setInput(userInput);
			if (userInput.equals("q")) {	//'q' quits the program
				keepRunningParser = false;
			}  else if (userInput.equals("v")) {		//'v' toggles verbose mode on/off
				if (Flags.getVerbose() == true) {	//if verbose is on
					Flags.setVerbose(false);		//turn it off
				} else {
					Flags.setVerbose(true);			// else vice-versa
				}
			} else if (userInput.equals("f")) {	//'f' displays the functions available
				this.functions();
			} else {
				validBrackets = this.checkBrackets(userInput);
				if (validBrackets == false) {
					System.out.println("Matching braces error.");
				} else {
					finalAnswer = this.treeTime(userInput);
					if (finalAnswer != null) {
						System.out.println(finalAnswer);
					}
				}
			}
		}

	}

	public boolean checkBrackets (String userIn) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< checkBrackets() >>>");
		}
		
		int balancedBraces = 0;
		char[] userIn_charArray = userIn.toCharArray();
		
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
			return false;
		}
		return true;
	}
	
public String treeTime(String userIn) {
		char[] userInAsArray = userIn.toCharArray();
		char[] newArray = null;
		String concatedResult, recurseResult;
		boolean arrayStillContainsBraces = true;
		boolean arrayStillContainsSpaces = true;
		
	/*	if ((userInAsArray[0] != '(') && (userInAsArray[userInAsArray.length] != ')')) {
			System.out.println("Error missing bracket at offset " + Errors.getOffset());
			return null;
		}*/
		for (int i = 0; i < userInAsArray.length; i++) {	
			if (userInAsArray[i] == '(') {
				recurseResult = this.treeTime(new String(userInAsArray, i+1, userInAsArray.length-(i+1)));
				//System.out.println("recurseResult is " + recurseResult);
				//if (recurseResult.contains("null)")) {
				//	return null;
				//} else {
				concatedResult = new String(userInAsArray, 0, i) + recurseResult;
				//	System.out.println("bleh is " + bleh);
			//	}
				
				newArray = concatedResult.toCharArray();
				arrayStillContainsBraces = arrayHasBraces(newArray);
				arrayStillContainsSpaces = arrayHasSpaces(newArray);
				if ((arrayStillContainsBraces != true) || (arrayStillContainsSpaces != true)) {
					return concatedResult;
				} else {
					return treeTime(concatedResult);
				}
			} else if (userInAsArray[i] == ')') {
				String thingToProcess = new String(userInAsArray, 0, i);				
				String result = methods.timeToEvaluateStuff(thingToProcess);
				return result + (new String(userInAsArray, i+1, userInAsArray.length-(i+1)));
			}
		}
		return null;
	}
	
	
	public boolean arrayHasBraces(char[] inArray) {
		for (int i=0; i<inArray.length; i++) {
			if ((inArray[i] == '(') || (inArray[i] == ')')) {
				return true;
			}
		}
		return false;
	}
	
	public boolean arrayHasSpaces(char[] inArray) {
		for (int i=0; i<inArray.length; i++) {
			if((inArray[i] == ' ')) {
				return true;
			}
		}
		return false;
	}

	public void startUp() {
		System.out.println("q \t : Quit the program.\n"
				+ "v \t : Toggle verbose mode (stack traces).\n"
				+ "f \t : List all known functions.\n"
				+ "? \t : Print this helpful text.\n"
				+ "<expression>: Evaluate the expression."
				+ "Expressions can be integers, floats, strings (surrounded in double quotes) or function\n"
				+ "calls of the form '(identifier {expression}*)'");
		return;
	} 
    
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
