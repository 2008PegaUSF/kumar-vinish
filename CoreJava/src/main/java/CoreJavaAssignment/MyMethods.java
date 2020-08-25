package CoreJavaAssignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import Package2.Floats;

public class MyMethods {
	
	//conversion of integer array to string for Fibonacci method
	public String IntegerArrayToString(int arr[]) {
		//opening bracket of array
		String s = "[";
		//loop through each element of array using index
		for(int i = 0; i < arr.length; i++) {
			//append element at index i to string
			s = s + arr[i];
			//separate elements using commas, no comma after last element
			if(i < arr.length-1) {
				s += ", ";
			}
		}
		//closing bracket of array
		s = s + "]";
		//return string
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
	
	//method to print integer array to console
	public void displayArray(int array[]) {
		//assign array length to integer
		int arrayLength = array.length; 
		//loop to print each integer separated by spaces
		for (int i=0; i<arrayLength; i++) {
        	System.out.print(array[i] + " "); 
		}
		//go to next line
		System.out.println(); 
	}
	
	//Question 2: Display First 25 Fibonacci Numbers
	public int[] q2(int numberOfFibs) {
		//create two integers to store first two Fibonacci numbers
		int a = 0;
		int b = 1;
		//create array to store all Fibonacci numbers
		int fib[] = new int[numberOfFibs];
		//store first two Fibonacci values
		fib[0] = 0;
		fib[1] = 1;
		//loop for rest of Fibonacci values
		for(int i=2; i<numberOfFibs; i++) {
			//add previous values to find next Fibonacci number
			int nextFib = a+b;
			//store current highest Fib value to current second highest Fib value
			a=b;
			//store new highest Fib value to current highest Fib value
			b=nextFib;
			//store new current highest Fib value to Fib array
			fib[i] = b;
		}
		//print Fib array to console and return array
		System.out.println(IntegerArrayToString(fib));
		return fib;
	}
	
	//Question 3: Reverse a string without a temporary variable
	public char[] q3(String s) {
		//Create character array and store input string
		char[] string = s.toCharArray();
		//Create character array to store reversed string
		char[] reversed = new char[string.length];
		int a = 0;
		//Use for loop to print array from last element to first element, hence "reversing" the string, and store reversed string in second char array
		for(int i = string.length; i > 0; i--) {
			reversed[a] = string[i-1];
			System.out.print(reversed[a]);
			a++;
		}
		//return reversed string
		//System.out.println(reversed.toString());
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
		//print and return factorial
		System.out.println(factorial);
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
			System.out.print(string[i]);
			substring[a] = string[i];
			a++;
		}
		System.out.println();
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
			System.out.println(even);
			return even;
		} else {
			String odd = "Number is odd!";
			System.out.println(odd);
			return odd;
		}
	}
	
	//Question 7: Use Comparator interface to sort two employees based on name, department, and age
	//Methods implemented in Employee classes and Q7Driver
	
	//Question 8: Store strings in an ArrayList and save palindromes in a different ArrayList
	public ArrayList<String> q8() {
		//store strings in array list
		ArrayList<String> original = new ArrayList<String>(Arrays.asList("karan", "madam", "tom", "civic", "radar", "jimmy", "kayak", "john", "refer", "billy", "did"));
		//create array list to store reversed strings
		ArrayList<String> reversed = new ArrayList<String>();
		//create array list to store palindromes
		ArrayList<String> palindromes = new ArrayList<String>();
		//loop to reverse strings and store palindromes in correct array list
		for(int i=0; i<original.size(); i++) {
			//create string builder
			StringBuilder reversedStringBuilder = new StringBuilder();
			//store original string to string builders
			reversedStringBuilder.append(original.get(i));
			//reverse string
			reversedStringBuilder = reversedStringBuilder.reverse();
			//turn reversed string builder into string
			String reversedString = reversedStringBuilder.toString();
			//add reversed string to reversed array list
			reversed.add(reversedString);
			//if reversed string is same as original, store string in palindromes array list
			if(reversed.get(i).equals(original.get(i))) {
				palindromes.add(reversed.get(i));
			}
		}
		//print and return palindromes array list
		System.out.println(palindromes);
		return palindromes;
	}
	
	//Question 9: Create an ArrayList with numbers 1-100 and print out all primes
	public ArrayList<Integer> q9() {
		//create array lists for all numbers and only prime numbers
		ArrayList<Integer> array = new ArrayList<Integer>();
		ArrayList<Integer> primes = new ArrayList<Integer>();
		//loop to add numbers 1-100 to first array list
		for(int i=1; i<101; i++) {
			array.add(i);
		}
		//loop to determine if number is prime and if so, copy number into primes array list
		for(int j=1; j<100; j++) {
			int a = array.get(j);
			boolean isPrime = true;
			//handle isPrime for 1
			if(a==1){
				isPrime = false;
			} 
			//handle isPrime for 2
			else if(a==2) {
				isPrime = true;
			}
			//handle isPrime for 3-100
			else {
				//divide number by every number from 2 to that number, if modulus is ever 0, number is not prime
				for(int k=2; k<a; k++) {
					if(a%k == 0) {
						isPrime = false;
					} 
				}
			}
			//add number to primes array list if number is prime
			if(isPrime == true) {
				//System.out.println(a);
				primes.add(a);			
			}
		}
		//print and return primes array list
		System.out.println(primes);
		return primes;
	}
	
	//Question 10: Find the minimum of two numbers using ternary operators
	public String q10(int a, int b) {
		int minimumValue;
		//use ternary operator to determine minimum, a represents statement inside parentheses being true, b represents false
		minimumValue = (a < b) ? a : b;
		//print and return minimum value
		System.out.println("Minimum value is " + minimumValue);
		String minimum = "Minimum value is " + minimumValue;
		return minimum;
	}
	
	//Question 11: Access two float-variables from a class in another package
	public String q11() {
		//create two floats to store floats from Package2.Floats
		float a = Floats.a;
		float b = Floats.b;
		//print and return floats
		String floats = "Floats from Package2.Floats: " + a + " and " + b;
		System.out.println(floats);
		return floats;
	}
	
	//Question 12: Store numbers 1-100 in an array and print out all even numbers using enhanced for loop
	public ArrayList<Integer> q12() {
		//create array and array list to store all numbers and all even numbers
		int[] array = new int[100];
		ArrayList<Integer> evens = new ArrayList<Integer>();
		//add numbers 1-100 to array
		for(int i=0; i<100; i++) {
			array[i] = i+1;
		}
		//use enhanced for loop to determine if even
		for(int number : array) {
			if(number % 2 == 0) {
				//add number to array list if even
				evens.add(number);
			}
		}
		//print and return evens array list
		System.out.println(evens);
		return evens;
	}
	
	//Question 13: Display triangle of 0's and 1's, do not use group of print statements
	public String q13() {
		int a=0;
		//create string to store integers
		String triangle = new String();
		//outer loop handles moving from one line to next in console
		for(int i=0; i<4; i++) {
			//inner loop handles integers printed on each line
			for(int j=0; j<=i; j++) {
				//order of integers printed is 0,1,0,1,0...
				//assign current integer to temp string
				String current = a + " ";
				//adds temp string to cumulative string
				triangle = triangle + current;
				System.out.print(a + " ");
				//according to pattern; alternates between 0 and 1
				if(a==0) {
					a++;
				} else {
					a--;
				}
			}
			System.out.println("");
		}
		//returns string without triangle pattern for testing purposes, triangle pattern printed within for loops
		return triangle;
	} 
	
	//Question 14: Demonstrate a switch case
	public void q14() {
		//creates console scanner
		Scanner q14Scanner = new Scanner(System.in);
		System.out.println("Enter Case Number: 1, 2, or 3");
		//reads user input
		int scannerInput = q14Scanner.nextInt();
		//switch case
		switch(scannerInput) {
			//if user enters 1...
			case 1:
				Scanner q14Case1Scanner = new Scanner(System.in);
				System.out.println("Find square root of:");
				//reads user input
				int num = q14Case1Scanner.nextInt();
				//takes square root of number entered by user
				System.out.println(Math.sqrt(num));
				//ends switch case
				break;
			case 2:
				//creates and prints localDate object
				LocalDate todaysDate = LocalDate.now();
				System.out.println(todaysDate);
				//ends switch case
				break;
			case 3:
				//creates string
				String learning = "I am learning Core Java";
				//splits string at each space
				String[] learningArray = learning.split(" ");
				//turns array into string and prints string
				System.out.println(Arrays.toString(learningArray));
				//ends switch case
				break;
		}
	}
	
	//same as switch case 1, used for testing
	public double q14Case1Tester(int square) {
		return Math.sqrt(square);
	}
	
	//same as switch case 2, used for testing
	public LocalDate q14Case2Tester() {
		LocalDate todaysDate = LocalDate.now();
		return todaysDate;
	}
	
	//same as switch case 3, used for testing
	public String q14Case3Tester() {
		String learning = "I am learning Core Java";
		String[] learningArray = learning.split(" ");
		return Arrays.toString(learningArray);
	}
	
	//Question 15: Define an interface with math operators, implement them in a different class
	//Methods implemented in Calculator class
	
	//Question 16: Display number of characters in a string input, string should be entered using (String [] args)
	public int q16(String string) {
		//finds length of input string
		int length = string.length();
		//prints and returns string length
		System.out.println(length);
		return length;
	}
	
	//Question 17: Calculate interest using principal, rate, and time entered with Scanner class
	public double q17() {
		//creates scanner to read console input
		Scanner q17Scanner = new Scanner(System.in);
		System.out.println("Interest Calculator");
		System.out.println("What is your principal?");
		//reads user input and stores as double for principal 
		double principal = q17Scanner.nextDouble();
		System.out.println("What is your percent interest rate?");
		//reads user input and stores as double for rate
		double rate = q17Scanner.nextDouble();
		System.out.println("How many years has your interest been accumulating?");
		//reads user input and stores as double for time
		double time = q17Scanner.nextDouble();
		double adjustedRate = rate/100;
		//stores calculated interest in interest
		double interest = principal*adjustedRate*time;
		//prints and returns interest
		System.out.println("Your accumulated interest is " + interest);
		return interest;
	}
	
	//same as above, used for testing
	public double q17Tester(double principal, double rate, double time) {
		double adjustedRate = rate/100;
		double interest = principal*adjustedRate*time;
		return interest;
	}
	
	//Question 18: Write a program using a subclass that inherits from a superclass
	//Methods and Driver implemented in Q18Super, Q18Sub, and Q18Driver classes
	
	//Question 19: Create ArrayList, insert numbers 1-10, display the ArrayList, display sum of even numbers, display sum of odd numbers, and remove prime numbers and display ArrayList again
	public void q19() {
		//creates array list and integers to store all numbers, even sum, and odd sum
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
		int evenSum = 0;
		int oddSum = 0;
		//adds numbers 1-10 to array
		for(int i=0; i<10; i++) {
			integerArray.add(i+1);
		}
		//for loop to determine even sum and odd sum
		for(int j=0; j<integerArray.size(); j++) {
			//if number is even, added to even sum integer
			if(integerArray.get(j)%2 == 0) {
				evenSum = evenSum + integerArray.get(j);
			} 
			//if number is odd, added to odd sum integer
			else {
				oddSum = oddSum + integerArray.get(j);
			}
		}
		//prints original array list, even sum, and odd sum
		System.out.println("Original ArrayList: " + integerArray);
		System.out.println("Sum of Even Numbers: " + evenSum);
		System.out.println("Sum of Odd Numbers: " + oddSum);
		//for loop to remove prime numbers
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
			//removes prime numbers from array list, k-- so no elements in array list are skipped
			if(isPrime == true) {
				integerArray.remove(k);
				k--;
			}
		}
		//print array list with primes removed
		System.out.println("ArrayList after removing prime numbers: " + integerArray);
	}
	
	//same as above, returns even sum, used for testing
	public int q19ReturnEvenSum() {
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
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
		//System.out.println("Original ArrayList: " + integerArray);
		//System.out.println("Sum of Even Numbers: " + evenSum);
		//System.out.println("Sum of Odd Numbers: " + oddSum);
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
		return evenSum;
		//System.out.println("ArrayList after removing prime numbers: " + integerArray);
	}
	
	//same as above, returns odd sum, used for testing
	public int q19ReturnOddSum() {
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
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
		//System.out.println("Original ArrayList: " + integerArray);
		//System.out.println("Sum of Even Numbers: " + evenSum);
		//System.out.println("Sum of Odd Numbers: " + oddSum);
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
		return oddSum;
		//System.out.println("ArrayList after removing prime numbers: " + integerArray);
	}
	
	//same as above, returns array with primes removed, used for testing
	public ArrayList<Integer> q19ReturnNoPrimesArray() {
		ArrayList<Integer> integerArray = new ArrayList<Integer>();
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
		//System.out.println("Original ArrayList: " + integerArray);
		//System.out.println("Sum of Even Numbers: " + evenSum);
		//System.out.println("Sum of Odd Numbers: " + oddSum);
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
		return integerArray;
		//System.out.println("ArrayList after removing prime numbers: " + integerArray);
	}
	
	//Question 20: Read from Data.txt file and print out information to screen
	//exception thrown if file with input path does not exist
	public String q20(String path) throws FileNotFoundException {
		//create file to store data from file path
		File information = new File(path);
		//create scanner to read file
		Scanner infoScanner = new Scanner(information);
		String print = new String();
		//loop to print out info in proper format, while loop used to ensure there is data to be read
		while(infoScanner.hasNextLine()) {
			//reads next line in scanner and stores to string
			String rawInfo = infoScanner.nextLine();
			//splits string at every ":"
			String[] storedInfo = rawInfo.split(":");
			//stores formatted info to print string
			print = print + "Name: " + storedInfo[0] + " " + storedInfo[1] +"\n" + "Age: " + storedInfo[2] +" years" + "\n" + "State: " + storedInfo[3] + " State" + "\n" + "\n";
			//System.out.println("Name: " + categorizedInfo[0] + " " + categorizedInfo[1]);
			//System.out.println("Age: " + categorizedInfo[2] + " years");
			//System.out.println("State: " + categorizedInfo[3] + " State");
			//System.out.println("");
		}
		//prints and returns print string
		System.out.println(print);
		return print;
	}
}
