package tripadvisor;


import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelDetailsPage {
	WebDriver driver;
	
	public HotelDetailsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//h1[@id='HEADING']")
	public WebElement headerHotelTitle;
	
	@FindBy(xpath="//a[text()='Write a review']")
	public WebElement btnWriteAReview;
	
	/**
	 * Method to click on Write a Review button
	 * 
	 */
	public UserReviewPage clickOnWriteAReview() {
		
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", btnWriteAReview);
		
		btnWriteAReview.click();
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		
		return PageFactory.initElements(driver, UserReviewPage.class);
		
	}
}
