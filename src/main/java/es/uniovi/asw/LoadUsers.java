package es.uniovi.asw;

import java.io.IOException;
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
		System.out.println("#########\nCitizens Loader i3a\n#########\n");
		
		ArrayList<UserModel> users = new ArrayList<UserModel>();
		PersonFactory pf =  new PersonFactory();
		IUserDAO udao = new Factory().getDAO().getUserDAO();

		for (String file : args){
			users.clear();
			try {
				users = pf.usersFromFile(file);
				for(UserModel us : users)  {
					udao.save(us);
					System.out.println("Saved " + us.toString());
				}
				System.out.println("Loaded " + users.size() + " users from " + file + "\n");
				
			}catch (IOException e){
				System.out.printf("\n[ERROR] The file %s could not be loaded\n\n", file);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
