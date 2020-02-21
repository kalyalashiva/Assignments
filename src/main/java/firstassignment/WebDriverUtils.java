package firstassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverUtils {
	public WebDriver driver;
	
	public WebDriver initilizeDriver() {
			System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;	
	}
	
	public void openApplication(String url) {
		
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void killDriver() {
	        driver.quit();
	}

}
