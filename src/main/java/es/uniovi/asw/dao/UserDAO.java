package es.uniovi.asw.dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import es.uniovi.asw.SQL;
import es.uniovi.asw.model.UserModel;

public class UserDAO implements IUserDAO {

	private static Connection conn;
	
	public UserDAO() {
		try {
			openConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void openConn() throws SQLException {
		try {
		if(conn == null) {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(SQL.get("DATABASE_URL"),
					SQL.get("DATABASE_USER"), SQL.get("DATABASE_PASS"));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	private boolean exists(UserModel user) {
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL.get("USER_SELECT_ALL_BY_ID"));
			stmt.setString(1, user.getID());
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	@Override
	public void save(UserModel user) {
		
		if(exists(user)) {
			System.out.println("User already exists: " + user.toString());
			File log = new File("Logs/log.txt");
			try {
				
				BufferedWriter bw = new BufferedWriter(new FileWriter(log));
				bw.append("User already exists: " + user.getfName() + " " + user.getlName() + " " + user.getID() + "\n");
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return;
		}
		try {
			PreparedStatement stmt = conn.prepareStatement(SQL.get("USER_INSERT"));
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
