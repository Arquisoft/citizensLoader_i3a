package es.uniovi.asw.dao;

import es.uniovi.asw.model.UserModel;

public class UserDAO implements IUserDAO {

	@Override
	public void save(UserModel user) {
		String sql = "INSERT INTO (FName, LName, Email, DOB, Address, Nationality, ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
	}
	
}
