package CoreJavaAssignment;

public class MyMethods {
	
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
	
	public void displayArray(int array[]) {
		int arrayLength = array.length; 
        for (int i=0; i<arrayLength; i++) {
        	System.out.print(array[i] + " "); 
        }
        System.out.println(); 
	}
	
	//Question 2: Display First 25 Fibonacci Numbers
	public void q2(int numberOfFibs) {
		int a = 0;
		int b = 1;
		for(int i=1; i<=numberOfFibs; i++) {
			System.out.println(b);
			int nextFib = a+b;
			a=b;
			b=nextFib;
			
		}
	}
	
	//Question 3: Reverse a string without a temporary variable
	public void q3(String s) {
		//Create character array and input string
		char[] string = s.toCharArray();
		//Use for loop to print array from last element to first element, hence "reversing" the string
		for(int i = string.length; i > 0; i--) {
			System.out.print(string[i-1]);
		}
	}
	
	//Question 4: Find N Factorial
	public void q4(int n) {
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
		System.out.println(factorial);
	}
	
	//Question 5: Accept a string and an index and return a substring between 0 and index-1
	public void q5(String str, Integer idx) {
		//Create character array and input string
		char[] string = str.toCharArray();
		//Use loop to print substring from index 0 to index idx-1
		for(int i=0; i<idx; i++) {
			System.out.print(string[i]);
		}
	}
	
	//Question 6: Determine if a number is even without using the modulus operator
	public void q6(int i) {
		//divide initial number by 2
		int a = i/2;
		//multiply result by 2
		int b = a*2;
		//dividing an odd integer by 2 and multiplying result by 2 will give a different number (i-1) than original due to truncation of integer values when they have decimals
		//dividing an even integer by 2 and multiplying result by 2 will give original number
		//this if statement uses this logic to determine whether or not the original number is even or odd
		if(b == i) {
			System.out.println("Number is even!");
		} else {
			System.out.println("Number is odd!");
		}
	}
	
	//Question 7: Use Comparator interface to sort two employees based on name, department, and age
	
	
	//Question 8: Store strings in an ArrayList and save palindromes in a different ArrayList
	
	
	//Question 9: Create an ArrayList with numbers 1-100 and print out all primes
	
	
	//Question 10: Find the minimum of two numbers using ternary operators
	public void q10(int a, int b) {
		int minimumValue;
		minimumValue = (a < b) ? a : b;
		System.out.println("Minimum value is " + minimumValue);
	}
	
	//Question 11: Access two float-variables from a class in another package
	
	
	//Question 12: Store numbers 1-100 in an array and print out all even numbers using enhanced for loop
	
	
	//Question 13: Display triangle of 0's and 1's, do not use group of print statements
	
	
	//Question 14: Demonstrate a switch case
	
	
	//Question 15: Define an interface with math operators, implement them in a different class
	
	
	//Question 16: Display number of characters in a string input, string should be entered using (String [] args)
	
	
	//Question 17: Calculate interest using principal, rate, and time entered with Scanner class
	
	
	//Question 18: Write a program using a subclass that inherits from a superclass
	
	
	//Question 19: Create ArrayList, insert numbers 1-10, display the ArrayList, display sum of even numbers, display sum of odd numbers, and remove prime numbers and display ArrayList again
	
	
	//Question 20: Read from Data.txt file and print out information to screen
}
