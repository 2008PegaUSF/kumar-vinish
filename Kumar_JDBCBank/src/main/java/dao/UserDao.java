package dao;

import java.sql.SQLException;
import java.util.List;

import beans.User;

public interface UserDao {
	public List<User> getUserList() throws SQLException;
	public List<User> getUsersFromUserId(int id) throws SQLException;
	public void makeNewUser(User newUser) throws SQLException;
}