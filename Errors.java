package a2;

import java.util.*;

/*
Purpose of class: 
When an error is found, print out error message then revert back to program

	> (add 1 (mul 10. 5))
	Matching function for '(mul float int)' not found at offset 8
	(add 1 (mul 10. 5))
	--------^
	java.text.ParseException: Matching function for '(mul float int)' not found
		at Execution.execute(Execution.java:99)
		at Execution.execute(Execution.java:73)
		at Methods.<init>(Methods.java:51)
		at Methods.processCommandLineAndGo(Methods.java:145)
		at Methods.main(Methods.java:74)
*/

public class Errors {
	
	//errors should continue with the program from Main
	static InCompiler main = new InCompiler();
	//trees is needed to check if input is a funcall in order to get the offset line pointer 
	static Trees trees = new Trees();

	//getters and setters for error handling
	//offset determines where the offset line pointer has found the issue
	public static int getOffset() {
		int offset = 0; 
		return offset;
	}
	//having access to the input is also important in the error print-out
	public static String getInput() {
		String func = null; 
		return func;
	}
	//sets offset when error is found 
	public static void setOffset(int newOffset) {
		int offset = newOffset;
	}
	//sets new input when error is found 
	public static void setInput(String newInput) {
		String input = newInput;
	}

	//This is the beginning message of the error handle. Printing out the input, matching with the corresponding offset
	public static void beginError (){		
		System.out.println("Matching function for '" + getInput() + "' not found at offset " + getOffset() + "\n"
				+ getInput());
		//offsetPoint prints out the corresponding offset line print
		offsetPoint();
		return;
	}

	public static void offsetPoint(){
		//starts with a -, null was having errors but essentially this is the start of the offset pointer 
		String s = "-";	
		//this for loop creates a line of dash's (using the offset) to point to point of error
		for (int i=0; i<getOffset(); i++){ 
			s.concat("-"); // concat the the line
		}	
		s.concat("^"); // end off with a hat !
		return;
	}
}
