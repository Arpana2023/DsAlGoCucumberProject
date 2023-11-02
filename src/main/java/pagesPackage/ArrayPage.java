package pagesPackage;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.BaseClass;
import utilities.ConfigReader;
import utilities.Loggerload;
import utilities.util;

public class ArrayPage extends BaseClass
{
	@FindBy(xpath="//a[@href='arrays-in-python']")  WebElement arraysInPythonLnk;
	@FindBy (xpath="//a[@href='/tryEditor']") WebElement tryHereBtn;
	@FindBy(xpath ="//button[@type ='button' and text ()='Run']") WebElement runBtn;
	@FindBy(xpath="//a[@href=\"arrays-using-list\"]") WebElement arraysUsingListLnk;	
	@FindBy(xpath="//a[@href='basic-operations-in-lists']") WebElement basicOperationInListsLnk;
	//@FindBy(xpath="//a[@href=\"/array/applications-of-array/\"]") WebElement applicationOfArrayLnk;
	@FindBy(xpath="//a[text()='Applications of Array']") WebElement applicationOfArrayLnk;
	@FindBy(xpath="//a[text()='Practice Questions']") WebElement practiceQuestionLink;
	@FindBy(xpath="//a[@href=\"/question/1\"]") WebElement searchTheArrayLink;
	@FindBy(xpath="//textarea[@tabindex='0']") WebElement editorInput;
	@FindBy(xpath="//pre[@id ='output']") WebElement outputConsole;
	//private WebDriver driver;
	String arraypgUrl = configReader.getcorrepondingUrl("array_url");
	String arraysInPythonUrl = configReader.getcorrepondingUrl("arraysInPython_Url");
	String arraysUsingListUrl = configReader.getcorrepondingUrl("arraysUsingList_Url");
	String basicOperationsInListUrl = configReader.getcorrepondingUrl("basicOperationsInList_Url");
	String practicePageUrl = configReader.getcorrepondingUrl("practicePage_Url");

	//static ConfigReader configReader;

	public ArrayPage(WebDriver driver)
	{
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	public void arrayPageUrl()
	{
		driver.get(arraypgUrl);
	}
	public void clickArraysInPythonLink()
	{
		Loggerload.info("click " + arraysInPythonLnk.getText() + " On array page");
		arraysInPythonLnk.click();;
	}
	public void clickArraysUsingListLink()
	{
		Loggerload.info("click " + arraysUsingListLnk.getText() + " On array page");
		arraysUsingListLnk.click();
	}
	public void clickBasicOperationsInListLink()
	{
		Loggerload.info("click " + basicOperationInListsLnk.getText() + " On array page");
		basicOperationInListsLnk.click();
	}
	public void clickApplicationsOfArrayLink()
	{
		Loggerload.info("click " + applicationOfArrayLnk.getText() + " On array page");
		applicationOfArrayLnk.click();
	}
	public void clickPracticeQuestionsLink()
	{
		Loggerload.info("click " + practiceQuestionLink.getText() + " On array page");
		practiceQuestionLink.click();
	}
	public void clickSearchTheArrayLink()
	{
		Loggerload.info("click " + searchTheArrayLink.getText() + " On array page");
		searchTheArrayLink.click();
	}
	
	public void arraysInPythonPage()
	{
		driver.get(arraysInPythonUrl);
	}
	public void arraysUsingListPage()
	{
		driver.get(arraysUsingListUrl);
	}
	public void basicOperationsInListsPage()
	{
		driver.get(basicOperationsInListUrl);

	}
	public void practicePage()
	{
		driver.get(practicePageUrl);
	}

	public void navigateTo(String page_name) 
	{
		String page_nameUrl = configReader.getcorrepondingUrl(page_name);

		driver.get(page_nameUrl);
	}
	public void enterCodePractice(String Sheetname,Integer rownumber) throws InvalidFormatException, IOException 
	{
		String validCode=util.getCodeFromExcel(Sheetname,rownumber);
		util.clearCodeFirst(editorInput);
		util.enterPythonCode(editorInput,validCode);
		clickBtnRun();
	}
	public void clickBtnRun() 
	{
		Loggerload.info("Click on Run button");
		runBtn.click();
	}
	public String getExpectedResult(String Sheetname,Integer rownumber) throws InvalidFormatException, IOException
	{
		String expectedResult=util.getCodeFromExcel(Sheetname,rownumber);
		return expectedResult;
	}
	public String getActualResult()
	{
		return outputConsole.getText();
	}
}
