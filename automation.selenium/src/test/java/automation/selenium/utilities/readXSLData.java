package automation.selenium.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readXSLData {

	String filePath = "D:\\Jamuna\\Eclipse\\automation.selenium\\src\\test\\resources\\inputdata\\inputData.xlsx";

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		readXSLData rd = new readXSLData();
		// rd.getData();
	//	 rd.readData();
		rd.readDemo();

	}

	public void readDemo() throws EncryptedDocumentException, IOException {
		// Path of the excel file
		FileInputStream fs = new FileInputStream(filePath);
		// Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(sheet.getRow(0).getCell(0));
		Row row1 = sheet.getRow(1);
		Cell cell1 = row1.getCell(1);
		System.out.println(sheet.getRow(0).getCell(1));
		Row row2 = sheet.getRow(1);
		Cell cell2 = row2.getCell(1);
		System.out.println(sheet.getRow(1).getCell(0));
		Row row3 = sheet.getRow(1);
		Cell cell3 = row3.getCell(1);
		System.out.println(sheet.getRow(1).getCell(1));
		// String cellval = cell.getStringCellValue();
		// System.out.println(cellval);
	}

	public void readData() throws IOException {
		FileInputStream file = new FileInputStream(new File(filePath));

		// Get the workbook instance for XLS file
		XSSFWorkbook workbook = new XSSFWorkbook(file);

		// Get first sheet from the workbook
		XSSFSheet sheet = workbook.getSheet("sheet1");

		// Iterate through each rows from first sheet
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			// For each row, iterate through each columns
			Iterator<Cell> cellIterator = row.cellIterator();
			while (cellIterator.hasNext()) {

				Cell cell = cellIterator.next();

				System.out.print(cell.getNumericCellValue() + "\t\t");
			}
			System.out.println("");
		}
		file.close();
		
	}

	public String[][] getData() throws EncryptedDocumentException, IOException {
		FileInputStream fls = new FileInputStream(
				"D:\\Jamuna\\Eclipse\\automation.selenium\\src\\test\\resources\\inputdata\\inputData.xlsx");
		Workbook wb = WorkbookFactory.create(fls);
		org.apache.poi.ss.usermodel.Sheet sheet = wb.getSheet("sheet1");

		int totalRows = sheet.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheet.getRow(0);
		int totalColumns = rowCells.getLastCellNum();
		System.out.println(totalColumns);

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalRows][totalColumns];
		for (int i = 1; i < totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				testData[i - 1][j] = format.formatCellValue(sheet.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}

		}
		return testData;
	}
}
