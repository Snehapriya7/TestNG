package Asserts;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions 
{
	@Test
	public void hardAsrt()
	{
		//Hard Assertion-Assert()
		System.out.println("Beginning...");
		Assert.assertTrue(true);
		System.out.println("Test1 passed");
		Assert.assertTrue(false);
		System.out.println("Test 2 failed");
		Assert.assertFalse(true);
		System.out.println("Test 3 failed");
		System.out.println("Ending...");
	}
	@Test
	public void softAsrt()
	{
		//Soft Assertion-SoftAssert()
		System.out.println("Beginning...");
		SoftAssert s=new SoftAssert();
		s.assertTrue(true);
		System.out.println("Test1 passed");
		s.assertTrue(false);
		System.out.println("Test 2 failed");
		s.assertFalse(true);
		System.out.println("Test 3 failed");
		System.out.println("Ending...");
		s.assertAll();
	}

}
