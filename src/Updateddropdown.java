import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Updateddropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.navigate().to("https://www.spicejet.com/");

		// Select radio button
		driver.findElement(By.xpath("//div[text()='Senior Citizen']")).click();
		Thread.sleep(3000);

		// Verify the radio button is selected by checking the 'fill' attribute
		String fillValue = driver.findElement(By.xpath("(//*[name()='circle'][@fill='#EDB16A'])[2]"))
				.getAttribute("fill");
		System.out.println(fillValue.equals("#EDB16A")); // This should return true if the button is selected

		Thread.sleep(2000);
		// Count the number of checkbox
		System.out.println(driver
				.findElements(By.xpath("//div[@class='css-1dbjc4n r-1awozwy r-1loqt21 r-18u37iz r-15d164r r-1otgn73']"))
				.size());

		driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).click();
		Thread.sleep(2000);

		/*
		 * int i = 1; while(i < 5) {
		 * driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']"
		 * )).click(); //add 5 adults i++;
		 * 
		 * }
		 */

		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.xpath("//div[@data-testid='Adult-testID-plus-one-cta']")).click(); // add 5 adults

		}

		Assert.assertEquals(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText(), "5 Adults");

		// Click on the Done button
		driver.findElement(By.cssSelector("div[data-testid='home-page-travellers-done-cta']")).click();

		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Adult')]")).getText());

		// round trip
		driver.findElement(By.xpath("//div[contains(text(),'round trip')]")).click();
		System.out.println(driver.findElement(By.xpath("//div[contains(text(),'Select Date')]")).isEnabled());

	}

}
