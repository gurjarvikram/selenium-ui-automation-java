import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frametest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Navigate to the target website
		driver.get("https://jqueryui.com/droppable/");
		//
		// Confirm how many iframes are present on the webpage
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		// Switch to the iframe containing draggable and droppable elements
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

		//or using index
		//driver.switchTo().frame(0);
		
		// Locate the draggable (source) and droppable (target) elements
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.xpath("//div[@class='ui-widget-header ui-droppable']"));
		
		// Perform drag-and-drop using the Actions class
		Actions a = new Actions(driver);
		a.dragAndDrop(source,target).perform();
		driver.switchTo().defaultContent();
		
	}

}
