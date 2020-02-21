package Assignment.SeleniumAssignment;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import firstassignment.WebDriverUtils;
import tripadvisor.HomePage;

public class TripAdvisorTest {
	
	public HomePage homePage;
	WebDriver driver=null;
	WebDriverUtils utils;
	
	@BeforeMethod(alwaysRun = true)
	public void openApplication() {
		utils = new WebDriverUtils();
		driver = utils.initilizeDriver();
		
	}
	
	@Test(enabled=true)
	@Parameters({ "url","hotelName","title","summary"})
	public void amazonTest(String url,String hotelName,String title,String summary) throws Exception{
		try {
					
			utils.openApplication(url);
			homePage = new HomePage(driver);
			
			homePage.searchHotel(hotelName)
					.clickOnHotel()
					.clickOnWriteAReview()
					.clickOnRating()
					.enterReviewTitle(title)
					.enterReviewSummart(summary)
					.clickReviewCheckBox();
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
