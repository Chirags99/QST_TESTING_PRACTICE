package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public static WebDriver driver;
	@BeforeMethod
	public static WebDriver setup() {
		driver = WebDriverManager.firefoxdriver().create();
		//driver = WebDriverManager.chromedriver().create();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.floweraura.com/");
		return driver;
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
}
