package firstassignment;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlipkartHomePage {

	WebDriver driver;
	
	public FlipkartHomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@type='text']")
	public WebElement textBoxSearch;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement btnSearch;
	
	@FindBy(xpath="//div[@class='col col-7-12']/div[@class='_3wU53n']")
	public List<WebElement> linkSearchResults;
	
	@FindBy(xpath="//div[@class='col col-7-12']/div[@class='_3wU53n']")
	public WebElement linkSearchResult;
	
	@FindBy(xpath="//button[@class='_2AkmmA _29YdH8']")
	public WebElement btnClosePopup;
	
	public FlipkartHomePage searchProduct(String mobile) {
		
		closeLoginPopup();
		textBoxSearch.clear();
		textBoxSearch.sendKeys(mobile);
		btnSearch.click();
		
		return PageFactory.initElements(driver, FlipkartHomePage.class);
		
	}
	
	public ProductDetailsPage clickOnProduct(String product) {
				
		/*for(WebElement link:linkSearchResults) {
			
			if(link.getText().contains(product)) {
				link.click();
			}
		}*/
	
		linkSearchResult.click();
		return PageFactory.initElements(driver, ProductDetailsPage.class);
		
	}
	
	public void closeLoginPopup() {
		
		if(btnClosePopup.isDisplayed()) {
			btnClosePopup.click();
		}
	}
	
}
