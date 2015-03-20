package a2;

import java.util.*;

public class ParserMain {

	public static void main (String [] args){
		InCompiler mainStuff = new InCompiler();
		LoadJarClass load = new LoadJarClass();
		
		//This block of code is imbedded in a try catch to keep track of non-fatal errors
		try {
			Scanner input = new Scanner(System.in);	
			char[] inputAsArray = null;
	
			if (args.length == 0) {
				synopsis();
			} else if ((args[0].equals("-h") || args[0].equals("-?") || args[0].equals("--help")) && (args.length == 1)) {
				synopsis();
				System.out.println("\nThis program interprets commands of the format '(<method> {arg}*}' on the command line, finds corresponding methods in <class-name>, and executes them, printing the result to sysout. Terminate with ^D or \"exit\"");
			} else if ((args[0].equals("-h") || args[0].equals("-?") || args[0].equals("--help")) && (args.length != 1)) {
				System.out.println("Qualifier --help (-h, -?) should not appear with any command-line arguments.");
				synopsis();
			} else if (args[0].equals("-v") || args[0].equals("--verbose")) {
				Flags.setVerbose(true); //sets verbose mode in action
				System.out.println("Running in verbose mode...");		
				if ((args[1].contains(".jar"))) { /* TO ADD HERE - Kyle's stuff!! // the args[1] (aka the jar file) is valid */
					if (true) {			/* valid, check if the args[2] (aka the class) is valid */
						/* if args[2] is valid, ~ENTER COMPILER PROGRAM~ */
					
						//This will load the .jar file from arg[1] and load the classes from arg[2] in the .jar file
						load.loadJC(args[1], args[2]);
					
						mainStuff.mainMenu();
					} else {
						System.out.println("Could not find class: '" + inputAsArray[2]);
						synopsis();
					}
				} else {
					System.out.println("Could not find jar file: '" + inputAsArray[1]);
					synopsis();
				}
			} else {
				inputAsArray = args[0].toCharArray();
				if (Character.valueOf(inputAsArray[0]) == '-') {
					System.out.println("Unrecognized qualifier '" + inputAsArray[1] + "' in '" + args[0] + "'");
					synopsis();
				} else {
					System.out.println("Unrecognized qualifier '" + inputAsArray[0] + "' in '" + args[0] + "'");
					synopsis();
				}
			}
		} catch (Throwable e1){
			//If verbose is on it will print ut the stack trace of the given error 
			if (Flags.verboseOn) {
				//begins error
				Errors.beginError();
				//prints out specified stack trace from the given error
				e1.printStackTrace(System.out);
				//returns back to normal execution
				mainStuff.mainMenu();
			}
			//returns back to normal execution if verbose mode is off 
			mainStuff.mainMenu();
		}
		//otherwise returns back to normal execution
		mainStuff.mainMenu();
		
    }
	

	public static void synopsis() {
		System.out.println("Synopsis:\n  methods\n  methods { -h | -? | --help }+\n  methods {-v --verbose}* <jar-file> [<class-name>]");
		System.out.println("Arguments:\n  <jar-file>:   The .jar file that contains the class to load (see next line).\n  <class-name>: The fully qualified class name containing public static command methods to call. [Default=\"Commands\"]");
		System.out.println("Qualifiers:\n  -v --verbose: Print out detailed errors, warnings, and tracking.\n  -h -? --help: Print out a detailed help message.");
		System.out.println("Single-char qualifiers may be grouped; long qualifiers may be truncated to unique prefixes and are not case sensitive.");
		return;
	}
	
	
	public static void functions() {
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
		return;
	}
		
	public static void nonFatalError() {
		// whatever is enclosed by the <>, will be changed later once we get the logic to do so
		// will update for the future 
		System.out.println("Matching function for <function type> not found at offset <offset-number>\n"
				+ "<specific function>\n"
				+ "-----------^\n"
				+ "\n java.text.ParseException: Matching function for <function type> not found\n"
				+ "\t at Excecution.execute(Execution)"
				+ "\t at Method.<init>(Method)"
				+ "\t at Method.main(Methods.blah)");
		return; 
	}
}
