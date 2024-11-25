package Groups;

import org.testng.annotations.Test;

public class GroupTestDemo
{
	@Test(groups = "Login")
	public void login()
	{
		System.out.println("login test");
	}
	
	@Test(groups = {"Login","Transactions"})
	public void logout()
	{
		System.out.println("logout test");
	}
	
	@Test(groups = "Transactions")
	public void Deposit()
	{
		System.out.println("Deposit test");
	}
	
	@Test(groups = "Transactions")
	public void Withdraw()
	{
		System.out.println("Withdraw test");
	}


}
