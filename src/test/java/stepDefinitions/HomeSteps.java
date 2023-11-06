package stepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.asynchttpclient.config.AsyncHttpClientConfigHelper.Config;
import org.junit.Assert;

import driverFactoryPkg.DriverFactory;
import pagesPackage.HomePage;
import pagesPackage.SignInPage;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.ExcelReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeSteps extends BaseClass
{
	private HomePage homePageObj = new HomePage(DriverFactory.getDriver());
	//private SignInPage signInPage = new SignInPage(DriverFactory.getDriver());
	//private SignInPage signInPageObj = new SignInPage();//uncomment this
	//static ConfigReader configReader;
	//Properties prop;
	//static ExcelReader excelReader= new ExcelReader();
	//String ExcelFilePath = configReader.getexcelfilepath();
	private static String Failuremsg;
	String expectedLoggedInMsg;
	String username;
	String password;
	@Given("the user opens DS Algo portal link")
	public void the_user_opens_ds_algo_portal_link() 
	{
		homePageObj.openDsalgoPortal();
	}
	
//Clicking on Getstarted button without giving the string "Get Started" in feature file
//	@When("the user clicks the Get Started button")
//	public void the_user_clicks_the_button() 
//	{
//		homePage.clickOnGetStarted();
//	}
	
	//Clicking on Getstarted button by giving the string "Get Started" in feature file
	@When("the user clicks the {string} button")
	public void the_user_clicks_the_button(String string) 
	{
		homePageObj.clickOnGetStarted(string);
	}

	@Then("the user should be redirected to homepage")
	public void the_user_should_be_redirected_to_homepage() 
	{	
		Assert.assertEquals("User has not landed on HomePage","NumpyNinja",ConfigReader.getPageTitle());	
	}	
	@Given("the User is on HomePage")
	public void the_user_is_on_home_page() 
	{
		homePageObj.homepage_url();
	}   
	@When("the user clicks on Get Started link on homepage {string}  without login")
	public void the_user_clicks_on_get_started_link_on_homepage_without_login(String getstartedBtn) 
	{
		homePageObj.clickOnAnyGetStartedBtnInHomePage(getstartedBtn);
	}
	@Then("the user get warning message {string}")
	public void the_user_get_warning_message(String Expectedmsg) 
	{
	    Failuremsg=homePageObj.loginFailureMessage();
		Assert.assertEquals(Expectedmsg, Failuremsg);
	}
	@When("the user clicks on Dropdown on homepage {string} without login")
	public void the_user_clicks_on_dropdown_on_homepage_without_login(String dropdownMenu) 
	{
		homePageObj.ClickOnDropdown(dropdownMenu);
	}

	@When("the user clicks on RegisterLink")
	public void the_user_clicks_on_register_page() 
	{
		homePageObj.ClickRegisterUserLnk();
	}

	@Then("the user landsOn Register Page")
	public void the_user_landson_register_page() 
	{
		Assert.assertEquals("----User has not landed on Registration Page___","Registration",configReader.getPageTitle());	
	}

	@When("the user clicks on Sign in link after getting the not logged in message")
	public void the_user_clicks_on_sign_in_link_after_getting_the_not_logged_in_message()
	{
		homePageObj.ClickSignInLnk();
	}

	@Then("the user lands on loginPage")
	public void the_user_lands_on_login_page() 
	{
		Assert.assertEquals("----User has not landed on Login Page___","Login",configReader.getPageTitle());	
	}
	@Given("the user is on loginPage")
	public void the_user_is_on_login_page() 
	{
		signInPageObj.OpenSignInPageURL();
	}

	@When("the user gives valid username password from sheetname {string} and RowNumber {int} and clicks Login button")
	public void the_user_gives_valid_username_password_from_sheetname_and_row_number_and_clicks_login_button(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException 
	{
		List<Map<String,String>> testData = 
				excelReader.getData(ExcelFilePath, Sheetname);
		String username=testData.get(rownumber).get("username");
		String password=testData.get(rownumber).get("password");
		//expectedLoggedInMsg=testData.get(rownumber).get("expected message"); 
		signInPageObj.fillvalidAndInvalidData(username,password);

	}
	@Then("the user lands onto HomePage and displays the message {string}")
	public void the_user_lands_onto_home_page_and_displays_the_message(String expectedMsg) 
	{
		String actualAlert=signInPageObj.AlertMessageLoginSuccessOrFailure();
		Assert.assertEquals("User has not logged into HomePage",expectedMsg, actualAlert);
	}
	
	@When("the user clicks on DataStructure Get started button")
	public void the_user_clicks_on_data_structure_get_started_button() 
	{
		//homePageObj.ClickOnDataStrctGetStrtdOrDropDwn("Datastructures");
		homePageObj.clickgetStartedDS();
	}

	@Then("the user should be navigated to DataStructure Page having title {string}")
	public void the_user_should_be_navigated_to_data_structure_page_having_title(String ExpecdatastrPgTitle) 
	{
	    Assert.assertEquals(ExpecdatastrPgTitle, configReader.getPageTitle());
	}

	@Given("user is on Homepage after logged in")
	public void user_is_on_homepage_after_logged_in()
	{
		homePageObj.homepage_url();
	}
	@When("the user clicks on Array Get started button or from dropdown")
	public void the_usr_clicks_on_array_get_started_button_or_from_dropdown()
	{
		homePageObj.ClickOnDataStrctGetStrtdOrDropDwn("DataStructures");
	}
	@Then("the user should be navigated to Array Page")
	public void the_user_should_be_navigated_to_array_page() 
	{
		Assert.assertEquals("User has not landed on ArrayPage","Array",configReader.getPageTitle());	
	}
	
	@When("the user clicks on signout link")
	public void the_user_clicks_on_signout_link() 
	{
		homePageObj.ClickSignoutBtn();
	}

	@Then("the user SignsOut and displays the message {string}")
	public void the_user_signs_out_and_displays_the_message(String expecLoggedOffMsg) 
	{
		String actualMsg= homePageObj.logoutSucessMessage();
		Assert.assertEquals(expecLoggedOffMsg,actualMsg);	

	}


//	@When("the user clicks on DataStructure Get started button or from dropdown")
//	public void the_user_clicks_on_data_structure_get_started_button_or_from_dropdown() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should be navigated to DataStructure Page")
//	public void the_user_should_be_navigated_to_data_structure_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("the user clicks on Graph Get started button or from dropdown")
//	public void the_user_clicks_on_graph_get_started_button_or_from_dropdown() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should be navigated to Graph Page")
//	public void the_user_should_be_navigated_to_graph_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("the user clicks on Stack Get started button or from dropdown")
//	public void the_user_clicks_on_stack_get_started_button_or_from_dropdown() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should be navigated to Stack Page")
//	public void the_user_should_be_navigated_to_stack_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("the user clicks on Queue Get started button or from dropdown")
//	public void the_user_clicks_on_queue_get_started_button_or_from_dropdown() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should be navigated to Queue Page")
//	public void the_user_should_be_navigated_to_queue_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("the user clicks on LinkedList Get started button or from dropdown")
//	public void the_user_clicks_on_linked_list_get_started_button_or_from_dropdown() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should be navigated to LinkedList Page")
//	public void the_user_should_be_navigated_to_linked_list_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@When("the user clicks on Tree Get started button or from dropdown")
//	public void the_user_clicks_on_tree_get_started_button_or_from_dropdown() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//	@Then("the user should be navigated to Tree Page")
//	public void the_user_should_be_navigated_to_tree_page() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}
//
//

}
