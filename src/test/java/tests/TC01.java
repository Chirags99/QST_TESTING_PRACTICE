package tests;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.ProductPage;

@Listeners(utilities.TestListener.class)
public class TC01 extends BaseTest {
@Test
	public void test1() throws InterruptedException
	{
		HomePage hm = new HomePage(driver);
		ProductPage pp = new ProductPage(driver);
		hm.locationactions();
		hm.floweractions();
		hm.particlarsaction();
		pp.switchToChildWindow();
		pp.ppactions();
		
	}

}
