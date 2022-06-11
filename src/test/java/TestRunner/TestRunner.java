package TestRunner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = {"C:\\Users\\002OER744\\Desktop\\IBMSDET01\\Upskills\\src\\test\\java\\feature"}
		,glue={"C:\\Users\\002OER744\\Desktop\\IBMSDET01\\Upskills\\src\\test\\java\\test\\java\\StepDefinition"}
		)

public class TestRunner {

}