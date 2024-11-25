package helper;

import static org.testng.Assert.assertNotNull;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.text.FlowView;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	 //Create a method which will accept only sheet name and this will read complete data and return 2D Object Array
	static XSSFWorkbook wb;
	public static Object[][] getDataFromExcel(String sheetName)
    {
		Object [][]arr=null;
		try 
		{
			 wb= new XSSFWorkbook(new FileInputStream(new File(".\\testdata\\Data.xlsx")));
			int rows=wb.getSheet(sheetName).getPhysicalNumberOfRows();
			int cols=wb.getSheet(sheetName).getRow(0).getPhysicalNumberOfCells();
			
			arr=new Object[rows-1][cols];
			
			//Skip first row as they are headings
			for(int i=1;i<rows;i++)
			{
				for(int j=0;j<cols;j++)
				{
					arr[i-1][j]=getData(sheetName, i, j);
				}
			}
			wb.close();
		}
		catch(FileNotFoundException e)
		{
			System.out.println("File Not Found "+e.getMessage());
		}
		catch (IOException e) 
		{
			System.out.println("Unable to read file "+e.getMessage());
		}
		return arr;
	}

    public static String getData(String sheetName,int row, int col)
    { 
        String data="";
    	CellType type =wb.getSheet(sheetName).getRow(row).getCell(col).getCellType();
        if(type==CellType.STRING)
        {
          data=wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();
        }
        else if(type==CellType.NUMERIC)
        {
        	double value= wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
        	data=String.valueOf(value);
        }
        else if(type==CellType.BOOLEAN)
        {
          boolean value	=wb.getSheet(sheetName).getRow(row).getCell(col).getBooleanCellValue();
          data= String.valueOf(value);
        }
        else if(type==CellType.BLANK)
        {
        	data="";
        }
    	return data;
    }
}
