package utilities;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import driverFactoryPkg.DriverFactory;
import pagesPackage.GetStartedPage;
import pagesPackage.GraphPage;
import pagesPackage.HomePage;
import pagesPackage.SignInPage;

public class BaseClass 
{
	//Constructor ,initializing the PageObjects
//			public BaseClass(WebDriver driver)
//			{
//				//this.driver=driver;
//				PageFactory.initElements(driver, this);
//			}
			public WebDriver driver;
			//public WebDriver driver=DriverFactory.getDriver();
			public SignInPage signInPageObj = new SignInPage();
			public ConfigReader configReader;
			//public GetStartedPage getStartedPage = new GetStartedPage(DriverFactory.getDriver());
			public Properties prop;
			public ExcelReader excelReader= new ExcelReader();
			public String ExcelFilePath = configReader.getexcelfilepath();

}
