import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Miscellaneous {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();		
		driver.manage().window().maximize();

		//Delete cookies
		driver.manage().deleteAllCookies();	
		
		//Click on any link
		//Login page - verify login url		
		//driver.manage().deleteCookieNamed("sessionKey");
		
		driver.get("https://google.com/");
		
		//Screenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File des = new File("//home/b//Desktop//screenshots//screenshot.png");
		FileUtils.copyFile(src, des);
		

	}

}
