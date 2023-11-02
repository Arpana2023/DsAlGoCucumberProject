package pagesPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import driverFactoryPkg.DriverFactory;
import locators.GraphPageLocators;
import utilities.BaseClass;

public class GraphPage extends BaseClass
{
	private WebDriver driver=DriverFactory.getDriver();
	String graphpgUrl = configReader.getcorrepondingUrl("graph_url");
	String graphPageUrl = configReader.getcorrepondingUrl("graphPage_url");
	String graphRepresUrl = configReader.getcorrepondingUrl("graphRepres_Url");

	GraphPageLocators graphPagelocators=null;
	
	public GraphPage()
	{
		this.graphPagelocators=new GraphPageLocators();
		//PageFactory.initElements(driver, this);
		PageFactory.initElements(driver, graphPagelocators);//we can write like this also
	}
	public void graphPageUrl()
	{
		driver.get(graphpgUrl);
	}
	public void clickGraphLink()
	{
		graphPagelocators.graphLink.click();
	}
	public void graphPage()
	{
		driver.get(graphPageUrl);
	}
	public void clickGraphRepresentationLink() 
	{
		graphPagelocators.graphRepresentationslink.click();
	}
	public void graphRepresPage()
	{
		driver.get(graphRepresUrl);
	}
}
