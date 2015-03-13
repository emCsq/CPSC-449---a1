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
	static Trees trees = new Trees();
	
	public Errors() {
		int offset = 0; 
		String func = null;
		Exception e = null;
	}

	public static int getOffset() {
		int offset = 0; 
		return offset;
	}

	public static String getInput() {
		String func = null; 
		return func;
	}

	public static void setOffset(int newOffset) {
		int offset = newOffset;
	}
	
	public static void setInput(String newInput) {
		String input = newInput;
	}

	public static void beginError (){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< beginError() >>>"
			+ "Non-Fatal Error encountered");
		}
		
		System.out.println("Matching function for '" + getInput() + "' not found at offset " + getOffset() + "\n"
				+ getInput());
		return;
	}
	
	
	@SuppressWarnings("null")
	public static void offsetPoint(){
		String s = null;
		if (trees.funcall(getInput()) == true){
			return;
		} else {			
			for (int i=0; i<getOffset(); i++){
				s.concat("-");
			}	
			s.concat("-");
		}
	
		return;
	}
	
	/*
	public static void errorCatch(Exception e) throws Exception {
		boolean nonFatalError = true;	
		
		try {			
			beginError();	
			offsetPoint();
			//Take out once you get the actual error given
			if (nonFatalError){
				throw new Exception();
			}	
		} catch (Throwable e1){
			//get stack trace
			beginError();	
			offsetPoint();
			e1.printStackTrace(System.out);
			main.mainMenu();
		}	
		main.mainMenu();
	}*/
	
}
