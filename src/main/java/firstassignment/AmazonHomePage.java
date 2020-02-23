package firstassignment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonHomePage extends WebDriverUtils{

	WebDriver driver;
	
	public AmazonHomePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@id='twotabsearchtextbox']")
	public WebElement textBoxSearch;
	
	@FindBy(xpath="//input[@value='Go']")
	public WebElement btnSearchIcon;
	
	@FindBy(xpath="//span[contains(@class,' a-text-normal')]")
	public List<WebElement> linkSearchResults;
	
	@FindBy(xpath="//span[@id='priceblock_ourprice']")
	public WebElement txtPrice;
	
	/**
    	 * Method to search product.
	 * @param productName
     	 *  
     	 */
	public AmazonHomePage searchProduct(String mobile) {
		
		textBoxSearch.clear();
		textBoxSearch.sendKeys(mobile);
		btnSearchIcon.click();
		
		return PageFactory.initElements(driver, AmazonHomePage.class);
	}
	
	/**
    	 * Method to click on the product
     	 * @param productName
	 *
     	 */
	public ProductDetailsPage clickOnProduct(String mobile) {
				
		for(WebElement link:linkSearchResults) {
			
			if(link.getText().contains(mobile)) {
				link.click();
			}
		}
		
		return PageFactory.initElements(driver, ProductDetailsPage.class);
		
	}

	public void switchTab() {
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));

	}
	
	/**
    	 * Method to get price of required product
	 *
     	 */
	public Double getPrice() throws InterruptedException {
		
		switchTab();
		System.out.println(driver.getTitle());
		String price = txtPrice.getText().replaceAll("[^0-9.]", "");	
		return Double.valueOf(price);
	}
	
	public void switchToParentTab() {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.close();
		driver.switchTo().window(tabs.get(0));
	}
}
