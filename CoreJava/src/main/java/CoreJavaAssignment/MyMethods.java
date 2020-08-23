package CoreJavaAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Package2.Floats;

public class MyMethods {
	
	private String IntArrayToString(int arr[]) {
		String s = "[";
		
		for(int i = 0; i < arr.length; i++) {
			s += arr[i];
			if(i < arr.length-1) {
				s += ", ";
			}
		}
		s += "]";
		return s;
	}
	
	//Question 1: Bubble Sort
	public void q1(int unsortedArray[]) {
		//find length of array
		int length = unsortedArray.length;
		//nested for loop
		//loop to determine number of bubble sort iterations necessary
		for(int i=0; i < length-1; i++) {
			//loop to set start and end indices of values to be compared for each bubble sort iteration 
			for(int j=0; j<length-1-i; j++) {
				//swap values if current value is greater than next value
				if(unsortedArray[j] > unsortedArray[j+1]) {
					int a = unsortedArray[j];
					unsortedArray[j] = unsortedArray[j+1];
					unsortedArray[j+1] = a;
				}
			}
		}
	}
	
	//
	public void displayArray(int array[]) {
		int arrayLength = array.length; 
		for (int i=0; i<arrayLength; i++) {
        	System.out.print(array[i] + " "); 
		}
		System.out.println(); 
	}
	
	//Question 2: Display First 25 Fibonacci Numbers
	public int[] q2(int numberOfFibs) {
		int a = 0;
		int b = 1;
		int fib[] = new int[numberOfFibs];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2; i<numberOfFibs; i++) {
			int nextFib = a+b;
			a=b;
			b=nextFib;
			fib[i] = b;
		}
		//System.out.println(IntArrayToString(fib));
		return fib;
	}
	
	//Question 3: Reverse a string without a temporary variable
	public char[] q3(String s) {
		//Create character array and input string
		char[] string = s.toCharArray();
		char[] reversed = new char[string.length];
		int a = 0;
		//Use for loop to print array from last element to first element, hence "reversing" the string
		for(int i = string.length; i > 0; i--) {
			reversed[a] = string[i-1];
			a++;
		}
		return reversed;
	}
	
	//Question 4: Find N Factorial
	public int q4(int n) {
		int factorial = 1;
		//Handle factorial for 0! and 1!
		if(n==0 || n==1) {
			factorial = 1;
		} else {
			//Handle factorial for n >= 2
			for(int i=1; i<n; i++) {
				factorial = factorial*(i+1);
			}
		}
		//System.out.println(factorial);
		return factorial;
	}
	
	//Question 5: Accept a string and an index and return a substring between 0 and index-1
	public char[] q5(String str, Integer idx) {
		//Create character array and input string
		char[] string = str.toCharArray();
		//Use loop to print substring from index 0 to index idx-1
		char[] substring = new char[idx];
		int a = 0;
		for(int i=0; i<idx; i++) {
			//System.out.print(string[i]);
			substring[a] = string[i];
			a++;
		}
		return substring;
	}
	
	//Question 6: Determine if a number is even without using the modulus operator
	public String q6(int i) {
		//divide initial number by 2
		int a = i/2;
		//multiply result by 2
		int b = a*2;
		//dividing an odd integer by 2 and multiplying result by 2 will give a different number (i-1) than original due to truncation of integer values when they have decimals
		//dividing an even integer by 2 and multiplying result by 2 will give original number
		//this if statement uses this logic to determine whether or not the original number is even or odd
		if(b == i) {
			String even = "Number is even!";
			return even;
		} else {
			String odd = "Number is odd!";
			return odd;
		}
	}
	
	//Question 7: Use Comparator interface to sort two employees based on name, department, and age
	
	
	//Question 8: Store strings in an ArrayList and save palindromes in a different ArrayList
	public void q8() {
		ArrayList<String> original = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"));
		ArrayList<String> reversed = new ArrayList<String>();
		ArrayList<String> palindromes = new ArrayList<String>();
		for(int i=0; i<original.size(); i++) {
			StringBuilder reversedStringBuilder = new StringBuilder();
			reversedStringBuilder.append(original.get(i));
			reversedStringBuilder = reversedStringBuilder.reverse();
			String reversedString = reversedStringBuilder.toString();
			reversed.add(reversedString);
			if(reversed.get(i).equals(original.get(i))) {
				palindromes.add(reversed.get(i));
			}
		}
		System.out.println(palindromes);
	}
	
	//Question 9: Create an ArrayList with numbers 1-100 and print out all primes
	public void q9() {
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i=1; i<101; i++) {
			array.add(i);
		}
		for(int j=1; j<100; j++) {
			int a = array.get(j);
			boolean isPrime = true;
			if(a==1){
				isPrime = false;
			} else if(a==2) {
				isPrime = true;
			} else {
				for(int k=2; k<a; k++) {
					if(a%k == 0) {
						isPrime = false;
					} 
				}
			}
			if(isPrime == true) {
				System.out.println(a);
			}
		}
		//System.out.println(array);
	}
	
	//Question 10: Find the minimum of two numbers using ternary operators
	public String q10(int a, int b) {
		int minimumValue;
		minimumValue = (a < b) ? a : b;
		//System.out.println("Minimum value is " + minimumValue);
		String minimum = "Minimum value is " + minimumValue;
		return minimum;
	}
	
	//Question 11: Access two float-variables from a class in another package
	public String q11() {
		float a = Floats.a;
		float b = Floats.b;
		String floats = "Floats from Package2.Floats: " + a + " and " + b;
		return floats;
	}
	
	//Question 12: Store numbers 1-100 in an array and print out all even numbers using enhanced for loop
	public void q12() {
		int[] array1 = new int[100];
		for(int i=0; i<100; i++) {
			array1[i] = i+1;
		}
		for(int number : array1) {
			if(number % 2 == 0) {
				System.out.println(number);
			}
		}
	}
	
	//Question 13: Display triangle of 0's and 1's, do not use group of print statements
	
	
	//Question 14: Demonstrate a switch case
	public void q14() {
		Scanner q14Scanner = new Scanner(System.in);
		System.out.println("Enter Case Number: 1, 2, or 3");
		int scannerInput = q14Scanner.nextInt();
		switch(scannerInput) {
			case 1:
				Scanner q14Case1Scanner = new Scanner(System.in);
				System.out.println("Find square root of:");
				int num = q14Case1Scanner.nextInt();
				System.out.println(Math.sqrt(num));
				break;
			case 2:
				LocalDate todaysDate = LocalDate.now();
				System.out.println(todaysDate);
				break;
			case 3:
				String learning = "I am learning Core Java";
				String[] learningArray = learning.split(" ");
				for(int i=0; i<learningArray.length; i++) {
					System.out.println(learningArray[i]);
				}
				System.out.println("String split successfully");
		}
	}
	
	//Question 15: Define an interface with math operators, implement them in a different class
	//Methods implemented in Calculator class
	
	//Question 16: Display number of characters in a string input, string should be entered using (String [] args)
	
	
	//Question 17: Calculate interest using principal, rate, and time entered with Scanner class
	public double q17() {
		Scanner q17Scanner = new Scanner(System.in);
		System.out.println("Interest Calculator");
		System.out.println("What is your principal?");
		double principal = q17Scanner.nextDouble();
		System.out.println("What is your percent interest rate?");
		double rate = q17Scanner.nextDouble();
		System.out.println("How many years has your interest been accumulating?");
		double time = q17Scanner.nextDouble();
		double adjustedRate = rate/100;
		double interest = principal*adjustedRate*time;
		System.out.println("Your accumulated interest is " + interest);
		return interest;
	}
	
	public double q17Tester(double principal, double rate, double time) {
		double adjustedRate = rate/100;
		double interest = principal*adjustedRate*time;
		return interest;
	}
	
	//Question 18: Write a program using a subclass that inherits from a superclass
	
	
	//Question 19: Create ArrayList, insert numbers 1-10, display the ArrayList, display sum of even numbers, display sum of odd numbers, and remove prime numbers and display ArrayList again
	public void q19() {
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		//ArrayList<Integer> evenIntegers = new ArrayList<Integer>();
		//ArrayList<Integer> oddIntegers = new ArrayList<Integer>();
		int evenSum = 0;
		int oddSum = 0;
		for(int i=0; i<10; i++) {
			integerArray.add(i+1);
		}
		for(int j=0; j<integerArray.size(); j++) {
			if(integerArray.get(j)%2 == 0) {
				evenSum = evenSum + integerArray.get(j);
			} else {
				oddSum = oddSum + integerArray.get(j);
			}
		}
		System.out.println("Original ArrayList: " + integerArray);
		System.out.println("Sum of Even Numbers: " + evenSum);
		System.out.println("Sum of Odd Numbers: " + oddSum);
		for(int k=0; k<integerArray.size(); k++) {
			int a = integerArray.get(k);
			boolean isPrime = true;
			if(a==1) {
				isPrime = false;
			} else if(a==2) {
				isPrime = true;
			} else {
				for(int b=2; b<a; b++) {
					if(a%b == 0) {
						isPrime = false;
					}
				}
			}
			if(isPrime == true) {
				integerArray.remove(k);
				k--;
			}
		}
		System.out.println("ArrayList after removing prime numbers: " + integerArray);
	}
	
	//Question 20: Read from Data.txt file and print out information to screen
	public void q20(String path) throws FileNotFoundException {
		File information = new File(path);
		Scanner infoScanner = new Scanner(information);
		while(infoScanner.hasNextLine()) {
			String rawInfo = infoScanner.nextLine();
			String[] categorizedInfo = rawInfo.split(":");
			System.out.println("Name: " + categorizedInfo[0] + " " + categorizedInfo[1]);
			System.out.println("Age: " + categorizedInfo[2] + " years");
			System.out.println("State: " + categorizedInfo[3] + " State");
			System.out.println("");
		}
	}
}
