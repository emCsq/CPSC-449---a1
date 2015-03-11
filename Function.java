public class Functions {
	
	public static String add(String a, String b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< String add() >>>");
		}
		
		return a.concat(b);
	}	
	
	public static float add(float a, float b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float add() >>>");
		}
		
		return a+b; 
	}
	
	public static int add(int a, int b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int add() >>>");
		}
		
		return a+b; 
	}
	
	public static float sub(float a, float b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float sub() >>>");
		}
		
		return a-b; 
	}
	
	public static int sub(int a, int b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int sub() >>>");
		}
		
		return a-b; 
	}
	
	public static int div(int a, int b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int div() >>>");
		}
		
		return a/b; 
	}
	
	public static float div(float a, float b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float div() >>>");
		}
		
		return a/b; 
	}
	
	public static int mul(int a, int b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int mul() >>>");
		}
		
		return a*b; 
	}
	
	public static float mul(float a, float b) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float mul() >>>");
		}
		
		return a*b; 
	}
	
	public static int inc(int a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int inc() >>>");
		}
		
		return a+1;
	}
	public static float inc(float a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float inc() >>>");
		}
		
		return a+1;
	}
	
	public static int dec(int a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int dec() >>>");
		}
		
		return a-1;
	}
	
	public static float dec(float a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< float dec() >>>");
		}
		
		return a-1;
	}
	
	public static int len(String a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< int len() >>>");
		}
		
		return a.length();
	}


}
