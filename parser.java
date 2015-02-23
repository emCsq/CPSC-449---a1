import java.util.*;
import java.lang.*;
import java.text.*;

public class parser extends Commands {

	public static void main (String [] args){
    
		Scanner input = new Scanner(System.in);

		if (args.length == 0) {
			printOut();
		} else if ((args[0].equals("-h") || args[0].equals("-?") || args[0].equals("--help")) && (args.length == 1)) {
			printOut();
			System.out.println("\nThis program interprets commands of the format '(<method> {arg}*}' on the command line, finds corresponding methods in <class-name>, and executes them, printing the result to sysout. Terminate with ^D or \"exit\"");
		} else if ((args[0].equals("-h") || args[0].equals("-?") || args[0].equals("--help")) && (args.length != 1)) {
			System.out.println("Qualifier --help (-h, -?) should not appear with any command-line arguments.");
			printOut();
		} else if (args[0].equals("-v") || args[0].equals("--verbose")) {
			System.out.println("SOMETHING TO DO LATER ON");
		}  
		
    }
    
	public static void printOut() {
		System.out.println("Synopsis:\n  methods\n  methods { -h | -? | --help }+\n  methods {-v --verbose}* <jar-file> [<class-name>]");
		System.out.println("Arguments:\n  <jar-file>:   The .jar file that contains the class to load (see next line).\n  <class-name>: The fully qualified class name containing public static command methods to call. [Default=\"Commands\"]");
		System.out.println("Qualifiers:\n  -v --verbose: Print out detailed errors, warnings, and tracking.\n  -h -? --help: Print out a detailed help message.");
		System.out.println("Single-char qualifiers may be grouped; long qualifiers may be truncated to unique prefixes and are not case sensitive.");
		return;
	}
}
