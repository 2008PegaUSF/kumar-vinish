package dao;

import java.sql.SQLException;
import java.util.List;

import bankingApp.Customer;
import beans.User;

public interface UserDao {
	public List<User> getUserList() throws SQLException;
	public void makeNewUser(Customer newCust) throws SQLException;
	public List<User> getUserAccounts(String fullname) throws SQLException;
	public void deleteUserAccount(String username) throws SQLException;
	public void transaction(int funds, String username) throws SQLException;
	public void deleteUser(String fullname) throws SQLException;
	public void updateUserFullName(String newname, String oldname) throws SQLException;
	public void updateAccountUserName(String newuser, String olduser) throws SQLException;
	public void updateAccountPassWord(String newpass, String oldpass) throws SQLException;
}
