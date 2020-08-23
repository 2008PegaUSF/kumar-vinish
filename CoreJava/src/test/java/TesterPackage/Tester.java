package TesterPackage;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import CoreJavaAssignment.Calculator;
import CoreJavaAssignment.MyMethods;
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
}
