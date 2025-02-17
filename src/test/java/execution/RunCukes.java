package execution;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src\\test\\resources\\Features\\CreateRequest.feature", glue = "steps.CreateRequestSteps")
public class RunCukes extends AbstractTestNGCucumberTests{
	

}
