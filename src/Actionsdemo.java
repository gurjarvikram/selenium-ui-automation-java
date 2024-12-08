import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actionsdemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Perform the sequence to type "HELLO" in the input field
		Actions a = new Actions(driver);
		WebElement inputField = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
		a.moveToElement(inputField).click().keyDown(Keys.SHIFT).sendKeys("Hello").doubleClick().perform();

		// Perform a right-click (context click) on a specific web element
		 WebElement moveSign =
		 driver.findElement(By.cssSelector("a[data-csa-c-content-id='nav_ya_signin']"));
		 a.moveToElement(moveSign).contextClick().perform();

	}

}
