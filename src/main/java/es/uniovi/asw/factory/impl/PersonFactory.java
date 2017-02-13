package es.uniovi.asw.factory.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.factory.IPersonFactory;
import es.uniovi.asw.letters.LetterGenerator;
import es.uniovi.asw.letters.PasswordGenerator;
import es.uniovi.asw.model.UserModel;

public class PersonFactory implements IPersonFactory {
	
	private LetterGenerator letterGenerator;
	
	public ArrayList<UserModel> UsersFromFile(String filename) throws IOException {
		 ArrayList<UserModel> um = new ArrayList<UserModel>();
		 FileInputStream file;
		 
		 try {
			 file = new FileInputStream(new File(filename));
			 XSSFWorkbook hwb = new XSSFWorkbook(file);
			 XSSFSheet sheet = hwb.getSheetAt(0);
			 Iterator<Row> rowIterator = sheet.iterator();
			 while(rowIterator.hasNext()) {
				 Row row = rowIterator.next();
				 
				 um.add(UserFromRow(row));				 
			 }
			 
			 for(UserModel user : um){
				 letterGenerator.generateLetter(user);
			 }
			 
			 hwb.close();
			 file.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found: " + filename);
			throw e;
		} catch (IOException e) {
			System.out.println("Could not access file: " + filename);
			throw e;
		}
		 
		 return um;
	}
	
	private UserModel UserFromRow(Row row) {
		UserModel um;
		Iterator<Cell> cellIterator = row.cellIterator();
		ArrayList<String> data = new ArrayList<String>();
		while(cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			System.out.println(cell.getStringCellValue());
			data.add(cell.getStringCellValue());
		}
		um = new UserModel(data.get(0), data.get(1), data.get(2), data.get(3), 
							data.get(4), data.get(5), data.get(6));
		um.setPassword(PasswordGenerator.generateRandomPassword());
		return um;
	}	
}
