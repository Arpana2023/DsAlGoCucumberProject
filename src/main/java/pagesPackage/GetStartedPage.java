package pagesPackage;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactoryPkg.DriverFactory;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.Loggerload;

public class GetStartedPage extends BaseClass
{
	//Properties prop;
	private WebDriver driver=DriverFactory.getDriver();
	//static ConfigReader configReader;
	//ConfigReader configReader=new ConfigReader();

	 String Url= configReader.getApplicationUrl();

	//Page Factory-OR:	
		@FindBy(xpath="//a[@href='/home']") WebElement getStartedBtn;
				
	//Constructor ,initializing the PageObjects
		public GetStartedPage(WebDriver driver)
		{
			//this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	
	//Click on Get Started button method
//		public GetStartedPage(WebDriver driver) {
//			super(driver);
//		}
	public HomePage clickOnGetStarted() 
	{					 
		Loggerload.info("click on getStartedPage "+getStartedBtn.getText()+" button");
		getStartedBtn.click();
		return new HomePage(driver);
	}
	
	
    public void openDsalgoPortal()
    {
    	driver.get(Url);
	}
	
}
