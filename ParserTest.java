package a2;
import static org.junit.Assert.*;

import org.junit.Test;


public class ParserTest {

	Functions functionTest = new Functions();
	
	@Test
	public void testErrorCatch() throws Exception {
		
		String Exception = "(add 1 (mul 10. 5))";
		Exception EmptyStackException = null;
		Errors.errorCatch(EmptyStackException); 
	}
	
	@Test
	public void testAddString() {
		String addResult = functionTest.add("cat", "dog");
		System.out.println("testAddString()\n\tExpected result: catdog \t Real result: " + addResult);
	}
	
	@Test
	public void testAddFloat() {
		float addResult = functionTest.add((float)1.0, (float)2.0);
		System.out.println("testAddFloat()\n\tExpected result: 3.0 \t Real result: " + addResult);
	}
	
	@Test
	public void testAddInt() {
		int addResult = functionTest.add((int)1, (int)2);
		System.out.println("testAddInt()\n\tExpected result: 3 \t Real result: " + addResult);
	}
	
	@Test
	public void testSubFloat() {
		float subResult = functionTest.sub((float)1.0, (float)2.0);
		System.out.println("testSubFloat()\n\tExpected result: -1.0 \t Real result: " + subResult);
	}
	
	@Test
	public void testSubInt() {
		int subResult = functionTest.sub((int)1, (int)2);
		System.out.println ("testSubInt()\n\tExpected result: -1 \t Real result: " + subResult);
	}
	
	@Test
	public void testDivFloat() {
		float divResult = functionTest.div((float)1.0, (float)2.0);
		System.out.println("testDivFloat()\n\tExpected result: 0.5 \t Real result: " + divResult);
	}
	
	@Test
	public void testDivInt() {
		int divResult = functionTest.div((int)1, (int)2);
		System.out.println ("testDivInt()\n\tExpected result: 0 \t Real result: " + divResult);
	}
	
	@Test
	public void testMulFloat() {
		float mulResult = functionTest.mul((float)1.0, (float)2.0);
		System.out.println("testMulFloat()\n\tExpected result: 2.0 \t Real result: " + mulResult);
	}
	
	@Test
	public void testMulInt() {
		int mulResult = functionTest.mul((int)1, (int)2);
		System.out.println ("testMulInt()\n\tExpected result: 2 \t Real result: " + mulResult);
	}

	@Test
	public void testIncFloat() {
		float incResult = functionTest.inc((float)1.0);
		System.out.println("testIncFloat()\n\tExpected result: 2.0 \t Real result: " + incResult);
	}
	
	@Test
	public void testIncInt() {
		int incResult = functionTest.inc((int)1);
		System.out.println ("testIncFloat()\n\tExpected result: 2 \t Real result: " + incResult);
	}
	
	@Test
	public void testDecFloat() {
		float decResult = functionTest.dec((float)1.0);
		System.out.println("testDecFloat()\n\tExpected result: 0.0 \t Real result: " + decResult);
	}
	
	@Test
	public void testDecInt() {
		int decResult = functionTest.dec((int)1);
		System.out.println ("testDecInt()\n\tExpected result: 0 \t Real result: " + decResult);
	}
	
	@Test
	public void testLengthString() {
		int lenResult = functionTest.len("hello World");
		System.out.println ("testLengthString()\n\tExpected result: 11 \t Real result: " + lenResult);
	}
}
