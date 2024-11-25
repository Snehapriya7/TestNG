package getting_started;



import org.testng.annotations.Test;

public class TestngExample2 
{
	@Test
   public void loginToApplication()
   {
	   System.out.println("Login into Application");
   }
	@Test
	public void makePayment()
	   {
		   System.out.println("Payment done by CC");
	   }
	@Test
	public void collectReceipt()
	   {
		   System.out.println("Receipt collected");
		
	   }
	@Test
	public void logoutFromApplication()
	{
		System.out.println("logout from app");
	}
}
