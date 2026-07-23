package dataDrivernTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class ExcelFileHandle {
	
	@Test
	public void excelTestScript() throws EncryptedDocumentException, IOException {
		
		//convert physical file to java object
		FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
		
		//create the workbook
		Workbook wb = WorkbookFactory.create(fis);
		
		//fetch the sheet
		Sheet sh = wb.getSheet("data");
		
		//fetch the row
		Row r = sh.getRow(1);
		
		//fetch the cell
		Cell c = r.getCell(1);
		
		//fetch the data. Note if you try to fetch numeric data using String method you will get IllegalStateException
//		String data = c.getStringCellValue();
		double num = c.getNumericCellValue();
		System.out.println(num);
		
		wb.close();
		fis.close();
		
	}
	
	
	//using loop fetch all the data
	@Test
	public void fetchData() throws EncryptedDocumentException, IOException {
		
		//convert physical file to java object
			FileInputStream fis = new FileInputStream("./src/test/resources/TestData.xlsx");
			
			//create the workbook
			Workbook wb = WorkbookFactory.create(fis);
			
			//fetch the sheet
			Sheet sh = wb.getSheet("data");
			
			for(int i=1; i<=sh.getLastRowNum(); i++) {
				for(int j=0; j<sh.getRow(i).getLastCellNum(); j++) {					
					//fetch the data and print in console
					String data = sh.getRow(i).getCell(j).toString();
					System.out.print(data + " ");
				}
				System.out.println();
			}
			
			wb.close();
			fis.close();
	}

}
