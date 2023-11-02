package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features"},
					glue= {"stepDefinitions","appHooks"},
					plugin= {"pretty",
							 "html:target/cucumber.html",
							 "json:target/json-report/cucumber.json",
							 "html:target/dsAlgoCucumberReport.html",
							 "junit:target/MyReports/report.xml",
							 "rerun:target/rerun.txt", //mandatory for capture failure
							 "timeline:test-output-thread/",
							 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		  				}
        // dryRun=true
		)
public class testrunner1 {

}
