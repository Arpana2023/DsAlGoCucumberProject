package runners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/Features"},
					glue= {"stepDefinitions","appHooks"},
					plugin= {"pretty",
							 "json:target/json-Report/cucumber.json",
							 "html:target/cucumberHtml-Report/dsAlgoCucumberReport.html",
							 "junit:target/cucumberXml-Report/report.xml",
							 "rerun:target/rerun.txt", //mandatory for capture failure
							 "timeline:test-output-thread/",
							 "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
							 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		  				},
        // dryRun=true	
monochrome=true,//this will provide more readability of console output by removing all junk
publish=true
		)
public class testrunner1 {

}
/*
<dependency>
<groupId>net.masterthought</groupId>
<artifactId>maven-cucumber-reporting</artifactId>
<version>5.7.8</version>
</dependency>
*/