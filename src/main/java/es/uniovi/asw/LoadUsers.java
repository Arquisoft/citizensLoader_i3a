package es.uniovi.asw;

import java.util.ArrayList;
import es.uniovi.asw.dao.IUserDAO;
import es.uniovi.asw.factory.impl.Factory;
import es.uniovi.asw.factory.impl.PersonFactory;
import es.uniovi.asw.model.UserModel;

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

	private void run(String... args) {
		System.out.println("Citizens Loader i3a");
		System.out.println(args[0]);
		ArrayList<UserModel> users = new ArrayList<UserModel>();
		try {
			PersonFactory pf = new PersonFactory();
			users = pf.usersFromFile(args[0]);
			IUserDAO udao = new Factory().getDAO().getUserDAO();
			for(UserModel us : users)  {
				udao.save(us);
				System.out.println("Saved " + us.toString());
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("Loaded " + users.size() + " users from " + args[0]);
	}
}
