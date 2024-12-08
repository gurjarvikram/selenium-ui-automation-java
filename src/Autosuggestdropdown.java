import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestdropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");

		// Select country from auto suggested drop down
		driver.findElement(By.id("autosuggest")).sendKeys("ind");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a")); // Country list

		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		driver.close();
		
	}

}
