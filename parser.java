import java.util.*;
import java.lang.*;
import java.text.*;

public class parser extends Commands {

	public static void main (String [] args){
    
		Scanner input = new Scanner(System.in);		
		char[] inputAsArray;

		if (args.length == 0) {
			synopsis();
		} else if ((args[0].equals("-h") || args[0].equals("-?") || args[0].equals("--help")) && (args.length == 1)) {
			synopsis();
			System.out.println("\nThis program interprets commands of the format '(<method> {arg}*}' on the command line, finds corresponding methods in <class-name>, and executes them, printing the result to sysout. Terminate with ^D or \"exit\"");
		} else if ((args[0].equals("-h") || args[0].equals("-?") || args[0].equals("--help")) && (args.length != 1)) {
			System.out.println("Qualifier --help (-h, -?) should not appear with any command-line arguments.");
			synopsis();
		} else if (args[0].equals("-v") || args[0].equals("--verbose")) {
			System.out.println("SOMETHING TO DO LATER ON");
			if (/* the args[1] (aka the jar file) is valid */) {
				if (/* valid, check if the args[2] (aka the class) is valid */) {
					/* if args[2] is valid, ~ENTER COMPILER PROGRAM~
					MORE TO DO HERE!! */
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
		
    }
	
	public static void startUp() {
		//this is the additional last paragraph
		System.out.println("q \t : Quit the program.\n"
				+ "v \t : Toggle verbose mode (stack traces).\n"
				+ "f \t : List all known functions.\n"
				+ "? \t : Print this helpful text.\n"
				+ "<expression>: Evaluate the expression."
				+ "Expressions can be integers, floats, strings (surrounded in double quotes) or function\n"
				+ "calls of the form '(identifier {expression}*)'");
		return;
	} 
    
	public static void synopsis() {
		System.out.println("Synopsis:\n  methods\n  methods { -h | -? | --help }+\n  methods {-v --verbose}* <jar-file> [<class-name>]");
		System.out.println("Arguments:\n  <jar-file>:   The .jar file that contains the class to load (see next line).\n  <class-name>: The fully qualified class name containing public static command methods to call. [Default=\"Commands\"]");
		System.out.println("Qualifiers:\n  -v --verbose: Print out detailed errors, warnings, and tracking.\n  -h -? --help: Print out a detailed help message.");
		System.out.println("Single-char qualifiers may be grouped; long qualifiers may be truncated to unique prefixes and are not case sensitive.");
		return;
	}
	
	public static void helpCommandLine() {
		System.out.println("Synopsis:\n  methods\n  methods { -h | -? | --help }+\n  methods {-v --verbose}* <jar-file> [<class-name>]"
				+ "Arguments:\n  <jar-file>:   The .jar file that contains the class to load (see next line).\n  <class-name>: The fully qualified class name containing public static command methods to call. [Default=\"Commands\"]"
				+ "Qualifiers:\n  -v --verbose: Print out detailed errors, warnings, and tracking.\n  -h -? --help: Print out a detailed help message."
				+ "Single-char qualifiers may be grouped; long qualifiers may be truncated to unique prefixes and are not case sensitive.\n"
				+ "\nThis program interprets commands of the format '(<method> {arg}*)' on the command line, finds corresponding"
				+ "methods in <class-name>, and executes them, printing the result to sysout");
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
