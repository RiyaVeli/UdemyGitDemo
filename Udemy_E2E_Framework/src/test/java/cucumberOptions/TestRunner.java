package cucumberOptions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src\\test\\java\\features\\login.feature",
		glue = "stepDefinitions")
//if you pass the feature path as package level, everything in the package will be executed

public class TestRunner extends AbstractTestNGCucumberTests{

}
