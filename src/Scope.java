import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Navigate to the target website
		driver.get("https://www.qaclickacademy.com/");

		// 1 Give me the count of all links on the page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// 2 Count of footer section
		WebElement footerDriver = driver.findElement(By.id("footer-part")); // Limited webdriver scope
		System.out.println(footerDriver.findElements(By.tagName("a")).size());

		// 3 Count of second column in footer section
		WebElement columnDriver = footerDriver.findElement(By.xpath("//div[@class='footer-link mt-40']"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());

		// 4. Click on each link in the column and check if pages are opening

		// Store links in a list to avoid multiple DOM queries		
		List<WebElement> links = columnDriver.findElements(By.tagName("a"));
		// 
		//Iterate through the links
		for (int i = 1; i < links.size(); i++) {
			WebElement link = links.get(i);

			// Open the link in a new tab using Keys.CONTROL + Keys.ENTER
			String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
			link.sendKeys(clickOnLinkTab);			
		}
		
		// Switch to all opened tabs and print their titles to verify they opened
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> iterator = tabs.iterator();
		
		while (iterator.hasNext()) {  //check next window present or not
		    driver.switchTo().window(iterator.next());  //move to another window
		    System.out.println(driver.getTitle());
		}

	}

}
