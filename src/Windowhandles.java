import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Windowhandles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Navigate to the target website
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		// Click on the link to open a new child window
		driver.findElement(By.xpath("//a[@class='blinkingText'][1]")).click();

		// Get the window handles for parent and child windows
		Set<String> windows = driver.getWindowHandles(); // This will hold IDs for both windows [parentId, childId]
		Iterator<String> it = windows.iterator();
		String parentId = it.next(); // Get the parent window ID
		String childId = it.next();  // Get the child window ID

		// Switch to the child window
		driver.switchTo().window(childId);

		// Print the text containing the email on the child window (debugging purposes)
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

		// Extract the email ID from the text in the child window
		String emailId = driver.findElement(By.cssSelector(".im-para.red")).getText()
		    .split("at")[1].trim()  // Split the text to isolate the portion after "at"
		    .split(" ")[0];         // Further split to extract only the email ID

		// Switch back to the parent window
		driver.switchTo().window(parentId);

		// Enter the extracted email ID into the username input field on the parent window
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(emailId);


	}

}
