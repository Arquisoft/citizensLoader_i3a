package es.uniovi.asw;

import java.util.ArrayList;
import java.util.logging.Logger;

import Factory.impl.PersonFactory;
import es.uniovi.asw.*;
import model.UserModel;

/**
 * Main application
 *-
 * @author Labra
 *
 */
public class LoadUsers {

	public static void main(String... args) {
		final LoadUsers runner = new LoadUsers();
		runner.run(args);
	}

	void run(String... args) {
		System.out.println("Citizens Loader i3a");
		ArrayList<UserModel> users = new ArrayList<UserModel>();
		try {
			PersonFactory pf = new PersonFactory();
			users = pf.UsersFromFile(args[0]);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Loaded " + users.size() + " users from " + args[0]);
	}
}
