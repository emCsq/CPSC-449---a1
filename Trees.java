package a2;
public class Trees {

	
	public Trees() {
		
	}
	
	// expr	:=	funcall | value
	public boolean expr(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< expr() >>>");
		}
		
		if ((funcall(a) || value(a)))
			return true;
		return false;
	}
	
	// funcall	:=	( identifier { expr }* )
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
	
	
	// identifier	:=	alpha { alphanum }*
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
	
	// value	:=	integer | float | string
	public boolean value(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< value() >>>");
		}
		
		if ((isInteger(a) || isFloat(a) || isString(a)))
			return true;
		return false;
	}
	
	// integer :=	sign { digit }+ { . }~
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
	
	// float :=	sign { digit }+ .  { digit }*
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

	// string := " { char }* "
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
	
	// alpha := a..z|A..Z|_
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
	
	// alphanum := alpha|digit
	public boolean alphaNum(String a){
		//if verbose is on, track code
		if (Flags.verboseOn) {
			System.out.println("<<< alphaNum() >>>");
		}
		
		if (alpha(a) || digit(a))
			return true;
		return false;
	}
	
	// char := <any character>
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
	
	// sign := nothing|+|-
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
	
	// digit := 0..9
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
	
	// whitespace := {''|tab}+
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
