package es.uniovi.asw;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;

import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.letters.LetterGenerator;
import es.uniovi.asw.letters.TxtLetter;
import es.uniovi.asw.model.UserModel;

public class LettersTest {

	private UserModel user;
	
	@Before
	public void setUp(){
		user = new UserModel("Maria", "Fernandez", "maria@email.com", "15/02/1995", "Calle", "España", "1", "xx");
	}
	
	@Test
	public void testTxtLetter() throws FileNotFoundException {
		LetterGenerator generator = new TxtLetter();
		generator.generateLetter(user);
		File newLetter = new File("Letters/" + user.getEmail() + ".txt");
		assertTrue(newLetter.exists());
	}
}