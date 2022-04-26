package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataFileReader {
	
	public static Object[][] getData() {
		XSSFWorkbook workbook;
		XSSFSheet sheet;
		String[][] data=null;
		
		File file=new File("C:\\Users\\sugat\\OneDrive\\Documents\\SJEDData.xlsx");
		try {
			workbook =new XSSFWorkbook(file);
			
			sheet=workbook.getSheet("LoginData");
			
			int columns=sheet.getRow(0).getLastCellNum();
			
			int rows=sheet.getLastRowNum();
			
			data=new String[rows][columns];
			
			for(int i=0;i<rows;i++)
			{
				for(int j=0;j<columns;j++)
				{
					if(sheet.getRow(i+1).getCell(j)==null)
					{
						data[i][j]="";
					}
					else
					{
						data[i][j]=sheet.getRow(i+1).getCell(j).toString();
					}
					
		//			System.out.print(data[i][j]+"-");
				}
		//		System.out.println();
				
			}
			
			workbook.close();
			
		}  catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		}
		return data;
		

		
	}

}
