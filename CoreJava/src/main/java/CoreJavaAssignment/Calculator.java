package CoreJavaAssignment;

//class implements ArithmeticOperations interface and defines all methods
public class Calculator implements ArithmeticOperations{

	//defines add method
	public double add(double a, double b) {
		double c = a + b;
		System.out.println(c);
		return c;
	}

	//defines subtract method
	public double subtract(double a, double b) {
		double c = a - b;
		System.out.println(c);
		return c;
	}

	//defines multiply method
	public double multiply(double a, double b) {
		double c = a * b;
		System.out.println(c);
		return c;
	}

	//defines divide method
	public double divide(double a, double b) {
		double c = a / b;
		System.out.println(c);
		return c;
	}
	
}
