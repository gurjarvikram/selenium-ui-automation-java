import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamicdropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.navigate().to("https://www.spicejet.com/");
		//From
		driver.findElement(By.cssSelector("div[data-testid='to-testID-origin'] input[type='text']")).sendKeys("Jai");	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='Jaipur']")).click();
		
		//destination
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("div[data-testid='to-testID-destination'] input[type='text']")).sendKeys("Ah");	
		driver.findElement(By.xpath("//div[text()='Ahmedabad']")).click();
		
		driver.close();
	}

}
