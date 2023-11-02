package stepDefinitions;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Assert;

import driverFactoryPkg.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPackage.ArrayPage;
import pagesPackage.HomePage;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.util;

public class ArraySteps extends BaseClass
{
	private HomePage homePageObj = new HomePage(DriverFactory.getDriver());
	//static ConfigReader configReader;
	private ArrayPage arrayPageObj = new ArrayPage(DriverFactory.getDriver());
	String expectedMsg;
	@When("The user select Array item from the drop down menu")
	public void the_user_select_array_item_from_the_drop_down_menu()
	{
		homePageObj.ClickOnDropdown("Arrays");
	}

	@Then("The user should be redirected to Array Data Structure Page having page title {string}")
	public void the_user_should_be_redirected_to_array_data_structure_page_having_page_title(String ExpecArrayPageTitle) 
	{
	    Assert.assertEquals(ExpecArrayPageTitle, configReader.getPageTitle());

	}
	@Given("The user is on the Array page after logged in")
	public void the_user_is_on_the_array_page_after_logged_in() 
	{
		arrayPageObj.arrayPageUrl();
	}

	@When("The user clicks Arrays in Python link")
	public void the_user_clicks_arrays_in_python_link() 
	{
		arrayPageObj.clickArraysInPythonLink();
	}

	@Then("The user should be redirected to Arrays in Python page having page title {string}")
	public void the_user_should_be_redirected_to_arrays_in_python_page_having_page_title(String ExpecArrayInPythonTitle) 
	{
	    Assert.assertEquals(ExpecArrayInPythonTitle, configReader.getPageTitle());

	}
	@Given("The user is on the Arrays in Python page after logged in")
	public void the_user_is_on_the_arrays_in_python_page_after_logged_in() 
	{
		arrayPageObj.arraysInPythonPage();
	}
	@When("The user clicks Arrays Using List link")
	public void the_user_clicks_arrays_using_list_link() 
	{
		arrayPageObj.clickArraysUsingListLink();
	}

	@Then("The user should be redirected to Arrays Using List page having page title {string}")
	public void the_user_should_be_redirected_to_arrays_using_list_page_having_page_title(String ExpecArrUsingListTitle) 
	{
	    Assert.assertEquals(ExpecArrUsingListTitle, configReader.getPageTitle());
	}

	@Given("The user is on the Arrays Using List after logged in")
	public void the_user_is_on_the_arrays_using_list_after_logged_in() 
	{
		arrayPageObj.arraysUsingListPage();
	}
	@When("The user clicks Basic Operations in Lists link")
	public void the_user_clicks_basic_operations_in_lists_link() 
	{
		arrayPageObj.clickBasicOperationsInListLink();
	}

	@Then("The user should be redirected to Basic Operations in Lists page having page title {string}")
	public void the_user_should_be_redirected_to_basic_operations_in_lists_page_having_page_title(String ExpecBasicOperInListTitle) 
	{
	    Assert.assertEquals(ExpecBasicOperInListTitle, configReader.getPageTitle());

	}
	@Given("The user is on the Basic Operations in Lists after logged in")
	public void the_user_is_on_the_basic_operations_in_lists_after_logged_in() 
	{
		arrayPageObj.basicOperationsInListsPage();
	}
	@When("The user clicks Applications of Array link")
	public void the_user_clicks_applications_of_array_link() 
	{
		arrayPageObj.clickApplicationsOfArrayLink();
	}

	@Then("The user should be redirected to Applications of Array page having page title {string}")
	public void the_user_should_be_redirected_to_applications_of_array_page_having_page_title(String ExpecApplOfArrayPgTitle)
	{
	    Assert.assertEquals(ExpecApplOfArrayPgTitle, configReader.getPageTitle());

	}
	@When("The user clicks Practice Questions link")
	public void the_user_clicks_practice_questions_link() 
	{
		arrayPageObj.clickPracticeQuestionsLink();
	}
	@Then("The user should be redirected to Practice page having title {string}")
	public void the_user_should_be_redirected_to_practice_page_having_title(String ExpecPracticePageTitle) 
	{
	    Assert.assertEquals(ExpecPracticePageTitle, configReader.getPageTitle());
	}
	@Given("The user is on the Practice page after logged in")
	public void the_user_is_on_the_practice_page_after_logged_in() 
	{
		arrayPageObj.practicePage();
	}

	@When("The user clicks the Search the array link")
	public void the_user_clicks_the_search_the_array_link() 
	{
		arrayPageObj.clickSearchTheArrayLink();
	}

	@Then("The user should be redirected to question page having tryEditor with Run and Submit buttons having page Title {string}")
	public void the_user_should_be_redirected_to_question_page_having_try_editor_with_run_and_submit_buttons_having_page_title(String ExpecQuesPageTitle)
	{
	    Assert.assertEquals(ExpecQuesPageTitle, configReader.getPageTitle());

	}
	@Given("The user is on {string} page of {string} after logged in")
	public void the_user_is_on_page_of_after_logged_in(String question, String section) 
	{
		String page_name= question + section.replaceAll("\\s+", "");
		arrayPageObj.navigateTo(page_name);
	}

	@When("The user enter valid python code in tryEditor from sheetname {string} and rownumber {int} and clicks Run button")
	public void the_user_enter_valid_python_code_in_try_editor_from_sheetname_and_rownumber_and_clicks_run_button(String sheetname, Integer rownumber) throws InvalidFormatException, IOException 
	{
		arrayPageObj.enterCodePractice(sheetname,rownumber);
		expectedMsg = arrayPageObj.getExpectedResult(sheetname, rownumber);

	}

	@Then("The user should be presented with Run result")
	public void the_user_should_be_presented_with_run_result() 
	{
		String actualMsg = arrayPageObj.getActualResult();

	    Assert.assertEquals(expectedMsg, configReader.getPageTitle());

	}


}
