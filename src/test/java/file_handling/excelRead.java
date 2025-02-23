package file_handling;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Iterator;

public class excelRead {
    public static void main(String[] args){
        String fileName = getFilePath("Test_File.xlsx");
        try{
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet ws = wb.getSheetAt(0);

            Iterator<Row> rowIterator = ws.iterator();
            while(rowIterator.hasNext()){
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator =  row.iterator();
                while(cellIterator.hasNext()){
                    Cell cell = cellIterator.next();

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
                            System.out.print(cell.getCellFormula()+"\t\t");
                            break;
                        default:
                            System.out.print("\t\t");
                    }
                }
                System.out.println();
            }
        }
        catch(IOException e){
            System.out.println("Error while reading a file");
        }
    }
    private static String getFilePath(String fileName){
        return Paths.get("src/test/resources/testdata", fileName).toAbsolutePath().toString();
    }
}
