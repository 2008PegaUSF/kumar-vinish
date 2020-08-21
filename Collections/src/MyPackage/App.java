package MyPackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class App {
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<String>();
		
		al.add("first string");
		al.add("second string");
		al.add("third string");
		
		Stack<String> stack = new Stack<String>();
		
		MyGeneric<Stack<String>> myGenericStack = new MyGeneric<Stack<String>>();
		myGenericStack.myT = stack;
		myGenericStack.printMyT();
		
		for(int i=0; i < al.size(); i++) {
			System.out.println(al.get(i));
		}
		
		for(String s : al) {
			System.out.println(s);
		}
		
		Iterator<String> it = al.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
