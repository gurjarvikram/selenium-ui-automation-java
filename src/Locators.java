import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("Vikram");
		driver.findElement(By.name("inputPassword")).sendKeys("hellow123");
		driver.findElement(By.className("signInBtn")).click();
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);
		// Forgot password page
		driver.findElement(By.cssSelector("input[type='text']:nth-child(2)")).sendKeys("Vikcy");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("vk@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("vicky@gmail.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9123456789");
		// reset button
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		// validation message
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());

		// Navigate to login page
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		// login with valid username and password
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxTwo")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		driver.close();

	}

}
