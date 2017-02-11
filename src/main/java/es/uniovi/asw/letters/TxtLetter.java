package es.uniovi.asw.letters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import es.uniovi.asw.model.UserModel;

public class TxtLetter implements LetterGenerator{

	@Override
	public void generateLetter(UserModel user) throws FileNotFoundException {
		File letter = new File("Letters/" + user.getEmail() + ".txt");
		
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(letter));
			bw.write(user.getfName() + ", you have been added to the Council. \nYour login name is: " + user.getEmail() +
					"\nYour password is: " + user.getPassword());
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}