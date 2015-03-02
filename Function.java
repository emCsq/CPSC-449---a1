package a2;

public class Functions {

	public Trees tree;

	public Functions()
	{
		tree = new Trees();
	}
	
	public String add(String a, String b) {		
		if ((a == null) || (b == null)){
			return "null"; 
		}
		
		String ans = null;
		if (tree.isString(a) && tree.isString(b)) {
			ans = a.concat(b);
		}
		return ans;
	}
	
	
	public float add(float a, float b) {		
		if (tree.isFloat(Float.toString(a)) && tree.isFloat(Float.toString(b))) {
			return a+b; 
		}
		return -1; 
	}
	
	public int add(int a, int b) {
		if (tree.isInteger(Integer.toString(a)) && tree.isInteger(Integer.toString(b))) {
			return a+b; 
		}
		return -1; 
	}
	
	public float sub(float a, float b) {
		if (tree.isFloat(Float.toString(a)) && tree.isFloat(Float.toString(b))) {
			return a-b; 
		}
		return -1; 
	}
	public int sub(int a, int b) {
		if (tree.isInteger(Integer.toString(a)) && tree.isInteger(Integer.toString(b))) {
			return a-b; 
		}
		return -1; 
	}
	
	public int div(int a, int b) {
		if (tree.isInteger(Integer.toString(a)) && tree.isInteger(Integer.toString(b))) {
			return a/b; 
		}
		return -1; 
	}
	public float div(float a, float b) {
		if (tree.isFloat(Float.toString(a)) && tree.isFloat(Float.toString(b))) {
			return a/b; 
		}
		return -1; 
	}
	
	public int mul(int a, int b) {
		if (tree.isInteger(Integer.toString(a)) && tree.isInteger(Integer.toString(b))) {
			return a*b; 
		}
		return -1; 
	}
	public float mul(float a, float b) {
		if (tree.isFloat(Float.toString(a)) && tree.isFloat(Float.toString(b))) {
			return a*b; 
		}
		return -1; 
	}
	
	public int inc(int a) {
		if (tree.isInteger(Integer.toString(a))){
			return a+1;
		}
		return -1;
	}
	public float inc(float a) {
		if (tree.isFloat(Float.toString(a))){
			return a+1;
		}
		return -1;
	}
	
	public int dec(int a) {
		if (tree.isInteger(Integer.toString(a))){
			return a-1;
		}
		return -1;
	}
	public float dec(float a) {
		if (tree.isFloat(Float.toString(a))){
			return a-1;
		}
		return -1;
	}
	
	public int len(String a) {
		return a.length();
	}


}
