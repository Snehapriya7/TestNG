package helper;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;

public class Utility 
{
	
	public static WebElement waitForWebElement(WebDriver driver,By locator,int timeToWait,int pollingInterval)
	{
		//default wait I am setting is 30seconds
		WebElement element=null;
		for(int i=0;i<timeToWait;i++)
		{
			try 
			{	
			  element=driver.findElement(locator);
			  if(element.isDisplayed() && element.isEnabled() && element.getSize().getHeight()>0 && element.getSize().getWidth()>0)
			  {
				  highLightElement(driver, element);
				  break;
			  }
			  else 
			  {
				System.out.println("Waiting for WebElement-Waiting for all states");
			
			  }
			}
			catch (Exception e) 
			{
				System.out.println("Waiting for WebElement-Retrying");
			}
		    try 
		    {
				Thread.sleep(pollingInterval);
			} 
		    catch (InterruptedException e) 
		    {
				
			}
		}
		    return element;
	}
	
	public static WebElement waitForWebElement(WebDriver driver,By locator,int timeToWait)
	{
		//default wait I am setting is 30seconds
		WebElement element=null;
		for(int i=0;i<timeToWait;i++)
		{
			try 
			{	
			  element=driver.findElement(locator);
			  if(element.isDisplayed() && element.isEnabled() && element.getSize().getHeight()>0 && element.getSize().getWidth()>0)
			  {
				  highLightElement(driver, element);
				  break;
			  }
			  else 
			  {
				System.out.println("Waiting for WebElement-Waiting for all states");
			
			  }
			}
			catch (Exception e) 
			{
				System.out.println("Waiting for WebElement-Retrying");
			}
		    try 
		    {
				Thread.sleep(1000);
			} 
		    catch (InterruptedException e) 
		    {
				
			}
		}
		    return element;
	}

	
	
	
	public static WebElement waitForWebElement(WebDriver driver,By locator)
	{
		//default wait I am setting is 30seconds
		WebElement element=null;
		for(int i=0;i<30;i++)
		{
			try 
			{	
			  element=driver.findElement(locator);
			  if(element.isDisplayed() && element.isEnabled() && element.getSize().getHeight()>0 && element.getSize().getWidth()>0)
			  {
				  highLightElement(driver, element);
				  break;
			  }
			  else 
			  {
				System.out.println("Waiting for WebElement-Waiting for all states");
			
			  }
			}
			catch (Exception e) 
			{
				System.out.println("Waiting for WebElement-Retrying");
			}
		    try 
		    {
				Thread.sleep(1000);
			} 
		    catch (InterruptedException e) 
		    {
				
			}
		}
		    return element;
	}
	

	
	
	
	
	public static void highLightElement(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('style', 'background:yellow;border:2px solid red;');", element);
		try {
			Thread.sleep(1000);
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		js.executeScript("arguments[0].setAttribute('style','border: sloid 2px white');", element);
	}
	
	
	public static String getCurrentDateTime()
	{
		Date currentDate=new Date();
		SimpleDateFormat myDateFormat=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		String date=myDateFormat.format(currentDate);
		return date;
	
		
	}
	
	public static void captureScreenshots(WebDriver driver)
	{
		 try 
		{
			FileHandler.copy(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File("./Screenshots/Screenshot_"+getCurrentDateTime() +".png"));
		} 
		catch (IOException e) 
		{
			System.out.println("Screenshot Failed "+e.getMessage());
		}
	}
	
	
	public static String acceptAlert(WebDriver driver)
	{
		Alert alt=driver.switchTo().alert();
		String alertText=alt.getText();
		return alertText;
		//driver.switchTo().alert().accept();
		
	}
	
	public static WebDriver startBrowser()
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://freelance-learn-automation.vercel.app/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	

	public static WebDriver startBrowser(String url)
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(10));
		
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	

	public static WebDriver startBrowser(String browser, String url)
	{
		WebDriver driver=null;
		if(browser.contains("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.contains("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.contains("Safari"))
		{
			driver=new SafariDriver();
		}
		else 
		{
			System.out.println("Sorry we dont support this browser-Please use Chrome,FF, Edge or Safari");
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return driver;
	}
	
	public static WebDriver startBrowser(String browser, String url, int wait)
	{
		WebDriver driver=null;
		if(browser.contains("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.contains("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.contains("Edge"))
		{
			driver=new EdgeDriver();
		}
		else if(browser.contains("Safari"))
		{
			driver=new SafariDriver();
		}
		else 
		{
			System.out.println("Sorry we dont support this browser-Please use Chrome,FF, Edge or Safari");
			
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(wait));
		return driver;
	}
	
	
	


	


	
	

}
