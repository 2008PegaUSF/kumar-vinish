package CoreJavaAssignment;

import java.util.ArrayList;
import java.util.Collections;

public class Q7Driver {
	public static void main(String[] args) {
		ArrayList<EmployeeCreator> employees = new ArrayList<EmployeeCreator>();
		employees.add(new EmployeeCreator("Vinish", "Software", 22));
		employees.add(new EmployeeCreator("Ricardo", "IT", 23));
		
		Collections.sort(employees, new EmployeeNameComparator());
		System.out.println("Name Sort:");
		for(int n=0; n<employees.size(); n++) {
			System.out.println(employees.get(n));
		}
		System.out.println("-------------------");
		
		Collections.sort(employees, new EmployeeDepartmentComparator());
		System.out.println("Department Sort:");
		for(int n=0; n<employees.size(); n++) {
			System.out.println(employees.get(n));
		}
		System.out.println("-------------------");
		
		Collections.sort(employees, new EmployeeAgeComparator());
		System.out.println("Age Sort:");
		for(int n=0; n<employees.size(); n++) {
			System.out.println(employees.get(n));
		}
	}
}
