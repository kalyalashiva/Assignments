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
	
	public UserReviewPage clickOnWriteAReview() {
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");		
		btnWriteAReview.click();
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		
		return PageFactory.initElements(driver, UserReviewPage.class);
		
	}
}
