package pagesPackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactoryPkg.DriverFactory;
import utilities.ConfigReader;

public class RegisterPage extends DriverFactory
{
	@FindBy(xpath="//input[@type='submit' and @value='Register']")
	WebElement registerButton;
	@FindBy(xpath="//input[@name='username']")
	WebElement txtboxusername;
	@FindBy (xpath="//*[@id='id_password1']") 
	WebElement txtboxpassword;
	@FindBy (xpath="//*[@id='id_password2']")
	WebElement txtboxconfirmpwd;
	@FindBy (xpath="//*[@class='alert alert-primary']")
	WebElement alertMsg;
	@FindBy(xpath = "//div[@role='alert']")
	WebElement accountCreatedSuccess;
	
	ConfigReader configReader;
	String AnyDSUrl = configReader.getcorrepondingUrl("register_url");

	//Constructor ,initializing the PageObjects
	public RegisterPage(WebDriver driver)
	{
		//this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void OpenRegisterPageURL() 
	{
		 driver.get(AnyDSUrl);	
	}
	public String getPageTitle() 
	{
		String Reg_Title = driver.getTitle();
		return Reg_Title;
	}

	public SignInPage clickRegisterButton()  
	{
		registerButton.click();
		return new SignInPage();
	}
	
	public void enterUserName(String uname)
	{	
		//configReader.webSendKeys(txtboxusername, configReader.getRandomNum()+uname);
		txtboxusername.clear();
		txtboxusername.sendKeys(uname);
	}
	public void enterPassword(String pswrd) {
		//configReader.webSendKeys(txtboxpassword, pswrd);
		txtboxpassword.clear();
		txtboxpassword.sendKeys(pswrd);
	}

	public void enterConfirmPassword(String Confirmpswrd) {	
		//configReader.webSendKeys(txtboxconfirmpwd, Confirmpswrd);
		txtboxconfirmpwd.clear();
		txtboxconfirmpwd.sendKeys(Confirmpswrd);
	}

	public Boolean getUserFieldEmptyRequired() 
	{
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (txtboxusername.getText().isEmpty()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", txtboxusername);
		}
		return isRequired;
	}
	public Boolean getPswdFieldEmptyRequired() {
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (txtboxpassword.getText().isEmpty()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", txtboxpassword);
		}
		return isRequired;
	}
	
	public Boolean getCofmPswdEmptyRequired() {
		boolean isRequired = false;
		// To check empty fields , we need to check "required" field is on an attribute
		if (txtboxconfirmpwd.getText().isEmpty()) {
			JavascriptExecutor js_user = (JavascriptExecutor) driver;
			isRequired = (Boolean) js_user.executeScript("return arguments[0].required;", txtboxconfirmpwd);
		}
		return isRequired;
	}
	public void fillvalidAndInvalidData(String username,String password,String confirmpwd) {
		enterUserName(configReader.getRandomNum()+username);
		enterPassword(password);
		enterConfirmPassword(confirmpwd);
		//System.out.println("USERNAME:"+configReader.getRandomNum()+username);
		//System.out.println("PASSWORD:"+password);
		//System.out.println("CONFIRMPWD:"+confirmpwd);
		clickRegisterButton();
	}
	public boolean comparePasswords(String password,String confirmpwd)
	{
		if(confirmpwd.equalsIgnoreCase(password))
			return true;
		else
			return false;
	}
	
//	public void filldData(String username,String password)
//	{
//		enterUserName(configReader.getRandomNum()+username);
//		enterPassword(password);
//		clickRegisterButton();			
//		try {
//			Thread.sleep(5000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public boolean checkPassWrdcharactersSize(String password) 
	{
		if(password.length()>8)
			return true;
		else
			return false;
	}
	
	public String registerSucessMessageRegisterPage() {
		return accountCreatedSuccess.getText();		
	}

	public String getEmptyfieldErrormsgUser() {
		return txtboxusername.getAttribute("validationMessage");
	}
	
	public String getEmptyfieldErrormsgPassword() {
		return txtboxpassword.getAttribute("validationMessage");
	}

	public String getEmptyfieldErrormsgConfirmPwd() {
		return txtboxconfirmpwd.getAttribute("validationMessage");
	}
	public String passwordMismatchErrormsg() 
	{
		return alertMsg.getText();
	}

}
