package a2;

import java.util.*;

public class Errors {
	
	//errors should continue with the program from inCompiler
	static inCompiler main = new inCompiler();
	static Trees trees = new Trees();
	
	public Errors() {
		int offset = 0; 
		String func = null;
		Exception e = null;
	}
	
	/*
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
	
	
	public static void offsetPoint(){

		if (trees.funcall(getInput()) == true){
			return;
		} else {
			int i;
			do {			
				for (i=0; i<getOffset(); i++){
					System.out.print("-");
				}				
			} while (i != 0);
			System.out.print("^");
		}
	
		return;
	}
	
	public static void errorCatch(Exception e) throws Exception {
		boolean nonFatalError = true;	
		
		try {			
			beginError();		
			//Take out once you get the actual error given
			if (nonFatalError){
				throw new Exception();
			}		
			//offsetPoint();
			
		} catch (Throwable e1){
			//get stack trace
			e1.printStackTrace(System.out);
			main.mainMenu();
		}
		
		main.mainMenu();
	}
	
}
