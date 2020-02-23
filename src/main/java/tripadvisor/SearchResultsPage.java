package tripadvisor;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchResultsPage {
	
	WebDriver driver;
	
	public SearchResultsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='result-title']/span")
	public WebElement hotelLink;
	
	/**
	 * Method to click on Hotel Link
	 * @param hotelName
	 * 
	 */
	public HotelDetailsPage clickOnHotel() {
		
		hotelLink.click();
		switchToChildTab();
		
		return PageFactory.initElements(driver, HotelDetailsPage.class);
	}
	
	public void switchToChildTab() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}

}
