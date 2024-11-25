package DataProvider;

import org.testng.annotations.DataProvider;

import helper.ExcelReader;

public class AllDataProviders
{
  @DataProvider(name="appdatafromexcelnew")
  public static Object[][] testData_excel_updated()
  {
	  System.out.println("Loading Data Provider");
	  Object[][] arr=ExcelReader.getDataFromExcel("users");
	  System.out.println("Data Provider Completed");
	  return arr;
  }
  
  @DataProvider(name="category")
  public static Object[][] categoryDetails()
  {
	  System.out.println("Loading Data Provider");
	  Object[][] arr=ExcelReader.getDataFromExcel("category");
	  System.out.println("Data Provider Completed");
	  return arr;
  }
  
}
