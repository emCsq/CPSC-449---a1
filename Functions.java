package a2;

public class Functions {
	
	/**
	 * Concatenates the two strings together. 
	 * @param a first string to concatenate
	 * @param b second string to concatenate
	 * @return the concatenated string
	 */
	public static String add(String a, String b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< String add() >>>");
		}
		
		return a.concat(b);
	}	
	
	/**
	 * Adds two floats together.
	 * @param a first float
	 * @param b second float
	 * @return summed float value
	 */
	public static float add(float a, float b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float add() >>>");
		}
		
		return a+b; 
	}
	
	/**
	 * Adds two integers together.
	 * @param a first integer
	 * @param b second integer
	 * @return summed integer value
	 */
	public static int add(int a, int b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int add() >>>");
		}
		
		return a+b; 
	}
	
	/**
	 * Subtracts two floats.
	 * @param a first float.
	 * @param b second float. 
	 * @return difference of float values
	 */
	public static float sub(float a, float b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float sub() >>>");
		}
		
		return a-b; 
	}
	
	/**
	 * Subtracts two integers
	 * @param a first integer
	 * @param b second integer
	 * @return difference of integer values
	 */
	public static int sub(int a, int b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int sub() >>>");
		}
		
		return a-b; 
	}
	
	/**
	 * Divides two integers.
	 * @param a first integer (dividend)
	 * @param b second integer (divisor)
	 * @return quotient of integer values
	 */
	public static int div(int a, int b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int div() >>>");
		}
		
		return a/b; 
	}
	
	/**
	 * Divides two floats.
	 * @param a first float (dividend)
	 * @param b second float (divisor)
	 * @return quotient of float values
	 */
	public static float div(float a, float b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float div() >>>");
		}
		
		return a/b; 
	}
	
	/**
	 * Multiplies two integers.
	 * @param a first integer
	 * @param b second integer
	 * @return product of integer values
	 */
	public static int mul(int a, int b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int mul() >>>");
		}
		
		return a*b; 
	}
	
	/**
	 * Multiplies two floats.
	 * @param a first float
	 * @param b second float
	 * @return product of float values
	 */
	public static float mul(float a, float b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float mul() >>>");
		}
		
		return a*b; 
	}
	
	/**
	 * Increments an integer value by 1.
	 * @param a the integer to be increased by 1
	 * @return the integer + 1
	 */
	public static int inc(int a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int inc() >>>");
		}
		
		return a+1;
	}
	
	/**
	 * Increments a float value by 1.
	 * @param a the float to be increased by 1
	 * @return the float + 1
	 */
	public static float inc(float a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float inc() >>>");
		}
		
		return a+1;
	}
	
	/**
	 * Decrements an integer value by 1.
	 * @param a the integer to be decreased by 1
	 * @return the integer - 1
	 */
	public static int dec(int a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int dec() >>>");
		}
		
		return a-1;
	}
	
	/**
	 * Decrements a float value by 1.
	 * @param a the float to be decreased by 1
	 * @return the float - 1
	 */
	public static float dec(float a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float dec() >>>");
		}
		
		return a-1;
	}
	
	/**
	 * Retrieves the length of a string.
	 * @param a the string of which we want the length of
	 * @return the integer count of the size of the input string.
	 */
	public static int len(String a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int len() >>>");
		}
		
		return a.length();
	}


}
