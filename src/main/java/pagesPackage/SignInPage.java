package pagesPackage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactoryPkg.DriverFactory;
import utilities.ConfigReader;
import utilities.ExcelReader;

public class SignInPage extends DriverFactory
{

	private WebDriver driver=DriverFactory.getDriver();
	@FindBy (xpath="//*[@id='id_username']")
	WebElement usernametxtbox;	
	@FindBy (xpath="//*[@id='id_password']")
	WebElement passwordtxtbox;
	@FindBy (xpath="//*[@value='Login']")
	WebElement loginBtn;
	@FindBy (xpath="//div[@class='alert alert-primary']")
	WebElement alertmsg;
	@FindBy (xpath="//a[@href='/register']")
	WebElement lnkregister;
	@FindBy (xpath="//a[@href='/logout']")
	WebElement Btnsignout;
	
	@FindBy(xpath="//a[@href='/register']")
	WebElement RegisterLnk;
	static ConfigReader configReader;
	String expectedLoggedInMsg;
	String AnyDSUrl = configReader.getcorrepondingUrl("loginpage_url");
	
	static ExcelReader excelReader= new ExcelReader();
	static String ExcelFilePath = configReader.getexcelfilepath();
	//private WebDriver driver;

	//Constructor ,initializing the PageObjects
	public SignInPage()
	{
		//driver= DriverFactory.getDriver();
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	public SignInPage(WebDriver driver)
//	{
//		//driver= DriverFactory.getDriver();
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	}
	public void OpenSignInPageURL() 
	{
		 driver.get(AnyDSUrl);	
	}
	//Actions		
	public void enterUsername(String username) {
		//System.out.println("^^^^^^^^^"+username+"^^^^^^^^^^^^");
		usernametxtbox.clear();
		usernametxtbox.sendKeys(username);
		//configReader.webSendKeys(usernametxtbox, username);
	}
	
	public void enterPassword(String password) {
		passwordtxtbox.clear();
		passwordtxtbox.sendKeys(password);
	}
	
	public HomePage clickLoginBtnLoginPage(){
		loginBtn.click();
		//configReader.webElement_Click(loginBtn);
		return  new HomePage(driver);	
	}
	
	public void fillvalidAndInvalidData(String username,String password) {
		enterUsername(username);
		enterPassword(password);
		clickLoginBtnLoginPage();			
	}
	public void fill2validAndInvalidData(String Sheetname,Integer rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> testData = 
				excelReader.getData(ExcelFilePath, Sheetname);
		String username=testData.get(rownumber).get("username");
		String password=testData.get(rownumber).get("password");
	    expectedLoggedInMsg=testData.get(rownumber).get("expected message");
		enterUsername(username);
		enterPassword(password);
		
		clickLoginBtnLoginPage();			
	}
	/*public void verifyValidData(String sheetname,Integer rownumber,Integer cellnumber) throws IOException 
	{
		System.out.println("******"+excelFilePath+"******");
		excelReader.setExcelFile(excelFilePath,sheetname);
		//ExcelData= excelReader.getCellData(sheetname,rownumber);
		enterUsername(excelReader.getCellData(rownumber,cellnumber));
	}*/

	public RegisterPage clickRegisterLnkInLoginPage() 
	{
		lnkregister.click();
		return new RegisterPage(driver);
	}
	
	public String LandedRegisterPage() 
	{
		 return driver.getTitle();
	}
	public String AlertMessageLoginSuccessOrFailure() {
		return alertmsg.getText();
	}
	public String expectedMsgfromExcel()
	{
		return expectedLoggedInMsg;
	}
	public String getValidationMsg()
	{
		WebElement activeElement = driver.switchTo().activeElement();
		String messageStr = activeElement.getAttribute("validationMessage");
		return messageStr;
	}
	
	public String SignInPageTitle() 
	{
		String pagetitle=driver.getTitle();
        return pagetitle;
	}
}