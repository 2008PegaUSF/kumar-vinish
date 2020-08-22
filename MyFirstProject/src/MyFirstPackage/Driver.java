package MyFirstPackage;

import java.util.Scanner;

public class Driver {
	
	public static void main(String[] args) {
		
	Scanner s = new Scanner(System.in);
	
	
	System.out.println("Login as:" + "\n" + "a) Customer" + "\n"
						+ "b) Employee"+"\n" + "c) Bank Admin" + "\n" 
						);//seed												
	String p = s.nextLine(); //stems out
	
		if (p.equals("Customer")) {//branch 1
			System.out.println("What would you like to do?"+"\n"
					+"a)Register"+ "\n"
					+ "b)Login to account" );
			String d = s.nextLine();
			
				if(d == "Register") {
					String uname = s.nextLine();
					System.out.println("Create New Username");
					
				
			}
				
			
			
		} else if(p == "employee") {//branch 2

		} else if(p == "bank admin") {//branch 3

		} else {
			
		}
	
	
	
	}
}
