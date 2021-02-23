package Com.MdwebProject.TestRun;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import Com.MdwebProject.StepDefinition.StepDefinition;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(tags = { "@tag" }, format = { "pretty",
		"html:target/html/" }, features = "classpath:features", glue = { "Com.MdwebProject.StepDefinition" })

public class TestRunner {

	@BeforeClass
	public static void beforeTest() throws Throwable {

		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		StepDefinition.driver.get("http://localhost:3000/");

	}
}
