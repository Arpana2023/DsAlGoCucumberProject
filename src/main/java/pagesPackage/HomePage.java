package pagesPackage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelReader;
import utilities.Loggerload;
import driverFactoryPkg.DriverFactory;
import utilities.BaseClass;
import utilities.ConfigReader;

public class HomePage extends BaseClass
{
	private WebDriver driver=DriverFactory.getDriver();
	//static ConfigReader configReader;
	//Properties prop;
	//static ExcelReader excelUtils = new ExcelReader();

	String Url= configReader.getApplicationUrl();
    String homepage_url=configReader.getHomePageUrl();
	String AnyDSUrl = configReader.getcorrepondingUrl("datastructure_url");

	//String AnyDSUrl = configReader.getcorrepondingUrl("homepage_url");
    //1.ByLocators
	
	  //Sign-in button
	@FindBy(xpath="//a[@href='/login']") WebElement loginLnk;
	
	//Register button
	@FindBy(xpath="//a[@href='/register']") WebElement registerLnk;
	
	//Signout button
	@FindBy(xpath= "//a[@href='/logout']") WebElement signoutBtn;
	
	//Dropdown options
	@FindBy (xpath="//a[@href='#']") WebElement dropdownMenuShow;		
	@FindBy (xpath="//a[@class='dropdown-item' and @href='/array']") WebElement dropdown_array;
	@FindBy (xpath="//a[@class='dropdown-item' and @href='/linked-list']") WebElement dropdown_linkedlist;
	//@FindBy (xpath="//*[@id='navbarCollapse']//a[2]") WebElement dropdown_linkedlist;
	@FindBy (xpath="//a[@class='dropdown-item' and @href='/stack']") WebElement dropdown_stack;
	@FindBy (xpath="//a[@class='dropdown-item' and @href='/queue']") WebElement dropdown_queue;
	@FindBy (xpath="//a[@class='dropdown-item' and @href='/tree']") WebElement dropdown_tree;
	@FindBy (xpath="//a[@class='dropdown-item' and @href='/graph']") WebElement dropdown_graph;
	
	//DropDownOptions
	@FindBy(xpath= "//div[@class='dropdown-menu show']") WebElement HomePageDropdwn;
	
	//Get Started buttons 
		@FindBy (xpath="//a[text()='Get Started' and @href='data-structures-introduction']") WebElement getstartBtn_dataStructures;
		@FindBy (xpath="//a[text()='Get Started' and @href='array']") WebElement getstartBtn_array;
		@FindBy (xpath="//a[text()='Get Started' and @href='linked-list']") WebElement getstartBtn_linkedlist;
		@FindBy (xpath="//a[text()='Get Started' and @href='stack']") WebElement getstartBtn_stack;
		@FindBy (xpath="//a[text()='Get Started' and @href='queue']") WebElement getstartBtn_queue;
		@FindBy (xpath="//a[text()='Get Started' and @href='tree']") WebElement getstartBtn_tree;
		@FindBy (xpath="//a[text()='Get Started' and @href='graph']") WebElement getstartBtn_graph;
	
		//@FindBy (xpath="//h5[text() = 'Linked List']/..//*[text() = 'Get Started']“) WebElement getstartBtn_linkedlist;
		//@FindBy(xpath="h5[text()='Linked List/..//*[text() ='Get Started']") WebElement dropdown_linkedlist;
		//GetStarted button under DataStructures
		//@FindBy(xpath = "//a[@href='data-structures-introduction']") WebElement GetStartedDSBtn;
	
	//You are logged in message
	@FindBy(xpath="//div[@class='alert alert-primary']") WebElement loginSuccessMsg;
	//@FindBy(xpath="//div[contains (text(),'You are logged in')]")
	
	//You are not logged in message
	@FindBy(xpath="//div[contains (text(),'You are not logged in')]") WebElement WithoutloginErrorMsg;
	
	//You are logged out successfully
	@FindBy(xpath="//div[contains(text(),'Logged out successfully')]") WebElement loggedOutSuccessMsg;
	
    //Get Started button in Getstarted page
	@FindBy(xpath="//a[@href='/home']") WebElement getStartedBtn;


	//2.Constructor of the page class
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Homepage_Title() 
	{
		driver.get(homepage_url);
	}
	public void homepage_url() 
	{
		driver.get(homepage_url);
	}
	/*public void homepage_url() {

		driver.get(AnyDSUrl);
		System.out.println("{}{}{}{}{}{"+AnyDSUrl);

	}*/
	public void openDsalgoPortal()
    {
    	driver.get(Url);
	}
//	//Click on Get Started button method in Getstarted page
//			public HomePage clickOnGetStarted() 
//			{	
//				getStartedBtn.click();
//				return new HomePage(driver);
//			}
	//Click on Get Started button method in Getstarted page
	public HomePage clickOnGetStarted(String str) 
	{	
		getStartedBtn.click();
		return new HomePage(driver);
	}
	
	/*public String getUrl(String dataStructureName)
	{
		switch(dataStructureName) 
		{	
		   case "Datastructures":
				  return driver.getTitle();
				  //return driver.get(configReader.getcorrepondingUrl("datastructure_url"));
				  break;
			case "Arrays":
				//Loggerload.info("click " + getstart_array.getText() + "link on Array ");
				 // return driver.get(configReader.getcorrepondingUrl("array_url"));
				//AnyDSUrl = configReader.getcorrepondingUrl("arraypage_url");
				  //return driver.get(AnyDSUrl);
				  return driver.getCurrentUrl();

				break;
			case "Linked List":
				//Loggerload.info("click " + getstart_linkedlist.getText() + "link on LinkedList");
				 // return driver.get(configReader.getcorrepondingUrl("linkedList_url"));
				//AnyDSUrl = configReader.getcorrepondingUrl("Linkedlist_url");
				  //return driver.get(AnyDSUrl);
				  return driver.getCurrentUrl();

				break;
			case "Stack":
				//Loggerload.info("click " + getstart_stack.getText() + "link on stack");
				  //return driver.get(configReader.getcorrepondingUrl("stack_url"));
				//AnyDSUrl = configReader.getcorrepondingUrl("Linkedlist_url");
				  //return driver.get(AnyDSUrl);
				  return driver.getCurrentUrl();

				break;
			case "Queue":
				//Loggerload.info("click " + getstart_queue.getText() + "link on queue ");
				  //return driver.get(configReader.getcorrepondingUrl("queue_url"));
				//AnyDSUrl = configReader.getcorrepondingUrl("Queue_url");
				  //return driver.get(AnyDSUrl);
				  return driver.getCurrentUrl();

				break;
			case "Tree":
				//Loggerload.info("click " + getstart_tree.getText() + "link on Tree ");
				  //return driver.get(configReader.getcorrepondingUrl("tree_url"));
				//AnyDSUrl = configReader.getcorrepondingUrl("Tree_url");
				  //return driver.get(AnyDSUrl);
				  return driver.getCurrentUrl();

				break;
			case "Graph":
				//Loggerload.info("click " + getstart_graph.getText() + "link on Graph ");
				 // return driver.get(configReader.getcorrepondingUrl("graph_url"));
				//AnyDSUrl = configReader.getcorrepondingUrl("Graph_url");
				  //return driver.get(AnyDSUrl);
				  return driver.getCurrentUrl();
				  break;					
		
		}
	}*/
	public void clickgetStartedDS()
	{
		Loggerload.info("click " + getstartBtn_dataStructures.getText() + " link on home page");
		getstartBtn_dataStructures.click();
	}
	public void clickOnAnyGetStartedBtnInHomePage(String VisibleGetstartedBtn_homepage)
	{
		switch (VisibleGetstartedBtn_homepage) {
		case "Datastructures":
			  Loggerload.info("click " + getstartBtn_dataStructures.getText() + "link on  DataStructures ");
			  getstartBtn_dataStructures.click();
			  break;
		case "Arrays":
			  Loggerload.info("click " + getstartBtn_array.getText() + "link on Array ");
			  getstartBtn_array.click();
			break;
		case "Linked List":
			Loggerload.info("click " + getstartBtn_linkedlist.getText() + "link on LinkedList");
			getstartBtn_linkedlist.click();
			break;
		case "Stack":
			Loggerload.info("click " + getstartBtn_stack.getText() + "link on stack");
			getstartBtn_stack.click();
			break;
		case "Queue":
			Loggerload.info("click " + getstartBtn_queue.getText() + "link on queue ");
			getstartBtn_queue.click();
			break;
		case "Tree":
			  Loggerload.info("click " + getstartBtn_tree.getText() + "link on Tree ");
			getstartBtn_tree.click();
			break;
		case "Graph":
			 Loggerload.info("click " + getstartBtn_graph.getText() + "link on Graph ");
			 getstartBtn_graph.click();
			 break;
		}
	}
	
	public void ClickOnDropdown(String string) 
	{
		if( dropdownMenuShow.isDisplayed())
		{
			dropdownMenuShow.click();
		}
		else
		{
			System.out.println("DROPDOWN NOT DISPLAYED--------------");
		}
		//dropdown.click();
		switch (string) 
		{
			case "Arrays":
			      Loggerload.info("User click on " + string);
			      dropdown_array.click();
			      break;
			case "Linked List":
					Loggerload.info("User click on " + string);
					dropdown_linkedlist.click();
					break;
			case "Stack":
					Loggerload.info("User click on " + string);
					dropdown_stack.click();
					break;
			case "Queue":
					Loggerload.info("User click on " + string);
					dropdown_queue.click();
					break;
			case "Tree":
					Loggerload.info("User click on " + string);
					dropdown_tree.click();
					break;
			case "Graph":
					Loggerload.info("User click on " + string);
					dropdown_graph.click();
					break;
		}
	}
	
	public void ClickOnDataStrctGetStrtdOrDropDwn(String datastrName)
	{
	    if(dropdownMenuShow.isSelected())
	    {
			ClickOnDropdown(datastrName);
	    }
	    else
	    {
		clickOnGetStarted(datastrName);
	    }
	}
	
	//Page methods
	public String LandedHomePage()
	{
		 return driver.getCurrentUrl();
	}
			
	public void ClickSignoutBtn()
	{
		signoutBtn.click();
	}
	
	public RegisterPage ClickRegisterUserLnk() {
		registerLnk.click();
		return new RegisterPage(driver);
	}
	
	public SignInPage ClickSignInLnk() 
	{
		loginLnk.click();
		//return new SignInPage(driver);
		return new SignInPage();
	}
	
	public String loginSucessMessage() 
	{
		String successTxt = loginSuccessMsg.getText();
		return successTxt;
	}
	public String loginFailureMessage() 
	{
		String FailureTxt = WithoutloginErrorMsg.getText();
		return FailureTxt;
	}
	public String logoutSucessMessage()
	{
		String logoutsuccessTxt = loggedOutSuccessMsg.getText();
		return logoutsuccessTxt;
	}
}
