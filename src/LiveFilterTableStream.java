import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LiveFilterTableStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Search vegetable with Rice
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("Rice");
		//1 result
		List<WebElement> veggies = driver.findElements(By.xpath("//tr/td[1]"));
		
		//1 Result
		List<WebElement> filteredList = veggies.stream().filter(veggie-> veggie.getText().contains("Rice")).collect(Collectors.toList());
		
		Assert.assertEquals(veggies.size(), filteredList.size());

	}

}
