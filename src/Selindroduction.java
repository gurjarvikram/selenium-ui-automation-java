
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selindroduction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Firefox
		// System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
		// WebDriver driver = new FirefoxDriver();

		// Microsoft Edge
		// System.setProperty("webdriver.edge.driver", "/usr/local/bin/msedgedriver");
		// WebDriver driver = new EdgeDriver();

		// Chrome
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/");

		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		driver.close();
	}

}
