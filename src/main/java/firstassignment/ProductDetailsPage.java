package firstassignment;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

	WebDriver driver;
	
	public ProductDetailsPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@id='priceblock_ourprice'] | //div[@class='_1vC4OE _3qQ9m1']")
	public WebElement txtPrice;
	
	/**
	 * Method to get price of the product
	 * 
	 */
	public Double getPrice(){
		
		switchTab();
		String price = txtPrice.getText().replaceAll("[^0-9.]", "");	
		return Double.valueOf(price);
	}

	public void switchTab(){
		
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	}
	
}
