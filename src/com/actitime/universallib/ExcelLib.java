package com.actitime.universallib;
import org.apache.poi.ss.usermodel.Cell;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLib {
	
	final static String xlpath="E://Automation//MyTestFramework//testdata//testdata.xlsx"; 
	
	public String getExcelData(String sname, int rnum,int cnum) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
	try {
	
	FileInputStream fis = new FileInputStream(xlpath);
	Workbook wb=WorkbookFactory.create(fis);
	String data = wb.getSheet(sname).getRow(rnum).getCell(cnum).getStringCellValue();
	fis.close();
	return data;
	} catch (FileNotFoundException e) {
		return "";
	}
	
	}

	public void setExcelData(String sname, int rnum,int cnum,String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		try {
			
			FileInputStream fis = new FileInputStream(xlpath);
			Workbook wb=WorkbookFactory.create(fis);
			Cell c1 = wb.getSheet(sname).getRow(rnum).createCell(cnum);
			c1.setCellValue(data);
			FileOutputStream fos = new FileOutputStream(xlpath);
			wb.write(fos);
			fos.close();
			fis.close();
		
			} catch (FileNotFoundException e) {
				System.out.println("Data Not Written");
			}
	}

}
