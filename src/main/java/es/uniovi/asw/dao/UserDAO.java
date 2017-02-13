package es.uniovi.asw.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import es.uniovi.asw.model.UserModel;

public class UserDAO implements IUserDAO {

	private static String URL = "jdbc:mysql://mysql.ciensbvk8ssi.eu-west-1.rds.amazonaws.com:3306/asw";
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
		if(conn == null) {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, User, Pass);
			
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void save(UserModel user) {
		
		String sql = "INSERT INTO ASW(FName, LName, Email, DOB, Address, Nationality, ID, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getfName());
			stmt.setString(2, user.getlName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getbDay());
			stmt.setString(5, user.getAddress());
			stmt.setString(6, user.getNationality());
			stmt.setString(7, user.getID());
			stmt.setString(8, user.getPassword());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
