package runners;

//import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
	
//import io.cucumber.junit.CucumberOptions;
//import io.cucumber.junit.Cucumber;

//@RunWith(Cucumber.class)
@CucumberOptions(
		         features={"src/test/resources/Features"},
		         glue= {"stepDefinitions","appHooks"},
		         plugin= {"pretty",
		        		  "json:target/json-report/cucumber.json",
		        		  "html:target/cucumberHtml-Report/dsAlgoCucumberReport.html",
		        		  "junit:target/cucumberXml-Report/report.xml",
		        		  "rerun:target/rerun.txt", //mandatory for capture failure
		        		  "timeline:test-output-thread/",
		        		  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
		        		  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
		        		 }
		         //dryRun=true
                )
public class testRunner extends AbstractTestNGCucumberTests
{
	@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios()
	{
			return super.scenarios();
	}
}	
