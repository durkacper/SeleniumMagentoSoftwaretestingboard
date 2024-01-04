package data;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelDataReader {
    public static Object[][] getExcelData(String path, String sheetName) throws IOException {
        DataFormatter dataFormatter = new DataFormatter();

        FileInputStream fileInputStream = new FileInputStream(path);

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        XSSFSheet sheet = workbook.getSheet(sheetName);

        int numberOfRows = sheet.getPhysicalNumberOfRows();
        int numberOfColumns = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] excelData = new Object[numberOfRows - 1][numberOfColumns];

        for (int i = 0; i < numberOfRows - 1; i++) {
            for (int j = 0; j < numberOfColumns; j++) {
                XSSFCell cell = sheet.getRow(i+1).getCell(j);
                excelData[i][j] = dataFormatter.formatCellValue(cell);
            }
        }
        return excelData;
    }
}
