import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Brokenlinks {

	public static void main(String[] args) throws MalformedURLException, IOException {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		// Navigate to the target website
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		//Broken URL
		//Step -1 Is to get all urls tied up to the links using selenium
		//Java method will call URL's and gets you the status code
		//if status code > 400 then that url is not working -> link which tied to url is broken
		
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
		SoftAssert softAssert = new SoftAssert();
		
		for(WebElement link : links) 
		{
			
			String urlString = link.getAttribute("href");	
			
            // Use URI to create URL and avoid deprecation warnings
            URI uri = URI.create(urlString); // Create URI
            URL url = uri.toURL(); // Convert URI to URL

            //Open connection method to identify status codes of the links
            // Open connection to the URL
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD"); // Use HEAD to get only the headers
            conn.connect(); // Establish the connection

			// Get and print the response code
			int respCode = conn.getResponseCode();	
			System.out.println(respCode);
			
			//implement the softAssert
			softAssert.assertTrue(respCode < 400, "The link with text"+link.getText()+" is broken with code " +respCode);		
			
		}
		softAssert.assertAll();		

		
	}

}
