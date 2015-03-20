package a2;
public class Trees {
	
	public Trees() {
		
	}
	
	/**
	 * expr	:=	funcall | value
	 * @param a expression to be evaluated
	 * @return a boolean value indicating whether it is a valid expression or not
	 */
	public boolean expr(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< expr() >>>");
		}
		
		if ((funcall(a) || value(a)))
			return true;
		return false;
	}
	
	/**
	 * funcall	:=	( identifier { expr }* )
	 * @param a the function call to be evaluated
	 * @return a boolean value indicating whether it is a valid function call or not
	 */
	public boolean funcall(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< funcall() >>>");
		}
		
		char[] s = a.toCharArray();
		if (identifier(Character.toString(s[0]))){
			for (int i = 0; i<=a.length(); i++) {
				if (!expr(Character.toString(s[i]))){
					return false;
				}
			}
		}
		return true;
	}
	
	
	/**
	 * identifier	:=	alpha { alphanum }*
	 * @param a the item to be identified
	 * @return a boolean value indicating whether or not the input is an identifier
	 */
	public boolean identifier(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< identifier() >>>");
		}
		
		char[] s = a.toCharArray();
		if (alpha(Character.toString(s[0]))){
			for (int i = 0; i<=a.length(); i++) {
				if (!alphaNum(Character.toString(s[i]))){
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * value	:=	integer | float | string
	 * @param a the input to be determined if it is a value or not
	 * @return a boolean value indicating whether or not the input is a value
	 */
	public boolean value(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< value() >>>");
		}
		
		if ((isInteger(a) || isFloat(a) || isString(a)))
			return true;
		return false;
	}
	
	/**
	 * integer :=	sign { digit }+ { . }~
	 * @param a a string that is to be determined whether or not is an integer
	 * @return a boolean value indicating whether or not the input is an integer
	 */
	public boolean isInteger(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< isInteger() >>>");
		}
		
		char[] s = a.toCharArray();
		if ((sign(s[0]) || digit(Character.toString(s[0])))){
			if (digit(a.substring(1))) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * float :=	sign { digit }+ .  { digit }*
	 * @param a a string that is to be determined whether or not is a float
	 * @return a boolean value indicating whether or not the input is a float
	 */
	public boolean isFloat(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< isFloat() >>>");
		}
		
		char[] s = a.toCharArray();
		if ((sign(s[0]) || digit(Character.toString(s[0])))){
			if (a.contains(".")) {
				int index = a.indexOf(".");
				if ((a.substring(0, index) + a.substring(index + 1)).contains(".")) {
					return false;
				} else if (sign(s[0]) && (s[1] == '.')) {
					return false;
				} else if (digit(a.substring(1, index) + a.substring(index + 1))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * string := " { char }* "
	 * @param a a string that is to be determined whether or not is a string
	 * @return a boolean value indicating whether or not the input is a string
	 */
	public boolean isString(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< isString() >>>");
		}
		
		char[] s = a.toCharArray();
		if ((s[0] == '\"') && (s[a.length()] == '\"')){
			for (int i = 0; i<=a.length(); i++) {
				if (!isChar(s[i])){
					return false;
				}
			}
		}
		return true;
	}	
	
	/**
	 * alpha := a..z|A..Z|_
	 * @param a a string that is to be determined whether or not is a letter
	 * @return a boolean value indicating whether or not the input is a letter
	 */
	public boolean alpha(String a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< alpha() >>>");
		}
		
		String pattern = "^[_a-zA-z]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;	
	}
	
	/**
	 * alphanum := alpha|digit
	 * @param a a string that is to be determined whether or not is a letter or digit
	 * @return a boolean value indicating whether or not the input is a letter or digit
	 */
	public boolean alphaNum(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< alphaNum() >>>");
		}
		
		if (alpha(a) || digit(a))
			return true;
		return false;
	}
	
	/**
	 * char := <any character>
	 * @param a a string that is to be determined whether or not is a char
	 * @return a boolean value indicating whether or not the input is a char
	 */
	public boolean isChar(char a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< isChar() >>>");
		}
		
		if (Character.isDefined(a)){
			return true;
		}
		return false;
	}
	
	/**
	 * sign := nothing|+|-
	 * @param a a string that is to be determined whether or not is a sign
	 * @return a boolean value indicating whether or not the input is a sign
	 */
	public boolean sign(char a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< sign() >>>");
		}
		
		if (a == '+'){
			return true;
		} else if (a == '-'){
			return true;
		} else {
			return false; 
		}
	}
	
	/**
	 * digit := 0..9
	 * @param a a string that is to be determined whether or not is a digit
	 * @return a boolean value indicating whether or not the input is a digit
	 */
	public boolean digit(String a) {
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< digit() >>>");
		}
		
		String pattern = "^[0-9]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;
	}
	
	/**
	 * whitespace := {''|tab}+
	 * @param a a string that is to be determined whether or not is any sort of whitespace
	 * @return a boolean value indicating whether or not the input is any sort of whitespace
	 */
	public boolean whiteSpace(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< whiteSpace() >>>");
		}
		
		String pattern = "^[''\t]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;
	}
	
	
}
