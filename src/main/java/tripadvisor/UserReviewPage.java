package tripadvisor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserReviewPage {
	
	WebDriver driver;
	
	public String Ratingxpath = "//select[@id='qid10']//option[@value='5']";

	@FindBy(xpath="//*[@name='ReviewTitle']")
	public WebElement textBoxTitle;
	
	@FindBy(xpath="//textarea[@name='ReviewText']")
	public WebElement textBoxReview;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement chkBoxReview;
	
	@FindBy(xpath="//div[@class='easyClear bigRatingParent']//span[@data-value='0']")
	public WebElement bubbleRatings;
	
	public UserReviewPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	public UserReviewPage enterReviewTitle(String title) {
		textBoxTitle.sendKeys(title);
		return PageFactory.initElements(driver, UserReviewPage.class);
	}

	public UserReviewPage enterReviewSummart(String summary) {
		textBoxReview.sendKeys(summary);
		return PageFactory.initElements(driver, UserReviewPage.class);
	}
	
	public UserReviewPage clickReviewCheckBox() {
		chkBoxReview.click();
		return PageFactory.initElements(driver, UserReviewPage.class);
	}
	
	public UserReviewPage clickOnRating() {

		 Actions action = new Actions(driver);
		 action.moveToElement(bubbleRatings).click().build().perform();
		 
		return PageFactory.initElements(driver, UserReviewPage.class);
	}
	
}

