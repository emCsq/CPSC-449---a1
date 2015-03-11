package a2;

/*
The sole purpose of this class is track if the program is in 
verbose mode or has encountered a non-fatal error.
*/

public class Flags {
	
	public static boolean verboseOn = false;
	public static boolean errorOn = false;

	public static boolean getVerbose() {
		return (verboseOn);
	}

	public static void setVerbose(boolean onValue) {
		verboseOn = onValue;
	}
	
	public static boolean getError() {
		return (errorOn);
	}

	public static void setError(boolean onValue) {
		errorOn = onValue;
	}
	

}
