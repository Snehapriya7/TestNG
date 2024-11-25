package UseDataProvider;

import org.testng.annotations.Test;

import DataProvider.AllDataProviders;

public class DataProviderExample 
{

	@Test(dataProvider = "appdatafromexcelnew", dataProviderClass=AllDataProviders.class, enabled=false)
	public void testfromExcel(String arg1,String arg2,String arg3,String arg4, String arg5,String arg6)
	{
		System.out.println(arg1+" "+arg2+" "+arg3+" "+arg4+" "+arg5+" "+arg6+" ");
	}
	
	@Test(dataProvider = "category", dataProviderClass=AllDataProviders.class )
	public void categoryNames(String name, String details)
	{
		System.out.println("Name " +name+" Details "+details);
	}

}
