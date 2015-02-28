import java.util.Scanner;

public class MainPrompt {

	boolean keepRunningParser = true;
	String userInput;
	
	Scanner input = new Scanner(System.in);
	
	public void mainMenu() {
		startUp();
		while (keepRunningParser == true) {
			System.out.print(">");
			userInput = input.next();
			if (userInput.equals("q")) {
				keepRunningParser = false;
			}
		}

	}

	public void startUp() {
		//this is the additional last paragraph
		System.out.println("q \t : Quit the program.\n"
				+ "v \t : Toggle verbose mode (stack traces).\n"
				+ "f \t : List all known functions.\n"
				+ "? \t : Print this helpful text.\n"
				+ "<expression>: Evaluate the expression."
				+ "Expressions can be integers, floats, strings (surrounded in double quotes) or function\n"
				+ "calls of the form '(identifier {expression}*)'");
		return;
	} 
    
	
}
