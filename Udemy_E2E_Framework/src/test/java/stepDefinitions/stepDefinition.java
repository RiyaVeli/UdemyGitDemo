package stepDefinitions;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import PageObjectsRepository.LandingPage;
import PageObjectsRepository.LogInPage;
import PageObjectsRepository.portalHomePage;
import Resources.Basics;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefinition extends Basics {

	
	@Given("^Initialize the browser with chrome$")
	public void initialize_the_browser_with_chrome() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver = initializeDriver();
	}

	@Given("^Navigate to \"([^\"]*)\" Site$")
	public void navigate_to_Site(String arg1) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		driver.get(arg1);
	}

	@Given("^Click on Login link to land on Secure signIn page$")
	public void click_on_Login_link_to_land_on_Secure_signIn_page() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		LandingPage home = new LandingPage(driver);
		if(home.getPopUpSize()>0) {
			home.getPopUp().click();
		}
		LogInPage lp = home.getLogin();
	}

	@When("^User enters (.+) and (.+) and click login$")
    public void user_enters_and_and_click_login(String username, String password) throws Throwable{
		// Write code here that turns the phrase above into concrete actions
		LogInPage lp = new LogInPage(driver);
		lp.EmailEntry().sendKeys(username);
		lp.PasswordEntry().sendKeys(password);
		lp.LoginBtn().click();
	}

	@Then("^Verify user login status$")
	public void verify_user_login_status() throws Exception {
		// Write code here that turns the phrase above into concrete actions
		portalHomePage pp = new portalHomePage(driver);
		Assert.assertTrue(pp.getSearchBox().isDisplayed());
	}
}
