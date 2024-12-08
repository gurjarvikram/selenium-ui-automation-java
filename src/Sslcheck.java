import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Sslcheck {

	public static void main(String[] args) {
		// Detect operating system
		String osName = System.getProperty("os.name").toLowerCase();
		boolean isMac = osName.contains("mac");
		WebDriver driver = null;

		String browser = "firefox"; // // Change to "chrome", "edge", or "safari" as needed

		switch (browser.toLowerCase()) {
		case "chrome":
			ChromeOptions chromeOptions = new ChromeOptions();
			//HTTPS certificate handling  
			chromeOptions.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(chromeOptions);
			break;
		case "firefox":
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setAcceptInsecureCerts(true);
			driver = new FirefoxDriver(firefoxOptions);
			break;
		case "edge":
			EdgeOptions edgeOptions = new EdgeOptions();
			edgeOptions.setAcceptInsecureCerts(true);
			driver = new EdgeDriver(edgeOptions);
			break;
		case "safari":
			if (isMac) {
				System.out.println("Safari is only supported on macOS. Running tests on Safari...");
				driver = new org.openqa.selenium.safari.SafariDriver();
			} else {
				System.out.println("Safari is not supported on this OS.");
				System.exit(0);
			}
			break;
		default:
			System.out.println("Invalid browser specified.");
			System.exit(0);
		}

		if (driver != null) {
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get("https://expired.badssl.com/");
			System.out.println("Page title: " + driver.getTitle());
			driver.quit();
		}
	}
}
