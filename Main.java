import java.util.Scanner;

public class Main {

	boolean keepRunningParser = true;
	String userInput = "";
	
	Scanner input = new Scanner(System.in);

	public Trees tree;
	public Functions function;

	public Main() {
		tree = new Trees();
		function = new Functions();
	}
	
	
	public void mainMenu() {
		startUp();
		while (keepRunningParser == true) {
			System.out.print("> ");
			userInput = input.nextLine();
			if (userInput.equals("q")) {	//'q' quits the program
				keepRunningParser = false;
			} else if (userInput.equals("f")) {	//'f' displays the functions available
				this.functions();
			} else {
				validBrackets = this.checkBrackets(userInput);
				if (validBrackets == false) {
					System.out.println("Matching braces error.");
				} else {
					this.checkNotQuitInput(userInput);
				}
			}
		}

	}

	public boolean checkBrackets (String userIn) {
		int balancedBraces = 0;
		char[] userIn_charArray = userIn.toCharArray();
		
		for (int i = 0; i < userIn_charArray.length; i++){
			if (userIn_charArray[i] == '(') {
				balancedBraces++;
			} else if (userIn_charArray[i] == ')') {
				balancedBraces--;
				if (balancedBraces < 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public void checkNotQuitInput(String userIn) {
		String concatResult = "";
		int stringLength = -9999999;
		int intResult = -9999999;
		float floatResult = -9999999;
		boolean arg1_Integer, arg2_Integer, arg1_Float, arg2_Float, arg1_String, arg2_String;
		
		String[] inArray = userIn.split(" ");

		//NOTE: inArray args are tentative in place of the legit arguments that will be from the tree	
		if (inArray.length == 3) {		//function arg1 arg2
			arg1_Integer = tree.isInteger(inArray[1]);	//check if arg1 is an Integer
			arg2_Integer = tree.isInteger(inArray[2]);	//check if arg2 is an Integer 
			arg1_Float = tree.isFloat(inArray[1]);		//check if arg1 is a Float
			arg2_Float = tree.isFloat(inArray[2]);		//check if arg2 is a Float
			arg1_String = tree.isString(inArray[1]);	//check if arg1 is a String
			arg2_String = tree.isString(inArray[2]);	//check if arg2 is a String 	

			if ((arg1_Integer == true) && (arg2_Integer == true)) {
				intResult = this.processTwoIntegers(inArray[0], Integer.parseInt(inArray[1]), Integer.parseInt(inArray[2]));
			} else if ((arg1_Float == true) && (arg2_Float == true)) {
				floatResult = this.processTwoFloats(inArray[0], Float.parseFloat(inArray[1]), Float.parseFloat(inArray[2]));
			} else if (((arg1_Float == true) && (arg2_Integer == true)) || ((arg1_Integer == true) && (arg2_Float == true))) {
				System.out.println("Incorrect argument types.");
			} else if ((arg1_String == true) && (arg2_String == true)) {
				concatResult = this.processStringConcat(inArray[1], inArray[2]);
			} else {
				System.out.println("Unexpected character encountered at offset."); //temp
			}
		} else if (inArray.length == 2) {	//function arg1
			arg1_Integer = tree.isInteger(inArray[1]);
			arg1_Float = tree.isFloat(inArray[1]);
			arg1_String = tree.isString(inArray[1]);
			
			if (arg1_Integer == true) {
				intResult = this.processOneInteger(inArray[0], Integer.parseInt(inArray[1]));
			} else if (arg1_Float == true) {
				floatResult = this.processOneFloat(inArray[0], Float.parseFloat(inArray[1]));
			} else if ((inArray[0].compareTo("len") == 0) && arg1_String == true) {
				stringLength = this.processStringLength(inArray[1]);
			} else {
				System.out.println("Unexpected character encountered at offset."); //temp
			}
		} else {
			System.out.println("FAIL"); //temp
		}
	
		//print out the FINAL result 
		if (intResult != -9999999) {
			System.out.println(intResult);
		} else if (floatResult != -9999999) {
			System.out.println(floatResult);	
		}else if (concatResult != "") {
			System.out.println(concatResult);
		} else if (stringLength != -9999999) {
			System.out.println(stringLength);
		}
		
	}

	public void startUp() {
		System.out.println("q \t : Quit the program.\n"
				+ "v \t : Toggle verbose mode (stack traces).\n"
				+ "f \t : List all known functions.\n"
				+ "? \t : Print this helpful text.\n"
				+ "<expression>: Evaluate the expression."
				+ "Expressions can be integers, floats, strings (surrounded in double quotes) or function\n"
				+ "calls of the form '(identifier {expression}*)'");
		return;
	} 
    
	public void functions() {
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
	}
	
	public int processTwoIntegers(String funct, int arg1, int arg2) {
		if (funct.compareTo("add") == 0) {
			return function.add(arg1, arg2);
		} else if (funct.compareTo("sub") == 0) {
			return function.sub(arg1, arg2);
		} else if (funct.compareTo("div") == 0) {
			return function.div(arg1, arg2);
		} else if (funct.compareTo("mul") == 0) {
			return function.mul(arg1, arg2);
		} else {
			return -1;
		}
	}
	
	public int processOneInteger(String funct, int arg1) {
		if (funct.compareTo("inc") == 0) {
			return function.inc(arg1);
		} else if (funct.compareTo("dec") == 0) {
			return function.dec(arg1);
		} else {
			return -1;
		}
	}	
	
	public float processTwoFloats(String funct, float arg1, float arg2) {
		if (funct.compareTo("add") == 0) {
			return function.add(arg1, arg2);
		} else if (funct.compareTo("sub") == 0) {
			return function.sub(arg1, arg2);
		} else if (funct.compareTo("div") == 0) {
			return function.div(arg1, arg2);
		} else if (funct.compareTo("mul") == 0) {
			return function.mul(arg1, arg2);
		} else {
			return -1;
		}
	}
	
	public float processOneFloat(String funct, float arg1) {
		if (funct.compareTo("inc") == 0) {
			return function.inc(arg1);
		} else if (funct.compareTo("dec") == 0) {
			return function.dec(arg1);
		} else {
			return -1;
		}
	}	
	
	
	public String processStringConcat(String arg1, String arg2) {
		return function.add(arg1, arg2);
	}
	
	public int processStringLength(String arg1) {
		return function.len(arg1);
	}
	
}
