package Assignment.SeleniumAssignment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import firstassignment.AmazonHomePage;
import firstassignment.FlipkartHomePage;
import firstassignment.WebDriverUtils;

public class FirstAssignment {

	public AmazonHomePage amazonHomePage;
	Double amazonProductPrice;
	Double FlipkartProductPrice;
	WebDriver driver=null;
	WebDriverUtils utils;
	
	@BeforeMethod(alwaysRun = true)
	public void openApplication() {
		utils = new WebDriverUtils();
		driver = utils.initilizeDriver();
		
	}
	
	@Test(enabled=true)
	@Parameters({ "item","url1","url2" })
	public void amazonTest(String item,String url1,String url2) throws Exception{
		try {
					
			utils.openApplication(url1);
			amazonHomePage = new AmazonHomePage(driver);
			
			amazonProductPrice = amazonHomePage.searchProduct(item)
						  					   .clickOnProduct(item)
						  					   .getPrice();		
			
			amazonHomePage.switchToParentTab();
			
			utils.openApplication(url2);
			FlipkartHomePage FlipkartHomePage= new FlipkartHomePage(driver);
			
			FlipkartProductPrice = FlipkartHomePage.searchProduct(item)
												   .clickOnProduct(item)
												   .getPrice();
			
			
			if (amazonProductPrice > FlipkartProductPrice) {
				System.out.println("Amazon price is more than Flipkart");
			} else if (amazonProductPrice < FlipkartProductPrice) {
				System.out.println("Amazon price is less than Flipkart");
			} else {
				System.out.println("Both Amazon and Flipkart has same price");
			}
			
		}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
