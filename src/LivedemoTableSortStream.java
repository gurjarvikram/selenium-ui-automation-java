import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LivedemoTableSortStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		
		//Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();
		
		//Capture all webelements into list
		List<WebElement> elementList= driver.findElements(By.xpath("//tr/td[1]"));
		
		//Capture text of all webelements into new (original)list
		List<String> originalList = elementList.stream().map(s-> s.getText()).collect(Collectors.toList());
		
		//Sort on the original list of step 3 -> sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		//Compare original list vs sorted list
		Assert.assertTrue(originalList.equals(sortedList));
		
		
		
		
		
		//Scan the name column  with gettext using pagination  -> rice -> print the price of rice.
		List<String> price;
		
		do 
		{
			List<WebElement> row= driver.findElements(By.xpath("//tr/td[1]"));
			
			price= row.stream().filter(s-> s.getText().contains("Rice"))
			.map(s-> getPriceVeggie(s)).collect(Collectors.toList());
			price.forEach(a-> System.out.println(a));
			
			if(price.size() < 1) 
			{
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
				
			}			
			
		}while(price.size() < 1);

	}

	private static String getPriceVeggie(WebElement s) {
		// TODO Auto-generated method stub
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return priceValue;
	}

}
