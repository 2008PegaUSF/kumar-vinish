package bankingApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import beans.User;
import daoImpl.UserDaoImpl;

public class atm {
	
	//scanner class instantiated
	Scanner s = new Scanner(System.in);
	static Logger log = LogManager.getLogger(atm.class);
	//String uname;
	//String pw;
	//String U2;
	//String P2;
	//String lname;
	//String fname;
	//int funds;
	UserDaoImpl udi = new UserDaoImpl();
	
	//SerializationMethods o = new SerializationMethods();
	
	String BAun = "admin"; //hardcode BankAdmin Username
	String BApw = "adminpass"; //hardcode BankAdmin password
	
	String Eu = "Employee"; //hardcode Employee Username
	String Ep = "employeepass"; //hardcode Employee password
	
	//ArrayLists used to deserialize data to and then iterate over
	ArrayList<Customer> custList = new ArrayList<Customer>();  
	ArrayList<Application> appList = new ArrayList<Application>();
	ArrayList<JointApp> JappList = new ArrayList<JointApp>();
	ArrayList<User> userList = new ArrayList<User>();
	
	//method used to run our Bank Interface
	public void battery() {
		sys();
	}
	
	// The heart of our project is built using this if-else if-else branch
	public void sys() {
		
		Configurator.initialize(null, "log4j.xml");
		readfile(); //used to deserialize customer data
		//readApps(); //used to deserialize normal application data
		//readJA(); ////used to deserialize joint application data
		
		//Our "Seed" that begins our decision tree
		System.out.println("-------------------------------");
		System.out.println("Welcome to the Kumar Bank ATM.");
		System.out.println("-------------------------------");
		log.info("Entered Main Menu.");
		System.out.println("Are you a customer or an administrator?" + "\n" + "a) Customer" + "\n"
					+ "b) Bank Admin" + "\n" 
					);
		// input users decision into string variable and then use conditionals to branch out to either 3 Users
		String p = s.nextLine();
		
		//Branch 1: Customer
		if (p.equals("a"))  {
			//Register or login to user account
			log.info("Entered Customer Branch.");
			System.out.println("What would you like to do?"+"\n"
					+"a)Register"+ "\n"
					+ "b)Login" );
			//reads user input
			String c1 = s.nextLine();
			if(c1.equals("a")) {//branch 1a
				//asks for first name, last name, username, and password info
				log.info("Entered Customer Registration Branch.");
				System.out.println("What is your full name? Be sure to correctly capitalize both names.");
				String nameinput = s.nextLine();
				for(int i=0; i<custList.size(); i++) {
					if(nameinput.equals(custList.get(i).getFN())) {
						System.out.println("You already have an account.");
						System.out.println("For security purposes, please start from the main menu.");
						log.info("Attempted to register with existing account holder.");
						sys();
					}
				}
				System.out.println("Create New Username:");
				String unameinput = s.nextLine();
				for(int i=0; i<custList.size(); i++) {
					if(unameinput.equals(custList.get(i).getUN())) {
						System.out.println("This username is already in use. Please try again.");
						System.out.println("For security purposes, please start from the main menu.");
						log.info("Attempted to register with existing username.");
						sys();
					}
				}
				System.out.println("Create Password:");
				String pwinput = s.nextLine();
				
				//System.out.println("What is your last name?");
				//String lnameinput = s.nextLine();
				int funds = 0;
				Customer c = new Customer(nameinput, unameinput, pwinput, funds);
				custList.add(new Customer(nameinput, unameinput, pwinput, funds));
				writefile(custList);
				//System.out.println(custList);
				System.out.println("New user " + nameinput + " has been registered.");
				//SQL STATEMENT TO CREATE USER IN DB
				try {
					udi.makeNewUser(c);
					//System.out.println(udi.getUserList());
					log.info("New customer registered to database.");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				sys(); //recall the system
				
			} else if(c1.equals("b")) {//branch 1b
				log.info("Entered Customer Login Branch.");
				System.out.println("Input Username: ");
				//stores username to string variable
				String checkUname = s.nextLine();
				System.out.println("Input Password: ");
				//stores password to string variable
				String checkPwd = s.nextLine();
				for(int a=0; a<custList.size(); a++) {
					String pwCheck = custList.get(a).getPW();
					String userCheck = custList.get(a).getUN();
					if(pwCheck.equals(checkPwd) && userCheck.equals(checkUname)) {
						boolean loggedin = true;
						while(loggedin) {
							log.info("Logged in successfully.");
							//System.out.println("User Information");
							//System.out.println(custList.get(a));
							System.out.println("What would you like to do?" + "\n" + "a) View Account(s)" + 
												"\n" + "b) Create Another Account" + "\n" + "c) Delete Empty Account(s)" + 
												"\n" + "d) Make a Transaction" + "\n" + "e) Log Out");
							String c1b = s.nextLine();
							if(c1b.equals("a")) {
								log.info("Entered View Accounts Branch for Customer.");
								String fullname = custList.get(a).getFN();
								System.out.println(fullname + "'s Bank Accounts");
								try {
									System.out.println(udi.getUserAccounts(fullname));
									log.info("Customer accounts viewed.");
								} catch(SQLException e) {
									e.printStackTrace();
								}
							} else if (c1b.equals("b")) {
								log.info("Entered Customer Create Account Branch.");
								System.out.println("Create username for new account:");
								String newuser = s.nextLine();
								System.out.println("Create password for new account:");
								String newpass = s.nextLine();
								int newfunds = 0;
								Customer newc = new Customer(custList.get(a).getFN(), newuser, newpass, newfunds);
								custList.add(newc);
								writefile(custList);
								System.out.println("New account with username " + newuser + " has been registered.");
								//SQL STATEMENT TO CREATE USER IN DB
								try {
									udi.makeNewUser(newc);
									log.info("New customer account created.");
									//System.out.println(udi.getUserList());
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} else if (c1b.equals("c")) {
								log.info("Entered Customer Delete Accounts Branch.");
								String fullname = custList.get(a).getFN();
								System.out.println(fullname + "'s Bank Accounts");
								try {
									System.out.println(udi.getUserAccounts(fullname));
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								System.out.println("Enter in the username of the account you wish to delete. The account will only be deleted if the account balance is 0.");
								String deleted = s.nextLine();
								for(int i=0; i<custList.size(); i++) {
									if(deleted.equals(custList.get(i).getUN())) {
										if(custList.get(i).get$() == 0 && i!=a) {
											custList.remove(i);
											writefile(custList);
											System.out.println("This account has been deleted.");
											try {
												udi.deleteUserAccount(deleted);
												log.info("Customer account deleted successfully.");
											} catch(SQLException e){
												e.printStackTrace();
											}
										} else if (custList.get(i).get$() !=0){
											System.out.println("You have attempted to delete an account with money in it.");
											log.info("Attempted to delete account that was not empty.");
										} else if (i == a) {
											System.out.println("You cannot delete the account you are currently using.");
											log.info("Attempted to delete account currently in use.");
										}
									} /*else {
										System.out.println("There is no account with that username. Please log back in to try again.");
									}*/
								}
							} else if (c1b.equals("d")) {
								log.info("Entered Customer Transactions Branch.");
								boolean transactions = true;
								while(transactions) {
									//decide transaction type
									System.out.println("Would you like to:" + "\n" + "a) Withdraw" + "\n" + "b) Deposit" 
														+ "\n" + "c) Finish Making Transactions");
									String c2b = s.nextLine(); 
									if (c2b.contentEquals("a")) { 
										log.info("Entered Customer Withdrawals Branch.");
										//Withdrawal branch
										int $ = custList.get(a).get$(); 
										System.out.println("How much would you like to withdraw?"); 
										int less$ = Integer.parseInt(s.nextLine()); 
										//overdraft validation
										if(less$ <= $) {
											int newF = $ - less$;
											//replaces old funds with new funds
											custList.get(a).setFunds(newF);
											//Show remaining balance
											System.out.println("New Balance: $"+custList.get(a).get$());
											//saves new data to customer list
											writefile(custList);
											try {
												udi.transaction(newF, custList.get(a).getUN());
												log.info("Successful withdrawal.");
											} catch(SQLException e) {
												e.printStackTrace();
											}
										} else {
											//let them know they can't do overdrafts
											System.out.println("Overdraft alert: cannot withdraw more money than current balance."); 
											log.info("Attempted to withdraw more money than was available.");
											//sys();
										}
									} else if (c2b.equals("b")) { 
										//Deposit branch
										log.info("Entered Deposits Branch.");
										int $ = custList.get(a).get$(); //change funds to double
										System.out.println("How much would you like to Deposit?"); 
										int plus$ = Integer.parseInt(s.nextLine()); 
										int newF = $ + plus$;
										custList.get(a).setFunds(newF);
										System.out.println("New Balance: $"+custList.get(a).get$());
										writefile(custList);
										try {
											udi.transaction(newF, custList.get(a).getUN());
											log.info("Successful deposit.");
										} catch(SQLException e) {
											e.printStackTrace();
										}
									} else if (c2b.equals("c")) {
										transactions = false;
									}
								}
							} else if (c1b.equals("e")) {
								System.out.println("Thank you for choosing Kumar Bank. We hope to see you again soon!");
								log.info("Customer logged out.");
								loggedin = false;
							} else {
								System.out.println("Invalid Input. Please try again.");
								log.info("Invalid input.");
							}	
						} 
						sys();
					} 
				}
				System.out.println("Invalid login credentials. Please try again.");
				log.info("Invalid log in credentials.");
				sys();
		
			} else {
				System.out.println("Invalid input, try again.");
				log.info("Invalid input.");
				sys();
			}
		}
		
// Employee branch 2		
		
		/*else if(p.equals("b")) {
			//ask for employee info
	 		System.out.println("Login in to Employee Account" + "\n" + "What is your Username?");
	 		String eu = s.nextLine();
	 		System.out.println("What is your Password?");
	 		String ep = s.nextLine(); 
	 		//boolean shorthand operator used to validate user information
	 		if (eu.equals(Eu) && ep.equals(Ep)) {
	 			System.out.println("Would you like to:" +"\n"+ "a) View Customer Information" + "\n"
									+ "b) Approve or deny normal applications" + "\n" + "c) Approve or deny joint applications");
	 			String e1 = s.nextLine();
	 			if(e1.equals("a")) { //View Customer Information branch
	 				for (int i=0; i< custList.size(); i++){
	 					//iterates over custList and prints information
	 					System.out.println(custList.get(i) + "\n");
	 				}
	 				try {
	 					System.out.println(udi.getUserList());
	 				} catch(SQLException e) {
	 					e.printStackTrace();
	 				}
	 				sys();
	 			} else if(e1.equals("b")) { //Approve or deny normal applications branch
	 				System.out.println("List of Normal Accounts to be Approved:");
	 				//loops through and prints out list of all accounts to be approved with identifying number
	 				for(int i=0; i<appList.size(); i++) {
						System.out.println(i+1 + ": " + appList.get(i));
					}
					System.out.print('\n');
	 				System.out.println("Would you like to:"+ "\n" + "a) Approve Normal Accounts" + "\n" +
	 						"b) Deny Normal Accounts");
	 				String d2b = s.nextLine();
	 				if (d2b.equals("a")) { // approve normal accounts branch
	 					//use identifying numbers from prior console print out to identify which application to accept
	 					System.out.println("Enter the number of the account you want to approve from the list above. Enter 0 if you don't want to approve any accounts.");
	 					int n = Integer.parseInt(s.nextLine());
	 					//create employee object
	 					Employee e = new Employee();
	 					ArrayList<Application> newApproved = new ArrayList<Application>();
	 					//employee object calls approve application method, assigns newly approved application to array list
	 					newApproved = e.approveApplication(appList, n);
	 					//serializes new list of pending applications
	 					writeApps(appList);
	 					//ensures there is an newly approved account to retrieve info from
	 					if(!newApproved.isEmpty()) {
	 						//use getter methods to take application data and create a new customer
	 						Customer newUser = new Customer(newApproved.get(0).getF1(), newApproved.get(0).getL1(), newApproved.get(0).getU1(), newApproved.get(0).getP1(), newApproved.get(0).getFunds());
		 					//adds new customer to comprehensive customer list
	 						custList.add(newUser);
	 						//serializes updated customer list
		 					writefile(custList);
	 					}
	 					
	 				} else if(d2b.equals("b")){ //deny normal accounts branch
	 					//use identifying numbers from prior console print out to identify which application to deny
	 					System.out.println("Enter the number of the account you want to deny from the list above. Enter 0 if you don't want to deny any accounts.");
	 					int n = Integer.parseInt(s.nextLine());
	 					//create employee object
	 					Employee e = new Employee();
	 					//ArrayList<Application> newDenied = new ArrayList<Application>();
	 					//remove denied application from pending applications
	 					e.denyApplication(appList, n);
	 					//serialize updated app list
	 					writeApps(appList);
	 				} 
	 			} else if (e1.equals("c")) { // joint account approval/denial branch, methods work similarly to normal accounts, except uses Japplist instead of applist since different application types have different implementations
	 				System.out.println("List of Joint Accounts to be Approved:");
					for(int i=0; i<JappList.size(); i++) {
						System.out.println(i+1 + ": " + JappList.get(i));
					}
					System.out.print('\n');
	 				System.out.println("Would you like to:"+ "\n" + "a) Approve Joint Accounts" + "\n" +
	 						"b) Deny Joint Accounts");
	 				String d2b = s.nextLine();
	 				if (d2b.equals("a")) {
	 					//call approve account
	 					System.out.println("Enter the number of the account you want to approve from the list above. Enter 0 if you don't want to approve any accounts.");
	 					int n = Integer.parseInt(s.nextLine());
	 					Employee e = new Employee();
	 					ArrayList<JointApp> newApproved = new ArrayList<JointApp>();
	 					newApproved = e.approveJointApplication(JappList, n);
	 					writeJA(JappList);
	 					Customer newUser = new Customer(newApproved.get(0).getfl1(), newApproved.get(0).getfl2(), newApproved.get(0).getUname(), newApproved.get(0).getPW(), newApproved.get(0).getFunds());
	 					custList.add(newUser);
	 					writefile(custList);
	 				} else if(d2b.equals("b")){
	 					//call deny method
	 					System.out.println("Enter the number of the account you want to deny from the list above. Enter 0 if you don't want to deny any accounts.");
	 					int n = Integer.parseInt(s.nextLine());
	 					Employee e = new Employee();
	 					//ArrayList<JointApp> newDenied = new ArrayList<JointApp>();
	 					e.denyJointApplication(JappList, n);
	 					writeJA(JappList);
	 				} 
	 			} else { //if input from scanner is not valid
	 				System.out.println("Invalid input, try again.");
	 			}
	 			sys();
	 		} else { // protects employee account from those without knowledge of password
	 			System.out.println("Invalid Login Information!");
	 		}
	 		sys();
		}*/
		
 // Bank Admin branch 3	
		
		else if(p.equals("b")) {
			log.info("Entered Admin Branch.");
			//login info for Bank Admin
			System.out.println("Login in to account" + "\n" + "What is your Username?");
			String bu = s.nextLine();
			System.out.println("What is your Password?");
			String bp = s.nextLine(); 
			// validates login input, bank admin actions can only be done inside this if block
			if (bu.equals(BAun) && bp.equals(BApw)) {
				log.info("Successful admin log in.");
				System.out.println("a) View Users" + "\n" + "b) Create User" + "\n" + "c) Update User" + "\n" + "d) Delete User");
				String d1 = s.nextLine();
				if(d1.equals("a")) {
					try {
						System.out.println(udi.getUserList());
						log.info("Successfully viewed all users.");
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if(d1.equals("b")){ 
					System.out.println("What is the user's full name? Be sure to correctly capitalize both names.");
					String nameinput = s.nextLine();
					for(int i=0; i<custList.size(); i++) {
						if(nameinput.equals(custList.get(i).getFN())) {
							System.out.println("This user already has an account.");
							System.out.println("For security purposes, please start from the main menu.");
							sys();
						}
					}
					System.out.println("Create New Username:");
					String unameinput = s.nextLine();
					for(int i=0; i<custList.size(); i++) {
						if(unameinput.equals(custList.get(i).getUN())) {
							System.out.println("This username is already in use. Please try again.");
							System.out.println("For security purposes, please start from the main menu.");
							sys();
						}
					}
					System.out.println("Create Password:");
					String pwinput = s.nextLine();
					int funds = 0;
					Customer c = new Customer(nameinput, unameinput, pwinput, funds);
					custList.add(new Customer(nameinput, unameinput, pwinput, funds));
					writefile(custList);
					//System.out.println(custList);
					System.out.println("New user " + nameinput + " has been registered.");
					//SQL STATEMENT TO CREATE USER IN DB
					try {
						udi.makeNewUser(c);
						log.info("Successfully made new user.");
						//System.out.println(udi.getUserList());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else if(d1.equals("c")) {
					log.info("Entered update user branch.");
					System.out.println("Do you want to update a user or a user account?" + "\n" + "a) User" + "\n" + "b) User Account");
					String userOrAccount = s.nextLine();
					if(userOrAccount.equals("a")) {
						System.out.println("Type in the full name of the user you would like to update.");
						String originalName = s.nextLine();
						System.out.println("What would you like to change this user's name to?");
						String nameChange = s.nextLine();
						for(int i=0; i<custList.size(); i++) {
							if(originalName.equals(custList.get(i).getFN())) {
								Customer cust = new Customer(nameChange, custList.get(i).getUN(), custList.get(i).getPW(), custList.get(i).get$());
								custList.remove(i);
								custList.add(cust);
								writefile(custList);
								System.out.println("User's name was successfully changed.");
								try {
									udi.updateUserFullName(nameChange, originalName);
									log.info("Successfully updated user.");
								} catch(SQLException e) {
									e.printStackTrace();
								}
							}
						}
					} else if(userOrAccount.equals("b")) {
						System.out.println("Which account would you like to update? Type in the account username.");
						String user = s.nextLine();
						System.out.println("Would you like to update this account's username or password?" + "\n" + "a) Username" + "\n" + "b) Password");
						String userOrPass = s.nextLine();
						if(userOrPass.equals("a")) {
							System.out.println("Type in new username:");
							String newuser = s.nextLine();
							for(int i=0; i<custList.size(); i++) {
								if(custList.get(i).getUN().equals(user)) {
									Customer c = new Customer(custList.get(i).getFN(), newuser, custList.get(i).getPW(), custList.get(i).get$());
									custList.remove(i);
									custList.add(c);
									writefile(custList);
									System.out.println("Account username was successfully changed.");
									try {
										udi.updateAccountUserName(newuser, user);
										log.info("Successfully updated account username.");
									} catch(SQLException e) {
										e.printStackTrace();
									}
								}
							}
						} else if (userOrPass.equals("b")) {
							System.out.println("Type in new password:");
							String newpass = s.nextLine();
							for(int i=0; i<custList.size(); i++) {
								if(custList.get(i).getUN().equals(user)) {
									String oldpass = custList.get(i).getPW();
									Customer c = new Customer(custList.get(i).getFN(), custList.get(i).getUN(), newpass, custList.get(i).get$());
									custList.remove(i);
									custList.add(c);
									writefile(custList);
									System.out.println("password was successfully changed.");
									try {
										udi.updateAccountPassWord(newpass, oldpass);
										log.info("Successfully updated account password.");
									} catch(SQLException e) {
										e.printStackTrace();
									}
								}
							}
						}
					}
					
				} else if(d1.equals("d")) {
					log.info("Entered Delete Users branch.");
					System.out.println("Which user would you like to delete? Be sure to type in their full name.");
					String fullname = s.nextLine();
					for(int i=0; i<custList.size(); i++) {
						
						
						if(custList.get(i).getFN().equals(fullname)) {
							custList.remove(i);
							writefile(custList);
							System.out.println("User has been deleted");
							try {
								udi.deleteUser(fullname);
								log.info("User successfully deleted.");
							} catch(SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			} else { //protects bank admin account from users without knowledge of password
				System.out.println("Invalid Login Information.");
			}
			System.out.println("For security purposes, please log in again");
			sys();
		}
		s.close();
	}

	//password validator
	public String findCusty(String checkPwd) {
		//for(Customer customer : custList) {
		for(int i=0; i<custList.size(); i++) {
			Customer customer = custList.get(i);
			if (customer.getPW().equals(checkPwd)){
				return customer.getPW();
			}
		}
		return null;
	}
	
//Serialization Methods	
	
	//serialize customer list
	public void writefile(ArrayList<Customer> custList) {
		try {
			ArrayList<Customer> custys = new ArrayList<Customer>();
			custys = custList;
			FileOutputStream fos = new FileOutputStream("CustomerData.txt");
        	ObjectOutputStream oos = new ObjectOutputStream(fos);
        	oos.writeObject(custys);
        	System.out.println();
        	oos.close();
        	fos.close();
    	} 
    	catch (IOException ioe) {
        	ioe.printStackTrace();
    	}
	}
	
	//serialize normal application list
	public void writeApps(ArrayList<Application> appList) {
		try {
			ArrayList<Application> apply = new ArrayList<Application>();
			apply = appList;
			FileOutputStream fos = new FileOutputStream("Applications.txt");
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(apply);
	    	System.out.println();
	    	oos.close();
	    	fos.close();
		} 
		catch (IOException ioe) {
	    	ioe.printStackTrace();
		}
	}
	
	//serialize joint application list
	public void writeJA(ArrayList<JointApp> JappList) {
		try {
			ArrayList<JointApp> Japps = new ArrayList<JointApp>();
			Japps = JappList;
			FileOutputStream fos = new FileOutputStream("Joint.txt");
	    	ObjectOutputStream oos = new ObjectOutputStream(fos);
	    	oos.writeObject(Japps);
	    	System.out.println();
	    	oos.close();
	    	fos.close();
		} 
		catch (IOException ioe) {
	    	ioe.printStackTrace();
		}
	}
	
	//deserialize customer list
	@SuppressWarnings("unchecked")
	public void readfile() {
		try {	
			ArrayList<Customer> deSerializedCustys;
			FileInputStream fis = new FileInputStream(new File ("CustomerData.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
        	deSerializedCustys = ((ArrayList<Customer>)ois.readObject());
			custList = deSerializedCustys;
			ois.close();
			fis.close();
    	} 
    	catch (IOException ioe) {
    		//System.out.println("Customer List is empty");
    		//ioe.printStackTrace();
        	//return;
    	} 
		catch(ClassNotFoundException c) {
        	//System.out.println("Class not found");
        	c.printStackTrace();
        	//return;
    	}
	}
	
	//deserialize normal application list
	@SuppressWarnings("unchecked")
	public void readApps() {
		try {	
			ArrayList<Application> deSerializedApps;
			FileInputStream fis = new FileInputStream(new File ("Applications.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
        	deSerializedApps = ((ArrayList<Application>)ois.readObject());
			appList = deSerializedApps;
			ois.close();
			fis.close();
    	} 
    	catch (IOException ioe) {
    		//System.out.println("Application List is empty");
    		//ioe.printStackTrace();
        	//return;
    	} 
		catch(ClassNotFoundException c) {
        	//System.out.println("Class not found");
        	c.printStackTrace();
        	//return;
    	}
	}
		
	//deserialize joint application list
	@SuppressWarnings("unchecked")
	public void readJA() {
		ArrayList<JointApp> deSerializedJA = new ArrayList<JointApp>();
		try {	
			FileInputStream fis = new FileInputStream(new File ("Joint.txt"));
			ObjectInputStream ois = new ObjectInputStream(fis);
	        deSerializedJA = ((ArrayList<JointApp>)ois.readObject());
			JappList = deSerializedJA;
			ois.close();
			fis.close();
	    } 
	    catch (IOException ioe) {
	        //ioe.printStackTrace();
	    	//System.out.println("Joint Application List is empty");
	    	//return;
	    } 
		catch(ClassNotFoundException c) {
	        	//System.out.println("Class not found");
	        	c.printStackTrace();
	        	//return;
	    }
	}
}