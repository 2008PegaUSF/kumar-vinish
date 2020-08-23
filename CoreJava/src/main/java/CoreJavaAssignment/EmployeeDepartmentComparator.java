package CoreJavaAssignment;

import java.util.Comparator;

public class EmployeeDepartmentComparator implements Comparator<EmployeeCreator>{

	public int compare(EmployeeCreator e1, EmployeeCreator e2) {
		int departmentCompare = e1.getDepartment().compareTo(e2.getDepartment());
		//System.out.println(departmentCompare);
		return departmentCompare;
	}

}
