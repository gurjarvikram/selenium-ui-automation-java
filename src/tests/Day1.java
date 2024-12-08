package tests;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Day1 {
	
	@AfterTest()
	public void lastExecution()
	{
		System.out.println("I will execute last");
	}
	
	@Test
	public void demo()
	{
		System.out.println("Demo");
		Assert.assertTrue(false);
	}
	@AfterSuite()
	public void afSuite()
	{
		System.out.println("I am the no 1 from last");
	}
	
	@Test
	public void  secondTest()
	{
		System.out.println("Second");
	}

}
