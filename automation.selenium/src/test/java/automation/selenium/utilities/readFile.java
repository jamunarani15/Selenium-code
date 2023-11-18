package automation.selenium.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

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

public class readFile {

	static String filePath = "D:\\Jamuna\\Eclipse\\automation.selenium\\src\\test\\resources\\inputdata";
	static String fileName = "inputData.xlsx";
	static String sheetName = "Sheet1";

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		File file = new File(filePath + "\\" + fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook trackWorkbook = null;
		
		trackWorkbook = new XSSFWorkbook(inputStream);
		

		org.apache.poi.ss.usermodel.Sheet trackSheet = trackWorkbook.getSheet(sheetName);
		int rowCount = trackSheet.getLastRowNum() - trackSheet.getFirstRowNum();

		for (int i = 0; i < rowCount + 1; i++) {
			Row row = trackSheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				System.out.print(row.getCell(j).getStringCellValue() + "|| ");

			}
			System.out.println();
		}

		System.out.println("read excel file : ");

	}

}
