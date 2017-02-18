package es.uniovi.asw.factory.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import es.uniovi.asw.factory.FileType;
import es.uniovi.asw.letters.PasswordGenerator;
import es.uniovi.asw.model.UserModel;

public class TxtReader implements FileType{

	private final static int PERSON_ELEMENTS = 7; 
	
	@Override
	public ArrayList<UserModel> readFrom(String filename) throws IOException {

		ArrayList<UserModel> um = new ArrayList<UserModel>();
		BufferedReader reader = new BufferedReader(new FileReader(new File(filename)));

		String line = reader.readLine();
		while (line!=null){
			um.add(newPerson(line));
			line = reader.readLine();
		}
		reader.close();
		
		return um;
	}

	/**
	 * generates a new Person from the txt data file.
	 * @param line txt line from which the person data is obtained
	 * @return new user
	 * @throws IOException if the line has more/less columns than expected
	 */
	private UserModel newPerson(String line) throws IOException{
		UserModel um;
		String[] data = line.split("\t");

		if (data.length!=PERSON_ELEMENTS)
			throw new IllegalStateException();
		
		um = new UserModel(data[0], data[1], data[2], data[3], 
				data[4], data[5], data[6]);
		um.setPassword(PasswordGenerator.generateRandomPassword());
		
		return um;
	}
}
