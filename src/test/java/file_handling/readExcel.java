package file_handling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class readExcel {
    public static void main(String[] str) {
        TestNG testNg = new TestNG();
        testNg.setTestClasses(new Class[]{excelFileRead.class});
        testNg.run();
    }
}

class excelFileRead {
    @Test(dataProvider = "excelData")
    public static void testExcel(Object... rowData) {
        System.out.println("TestData : " + Arrays.toString(rowData));
    }

    @DataProvider(name = "excelData")
    private Object[][] getDataFromExcel() throws IOException {
        String filePath = getFilePath("Test_File.xlsx");
        List<List<Object>> data = getExcelData(filePath);

        Object[][] excelData = new Object[data.size()][];
        for (int i = 0; i < data.size(); i++) {
            excelData[i] = data.get(i).toArray();
        }
        return excelData;
    }

    private static List<List<Object>> getExcelData(String filePath) throws IOException {

        List<List<Object>> data = new ArrayList<>();
        FileInputStream fis = new FileInputStream(filePath);

        XSSFWorkbook wb = new XSSFWorkbook(fis);
        FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();

        XSSFSheet ws = wb.getSheetAt(0);
        for (Row row : ws) {
            List<Object> rowCell = new ArrayList<>();
            for (Cell cell : row) {
                switch (cell.getCellType()) {
                    case STRING:
                        rowCell.add(cell.getStringCellValue());
                        break;
                    case NUMERIC:
                        rowCell.add(cell.getNumericCellValue());
                        break;
                    case BOOLEAN:
                        rowCell.add(cell.getBooleanCellValue());
                        break;
                    case FORMULA:
                        switch (evaluator.evaluateFormulaCell(cell)) {
                            case STRING:
                                rowCell.add(cell.getStringCellValue());
                                break;
                            case NUMERIC:
                                rowCell.add(cell.getNumericCellValue());
                                break;
                            case BOOLEAN:
                                rowCell.add(cell.getBooleanCellValue());
                                break;
                            default:
                                rowCell.add("");
                        }
                    default:
                        rowCell.add("");
                }
            }
            data.add(rowCell);
        }
        fis.close();
        wb.close();
        return data;

    }
    private static String getFilePath(String fileName){
        return Paths.get("src/test/resources/testdata", fileName).toAbsolutePath().toString();
    }

}
