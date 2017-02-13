package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import es.uniovi.asw.model.UserModel;

public class UserDAO implements IUserDAO {

	private static String URL = "mysql.ciensbvk8ssi.eu-west-1.rds.amazonaws.com:3306";
	private static String User = "brreaker";
	private static String Pass = "ASW13372017";
	private static Connection conn;
	
	public UserDAO() {
		try {
			OpenConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void OpenConn() throws SQLException {
		try {
		if(conn == null) 
			conn = DriverManager.getConnection(URL, User, Pass);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void save(UserModel user) {
		
		String sql = "INSERT INTO (FName, LName, Email, DOB, Address, Nationality, ID, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(0, user.getfName());
			stmt.setString(1, user.getlName());
			stmt.setString(2, user.getEmail());
			stmt.setString(3, user.getbDay());
			stmt.setString(4, user.getAddress());
			stmt.setString(5, user.getNationality());
			stmt.setString(6, user.getID());
			stmt.setString(7, user.getPassword());
			stmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
