package CoreJavaAssignment;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Driver {

	public static void main(String[] args) {
		
		MyMethods o = new MyMethods();
		Calculator c = new Calculator();
		EmployeeNameComparator enc = new EmployeeNameComparator();
		EmployeeDepartmentComparator edc = new EmployeeDepartmentComparator();
		EmployeeAgeComparator eac = new EmployeeAgeComparator();
		
		//Question 1
		System.out.println("QUESTION 1 -- Bubble Sort");
		int[] array = {8,4,6,2,7,3,5};
		System.out.println("Bubble Sorted Array:");
		o.q1(array);
		o.displayArray(array);
		System.out.println("");
		
		//Question 2
		System.out.println("QUESTION 2 -- First 25 Fibonacci Numbers");
		o.q2(25);
		System.out.println("");
		
		//Question 3
		System.out.println("QUESTION 3 -- Reverse a string without a temp variable");
		System.out.println("Reverse of string 'hot potato':");
		o.q3("hot potato");
		System.out.println("");
		System.out.println("");
		
		//Question 4
		System.out.println("QUESTION 4 -- Find factorial of input number");
		System.out.print("Factorial of 4 is ");
		o.q4(4);
		System.out.println("");
		
		//Question 5
		System.out.println("QUESTION 5 -- Find substring of string from 0 to idx");
		System.out.println("Substring of string 'hot potato' w/ idx 6:");
		o.q5("hot potato", 6);
		System.out.println("");
		
		//Question 6
		System.out.println("QUESTION 6 -- Determine if number is even without modulus");
		System.out.println("Test for if 7 is odd:");
		o.q6(7);
		System.out.println("");
		
		//Question 7
		System.out.println("QUESTION 7: SEE 'Q7Driver' CLASS ---------------");
		//Methods and Driver implemented in Employee... classes and Q7Driver
		System.out.println("");
		
		//Question 8
		System.out.println("QUESTION 8 -- Store strings in one Array List and store palindromes in another");
		o.q8();
		System.out.println("");
		
		//Question 9
		System.out.println("QUESTION 9 -- Create Array List w/ numbers 1-100 and print primes");
		o.q9();
		System.out.println("");
		
		//Question 10
		System.out.println("QUESTION 10 -- Find minimum using ternary operators");
		System.out.println("Compare 5 and 9:");
		o.q10(5, 9);
		System.out.println("");
		
		//Question 11
		System.out.println("QUESTION 11 -- Access two floats from a different package");
		o.q11();
		System.out.println("");
		
		//Question 12
		System.out.println("QUESTION 12 -- Store numbers 1-100 in Array List and print all evens");
		System.out.println("All evens from 1 to 100:");
		o.q12();
		System.out.println("");
		
		//Question 13
		System.out.println("QUESTION 13 -- Triangle of 1's and 0's");
		o.q13();
		System.out.println("");
		
		//Question 14
		System.out.println("QUESTION 14 -- Switch cases");
		o.q14();
		System.out.println("");
		
		//Question 15
		System.out.println("QUESTION 15 -- Calculator operators implemented with interface");
		System.out.print("1 + 2 = ");
		c.add(1, 2);
		System.out.print("3 - 2 = ");
		c.subtract(3, 2);
		System.out.print("4 * 6 = ");
		c.multiply(4, 6);
		System.out.print("64 / 8 = ");
		c.divide(64, 8);
		System.out.println("");
		
		//Question 16
		System.out.println("QUESTION 16 -- Number of characters in a string from command line arguments");
		System.out.println("Number of characters in 'potato':");
		o.q16(args[0]);
		System.out.println("");
				
		//Question 17
		System.out.println("QUESTION 17 -- Interest calculator from principal, rate, and time");
		o.q17();
		System.out.println("");
		
		//Question 18
		System.out.println("QUESTION 18: SEE 'Q18Driver' CLASS ---------------");
		//Methods and Driver implemented in Q18Super, Q18Sub, and Q18Driver classes
		System.out.println("");
		
		//Question 19
		System.out.println("QUESTION 19 -- Array List w/ numbers 1-10, sum of evens, sum of odds, Array List w/ no primes");
		o.q19();
		System.out.println("");
		
		//Question 20
		System.out.println("QUESTION 20 -- Read and format data from exterior file");
		//try catch block used to ensure file is found before running method
		try{
			o.q20("Data.txt");
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
