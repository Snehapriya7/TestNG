package BreakOutAssignment;


import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;



public class verifySignup extends setting
{
	@Test(dataProvider = "signUpData", dataProviderClass=dataprovider.class, enabled = false)
	public void signup(String uname,String email,String pwd,String interests,String gender,String state,String hobbies)
	{
		String url= driver.getCurrentUrl();
		Assert.assertTrue(url.contains("signup"), "Wrong URL");
		
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(pwd);
		driver.findElement(By.xpath("//label[text()='"+interests+"']")).click();
		driver.findElement(By.xpath("//input[@value='"+gender+"']")).click();
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='state']"));
		Select s1=new Select(dropdown1);
		s1.selectByVisibleText(state);
		
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='hobbies']"));
		Select s2=new Select(dropdown2);
		s2.selectByVisibleText(hobbies);
		
		driver.findElement(By.xpath("//button[text()='Sign up']")).click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Signup successfully, Please login!']"))));
	    String message=driver.findElement(By.xpath("//div[text()='Signup successfully, Please login!']")).getText();
	    Assert.assertTrue(message.contains("Signup successfully, Please login!"),"WrongText,SignUpFailed");
	}
	
	@Test(dataProvider = "signupdatafromExcel", dataProviderClass = dataprovider.class)
	public void Excelsignup(String uname,String email,String pwd,String interests,String gender,String state,String hobbies)
	{
		String url= driver.getCurrentUrl();
		Assert.assertTrue(url.contains("signup"), "Wrong URL");
		
		driver.findElement(By.xpath("//input[@id=\"name\"]")).sendKeys(uname);
		driver.findElement(By.xpath("//input[@id=\"email\"]")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys(pwd);
		
		if(interests.contains(","))
		{
		  String[] words=interests.split(",");
		  for(int i=0;i<words.length;i++)
		  {
		  driver.findElement(By.xpath("//label[text()='"+words[i]+"']")).click();
		  }
		}
		else 
		  driver.findElement(By.xpath("//label[text()='"+interests+"']")).click();
		
		driver.findElement(By.xpath("//input[@value='"+gender+"']")).click();
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='state']"));
		Select s1=new Select(dropdown1);
		s1.selectByVisibleText(state);
		
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='hobbies']"));
		Select s2=new Select(dropdown2);
		if(hobbies.contains(","))
		{
			String[] h=hobbies.split(",");
			for(int i=0;i<h.length;i++)
			{
				
				s2.selectByVisibleText(h[i]);
			}
		}
		else
		 s2.selectByVisibleText(hobbies);
		
		WebElement signupBtn= driver.findElement(By.xpath("//button[text()='Sign up']"));
		Actions act=new Actions(driver);
		act.moveToElement(signupBtn).click().perform();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[text()='Signup successfully, Please login!']"))));
	    String message=driver.findElement(By.xpath("//div[text()='Signup successfully, Please login!']")).getText();
	    Assert.assertTrue(message.contains("Signup successfully, Please login!"),"WrongText,SignUpFailed");
	}
}
