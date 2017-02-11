package es.uniovi.asw.letters;

import java.io.FileNotFoundException;
import es.uniovi.asw.model.UserModel;

public interface LetterGenerator {
	
	/**
	 * Generates letters to communicate the user the password
	 * The letter contain his login name and password.
	 * The login name will be the email.
	 * 
	 * @throws FileNotFoundException 
	 */
	public void generateLetter(UserModel user) throws FileNotFoundException;
	
	
}
