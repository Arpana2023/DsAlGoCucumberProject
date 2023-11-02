package stepDefinitions;

import org.junit.Assert;

import driverFactoryPkg.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pagesPackage.GraphPage;
import pagesPackage.HomePage;
import utilities.BaseClass;

public class GraphSteps extends BaseClass
{
	private GraphPage graphPageObj=new GraphPage();
	private HomePage homePageObj = new HomePage(DriverFactory.getDriver());

	@When("The user selects Graph item from the drop down menu")
	public void the_user_selects_graph_item_from_the_drop_down_menu()
	{
		homePageObj.ClickOnDropdown("Graph");
	}

	@Then("The user should be redirected to Graph Data Structure Page having page title {string}")
	public void the_user_should_be_redirected_to_graph_data_structure_page_having_page_title(String ExpecArrayPageTitle)
	{
	    Assert.assertEquals(ExpecArrayPageTitle, configReader.getPageTitle());

	}

	@Given("The user is on the Graph Page after logged in")
	public void the_user_is_on_the_graph_page_after_logged_in() 
	{
		graphPageObj.graphPageUrl();
	}

	@When("The user clicks Graph link on Graph page")
	public void the_user_clicks_graph_link_on_graph_page() 
	{
		graphPageObj.clickGraphLink();
	}

	@Then("The user should be redirected to Graph page in Graph page having page title {string}")
	public void the_user_should_be_redirected_to_graph_page_in_graph_page_having_page_title(String ExpecGraphPgTitle)
	{
	    Assert.assertEquals(ExpecGraphPgTitle, configReader.getPageTitle());
	}

	@Given("The user navigates to Graph page from Graph page")
	public void the_user_navigates_to_graph_page_from_graph_page() 
	{
		graphPageObj.graphPage();
	}

	@When("The user clicks on Graph Representations link")
	public void the_user_clicks_on_graph_representations_link() 
	{
		graphPageObj.clickGraphRepresentationLink();
	}

	@Then("The user should be redirected to Graph Representations page having page title {string}")
	public void the_user_should_be_redirected_to_graph_representations_page_having_page_title(String ExpecGraphRepresTitle) 
	{
	    Assert.assertEquals(ExpecGraphRepresTitle, configReader.getPageTitle());
	}

	@Given("The user navigates to Graph Representations page")
	public void the_user_navigates_to_graph_representations_page() 
	{
		graphPageObj.graphRepresPage();
	}

}
