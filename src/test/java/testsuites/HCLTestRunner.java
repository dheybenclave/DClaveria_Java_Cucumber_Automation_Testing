package testsuites;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/main/resources/AppFeatures" },
	glue ={"stepdefinitions", "hooks" },
	tags= "@All", //"@Regression or @Smoke | not @Prod | and @Smoke"
	monochrome=false,
	dryRun= false,
	plugin = {
		"pretty",
		"html:target/cucumber-html-report.html",
		"json:target/cucumber.json",
		"json:target/cucumber.xml",
		"json:target/json-report/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	)
	

//AND
//@CucumberOptions(features="feature", glue={"cucumber/steps"})
//OR
//@CucumberOptions(features="feature/Boutiqaat.feature", glue={"cucumber/steps"})
//OR
//@CucumberOptions(features="feature/Boutiqaat.feature", glue={"classpath:src/test/java/cucumber/steps"})

public class HCLTestRunner {}
