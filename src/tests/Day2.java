package tests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Day2 {
	
	@Test(groups = {"smoke"})
	public void  pLoan()
	{
		System.out.println("Personal");
	}
	
	@BeforeTest()
	public void prerequiste()
	{
		System.out.println("I will execute first");
	}


}
