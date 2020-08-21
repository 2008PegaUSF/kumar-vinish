package MyFirstPackage;

//import MySecondPackage.*;

public class App {
	public static void main(String args[]) {
		MyThirdPackage.SomeClass sc = new MyThirdPackage.SomeClass();
		sc.printMessage();
		System.out.println("Hello World");
	}
}
