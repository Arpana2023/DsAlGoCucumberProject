package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import driverFactoryPkg.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPackage.RegisterPage;
import pagesPackage.SignInPage;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class RegisterSteps 
{
	private RegisterPage registerPage = new RegisterPage(DriverFactory.getDriver());
    static ConfigReader configReader;
	static ExcelReader excelReader= new ExcelReader();
	static String ExcelFilePath = configReader.getexcelfilepath();
	String expectedMsg;
	String username;
	String password;
	String cofirmPwd;
	boolean booleanvalue;
	
	@Given("the user is on RegistrationPage")
	public void the_user_is_on_register_page() 
	{
		registerPage.OpenRegisterPageURL();
	}

	@When("the user gets the Title of the RegisterPage")
	public void the_user_gets_the_title_of_the_register_page()
	{
		registerPage.getPageTitle();
	}

	@Then("the page title to be {string}")
	public void the_page_title_to_be(String pageTitle)
	{
	   String registerPageTitle = registerPage.getPageTitle();
		Assert.assertEquals("----1.User has not landed on Registration Page___",pageTitle,configReader.getPageTitle());	

	}

//	@When("the user clicks on Register button")
//	public void the_user_clicks_on_register_button() 
//	{
//		registerPage.clickRegisterButton();
//	}
//
//	@Then("the user lands on to LoginPage")
//	public void the_user_lands_on_to_login_page() 
//	{
//		System.out.println("++++++registerPage++++++"+registerPage.getPageTitle());
//		Assert.assertEquals("----2.User has not landed on Login Page___","Login",registerPage.getPageTitle());	
//	}

	@When("The user clicks Register button with all fields empty")
	public void the_user_clicks_button_with_all_fields_empty() 
	{
		registerPage.clickRegisterButton();
	}

	@Then("It should display an error {string} below Username textbox")
	public void it_should_display_an_error_below_username_textbox(String expectedErrorrMsg)
	{
		Assert.assertTrue(registerPage.getUserFieldEmptyRequired());
		String actualErrormsg=registerPage.getEmptyfieldErrormsgUser();
		Assert.assertEquals(expectedErrorrMsg,actualErrormsg);	

	}

	@When("The user clicks Register button after entering username {string} with all fields empty")
	public void when_the_user_clicks_button_after_entering_with_all_fields_empty(String username)
	{
		registerPage.enterUserName(username);
		registerPage.clickRegisterButton();
	}

	@Then("It should display an error {string} below Password textbox")
	public void it_should_display_an_error_below_password_textbox(String expectedErrorrMsg)
	{
		Assert.assertTrue(registerPage.getPswdFieldEmptyRequired());
		String actualErrormsg=registerPage.getEmptyfieldErrormsgPassword();
		Assert.assertEquals(expectedErrorrMsg,actualErrormsg);	
	}
	@When("The user clicks Register button after entering username {string} and password {string} with all fields empty")
	public void when_the_user_clicks_button_after_entering_and(String username, String password) 
	{
		registerPage.enterUserName(username);
		registerPage.enterPassword(password);
		registerPage.clickRegisterButton();
	}

//	@When("Password Confirmation field empty")
//	public void password_confirmation_field_empty() 
//	{
//		registerPage.getCofmPswdEmptyRequired();
//	}

	@Then("It should display an error {string} below Password Confirmation textbox")
	public void it_should_display_an_error_below_password_confirmation_textbox(String expectedErrorrMsg)
	{
		Assert.assertTrue(registerPage.getCofmPswdEmptyRequired());
		String actualErrormsg=registerPage.getEmptyfieldErrormsgConfirmPwd();
		Assert.assertEquals(expectedErrorrMsg,actualErrormsg);	 
	}

	@When("The user clicks Register button after entering valid username and sheetname {string} and rownumber {int} different passwords in password and password confirmation fields from excelsheet")
	public void the_user_clicks_register_button_after_entering_valid_username_and_sheetname_and_rownumber_different_passwords_in_password_and_password_confirmation_fields_from_excelsheet(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException
	{
		List<Map<String,String>> testData = 
				excelReader.getData(ExcelFilePath,Sheetname);
		username=testData.get(rownumber).get("username");
		System.out.println("USERNAME:"+username);

		password=testData.get(rownumber).get("password");
		System.out.println("PASSWORD:"+password);

		cofirmPwd=testData.get(rownumber).get("confirmPwd");
		System.out.println("CONFIRMPWD:"+cofirmPwd);

		expectedMsg=testData.get(rownumber).get("expectedMessage");
		registerPage.fillvalidAndInvalidData(username, password, cofirmPwd);
	}

	@Then("It should display an error message for passwordMismatch")
	public void it_should_display_an_error_message_for_passwordMismatch()
	{
		boolean expbooleanvalue=registerPage.comparePasswords(password,cofirmPwd);
		Assert.assertFalse("The two password fields matched",expbooleanvalue);
		String actualAlert=	registerPage.passwordMismatchErrormsg();
		Assert.assertEquals("The two password fields matched",expectedMsg,actualAlert);
	}
//	@When("The user enters a valid username and password with characters less than eight from sheetname {string} and rownumber {int}")
//	public void the_user_enters_a_valid_username_and_password_with_characters_less_than_eight_from_sheetname_and_rownumber(String Sheetname , Integer rownumber) throws InvalidFormatException, IOException 
//	{
//		 List<Map<String,String>> testData = 
//				excelReader.getData(ExcelFilePath,Sheetname);
//		username=testData.get(rownumber).get("username");
//		System.out.println("USERNAME:"+username);
//
//		password=testData.get(rownumber).get("password");
//		System.out.println("PASSWORD:"+password);
//		cofirmPwd=testData.get(rownumber).get("confirmPwd");
//
//
//		expectedMsg=testData.get(rownumber).get("expectedMessage");
//
//	 	registerPage.fillvalidAndInvalidData(username, password,cofirmPwd);
//	}
//
//	@Then("It should display an error message for password lessthan 8characters")
//	public void it_should_display_an_error_message_for_password_lessthan_8characters()
//	{
//	   boolean booleanvalue=registerPage.checkPassWrdcharactersSize(password);
//		Assert.assertFalse("The password is not lessthan 8 characters",booleanvalue);
//		String actualAlert=	registerPage.passwordMismatchErrormsg();	
//		Assert.assertEquals("The password is not lessthan 8 characters",expectedMsg,actualAlert);
//	}
}
