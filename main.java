import java.util.Scanner;

public class main {

	boolean keepRunningParser = true;
	String userInput = "";
	
	Scanner input = new Scanner(System.in);

	public Trees tree;
	public Functions function;

	public main() {
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
				this.checkNotQuitInput(userInput);
			}
		}

	}
	
	public void checkNotQuitInput(String userIn) {
		if (userIn.startsWith("add")) {
			String[] addArray = userIn.split(" ");
			if (addArray.length != 3) {
				System.out.println("Unexpected character encountered at offset.");
			} else {	
				if ((addArray[1] == null) || (addArray[2] == null)){
					System.out.println("FAIL.");
				} else if (tree.isInteger(addArray[1]) && tree.isInteger(addArray[2])) {
					System.out.println(function.add(Integer.parseInt(addArray[1]), Integer.parseInt(addArray[2])));
				} else if (tree.isFloat(addArray[1]) && tree.isFloat(addArray[2])) {
					System.out.println(function.add(Float.parseFloat(addArray[1]), Float.parseFloat(addArray[2])));
				} else if (tree.isString(addArray[1]) && tree.isString(addArray[2])) {
					System.out.println(function.add(addArray[1], addArray[2]));
				} 
			}
		} else if (userIn.startsWith("sub")) {
			String[] subArray = userIn.split(" ");
			if (subArray.length != 3) {
				System.out.println("Unexpected character encountered at offset.");
			} else {
				if (tree.isInteger(subArray[1]) && tree.isInteger(subArray[2])) {
					System.out.println(function.sub(Integer.parseInt(subArray[1]), Integer.parseInt(subArray[2])));
				} else if (tree.isFloat(subArray[1]) && tree.isFloat(subArray[2])) {
					System.out.println(function.sub(Float.parseFloat(subArray[1]), Float.parseFloat(subArray[2])));
				} 
			}
		} else if (userIn.startsWith("div")) {
			String[] divArray = userIn.split(" ");
			if (divArray.length != 3) {
				System.out.println("Unexpected character encountered at offset.");
			} else {
				if (tree.isFloat(divArray[1]) && tree.isFloat(divArray[2])) {
					System.out.println(function.div(Float.parseFloat(divArray[1]), Float.parseFloat(divArray[2])));
				} else if (tree.isInteger(divArray[1]) && tree.isInteger(divArray[2])) {
					System.out.println(function.div(Integer.parseInt(divArray[1]), Integer.parseInt(divArray[2])));
				} 
			}
		} else if (userIn.startsWith("mul")) {
			String[] mulArray = userIn.split(" ");
			if (mulArray.length != 3) {
				System.out.println("Unexpected character encountered at offset.");
			} else {
				if (tree.isFloat(mulArray[1]) && tree.isFloat(mulArray[2])) {
					System.out.println(function.mul(Float.parseFloat(mulArray[1]), Float.parseFloat(mulArray[2])));
				} else if (tree.isInteger(mulArray[1]) && tree.isInteger(mulArray[2])) {
					System.out.println(function.mul(Integer.parseInt(mulArray[1]), Integer.parseInt(mulArray[2])));
				}
			}
		} else if (userIn.startsWith("inc")) {
			String[] incArray = userIn.split(" ");
			if (incArray.length != 2) {
				System.out.println("Unexpected character encountered at offset.");
			} else {
				if (tree.isFloat(incArray[1])) {
					System.out.println(function.inc(Float.parseFloat(incArray[1])));
				} else if (tree.isInteger(incArray[1])) {
					System.out.println(function.inc(Integer.parseInt(incArray[1])));
				}
			}
		} else if (userIn.startsWith("dec")) {
			String[] decArray = userIn.split(" ");
			if (decArray.length != 2) {
				System.out.println("Unexpected character encountered at offset.");
			} else {
				if (tree.isFloat(decArray[1])) {
					System.out.println(function.dec(Float.parseFloat(decArray[1])));
				} else if (tree.isInteger(decArray[1])) {
					System.out.println(function.dec(Integer.parseInt(decArray[1])));
				}
			}
		} else if (userIn.startsWith("len")) {
			String[] lenArray = userIn.split(" ");
			if (lenArray.length != 2) {
				System.out.println("Unexpected character encountered at offset.");
			} else {
				System.out.println(function.len(lenArray[1]));
			}
		} else {
				System.out.println("Matching function for '" + userIn + "' not found at offset 1.");
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
		return;
	}
	
}
