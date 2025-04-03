package file_handling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class excelDataReadAndPrint {
    public static void main(String[] args){

        try{
            String filePath = getFilePath("Test_File.xlsx");
            FileInputStream fis = new FileInputStream(filePath);
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            FormulaEvaluator evaluator = wb.getCreationHelper().createFormulaEvaluator();
            XSSFSheet ws = wb.getSheetAt(0);

            for(Row row : ws){
                for(Cell cell : row){
                    switch(cell.getCellType()){
                        case STRING:
                            System.out.print(cell.getStringCellValue()+"\t\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue()+"\t\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue()+"\t\t");
                            break;
                        case FORMULA:
                            switch(evaluator.evaluateFormulaCell(cell)){
                                case STRING:
                                    System.out.print(cell.getStringCellValue()+"\t\t");
                                    break;
                                case NUMERIC:
                                    System.out.print(cell.getNumericCellValue()+"\t\t");
                                    break;
                                case BOOLEAN:
                                    System.out.print(cell.getBooleanCellValue()+"\t\t");
                                    break;
                                default:
                                    System.out.print("");
                            }
                        default:
                            System.out.print("");
                    }
                }
                System.out.println();
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static String getFilePath(String filePath) throws IOException{
        return Paths.get("src/test/resources/testData",filePath).toAbsolutePath().toString();
    }
}
