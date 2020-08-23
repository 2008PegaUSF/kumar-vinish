package TesterPackage;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//import CoreJavaAssignment.Calculator;
import CoreJavaAssignment.*;
import Package2.Floats;

public class Tester {
	
	MyMethods o = new MyMethods();
	Calculator c = new Calculator();
	
	@Test
	public void testQ1() {
		int in[] = {8,3,5,4,1,0,2,6,9,7};
		int expected[] = {0,1,2,3,4,5,6,7,8,9};
		o.q1(in);
		Assertions.assertTrue(Arrays.equals(expected, in));
	}
	
	@Test
	public void testQ2() {
		int n = 25;
		int expected[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368};
		o.q2(n);
		Assertions.assertTrue(Arrays.equals(expected, o.q2(n)));
	}
	
	@Test
	public void testQ3() {
		char[] charArray1 = {'o', 't', 'a', 't', 'o', 'p'};
		String a = new String(charArray1);
		char[] charArray2 = o.q3("potato");
		String b = new String(charArray2);
		Assertions.assertEquals(a, b);
	}
	
	@Test
	public void testQ4() {
		int n = 6;
		int expected = 720;
		int actual = o.q4(n);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ5() {
		char[] charArray1 = {'p', 'o', 't'};
		String expected = new String(charArray1);
		char[] charArray2 = o.q5("potato", 3);
		String actual = new String(charArray2);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ6() {
		int a = 246;
		String expected = "Number is even!";
		String actual = o.q6(a);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ7() {
		
	}
	
	@Test
	public void testQ8() {
		
	}
	
	@Test
	public void testQ9() {
		
	}
	
	@Test
	public void testQ10() {
		int a = 5;
		String expected = "Minimum value is " + a;
		String actual = o.q10(5, 9);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ11() {
		float a = 2.25f;
		float b = 6.13f;
		String expected = "Floats from Package2.Floats: " + a + " and " + b;
		String actual = o.q11();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ12() {
		
	}
	
	@Test
	public void testQ13() {
		
	}
	
	@Test
	public void testQ14() {
		
	}
	
	@Test
	public void testQ15Add() {
		double expected = 15;
		double actual = c.add(6, 9);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ15Subtract() {
		double expected = -16;
		double actual = c.subtract(4, 20);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ15Multiply() {
		double expected = 28980;
		double actual = c.multiply(420, 69);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ15Divide() {
		double expected = 11;
		double actual = c.divide(66, 6);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ16() {
		
	}
	
	@Test
	public void testQ17() {
		double expected = 1250;
		double actual = o.q17Tester(5000, 5, 5);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ18() {
		
	}
	
	@Test
	public void testQ19() {
		
	}
	
	@Test
	public void testQ20() {
		
	}
} 
