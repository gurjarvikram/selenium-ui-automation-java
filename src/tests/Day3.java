package tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Day3 {
	
	@BeforeClass()
	public void befClass()
	{
		System.out.println("Before executing any methods in the class");
	}
	
	@Parameters({"URLCarLoan","keyAPI"})
	@Test
	public void webLoginCarLoan(@Optional("https://default.com") String urlCar, 
            @Optional("defaultKey") String apiKeyValue)
	{
		System.out.println("web login car loan");
		System.out.println(urlCar);
		System.out.println(apiKeyValue);
	}
	@BeforeSuite()
	public void  wfSuite()
	{
		System.out.println("I am no 1");
	}
	
	@Test(groups = {"smoke"})
	public void  mobileLoginCarLoan()
	{
		System.out.println("mobile loginin car");
	}
	
	@Test(enabled = false)
	public void mobileSignCarLoan()
	{
		System.out.println("mobile signin car");
	}
	
	@Test
	public void mobileSignOutCarLoan()
	{
		System.out.println("mobile signout car");

	}
	
	@Test(dataProvider="getData")
	public void testDataDriven(String username,String password)
	{
		System.out.println("This is data driven testing");
		System.out.println(username);
		System.out.println(password);
	}

	@Test(dependsOnMethods= {"webLoginCarLoan","mobileSignOutCarLoan"})
	public void loginAPICarLoan()
	{
		System.out.println("login API car loan");
	}
	
	@Test(timeOut= 5000)
	public void  loanCar()
	{
		System.out.println("loan car");
	}
	
	@BeforeMethod()
	public void  beforEvery()
	{
		System.out.println("I will execute before every test method in day3 class");
	}
	
	@AfterMethod()
	public void  afterEvery()
	{
		System.out.println("I will execute after every test method in day3 class");
	}
	
	@AfterClass()
	public void  aftClass()
	{
		System.out.println("After executing any methods in the class");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//1st combination -username password - Good credit history  = row
		//2nd username password - no credit history
		//3rd fraudelent credit history
		
		Object[][] data = new Object[3][2];
		
		//1st set
		data[0][0] = "firstSetUsername";
		data[0][1] = "firstPassword";

		//2nd set
		data[1][0] = "secondSetUsername";
		data[1][1] = "secondpassword";
		
		//3rd set
		data[2][0] = "thirdSetUsername";
		data[2][1] = "thirdpassword";
		return data;
	}
	
}
