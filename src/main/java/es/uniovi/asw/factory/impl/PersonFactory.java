package es.uniovi.asw.factory.impl;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import es.uniovi.asw.factory.IPersonFactory;
import es.uniovi.asw.factory.FileType;
import es.uniovi.asw.model.UserModel;

public class PersonFactory implements IPersonFactory {
	
	private FileType state;
	
	public ArrayList<UserModel> UsersFromFile(String filename) throws IOException {
		
		ArrayList<UserModel> um = new ArrayList<UserModel>();
		
		chooseFileType(filename);		
		
		 try {			 
			 um= state.readFrom(filename);
			 
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename);
			throw e;
		} catch (IOException e) {
			System.out.println("Could not access file: " + filename);
			throw e;
		} catch(IllegalStateException e){
			System.out.println("The file does not follow the schema: " + filename);
			throw e;
		} catch(Exception e) {
			System.out.println("Something went terribly wrong: ");
			e.printStackTrace();
		}
		 
		return um;
	}

	private void chooseFileType(String filename) {
		if (filename.contains(".txt"))
			this.state = new TxtReader();
		else if(filename.contains(".xls") || filename.contains(".xlsx"))
			this.state = new ExcelReader();		
	}
	
	
}
