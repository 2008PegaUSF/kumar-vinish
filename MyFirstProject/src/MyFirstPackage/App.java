package MyFirstPackage;

import java.util.Scanner;

public class App {
	
	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
	
		System.out.println("Login as:" + "\n" + "a) Customer" + "\n"
						+ "b) Employee"+"\n" + "c) Bank Admin" + "\n" 
						);//seed												
		String p = s.nextLine(); //stems out
		boolean startLoop = true;
		//while(startLoop) {
			switch(p) {
				case "a":  //branch 1
					System.out.println("What would you like to do?"+"\n"
							+"a)Register"+ "\n"
							+ "b)Login to account" );
					String c1 = s.nextLine();
					//String uname;
					//String pword;
					if( c1.equals("a")) {//branch 1a
						System.out.println("Create New Username:");
						String uname = s.nextLine();
						System.out.println("Create Password:");
						String pword = s.nextLine();
					} else if(c1.equals("b")) {//branch 1b
						System.out.println("Would you like to:" +"\n"+ "a) Apply for an account " + "\n"
										+ "b) Make a transaction");
						String c2 = s.nextLine();
						if(c2.equals("a")) {
							System.out.println("Type:" + "\n" + "a) Joint Account" + "\n" + "b) Account");
							String c2a = s.nextLine();
							if (c2a.equals("a")) { 
								//call apply4joint method
								System.out.println("Application for Joint Account sent");
							} else if (c2a.equals("b")) { 
								//call apply method
								System.out.println("Application for Account sent");
							}		
						} else if (c2.equals("b")) {
							System.out.println("Would you like to:" + "\n" + "a) Withdraw" + "\n" + "b) Deposit" 
												+"\n"+ "c) Transfer");
							String c2b = s.nextLine(); 
							if (c2b.contentEquals("a")) { 
								//call withdraw method
							} else if (c2b.equals("b")) { 
								//call deposit method
							} else if (c2b.equals("c")) {
								//call transfer method
							}	
						}
					}			
					break;
				
				case "b": //branch 2
					System.out.println("Login in to account" + "\n" + "What is your Username?");
					String eu = s.nextLine();
					System.out.println("What is your Password?");
					String ep = s.nextLine(); //conditional with hash map
					System.out.println("Would you like to:" +"\n"+ "a) View Customer Information " + "\n"
										+ "b) Approve or deny customer appliactions");
					String e1 = s.nextLine();
					if(e1.equals("a")) {
						System.out.println("Would you like to view:" +"\n"+ "a) Account Information" + "\n"
										+ "b) Personal Information" + "\n" + "c) Account Balances");
						String e2 = s.nextLine();
						if(e2.equals("a")) { 
							//call account info function
						} else if(e2.equals("b")) { 
							//call personal info function
						} else if(e2.equals("c")) {
							//call account balances function
						}
					} else if(e1.equals("b")) { 
						System.out.println("Would you like to:"+ "\n" + "a) Approve Account" + "\n" +
								"b) Deny Accounts");
						String d2b = s.nextLine();
						if (d2b.equals("a")) {
							//call approve account
							System.out.println("Account approve!");
						} else if(d2b.equals("b")) {
							System.out.println("Account denied!");
						}
					}
					break;
				case "c" : //branch 3
					System.out.println("Login in to account" + "\n" + "What is your Username?");
					String bu = s.nextLine();
					System.out.println("What is your Password?");
					String bp = s.nextLine(); //conditional with hash map
					System.out.println("a) View Accounts" + "\n" + "b) Edits Accounts" + "\n");
					String d1 = s.nextLine();
					if(d1.equals("a")) {
						//call method made for bank admin
					} else if(d1.contentEquals("b")) {
						System.out.println("Would you like to:"+ "\n" + "a) Approve/Deny Accounts" + "\n" +
										"b) Transaction" + "\n" +"c) Delete Accounts"	);
						String d2 = s.nextLine();
						if(d2.equals("a")) {
							System.out.println("Would you like to:"+ "\n" + "a) Approve Account" + "\n" +
									"b) Deny Accounts");
							String d2a = s.nextLine();
							if (d2a.equals("a")) { 
								//call approve account
								System.out.println("Account approve!");
							} else if(d2a.equals("b")){
								System.out.println("Account denied!");
							}
						} else if (d2.equals("b")) {
							System.out.println("Would you like to:" + "\n" + "a) Withdraw" + "\n" + "b) Deposit" 
									+"\n"+ "c) Transfer");
							String d3a = s.nextLine(); 
							if (d3a.contentEquals("a")) { 
								//call withdraw method
							} else if (d3a.equals("b")) {
								//call deposit method
							} else if (d3a.equals("c")) {
								//call transfer method
							}
						} else if (d2.equals("c")) {
							System.out.println("What account would you like to delete?");
							String d3b = s.nextLine(); 
							System.out.println("Account has been canceled");
					}
				}	
			}
		//}
	}
}