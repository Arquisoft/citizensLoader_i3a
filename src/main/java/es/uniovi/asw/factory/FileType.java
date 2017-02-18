package es.uniovi.asw.factory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import es.uniovi.asw.model.UserModel;

public interface FileType {

	/**
	 * gets users information from a file whose name is passed as a parameter
	 * @param filename name of the file where the data is going to be loaded
	 * @return a list of the new users
	 * @throws FileNotFoundException if the file cannot be found
	 * @throws IOException if the the file cannot be accessed
	 * @throws IllegalStateException if the data file is not properly formed
	 */
	ArrayList<UserModel> readFrom(String filename) throws FileNotFoundException, IOException, IllegalStateException;
}
