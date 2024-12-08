import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Additemcart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//Implicitly wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		//Explicitly wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String[] itemsNeeded = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		addItems(driver, itemsNeeded);

		// click on cart icon
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		// checkout button
		driver.findElement(By.xpath("//div[@class='cart-preview active']//button[@type='button']")).click();

		//Explicitly wait
		//productCartTables
		wait.until(webDriver -> webDriver.findElement(By.cssSelector("#productCartTables")).isDisplayed());
		
		
		// promo code
		driver.findElement(By.cssSelector("input[placeholder$='Enter promo code']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector(".promoBtn")).click();
		
		//Explicitly wait		
		wait.until(webDriver -> webDriver.findElement(By.cssSelector(".promoInfo")).isDisplayed());
		//Promo code successfully applied
		System.out.println(driver.findElement(By.cssSelector(".promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] itemsNeeded) {
		int j = 0;
		// adding items into cart for ecommerce app
		// array of products to cart for checkout
		List<WebElement> products = driver.findElements(By.cssSelector("h4[class='product-name']"));

		for (int i = 0; i < products.size(); i++) {

			// Brocolli - 1 Kg
			// split to veggies from - , in two parts
			// Brocolli, - 1 Kg

			String[] name = products.get(i).getText().split("-");
			String formatedName = name[0].trim();

			// format it to get actual vegetable name
			// convert array to array list for easy search
			// check whether name you extracted is present in arrayList or not
			List<String> itemNeededList = Arrays.asList(itemsNeeded);

			if (itemNeededList.contains(formatedName)) {
				j++;
				// click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeeded.length) {
					break;
				}

			}
		}

	}

}
