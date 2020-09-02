package beans;

public class User {
	
	private int userId;
	private String userFName;
	private String userLName;
	private String userUName;
	private String userPass;
	private int funds;
	
	public User() {
		super();
	}

	public User(int userId, String userFName, String userUName, String userPass, int funds) {
		super();
		this.userId = userId;
		this.userFName = userFName;
		//this.userLName = userLName;
		this.userUName = userUName;
		this.userPass = userPass;
		this.funds = funds;
	}
	
	@Override
	public String toString() {
		return "User " + userId + ": Name = " + userFName + ", Username = "
				+ userUName + ", Password = " + userPass + ", Funds = " + funds;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserFName() {
		return userFName;
	}

	public void setUserFName(String userFName) {
		this.userFName = userFName;
	}

	public String getUserLName() {
		return userLName;
	}

	public void setUserLName(String userLName) {
		this.userLName = userLName;
	}

	public String getUserUName() {
		return userUName;
	}

	public void setUserUName(String userUName) {
		this.userUName = userUName;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	
	public int getFunds() {
		return funds;
	}
	
	public void setFunds(int funds) {
		this.funds = funds;
	}
	
}
