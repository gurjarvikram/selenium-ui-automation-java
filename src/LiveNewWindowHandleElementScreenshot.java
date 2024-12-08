import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class LiveNewWindowHandleElementScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		//Fill the Name field with the first course name available to another new window 
		// Navigate to the target website
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//Switching window
		driver.switchTo().newWindow(WindowType.WINDOW);
		
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> it = handles.iterator();
		String parentWindowId = it.next();
		String childWindowId = it.next();
		
		driver.switchTo().window(childWindowId);
		driver.get("https://rahulshettyacademy.com/");
		String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();
		//Back to the parent window
		driver.switchTo().window(parentWindowId);		
		WebElement name = driver.findElement(By.cssSelector("input[name='name']"));  //name textbox locator
		name.sendKeys(courseName);
		
		
		//Capture element screenshot
		File src = name.getScreenshotAs(OutputType.FILE);
		File des = new File("/home/b/Desktop/screenshots/elementScreenshot.png");
		FileUtils.copyFile(src, des);
		
		
		//Get height and Width		
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		
		
		driver.quit();
		
		
		

	}

}
