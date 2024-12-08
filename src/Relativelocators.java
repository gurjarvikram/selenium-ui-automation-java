import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Relativelocators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//Above relative loc
		WebElement nameEditBox = driver.findElement(By.cssSelector("input[name='name']"));		
		System.out.println(driver.findElement(with(By.tagName("label")).above(nameEditBox)).getText());
		
		//Below relative loc
		WebElement dateOfBirth = driver.findElement(By.cssSelector("[for='dateofBirth']"));
		driver.findElement(with(By.tagName("input")).below(dateOfBirth)).click();
		
		//toLeftOf relative loc
		WebElement iceCream = driver.findElement(By.xpath("//label[@for='exampleCheck1']"));
		driver.findElement(with(By.tagName("input")).toLeftOf(iceCream)).click();
		
		//toRightOf relative loc
		WebElement rdb = driver.findElement(By.cssSelector("#inlineRadio1"));
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
		
		
		
	}

}
