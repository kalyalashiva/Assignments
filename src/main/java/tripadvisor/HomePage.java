package tripadvisor;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import firstassignment.WebDriverUtils;

public class HomePage extends WebDriverUtils{
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@title='Search'] | //span[text()='Search']")
	public WebElement btnSearchIcon;
	
	@FindBy(xpath="//input[@id='mainSearch']")
	public WebElement textBoxSearch;
	
	@FindBy(xpath="//div[@id='SEARCH_BUTTON_CONTENT']")
	public WebElement btnSearch;
	
	@FindBy(xpath="//div[@class='result-title']/span")
	public List<WebElement> resultList;
	
	public SearchResultsPage searchHotel(String hotelName) {
		
		btnSearchIcon.click();
		textBoxSearch.sendKeys(hotelName);
		btnSearch.click();
		
		return PageFactory.initElements(driver, SearchResultsPage.class);
	}
	
}
