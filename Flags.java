package a2;

/*
The sole purpose of this class is track if the program is in 
verbose mode or has encountered a non-fatal error.
*/

public class Flags {
	
	public static boolean verboseOn = false;

	//This gets the status of verboseOn
	public static boolean getVerbose() {
		return (verboseOn);
	}

	/*
	This will set when the user inidicates its use, all if not most classes 
	have verbose messages in each function to show its execution track
	*/
	public static void setVerbose(boolean onValue) {
		verboseOn = onValue;
	}

}
