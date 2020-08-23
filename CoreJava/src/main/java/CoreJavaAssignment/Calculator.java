package CoreJavaAssignment;

public class Calculator implements ArithmeticOperations{

	public double add(double a, double b) {
		double c = a + b;
		//System.out.println(c);
		return c;
	}

	public double subtract(double a, double b) {
		double c = a - b;
		//System.out.println(c);
		return c;
	}

	public double multiply(double a, double b) {
		double c = a * b;
		//System.out.println(c);
		return c;
	}

	public double divide(double a, double b) {
		double c = a / b;
		//System.out.println(c);
		return c;
	}
	
}
