package CoreJavaAssignment;

import java.util.Comparator;

//class to compare employee names, implements Comparator interface and defines compare method
public class EmployeeNameComparator implements Comparator<EmployeeCreator>{

	public int compare(EmployeeCreator e1, EmployeeCreator e2) {
		int nameCompare = e1.getName().compareTo(e2.getName());
		//System.out.println(nameCompare);
		return nameCompare;
	}

}
