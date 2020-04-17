package com.uiFramework.Inn.Marsh.helper.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.uiFramework.Inn.Marsh.helper.assertionHelper.VerificationHelper;
import com.uiFramework.Inn.Marsh.helper.logger.LoggerHelper;

public class ExcelHelper {

	Logger log = LoggerHelper.getLogger(VerificationHelper.class);

	public void getData(String excelLocation, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(excelLocation);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase(sheetName)) {
		
			XSSFSheet sheet = workbook.getSheetAt(i);
			Iterator<Row> rows = sheet.iterator();
			Row firstRow = rows.next();
			System.out.println("Row no: "+firstRow.getRowNum());
			
			Iterator<Cell> cells = firstRow.cellIterator();
			int column=1;
			while (cells.hasNext()) {
				Cell cell = cells.next();
				int col;
				if (cell.getStringCellValue().equals("TestCase")) 
				{
				    col=cell.getColumnIndex();
					System.out.println("Index of desired column is: "+col);	
					column=col;
					System.out.println(column);
				}			
			}
			
			int noOfRows=sheet.getLastRowNum();
			System.out.println(noOfRows);
			
			for (int j = 0; j <= noOfRows; j++) 
			{
				String content=sheet.getRow(j).getCell(column).getStringCellValue();
				if (content.equals("Purchase")) 
				{
					for (int k = 1; k <= 3; k++) {
						System.out.println(sheet.getRow(j).getCell(k).getStringCellValue());
					}
				}
			}
		}
	}
	}
}
