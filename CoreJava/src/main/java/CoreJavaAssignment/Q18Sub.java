package CoreJavaAssignment;

//subclass of Q18Super, defines all abstract methods from Q18Super
public class Q18Sub extends Q18Super{
	public boolean hasUpperCase(String string) {
		//turns input string into char array
		char[] charArray = string.toCharArray();
		//for loop goes through all characters in the string
		for(int i=0; i<charArray.length; i++) {
			//if any character is upper case, returns true
			if(Character.isUpperCase(charArray[i])) {
				//System.out.println("This string has uppercase letters.");
				return true;
			}
		}
		//if no characters are upper case, returns false
		//System.out.println("This string does not have uppercase letters.");
		return false;
	}
	
	public String changeToUpperCase(String string) {
		//makes all string characters upper case and returns new string
		String toUpperCase = string.toUpperCase();
		//System.out.println(toUpperCase);
		return toUpperCase;
	}
	
	public int add10(String stringNumber) {
		//turns string into integer
		int intNumber = Integer.parseInt(stringNumber);
		//adds 10 to new integer and returns that number
		int add10 = intNumber + 10;
		//System.out.println(add10);
		return add10;
	}
}
