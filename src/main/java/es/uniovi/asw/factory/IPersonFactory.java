package es.uniovi.asw.factory;
import java.io.IOException;
import java.util.ArrayList;

import es.uniovi.asw.model.UserModel;

public interface IPersonFactory {
	ArrayList<UserModel> usersFromFile(String filename) throws IOException;
	
}
