package BreakOutAssignment;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import helper.Utility;

public class setting 
{
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
	 driver=Utility.startBrowser("https://freelance-learn-automation.vercel.app/signup");
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	

}
