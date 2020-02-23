package tripadvisor;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserReviewPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//*[@name='ReviewTitle']")
	public WebElement textBoxTitle;
	
	@FindBy(xpath="//textarea[@name='ReviewText']")
	public WebElement textBoxReview;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement chkBoxReview;
	
	@FindBy(id="bubble_rating")
	public WebElement overAllRating;
	
	@FindBy(xpath="//span[contains(@id,'_bubbles')]")
	public List<WebElement> allRatings;
	
	public UserReviewPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Method to enter Review Title
	 * @param titleName
	 * 
	 */
	public UserReviewPage enterReviewTitle(String title) {
		textBoxTitle.sendKeys(title);
		return PageFactory.initElements(driver, UserReviewPage.class);
	}

	/**
	 * Method to enter Review Summary
	 * @param summary
	 * 
	 */
	public UserReviewPage enterReviewSummart(String summary) {
		textBoxReview.sendKeys(summary);
		return PageFactory.initElements(driver, UserReviewPage.class);
	}
	
	/**
	 * Method to Click on submit CheckBox
	 * 
	 */
	public UserReviewPage clickReviewCheckBox() {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", chkBoxReview);
		chkBoxReview.click();
		return PageFactory.initElements(driver, UserReviewPage.class);
	}
	
	/**
	 * Method to click on Over all Rating 
	 * 
	 */
	public UserReviewPage clickOnOverAllRating() {

		 Actions action = new Actions(driver);
		 action.moveToElement(overAllRating, 75, 0).click().build().perform();
		 
		return PageFactory.initElements(driver, UserReviewPage.class);
	}
	
	/**
	 * Method to click on Hotel Ratings
	 * Service Rating, Room Rating, Cleanliness Rating, Sleep Quality, Location Rating, Value Rating  
	 *
	 */
	public UserReviewPage clickOnHotelRatings() {

		 Actions action = new Actions(driver);
		 	
		for(WebElement ele:allRatings) {
			if(ele.isDisplayed()) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
				 action.moveToElement(ele, 40, 0).click().build().perform();		
			}
		}
		return PageFactory.initElements(driver, UserReviewPage.class);
	}
}
