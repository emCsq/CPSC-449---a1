package a2;

import java.util.*;

public class Errors {
	
	//errors should continue with the program from Main
	static Main main = new Main();
	
	public Errors() {		
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
	
	public static void beginError (String func, int offset){
		System.out.println("Matching function for '" + func + "' not found at offset " + offset + "\n"
				+ func);
		return;
	}
	
	public static void lineIndicator (){
		return;
	}
	
	public static void errorCatch(String func, int offset) throws Exception {

		boolean nonFatalError = true;	
		
		try {
			
			beginError(func, offset);			
			if (nonFatalError){
				throw new EmptyStackException();
			}
			lineIndicator();
			
		} catch (Throwable e){
			//get stack trace
			e.printStackTrace(System.out);
			main.mainMenu();
		}
		
		main.mainMenu();
	}
	
}
