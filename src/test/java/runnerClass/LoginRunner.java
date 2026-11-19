package runnerClass;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features= {"src/test/java/feature/Login.feature"},
		dryRun=false,
		glue={"steps"},
		tags="@login",
		snippets = CucumberOptions.SnippetType.CAMELCASE,
		monochrome=true,
		plugin= {"pretty",
				"html:target/cucumber/report.html",
				"json:target/cucumber/report.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
				)


public class LoginRunner extends AbstractTestNGCucumberTests {

}
                                                                                                                                  