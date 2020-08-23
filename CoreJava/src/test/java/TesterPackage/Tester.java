package TesterPackage;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;

//import CoreJavaAssignment.Calculator;
import CoreJavaAssignment.*;
import Package2.Floats;

public class Tester {
	
	MyMethods o = new MyMethods();
	Calculator c = new Calculator();
	Q18Sub q18 = new Q18Sub();
	EmployeeCreator e1 = new EmployeeCreator("Vinish", "Software", 22);
	EmployeeCreator e2 = new EmployeeCreator("Ricardo", "Development", 23);
	
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
	public void testQ7Name() {
		EmployeeNameComparator enc = new EmployeeNameComparator();
		int actual = enc.compare(e1, e2);
		int expected = 4;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ7Department() {
		EmployeeDepartmentComparator edc = new EmployeeDepartmentComparator();
		int actual = edc.compare(e1, e2);
		int expected = 15;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ7Age() {
		EmployeeAgeComparator eac = new EmployeeAgeComparator();
		int actual = eac.compare(e1, e2);
		int expected = -1;
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ8() {
		ArrayList<String> expected = new ArrayList<String>(Arrays.asList("madam", "civic", "radar", "kayak", "refer", "did"));
		ArrayList<String> actual = new ArrayList<String>();
		actual = o.q8();
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void testQ9() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
		ArrayList<Integer> actual = new ArrayList<Integer>();
		actual = o.q9();
		assertArrayEquals(expected.toArray(), actual.toArray());
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
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 64, 66, 68, 70, 72, 74, 76, 78, 80, 82, 84, 86, 88, 90, 92, 94, 96, 98, 100));
		ArrayList<Integer> actual = new ArrayList<Integer>();
		actual = o.q12();
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void testQ13() {
		String expected = "0 1 0 1 0 1 0 1 0 1 ";
		String actual = o.q13();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ14Case1() {
		double expected = 3;
		double actual = o.q14Case1Tester(9);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ14Case2() {
		LocalDate expected = LocalDate.now();
		LocalDate actual = o.q14Case2Tester();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ14Case3() {
		String expected = "[I, am, learning, Core, Java]";
		String actual = o.q14Case3Tester();
		Assertions.assertEquals(expected, actual);
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
		int expected = 6;
		int actual = o.q16("potato");
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ17() {
		double expected = 1250;
		double actual = o.q17Tester(5000, 5, 5);
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ18HasUpperCase() {
		boolean expected = true;
		boolean actual = q18.hasUpperCase("Potato");
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ18ChangeToUpperCase() {
		String expected = "POTATO";
		String actual = q18.changeToUpperCase("Potato");
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ18Add10() {
		int expected = 69;
		int actual = q18.add10("59");
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ19EvenSum() {
		int expected = 30;
		int actual = o.q19ReturnEvenSum();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ19OddSum() {
		int expected = 25;
		int actual = o.q19ReturnOddSum();
		Assertions.assertEquals(expected, actual);
	}
	
	@Test
	public void testQ19NoPrimesArray() {
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1, 4, 6, 8, 9, 10));
		ArrayList<Integer> actual = new ArrayList<Integer>();
		actual = o.q19ReturnNoPrimesArray();
		assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void testQ20() {
		String expected = "Name: Mickey Mouse\n" + 
				"Age: 35 years\n" + 
				"State: Arizona State\n" + 
				"\n" + 
				"Name: Hulk Hogan\n" + 
				"Age: 50 years\n" + 
				"State: Virginia State\n" + 
				"\n" + 
				"Name: Roger Rabbit\n" + 
				"Age: 22 years\n" + 
				"State: California State\n" + 
				"\n" + 
				"Name: Wonder Woman\n" + 
				"Age: 18 years\n" + 
				"State: Montana State\n" +
				"\n";
		try{
			String actual = o.q20("Data.txt");
			Assertions.assertEquals(expected, actual);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
} 
