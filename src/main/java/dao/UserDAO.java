package dao;

import model.UserModel;

public class UserDAO implements IUserDAO {

	@Override
	public void save(UserModel user) {
		String sql = "INSERT INTO (FName, LName, Email, DOB, Address, Nationality, ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
	}
	
}
