package tests;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day4 {
	
	@Parameters({"URL"})
	@Test
	public void  webLoginHomeLoan(String urlHome)
	{
		System.out.println("web login home loan");
		System.out.println(urlHome);
	}
	
	@Test(groups = {"smoke"})
	public void  mobileLoginHomeLoan()
	{
		System.out.println("mobile Login home loan");
	}

	@Test
	public void  loginAPIHomeLoan()
	{
		System.out.println("login API home loan");
	}
	
}
