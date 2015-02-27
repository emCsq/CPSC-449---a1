public class Trees {

	public boolean sign(char a) {
		
		if (a == '+'){
			return true;
		} else if (a == '-'){
			return true;
		} else {
			return false; 
		}
	}
		
	public boolean digit(String a) {
		String pattern = "^[0-9]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;
	}
	
	public boolean alpha(String a) {
		String pattern = "^[_a-zA-z]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;	
	}
	
	public boolean alphaNum(String a){
		if (digit(a)){
			return true; 
		} else if (alpha(a)){
			return true;
		} else {
			return false; 
		}
	}
	
	public boolean isChar(String a){
		return false;
	}
	
	public boolean whiteSpace(String a){
		String pattern = "^[''\t]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;
	}
}
