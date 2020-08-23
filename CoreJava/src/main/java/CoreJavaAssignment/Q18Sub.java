package CoreJavaAssignment;

public class Q18Sub extends Q18Super{
	public boolean hasUpperCase(String string) {
		char[] charArray = string.toCharArray();
		for(int i=0; i<charArray.length; i++) {
			if(Character.isUpperCase(charArray[i])) {
				//System.out.println("This string has uppercase letters.");
				return true;
			}
		}
		//System.out.println("This string does not have uppercase letters.");
		return false;
	}
	
	public String changeToUpperCase(String string) {
		String toUpperCase = string.toUpperCase();
		//System.out.println(toUpperCase);
		return toUpperCase;
	}
	
	public int add10(String stringNumber) {
		int intNumber = Integer.parseInt(stringNumber);
		int add10 = intNumber + 10;
		//System.out.println(add10);
		return add10;
	}
}
