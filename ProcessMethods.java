package a2;

public class ProcessMethods {
	
	public Trees tree;
	public Functions function;
	
	public ProcessMethods() {
		function = new Functions();
		tree = new Trees();
	}
	
	public String timeToEvaluateStuff (String userIn) {
		String concatResult = "";
		int stringLength = -9999999;
		int intResult = -9999999;
		float floatResult = -9999999;
		String[] inArray = userIn.split(" ");
		boolean arg1_Integer, arg2_Integer, arg1_Float, arg2_Float, arg1_String, arg2_String;
		
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
		}
		
		//return out the result of calculation 
		if ((intResult == 123456789) || (floatResult == 123456789) || (concatResult == null) || (stringLength == 123456789)) {
			return null;
		} else if (intResult != -9999999) {
			//System.out.println("intResult is " + intResult);
			return Integer.toString(intResult);
		} else if (floatResult != -9999999) {
			//System.out.println("floatResult is " + floatResult);
			return Float.toString(floatResult);	
		}else if (concatResult != "") {
			//System.out.println("concatResult is " + concatResult);
			return concatResult;
		} else if (stringLength != -9999999) {
			//System.out.println("stringLength is " + stringLength);
			return Integer.toString(stringLength);
		} else {
			return null;
		}
	}
	
	public int processTwoIntegers(String funct, int arg1, int arg2) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< processTwoIntegers() >>>");
		}		
		
		if (funct.compareTo("add") == 0) {
			return function.add(arg1, arg2);
		} else if (funct.compareTo("sub") == 0) {
			return function.sub(arg1, arg2);
		} else if (funct.compareTo("div") == 0) {
			return function.div(arg1, arg2);
		} else if (funct.compareTo("mul") == 0) {
			return function.mul(arg1, arg2);
		} else {
			return 123456789;
		}
	}
	
	public int processOneInteger(String funct, int arg1) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< processOneInteger() >>>");
		}
		
		if (funct.compareTo("inc") == 0) {
			return function.inc(arg1);
		} else if (funct.compareTo("dec") == 0) {
			return function.dec(arg1);
		} else {
			return 123456789;
		}
	}	
	
	public float processTwoFloats(String funct, float arg1, float arg2) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< processTwoFloats() >>>");
		}
		
		if (funct.compareTo("add") == 0) {
			return function.add(arg1, arg2);
		} else if (funct.compareTo("sub") == 0) {
			return function.sub(arg1, arg2);
		} else if (funct.compareTo("div") == 0) {
			return function.div(arg1, arg2);
		} else if (funct.compareTo("mul") == 0) {
			return function.mul(arg1, arg2);
		} else {
			return 123456789;
		}
	}
	
	public float processOneFloat(String funct, float arg1) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< processOneFloat() >>>");
		}
		
		if (funct.compareTo("inc") == 0) {
			return function.inc(arg1);
		} else if (funct.compareTo("dec") == 0) {
			return function.dec(arg1);
		} else {
			return 123456789;
		}
	}	
	
	public String processStringConcat(String arg1, String arg2) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< processStringConcat() >>>");
		}
		
		return function.add(arg1, arg2);
	}
	
	public int processStringLength(String arg1) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< processStringLength() >>>");
		}
		
		return function.len(arg1);
	}
	
	
}
