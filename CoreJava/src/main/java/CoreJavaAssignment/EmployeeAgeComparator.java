package CoreJavaAssignment;

import java.util.Comparator;

//class to compare employee ages, implements Comparator interface and defines compare method
public class EmployeeAgeComparator implements Comparator<EmployeeCreator>{

	public int compare(EmployeeCreator e1, EmployeeCreator e2) {
		//stores difference in age as integer
		int departmentCompare = e1.getAge() - e2.getAge();
		//prints and returns age difference
		//System.out.println(departmentCompare);
		return departmentCompare;
	}

}
