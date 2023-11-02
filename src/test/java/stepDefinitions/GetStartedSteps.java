package stepDefinitions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import driverFactoryPkg.DriverFactory;
import io.cucumber.java.en.*;
import pagesPackage.GetStartedPage;
import utilities.BaseClass;
//import utilities.BaseClass;
import utilities.ConfigReader;


public class GetStartedSteps extends BaseClass
{
	private GetStartedPage getStartedPageObj = new GetStartedPage(DriverFactory.getDriver());
    //Properties prop;
	//ConfigReader configReader;
	//WebDriver driver;
	//private WebDriver driver= DriverFactory.getDriver();
	@Given("User opens dsalgo application url")
	public void user_opens_dsalgo_application_url() 
	{
		getStartedPageObj.openDsalgoPortal();
	}
	@When("The user clicks the Get Started button")
	public void the_user_clicks_the_button() 
	{
		getStartedPageObj.clickOnGetStarted();
	}

	@Then("The user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() 
	{
		Assert.assertEquals("User has not landed on HomePage","NumpyNinja",configReader.getPageTitle());		
	
	}
}

