package academy;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjectsRepository.LandingPage;
import Resources.Basics;

public class validateNavBarTest2 extends Basics {
	public static Logger logger = LogManager.getLogger(Basics.class.getName());
	/*
	 * in order to avoid compiler issue when running all the tests in parallel mode
	 * we need to initialize driver locally ;(to assign the browser to the local driver)
	 * so that not all the test class will use the same driver in the basics class 
	 * and run in traffic 
	 */
	public WebDriver driver;
	@BeforeTest
	public void initializing() throws IOException {
		driver = initializeDriver();// the method is returning driver
		driver.get(prop.getProperty("url"));
	}

	/*
	 * browser will be close after a single test,
	 * so we should specify each class as a single test in the testNG.xml file
	 * or we could use @BeforeMethod
	 */
	@AfterTest
	public void teardown() {
		driver.quit();
	}
	

	@Test
	public void navBarValidation() throws IOException {
		LandingPage home = new LandingPage(driver);
		
		
		//validating navigation bar
		assertTrue(home.getNavBar().isDisplayed());
		logger.info("Navigation bar is displayed...");
		
		
		

	}

}
