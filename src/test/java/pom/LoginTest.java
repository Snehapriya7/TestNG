package pom;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import helper.Utility;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest
{
	@Test
	public void testLogin()
	{
		WebDriver driver= Utility.startBrowser();
		LoginPage loginPage=new LoginPage(driver);
		loginPage.loginToApp("admin@email.com", "admin@123");
	
		HomePage homePage=new HomePage(driver);
		Assert.assertTrue(homePage.getWelcomeMSg().contains("Welcome"),"Welcome msd not present");
	}

}
