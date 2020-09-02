package dao;

import java.sql.SQLException;
import java.util.List;

import bankingApp.Customer;
import beans.User;

public interface UserDao {
	public List<User> getUserList() throws SQLException;
	
	public void makeNewUser(Customer newCust) throws SQLException;
}