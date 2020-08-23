package CoreJavaAssignment;

//class to create employees for comparators
public class EmployeeCreator {
	private String name;
	private String department;
	private int age;
	
	//constructor for employee creator
	public EmployeeCreator(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	//method to retrieve employee names
	public String getName() {
		return name;
	}
	
	//method to retrieve employee departments
	public String getDepartment() {
		return department;
	}
	
	//method to retrieve employee ages
	public int getAge() {
		return age;
	}
	
	//method to override toString method to print employee info in readable format
	@Override
	public String toString() {
		return "Employee: " + name + ", " + department + ", " + age + " years old";
	}
}
