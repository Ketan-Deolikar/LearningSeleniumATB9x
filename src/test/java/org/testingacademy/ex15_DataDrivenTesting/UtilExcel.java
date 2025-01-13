package org.testingacademy.ex15_DataDrivenTesting;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;

public class UtilExcel {

    // Apache POI
    // Read the File
    //  Workbook Create
    // Sheet
    // Row and Cell
    // 2D Object  - getData()

    static Workbook book;
    static Sheet sheet;

    public static final String SHEET_PATH = System.getProperty("user.dir") + "/src/test/Assets/TestData.xlsx";

    /**
     * Reads test data from an Excel sheet and returns it as a 2D Object array.
     *
     * @param sheetName Name of the sheet to read data from.
     * @return A 2D Object array containing the data from the Excel sheet.
     * @throws IOException If the file is not found or cannot be read.
     */
    public static Object[][] getTestDataFromExcel(String sheetName) throws IOException {


        FileInputStream file = new FileInputStream(SHEET_PATH);
        book = WorkbookFactory.create(file);
        sheet = book.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int colCount = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rowCount][colCount];

        for (int i = 0; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
            }
        }
        file.close();
        return data;
    }

    /**
     * DataProvider method to supply test data.
     *
     * @return A 2D Object array containing test data.
     * @throws IOException If the file is not found or cannot be read.
     */
    @DataProvider(name = "getData")
    public Object[][] getData() throws IOException {
        return getTestDataFromExcel("Sheet1");
    }
}
