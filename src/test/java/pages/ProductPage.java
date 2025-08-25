package pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
WebDriver driver;
WebDriverWait wait ;

public ProductPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
	 wait = new WebDriverWait(driver, Duration.ofSeconds(20));
}

// Method to switch to child window
public void switchToChildWindow() {
    Set<String> windowHandles = driver.getWindowHandles();
    Iterator<String> iterator = windowHandles.iterator();

    String parentWindow = iterator.next();
    String childWindow = iterator.next();

    System.out.println("Parent Window ID: " + parentWindow);
    System.out.println("Child Window ID: " + childWindow);

    driver.switchTo().window(childWindow);  // Switch to child
}

//Locators
@FindBy(xpath="//a[text()='ADD TO CART']")
WebElement atc;

@FindBy(xpath="//div[text()='Skip']")
WebElement skip;

@FindBy(xpath="//span[text()='Cart']")
WebElement cart;

@FindBy(xpath="//div[@class='countBorCom countDec active']")
WebElement minus;

@FindBy(xpath="//div[text()='Remove']")
WebElement removeconfirm;

//Actions
public void ppactions() throws InterruptedException
{
	//wait.until(ExpectedConditions.elementToBeClickable(atc)).click();
	wait.until(ExpectedConditions.visibilityOf(atc)).click();
	//atc.click();
	//Thread.sleep(5000);
	wait.until(ExpectedConditions.visibilityOf(skip)).click();
	//skip.click();
	Thread.sleep(5000);
	cart.click();
	Thread.sleep(5000);
	minus.click();
	Thread.sleep(5000);
	removeconfirm.click();
	Thread.sleep(5000);
	}


}
