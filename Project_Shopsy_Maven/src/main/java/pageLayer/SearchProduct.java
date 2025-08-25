package pageLayer;



import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchProduct {
	
	WebDriver driver;

	public SearchProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// locator
	
	@FindBy(xpath="//input[@ placeholder='Search for Products, Brands and More']")
	WebElement searchInput;
	
	@FindBy(xpath="(//img[@alt='Image Placeholder'])[25]")
	WebElement motomobile;
	
	@FindBy(xpath="(//div[@class='css-175oi2r'])[8]")
	WebElement addtoCart;
	
	@FindBy(xpath="(//img[@alt='Image Placeholder'])[3]")
	WebElement removeCart;
	
	@FindBy(xpath="//div[@class='css-146c3p1 r-1tcj4yv r-1vgyyaa r-1b43r93 r-1rsjblm r-1un7vkp']")
	WebElement remove;
	
	// action
	
	public void search(String productName) throws InterruptedException {
		searchInput.sendKeys(productName);
		Thread.sleep(2000);
	}
	public void pressEnterKey() throws InterruptedException {
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
    }
	public void clickMoto() throws InterruptedException {
		motomobile.click();
		Thread.sleep(2000);
	}
	public void clicAddCart() throws InterruptedException {
		addtoCart.click();
		Thread.sleep(2000);
	}
	public void removeFromCart() throws InterruptedException {
		removeCart.click();
		Thread.sleep(2000);
	}
	public void removeToclick() throws InterruptedException {
		remove.click();
		Thread.sleep(2000);
	}

}
