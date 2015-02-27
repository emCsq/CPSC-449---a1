public class Trees {
	
	//TO DO
	// expr	:=	funcall | value
	public boolean expr(String a){
		return false;
	}	
	
	//TO DO
	// funcall	:=	( identifier { expr }* )
	public boolean funcall(String a){
		return false;
	}
	
	//TO DO
	// identifier	:=	alpha { alphanum }*
	public boolean identifier(String a){
		return false;
	}
	
	//TO DO
	// value	:=	integer | float | string
	public boolean value(String a){
		return false;
	}
	
	//TO DO
	// integer :=	sign { digit }+ { . }~
	public boolean isInteger(String a){
		return false;
	}
	
	//TO DO
	// float :=	sign { digit }+ .  { digit }*
	public boolean isFloat(String a){
		return false;
	}

	// string := " { char }* "
	public boolean isString(String a){
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
		String pattern = "^[_a-zA-z]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;	
	}
	
	// alphanum := alpha|digit
	public boolean alphaNum(String a){
		if (digit(a)){
			return true; 
		} else if (alpha(a)){
			return true;
		} else {
			return false; 
		}
	}
	
	// char := <any character>
	public boolean isChar(char a){
		if (Character.isDefined(a)){
			return true;
		}
		return false;
	}
	
	// sign := nothing|+|-
	public boolean sign(char a) {
		
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
		String pattern = "^[0-9]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;
	}
	
	// whitespace := {''|tab}+
	//PENDING TO DO ! 
	public boolean whiteSpace(String a){
		String pattern = "^[''\t]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;
	}
	
	
}
