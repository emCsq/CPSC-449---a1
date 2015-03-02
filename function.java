package a2;

public class Functions {

	public Trees tree;

	public String add(String a, String b) {
		String ans = null;
		if (tree.isString(a) && tree.isString(b)) {
			ans = a + b;
		}
		return ans;
	}
	
	public float add(float a, float b) {
		return 0;
	}
	
	public int add(int a, int b) {
		return 0;
	}
	
	public float sub(float a, float b) {
		return 0;
	}
	public int sub(int a, int b) {
		return 0;
	}
	
	public String div(int a, int b) {
		return null;
	}
	public String div(float a, float b) {
		return null;
	}
	
	public String mul(int a, int b) {
		return null;
	}
	public String mul(float a, float b) {
		return null;
	}
	
	public String inc(int a) {
		return null;
	}
	public String inc(float a) {
		return null;
	}
	
	public String dec(int a) {
		return null;
	}
	public String dec(float a) {
		return null;
	}
	
	public String len(int a) {
		return null;
	}


}
