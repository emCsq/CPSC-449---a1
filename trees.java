
public class Trees {

	public Boolean sign(char a) {
		
		if (a == '+'){
			return true;
		} else if (a == '-'){
			return true;
		} else {
			return false; 
		}
	}
		
	public Boolean digit(String a) {
		String pattern = "^[0-9]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;
	}
	
	//https://tr.im/VMTsA
	public Boolean alpha(String a) {
		String pattern = "^[_a-zA-z]*$";
			if (a.matches(pattern)){
				return true;
			}
			return false;	
	}
	
	//https://tr.im/VMTsA
	public boolean alphaNum(String a){
		String pattern = "^[a-zA-Z0-9]*$";
			if(a.matches(pattern)){
				return true;
			}
			return false; 
	}
}
