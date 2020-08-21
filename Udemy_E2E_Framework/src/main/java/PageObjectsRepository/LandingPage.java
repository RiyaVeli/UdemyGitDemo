package PageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By loginLink = By.cssSelector("a[href*='sign_in']");
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By navBar = By.xpath("//nav[@class='navbar-collapse collapse']");
	By header = By.xpath("//div[contains(@class,'video-banner')]/h3");
	By popup=By.xpath("//button[text()='NO THANKS']");
	
	public LandingPage(WebDriver driver) { 
		//this driver is coming from @Test by crating constructor here
		// driver in the Test extends from the Basics 
		this.driver =driver;
	}
	
	public LogInPage getLogin() {
		driver.findElement(loginLink).click();
		LogInPage lp = new LogInPage(driver);
		return lp;
	}
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	public WebElement getHeader() {
		return driver.findElement(header);
	}
	public int getPopUpSize(){
	return driver.findElements(popup).size();
	}

	public WebElement getPopUp(){
	return driver.findElement(popup);
	}
}
