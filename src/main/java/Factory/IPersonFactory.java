package Factory;
import java.io.IOException;
import java.util.ArrayList;


import model.UserModel;

public interface IPersonFactory {
	ArrayList<UserModel> UsersFromFile(String filename) throws IOException;
	
}
