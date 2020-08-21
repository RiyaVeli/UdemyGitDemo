package PageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage {
public WebDriver driver;
	
	public LogInPage(WebDriver driver) { 
		this.driver =driver;
	}
	
	By EmailEntry = By.id("user_email");
	By PasswordEntry = By.id("user_password");
	By LoginBtn = By.xpath("//input[@name='commit']");
	By forgotPsw = By.cssSelector(".link-below-button");
	
	public WebElement EmailEntry() {
		return driver.findElement(EmailEntry);
	}
	public WebElement PasswordEntry() {
		return driver.findElement(PasswordEntry);
	}
	public WebElement LoginBtn() {
		return driver.findElement(LoginBtn);
	}
	
	public ForgotPasswordPage forgotPswLink() {
		driver.findElement(forgotPsw).click();
		return new ForgotPasswordPage(driver);
	}
}
