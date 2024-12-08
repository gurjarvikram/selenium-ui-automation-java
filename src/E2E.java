import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://www.spicejet.com/");

		// From
		driver.findElement(By.cssSelector("div[data-testid='to-testID-origin'] input[type='text']")).sendKeys("Bho");
		// driver.findElement(By.xpath("//div[text()='Jaipur']")).click();

		// destination
		driver.findElement(By.cssSelector("div[data-testid='to-testID-destination'] input[type='text']"))
				.sendKeys("Ah");
		driver.findElement(By.xpath("//div[text()='Ahmedabad']")).click();

		// Departure date
		driver.findElement(By.xpath(
				"(//div[@data-testid='undefined-month-December-2024']//div[@class='css-1dbjc4n r-1awozwy r-14lw9ot r-1loqt21 r-eu3ka r-1otgn73 r-1aockid'])[7]"))
				.click();

		System.out.println(driver.findElement(By.cssSelector(
				"div[class='css-1dbjc4n r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73'] div[class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']"))
				.isDisplayed());
		Assert.assertTrue(driver.findElement(By.cssSelector(
				"div[class='css-1dbjc4n r-11u4nky r-z2wwpe r-1phboty r-rs99b7 r-1loqt21 r-13awgt0 r-ymttw5 r-5njf8e r-1otgn73'] div[class='css-1dbjc4n r-1awozwy r-18u37iz r-1wtj0ep']"))
				.isDisplayed());

		// Passengers
		driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).click();

		for (int i = 1; i < 3; i++) {
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click(); // add 5 adults

		}
		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText(), "3 Adults");
		// Click on the Done button
		driver.findElement(By.cssSelector("div[data-testid='home-page-travellers-done-cta']")).click();

		// Search Flight

		driver.findElement(By.xpath("//div[@data-testid='home-page-flight-cta']")).click();

	}

}
