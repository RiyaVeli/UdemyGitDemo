package academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjectsRepository.ForgotPasswordPage;
import PageObjectsRepository.LandingPage;
import PageObjectsRepository.LogInPage;
import Resources.Basics;

public class LogInTest extends Basics {
	public static Logger logger = LogManager.getLogger(Basics.class.getName());
	public WebDriver driver;
	@BeforeTest
	public void initializing() throws IOException {
		driver = initializeDriver();
		logger.info("Driver is initialized...");
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

	@Test(dataProvider = "getData")
	// the count of the argument sending to the method, should be equal to count of
	// the column-value we are sending
	public void basePageNavigation(String Username, String password, String text) throws IOException {
		driver.get(prop.getProperty("url"));
		logger.info("Navigated to the Landing page of QA Academy...");
		// to access another class
		// 1. inheritance: extends
		// 2. creating new object for that class and invoke the methods of it
		LandingPage home = new LandingPage(driver);
		LogInPage lp = home.getLogin();
		lp.EmailEntry().sendKeys(Username);
		lp.PasswordEntry().sendKeys(password);
		logger.info(text);
		lp.LoginBtn().click();

		ForgotPasswordPage fp = lp.forgotPswLink();
		fp.EmailEntry().sendKeys("xxx");
		fp.sendMeInstructions().click();
	}

	@DataProvider
	public Object[][] getData() {
		// Row stands for how many different data types test should run
		// column stands for how many value for each test
		// index and size is different
		// first[] of Object[2][2] represents size of array; which is 2 sets of data
		Object[][] data = new Object[2][3];
		// 0 th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "123456";
		data[0][2] = "Restricted User";
		// 1st row
		data[1][0] = "restricteduser@qw.com";
		data[1][1] = "45678";
		data[1][2] = "Non-Restricted User";

		return data;
	}
}
