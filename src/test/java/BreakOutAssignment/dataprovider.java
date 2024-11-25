package BreakOutAssignment;

import org.testng.annotations.DataProvider;

public class dataprovider 
{
	@DataProvider(name = "signUpData")
	public Object[][] testdata()
	{
		Object arr[][]=new Object[3][7];
		arr[0][0]="sneha";
		arr[0][1]="sneha@email8.com";
		arr[0][2]="uiyu8790";
		arr[0][3]="java";
		arr[0][4]="Female";
		arr[0][5]="Nagaland";
		arr[0][6]="Dancing";
		
		arr[1][0]="Priya";
		arr[1][1]="Priya@email8.com";
		arr[1][2]="uiyu8790";
		arr[1][3]="Cypress";
		arr[1][4]="Male";
		arr[1][5]="Assam";
		arr[1][6]="Playing";
		
		arr[2][0]="SnehaPriya";
		arr[2][1]="snehapriya@email8.com";
		arr[2][2]="uiyu8790";
		arr[2][3]="Selenium";
		arr[2][4]="Female";
		arr[2][5]="Bihar";
		arr[2][6]="Reading";
		return arr;
	 
	}
	
	@DataProvider (name = "signupdatafromExcel")
	public static Object[][] excelData()
	{
		Object[][] arr= ExcelReader.getDatafromExcel("SignUp");
		return arr; 
	}

}
