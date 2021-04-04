package Framwork.KhaznaTest.commonLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	/*
	 * Function that reads excel file containing the test cases data Then put it in
	 * ArrayList to be used by the framework
	 */
	public static ArrayList<String> getData(String testcaseName) throws IOException {
		// fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("src//Appium-Test-Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Data")) {
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify Testcases column by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						coloumn = k;

					}

					k++;
				}

				// once coloumn is identified then scan entire testcase coloum to identify a
				// testcase row
				while (rows.hasNext()) {

					Row r = rows.next();

					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {

						// after you grab a testcase row = pull all the data of that row and feed into
						// test

						Iterator<Cell> cv = r.cellIterator();
						Cell c = cv.next();
						while (cv.hasNext()) {
							c = cv.next();
							if (!c.getStringCellValue().isEmpty())
								a.add(c.getStringCellValue());
						}
					}

				}

			}
		}
		workbook.close();
		return a;

	}

	/*
	 * Get the data from the excel function and convert it to Object Array to be
	 * used by Testng
	 */
	public static Object[][] FormatData(String TestCaseName) throws IOException {
		ArrayList<String> data = dataDriven.getData(TestCaseName);
		Object[][] ObjArray = new Object[1][data.size()];
		for (int i = 0; i < data.size(); i++) {
			ObjArray[0][i] = data.get(i);
		}
		return ObjArray;
	}

}