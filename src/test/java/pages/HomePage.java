package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
WebDriver driver;
WebDriverWait wait ;

public HomePage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

//Locators
@FindBy(xpath="//input[@name=\"select_city\"]")
WebElement selectcity;

@FindBy(xpath="(//span[text()=\"Pune\"])[3]")
WebElement entercity;

@FindBy(xpath="(//a[text()='Flowers'])[1]")
WebElement flowers;

@FindBy(xpath="//a[text()='Flower Bouquet']")
WebElement flowertype;

@FindBy(xpath="//li[normalize-space()='Mixed']")
WebElement selectoption;

//@FindBy(xpath="//p[text()='Popularity']")////p[normalize-space()='Popularity']
WebElement selectpopularity;

//@FindBy(xpath="//li[normalize-space()='Low to High']")
WebElement lth;

@FindBy(xpath="//a[text()='Garden Symphony']")
WebElement flower;

//Actions
public void locationactions() throws InterruptedException
{
	wait.until(ExpectedConditions.visibilityOf(selectcity));
	selectcity.sendKeys("Pune");
	
	wait.until(ExpectedConditions.visibilityOf(entercity));
	entercity.click();
	Thread.sleep(5000);
	
	}
public void floweractions() throws InterruptedException
{
	Actions act =new Actions(driver);
	act.moveToElement(flowers).build().perform();
	Thread.sleep(5000);
	flowertype.click();
}
public void particlarsaction() throws InterruptedException
{
	selectoption.click();
	Thread.sleep(3000);
	flower.click();
	Thread.sleep(3000);
	//selectpopularity.click();
	//Thread.sleep(2000);
	//lth.click();
	//Thread.sleep(5000);
	}

}
