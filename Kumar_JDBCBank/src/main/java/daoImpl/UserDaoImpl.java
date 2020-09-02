package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import dao.UserDao;
import util.ConnFactory;

public class UserDaoImpl implements UserDao {
	public static ConnFactory cf = ConnFactory.getInstance();
	public List<User> getUserList() throws SQLException {
		List<User> uList = new ArrayList<User>();
		Connection c = cf.getConnection();
		String sql = "select * from \"users\"";
		PreparedStatement ps = c.prepareStatement(sql);
		//ps.setString(1, )
		ResultSet rs = ps.executeQuery();
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			uList.add(u);
		}
		return uList;
	}
	public List<User> getUsersFromUserId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	public void makeNewUser(User newUser) throws SQLException {
		// TODO Auto-generated method stub
		Connection c = cf.getConnection();
		String sql = null;
				//"insert into \"Users\" values (
		PreparedStatement ps = c.prepareStatement(sql);
		
	}
}
