package PageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage {
public WebDriver driver;
	
	public ForgotPasswordPage(WebDriver driver) { 
		this.driver =driver;
	}
	
	By EmailEntry = By.id("user_email");
	By sendMeInstructions= By.xpath("//input[@name='commit']");
	
	public WebElement EmailEntry() {
		return driver.findElement(EmailEntry);
	}
	public WebElement sendMeInstructions() {
		return driver.findElement(sendMeInstructions);
	}
}
