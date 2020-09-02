package daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bankingApp.Customer;
import beans.User;
import dao.UserDao;
import util.ConnFactory;

public class UserDaoImpl implements UserDao {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public void makeNewUser(Customer newUser) throws SQLException {
		// TODO Auto-generated method stub
		Connection c = cf.getConnection();
		String sql = "insert into Users "
				+ "values (nextval('seq'),?,?,?,?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, newUser.getFN());
		//ps.setString(2, newUser.getLN());
		ps.setString(2, newUser.getUN());
		ps.setString(3, newUser.getPW());
		ps.setInt(4, newUser.get$());
		//ps.setInt(5, 1);
		ps.executeUpdate();
	}
	
	public List<User> getUserAccounts(String fullname) throws SQLException {
		List<User> accounts = new ArrayList<User>();
		Connection c = cf.getConnection();
		String sql = "select * "
				+ "from \"users\" "
				+ "where \"userfullname\" = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, fullname);
		ResultSet rs = ps.executeQuery();
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			accounts.add(u);
		}
		//System.out.println(accounts);
		return accounts;
	}
	
	public void deleteUserAccount(String username) throws SQLException {
		Connection c = cf.getConnection();
		String sql = "delete from \"users\" "
				+ "where \"userusername\" = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, username);
		ps.executeUpdate();
	}
	
	public void transaction(int funds, String username) throws SQLException {
		Connection c = cf.getConnection();
		String sql = "update \"users\" "
				+ "set \"userfunds\" = ? "
				+ "where \"userusername\" = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, funds);
		ps.setString(2, username);
		ps.executeUpdate();
	}
	
	public List<User> getUserList() throws SQLException {
		List<User> uList = new ArrayList<User>();
		Connection c = cf.getConnection();
		String sql = "select * from \"users\"";
		PreparedStatement ps = c.prepareStatement(sql);
		//ps.setString(1, )
		ResultSet rs = ps.executeQuery();
		User u = null;
		while(rs.next()) {
			u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
			uList.add(u);
		}
		return uList;
	}
	
	public void deleteUser(String fullname) throws SQLException {
		Connection c = cf.getConnection();
		String sql = "delete from \"users\" "
				+ "where \"userfullname\" = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, fullname);
		ps.executeUpdate();
	}
	
	public void updateUserFullName(String newname, String oldname) throws SQLException {
		Connection c = cf.getConnection();
		String sql = "update \"users\" set \"userfullname\" = ? where \"userfullname\" = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, newname);
		ps.setString(2, oldname);
		ps.executeUpdate();
	}
	
	public void updateAccountUserName(String newuser, String olduser) throws SQLException {
		Connection c = cf.getConnection();
		String sql = "update \"users\" set \"userusername\" = ? where \"userusername\" = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, newuser);
		ps.setString(2, olduser);
		ps.executeUpdate();
	}
	
	public void updateAccountPassWord(String newpass, String oldpass) throws SQLException {
		Connection c = cf.getConnection();
		String sql = "update \"users\" set \"userpass\" = ? where \"userpass\" = ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, newpass);
		ps.setString(2, oldpass);
		ps.executeUpdate();
	}
}
