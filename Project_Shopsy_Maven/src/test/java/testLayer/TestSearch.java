package testLayer;

import org.testng.annotations.Test;

import baseLayer.BaseTest;
import pageLayer.SearchProduct;

public class TestSearch extends BaseTest {
	
	@Test
	
	public void TC01() throws InterruptedException {
		
		SearchProduct sp = new SearchProduct(driver);
		sp.search("Mobiles");
		sp.pressEnterKey();
		sp.clickMoto();
		sp.clicAddCart();
		sp.removeFromCart();
		sp.removeToclick();
	
		
	}

}
