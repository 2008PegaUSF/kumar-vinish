package CoreJavaAssignment;

import java.util.Comparator;

public class EmployeeAgeComparator implements Comparator<EmployeeCreator>{

	public int compare(EmployeeCreator e1, EmployeeCreator e2) {
		int departmentCompare = e1.getAge() - e2.getAge();
		//System.out.println(departmentCompare);
		return departmentCompare;
	}

}
