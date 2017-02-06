package Factory.impl;

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

import Factory.IPersonFactory;
import model.UserModel;

public class PersonFactory implements IPersonFactory {
	public ArrayList<UserModel> UsersFromFile(String filename) throws IOException {
		 ArrayList<UserModel> um = new ArrayList<UserModel>();
		 FileInputStream file;
		 try {
			 file = new FileInputStream(new File(filename));
			 HSSFWorkbook hwb = new HSSFWorkbook(file);
			 HSSFSheet sheet = hwb.getSheetAt(0);
			 Iterator<Row> rowIterator = sheet.iterator();
			 while(rowIterator.hasNext()) {
				 Row row = rowIterator.next();
				 um.add(UserFromRow(row));
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
			data.add(cell.getStringCellValue());
		}
		um = new UserModel(data.get(0), data.get(1), data.get(2), data.get(3), 
							data.get(4), data.get(5), data.get(6));
		return um;
	}
}
