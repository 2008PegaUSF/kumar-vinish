package CoreJavaAssignment;

public class EmployeeCreator {
	private String name;
	private String department;
	private int age;
	
	public EmployeeCreator(String name, String department, int age) {
		this.name = name;
		this.department = department;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDepartment() {
		return department;
	}
	
	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return "Employee: " + name + ", " + department + ", " + age + " years old";
	}
}
