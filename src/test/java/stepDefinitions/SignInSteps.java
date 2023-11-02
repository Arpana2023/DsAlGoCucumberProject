package stepDefinitions;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import driverFactoryPkg.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
//import io.qameta.allure.internal.shadowed.jackson.databind.exc.InvalidFormatException;
import pagesPackage.HomePage;
import pagesPackage.SignInPage;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class SignInSteps extends BaseClass
{
	//private SignInPage signInPage = new SignInPage(DriverFactory.getDriver());
	//private SignInPage signInPage = new SignInPage();//uncomment this

	//static ConfigReader configReader;
	//static ExcelReader excelReader= new ExcelReader();
	//static String ExcelFilePath = configReader.getexcelfilepath();
	 String invalidMessage =configReader.getInvalidMsg();
	 String expectedValidationMsg = configReader.getexpectedValidationMsg();
	 String expectedLoggedInMsg;

	@Given("the user is on SignInPage")
	public void the_user_is_on_sign_in_page() 
	{
		signInPageObj.OpenSignInPageURL();
	}

	@When("the user clicks on RegisterLink in SignInPage")
	public void the_user_clicks_on_register_link_in_sign_in_page() 
	{
		signInPageObj.clickRegisterLnkInLoginPage();
	}

	@Then("the user redirected to RegistrationPage")
	public void the_user_redirected_to_registration_page() 
	{
	    String pagetitle=signInPageObj.LandedRegisterPage();
		Assert.assertEquals("----User has not logged in Registration page___","Registration",pagetitle);	

	}
	@When("The user have missing fields in username {string} and password {string}")
	public void the_user_enter_invalid_username_and_password(String username, String password)
	{
		signInPageObj.fillvalidAndInvalidData(username,password);
	}
	@Then("verify missing fileds message")
	public void verify_missing_fileds_message()
	{
		String validationMsg= signInPageObj.getValidationMsg();
		Assert.assertEquals(expectedValidationMsg, validationMsg);
	}
//	@When("The user enters sheetname {string} and RowNumber {int} from Excel sheet")
//	public void the_user_enters_sheetname_and_row_number_from_excel_sheet(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException 
//	{		
//
//		List<Map<String,String>> testData = 
//				excelReader.getData(ExcelFilePath, Sheetname);
//		String username=testData.get(rownumber).get("username");
//		String password=testData.get(rownumber).get("password");
//		expectedLoggedInMsg=testData.get(rownumber).get("expected message");
//		signInPage.fillvalidAndInvalidData(username,password);
//	}

	@Then("the user verify valid login details")
	public void the_user_verify_valid_login_details()
	{
		String actualAlert=	signInPageObj.AlertMessageLoginSuccessOrFailure();
		String expectedLoggedInMsg=signInPageObj.expectedMsgfromExcel();
	    Assert.assertEquals(expectedLoggedInMsg, actualAlert);
	}
	@When("The user enters valid username password from sheetname {string} and RowNumber {int} and clicks Login button")
	public void the_user_enters_valid_username_password_from_sheetname_and_row_number_and_clicks_login_button(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException 
	{			
		signInPageObj.fill2validAndInvalidData(Sheetname,rownumber);
	}
}
