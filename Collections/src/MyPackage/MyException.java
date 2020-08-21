package MyPackage;

public class MyException extends Exception{
	
	public MyException(String message){
		super(message);
	}
	
	public static String checkForNegative(int in) throws MyException {
		if(in < 0) {
			throw new MyException("No negativity in this house.");
		} else {
			return "Positivity rules!";
		}
	}
}
