package file_handling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class readExcelFile {
    public static void main(String[] str) {
        TestNG testNg = new TestNG();
        testNg.setTestClasses(new Class[]{ReadExcel.class});
        testNg.run();
    }
}

class ReadExcel {
    @Test
    public void testWithMapData() {
        String filePath = getFilePath("Test_File.xlsx"); // Ensure this method is implemented
        List<Map<String, String>> data = readExcelAsMap(filePath);

        for (Map<String, String> entry : data) {
            System.out.println("Instrument: " + entry.get("Instrument"));
            System.out.println("Quantity: " + entry.get("Qty."));
        }
    }

    public static List<Map<String, String>> readExcelAsMap(String filePath) {
        List<Map<String, String>> data = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             XSSFWorkbook wb = new XSSFWorkbook(fis)) {

            XSSFSheet ws = wb.getSheetAt(0);
            Row headerRow = ws.getRow(0); // Assuming the first row is header

            if (headerRow == null) {
                throw new IllegalArgumentException("Excel sheet is empty!");
            }

            List<String> headers = new ArrayList<>();
            for (Cell cell : headerRow) {
                headers.add(cell.getStringCellValue().trim());
            }

            for (int i = 1; i <= ws.getLastRowNum(); i++) {
                Row row = ws.getRow(i);
                if (row == null) continue; // Skip empty rows

                Map<String, String> rowData = new HashMap<>();

                for (int j = 0; j < headers.size(); j++) {
                    Cell cell = row.getCell(j, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    String cellValue = cell.toString().trim();
                    rowData.put(headers.get(j), cellValue);
                }

                data.add(rowData);
            }
        } catch (IOException e) {
            System.out.println("Error reading the Excel file: " + e.getMessage());
        }

        return data;
    }

    private static String getFilePath(String fileName) {
        return Paths.get("src/test/resources/testdata", fileName).toAbsolutePath().toString();
    }
}

