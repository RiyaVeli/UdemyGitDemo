package academy;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectsRepository.LandingPage;
import Resources.Basics;

public class validateTitleTest extends Basics {
	public static Logger logger = LogManager.getLogger(Basics.class.getName());
	public WebDriver driver;
	LandingPage home; 
	@BeforeTest
	public void initializing() throws IOException {
		driver = initializeDriver();// the method is returning driver
		logger.info("Driver is initialized...");
		driver.get(prop.getProperty("url"));
		logger.info("Navigated to the Landing page of QA Academy...");
	}
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	@Test
	public void TitleTest() throws IOException {
	
		home = new LandingPage(driver);
		//compare the text from the browser with actual client required text
		assertEquals("AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING", home.getTitle().getText());
		logger.info("Successfully validated the header message...");
	}

	@Test
	public void HeaderTest() throws IOException {
	
		assertEquals("FEATURED COURSES---123", home.getHeader().getText());
		logger.info("Successfully validated the header message...");
	}
}
