package PageObjectsRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class portalHomePage {
	
	public WebDriver driver;
	
	
	By searchCourse = By.id("search-courses");
	
	
	public portalHomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getSearchBox() {
		return driver.findElement(searchCourse);
		}
}
