package es.uniovi.asw.factory.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import es.uniovi.asw.factory.FileType;
import es.uniovi.asw.letters.LetterGenerator;
import es.uniovi.asw.letters.PasswordGenerator;
import es.uniovi.asw.letters.TxtLetter;
import es.uniovi.asw.model.UserModel;

public class ExcelReader implements FileType{

	private LetterGenerator letterGenerator = new TxtLetter();

	@Override
	public ArrayList<UserModel> readFrom(String filename) throws IOException {

		ArrayList<UserModel> um = new ArrayList<UserModel>();

		FileInputStream file;

		file = new FileInputStream(new File(filename));
		 XSSFWorkbook hwb = new XSSFWorkbook(file);
		 XSSFSheet sheet = hwb.getSheetAt(0);
		 Iterator<Row> rowIterator = sheet.iterator();
		 while(rowIterator.hasNext()) {
			 Row row = rowIterator.next();
			 UserModel tst = UserFromRow(row);
			 if(tst != null)
				 um.add(tst);				 
		 }
		 
		 for(UserModel user : um){
			 letterGenerator.generateLetter(user);
		 }
		 
		 hwb.close();
		 file.close();
		 
		 return um;
	}

	/**
	 * generates a new Person from the excel data file
	 * @param row excel row from which the person data is obtained
	 * @return new user
	 */
	private UserModel UserFromRow(Row row) {
		UserModel um;
		Iterator<Cell> cellIterator = row.cellIterator();
		ArrayList<String> data = new ArrayList<String>();
		while(cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if(cell.getStringCellValue().trim().length() == 0)
				return null;
			data.add(cell.getStringCellValue());
		}
		System.out.println(data.size());
		um = new UserModel(data.get(0), data.get(1), data.get(2), data.get(3), 
							data.get(4), data.get(5), data.get(6));
		um.setPassword(PasswordGenerator.generateRandomPassword());
		return um;
	}	
}
