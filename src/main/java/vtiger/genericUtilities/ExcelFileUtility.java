package vtiger.genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import net.bytebuddy.asm.Advice.Return;

/**
 * This class consist of generic methods related to excel sheet
 * @author Vrushali P
 */
public class ExcelFileUtility {
/**
 * This method will read data from excel sheet
 * @param SheetName
 * @param rowNo
 * @param cellNo
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcel(String SheetName, int rowNo, int cellNo) throws  EncryptedDocumentException,  IOException{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook wb = new XSSFWorkbookFactory().create(fis);
		String value = wb.getSheet(SheetName).getRow(rowNo).getCell(cellNo).getStringCellValue();
		wb.close();
		return value;
	}
	
	/**
	 * This method will write data into excel
	 * @param SheetName
	 * @param rowNo
	 * @param cellNo
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public void writeIntoExcel(String SheetName, int rowNo, int cellNo, String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IconstantsUtility.excelFilrPath);
		Workbook wb = new XSSFWorkbookFactory().create(fis);
		Sheet sh = wb.getSheet(SheetName);
		Row rw = sh.createRow(rowNo);
		Cell cel = rw.createCell(cellNo);
		cel.setCellValue(value);
		
		FileOutputStream fos = new FileOutputStream(IconstantsUtility.excelFilrPath);
		wb.write(fos);
		wb.close();
	}
	/**
	 * This method will read data excel sheet n return it to data provider
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public Object[][] readDatafromExcelToDataProvider(String SheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(IconstantsUtility.excelFilrPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(SheetName);
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] data = new Object[lastRow][lastCell];
		
		for (int i = 0; i < lastRow; i++) //row
		{
			for (int j = 0; j < lastCell; j++) //cell
			{
				data[i][j] = sh.getRow(i+1).getCell(j).getStringCellValue();
			}
			
		}
		return data;
	}
	
	}


