package CoreJavaAssignmentClasses;

public class BasicMethods {
	
	//Question 2: Display First 25 Fibonacci Numbers
	
	
	//Question 4: Find N Factorial
	void q4(int n){
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
	
	
}
