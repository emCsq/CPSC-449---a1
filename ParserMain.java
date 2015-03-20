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
			} else if (((args[0].equals("-v") || args[0].equals("--verbose")) && args[1].contains(".jar") && args.length == 3)
					|| (args[0].equals("-v") || args[0].equals("--verbose")) && args[1].contains(".jar") && args.length == 2){
				Flags.setVerbose(true);
				System.out.println("Running in verbose mode...");		
				if (jarValid(args[1])) { // Check if jar file is valid
					if (args.length == 2) {  // Check if defaulted "Commands" class is in the jar file
						if (classValid(args[1], "Commands")) {
							load.loadJC(args[1], "Commands");
							mainStuff.mainMenu();
						} else {
							System.out.println("Could not find class: Commands");
						}
					} else {
						if (classValid(args[1], args[2])) { // Check if class argument is in the jar file
							load.loadJC(args[1], args[2]);
							mainStuff.mainMenu();
						} else {
							System.out.println("Could not find class: " + args[2]);
						}
					}
				} else {
					System.out.println("Could not find jar file: " + args[1]);
				}
			} else if ((args[0].contains(".jar") && args.length == 2) || (args[0].contains(".jar") && args.length == 1)) {
				Flags.setVerbose(false);
				if (jarValid(args[0])) { // Check if jar file is valid
					if (args.length == 1) { // Check if defaulted "Commands" class is in the jar file
						if (classValid(args[0], "Commands")) {
							load.loadJC(args[0], "Commands");
							mainStuff.mainMenu();
						} else {
							System.out.println("Could not find class: Commands");
						}
					} else {
						if (classValid(args[0], args[1])) { // Check if class argument is in the jar file
							load.loadJC(args[0], args[1]);
							mainStuff.mainMenu();
						} else {
							System.out.println("Could not find class: " + args[1]);
						}
					}
				} else {
					System.out.println("Could not find jar file: " + args[0]);
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
	
	/**
	 * Checks if jar file is in the class path and is valid
	 * @param jarName is the name of the jar file
	 * @return true if jar file is acceptable, false otherwise
	 * Based on one of the answers from http://stackoverflow.com/questions/20152195/how-to-check-if-a-jar-file-is-valid
	 */
	public static boolean jarValid(String jarName) {
		try {
	        JarFile jarFile = new JarFile(jarName);
	        Enumeration<? extends ZipEntry> e = jarFile.entries();
	        while(e.hasMoreElements()) {
	            ZipEntry entry = e.nextElement();
	            //System.out.println(entry.getName());
	        }
	        return true;
	    } catch(Exception ex) {
	        return false;
	    }
	}
	
	/**
	 * Checks if class is in the jar file and is valid
	 * @param jarName is the name of the jar file, className is the name of the class
	 * @return true if class is acceptable, false otherwise
	 * Based on one of the answers from http://stackoverflow.com/questions/11016092/how-to-load-classes-at-runtime-from-a-folder-or-jar
	 */
	public static boolean classValid(String jarName, String className) {
		try {
			JarFile jarFile = new JarFile(jarName);
			Enumeration e = jarFile.entries();
			URL[] urls = { new URL("jar:file:" + jarName + "!/") };
			URLClassLoader cl = URLClassLoader.newInstance(urls);
		    while (e.hasMoreElements()) {
		        JarEntry je = (JarEntry) e.nextElement();
		        if(je.isDirectory() || !je.getName().endsWith(".class")){
		            continue;
		        }
		        // -6 because of .class
		        String classes = je.getName().substring(0,je.getName().length()-6);
		        classes = classes.replace('/', '.');
		        if(classes.equals(className)) {
		        	return true;
		        }
		    }
		    return false;
		} catch(Exception ex) {
			return false;
		}
	}
	
}
