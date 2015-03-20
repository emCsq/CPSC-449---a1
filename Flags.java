package a2;

/*
The sole purpose of this class is track if the program is in 
verbose mode or has encountered a non-fatal error.
*/

public class Flags {
	
	public static boolean verboseOn = false;

	/**
	 * This gets the status of verboseOn.
	 * @return the status of verboseOn; a boolean value.
	 */
	public static boolean getVerbose() {
		return (verboseOn);
	}

	
	/**
	 * This will set the boolean value of whether verbose mode is on or not
	 * when the user indicates its use. All if not most classes will 
	 * have verbose messages in each function to show its execution track.
	 * @param onValue the boolean value of whether verbose mode is on or not.
	 */
	public static void setVerbose(boolean onValue) {
		verboseOn = onValue;
	}

}
