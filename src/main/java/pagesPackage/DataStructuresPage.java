package pagesPackage;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driverFactoryPkg.DriverFactory;
import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.util;

public class DataStructuresPage extends BaseClass
{
	//private WebDriver driver=DriverFactory.getDriver();

	@FindBy (xpath="//a[@href='time-complexity']")
	WebElement LnktimeComplexity;
	
	@FindBy(xpath ="//a[@ href ='/tryEditor']")
	WebElement LnktryHere;
	
	@FindBy (xpath="//textarea[@tabindex='0']")
	WebElement textEditor;
	
	@FindBy(xpath ="//button[text()='Run']")
	WebElement runBtn;
	
	@FindBy(xpath="//pre[@id='output']")
	WebElement OutputConsole;
	//private WebDriver driver;
	//static ConfigReader configReader;
	//static ExcelReader excelReader= new ExcelReader();
	//static String ExcelFilePath = configReader.getexcelfilepath();		
	String dataStrcUrl = configReader.getcorrepondingUrl("dataStructureIntro_url");
	String timeCompUrl = configReader.getcorrepondingUrl("timeComplexity_url");
	String tryEditorUrl = configReader.getcorrepondingUrl("tryEditor_url");
	String alertMsg;
	
	public DataStructuresPage(WebDriver driver)//java class which is encapsulated
	{
		//driver= DriverFactory.getDriver();
		this.driver=driver;
		PageFactory.initElements(driver, this); 
	} 
	
	
	//Methods
	public String DSIntoductionPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	public void dataStrucIntroUrl()
	{
		 driver.get(dataStrcUrl);
	}
	public void timeComplexityPage()
	{
		 driver.get(timeCompUrl);
	}
	public void tryEditorPage()
	{
		 driver.get(tryEditorUrl);
	}
	public void clickOnTimeComplexitylink()
	{
		LnktimeComplexity.isDisplayed();
		LnktimeComplexity.click();
	}
	
	public void clickTryHereButton() {
		LnktryHere.isDisplayed();
		LnktryHere.click();
	}

	public void enterInvalidPythonCode(String Sheetname,Integer rownumber) throws InvalidFormatException, IOException 
	{
		String invalidCode=util.getCodeFromExcel(Sheetname,rownumber);
		util.clearCodeFirst(textEditor);
		util.enterPythonCode(textEditor, invalidCode);
		clickBtnRun();
		 alertMsg = driver.switchTo().alert().getText();
		accetptAlert();
	}
	public void enterValidPythonCode(String Sheetname,Integer rownumber) throws InvalidFormatException, IOException 
	{
		String validCode=util.getCodeFromExcel(Sheetname,rownumber);
		util.clearCodeFirst(textEditor);
		util.enterPythonCode(textEditor,validCode);
		clickBtnRun();
	}
	public void accetptAlert()
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public String getAlertmessage()
	{
		return alertMsg;
	}
	
	public void clickBtnRun() {
		runBtn.click();
	}
	
	public String validatePythonCodeGotPrinted() 
	{
		return OutputConsole.getText();
	}

}