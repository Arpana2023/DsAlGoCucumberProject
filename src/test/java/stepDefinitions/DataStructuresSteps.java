package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;

import appHooks.hooks;
import driverFactoryPkg.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPackage.DataStructuresPage;
import pagesPackage.HomePage;
import pagesPackage.SignInPage;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.util;

public class DataStructuresSteps extends BaseClass
{
	//private SignInPage signInPage = new SignInPage(DriverFactory.getDriver());
	//private SignInPage signInPageObj = new SignInPage();
	//private WebDriver driver=hooks.getDriver();
	//private WebDriver driver;

	private HomePage homePageObj = new HomePage(DriverFactory.getDriver());
	//private HomePage homePage = new HomePage(driver);

	//static ConfigReader configReader;
	
	private DataStructuresPage dataStructureObj =  new DataStructuresPage(DriverFactory.getDriver());
//	public DataStructuresSteps()
//	{
//		driver = hooks.getDriver();
//		ObjDataStructuresPageObj =  new DataStructuresPage(driver);
//
//	}

	@Given("The user is on the home page after logged in")
	public void the_user_is_on_the_home_page_after_logged_in()
	{
		homePageObj.homepage_url();
	}

	@When("The user clicks the Getting Started button in Data Structure Page introduction Panel")
	public void the_user_clicks_the_getting_started_button_in_data_structure_page_introduction_panel() 
	{
		//homePage.ClickOnDataStrctGetStrtdOrDropDwn("Datastructures");
		homePageObj.clickgetStartedDS();
	}

	@Then("The user should be redirected to data structure introduction page having title {string}")
	public void the_user_should_be_redirected_to_data_structure_introduction_page_having_title(String ExpecdatastrPgTitle) 
	{
	    Assert.assertEquals(ExpecdatastrPgTitle, configReader.getPageTitle());
	}

	@Given("the user is on DataStructuresIntroductionPage")
	public void the_user_is_on_data_structures_Introduction_page() 
	{
		dataStructureObj.dataStrucIntroUrl();
	}



@Given("The user is on Data Structures introduction page")
public void the_user_is_on_data_structures_introduction_page() 
{
	dataStructureObj.dataStrucIntroUrl();
}

@When("The user clicks the Time Complexity link")
public void the_user_clicks_the_time_complexity_link() 
{
	dataStructureObj.clickOnTimeComplexitylink();

}

@Then("The user should be redirected to the Time Complexity page having title {string}")
public void the_user_should_be_redirected_to_the_time_complexity_page_having_title(String ExpecTimeCompPageTitle) 
{
    Assert.assertEquals(ExpecTimeCompPageTitle, configReader.getPageTitle());
}

@Given("the user is on TimeComplexityPage")
public void the_user_is_on_time_complexity_page() 
{
	dataStructureObj.timeComplexityPage();

}

@When("the user clicks on TryHere button")
public void the_user_clicks_on_try_here_button() 
{
	dataStructureObj.clickTryHereButton();
}

@Then("the user should be redirected to Try Editor Page having page Title {string}")
public void the_user_should_be_redirected_to_try_editor_page_having_page_title(String expecTryHereTitle) 
{
    Assert.assertEquals(expecTryHereTitle, configReader.getPageTitle());

}

@Given("the user is in a page having tryEditor")
public void the_user_is_in_a_page_having_try_editor()
{
	dataStructureObj.tryEditorPage();;
	
}

@When("The user enter python code with invalid syntax from sheet {string} and {int}")
public void the_user_enter_python_code_with_invalid_syntax_from_sheet_and(String sheetname, Integer rownumber) throws InvalidFormatException, IOException 
{
	dataStructureObj.enterInvalidPythonCode(sheetname,rownumber);
}

@Then("The user should be presented with error message {string}")
public void the_user_should_be_presented_with_error_message(String expectedAlertMsg) 
{
	String alertMsg=dataStructureObj.getAlertmessage();
    Assert.assertEquals(expectedAlertMsg, alertMsg);
}
@When("The user enter python code with valid syntax from sheet {string} and {int}")
public void the_user_enter_python_code_with_valid_syntax_from_sheet_and(String sheetname, Integer rownumber) throws InvalidFormatException, IOException
{
	dataStructureObj.enterValidPythonCode(sheetname,rownumber);

}
@Then("The user should be presented with Run result {string}")
public void the_user_should_be_presented_with_run_result(String expecRunResult) 
{
	String actualRunResult=dataStructureObj.validatePythonCodeGotPrinted();
    Assert.assertEquals(expecRunResult, actualRunResult);

}
}
