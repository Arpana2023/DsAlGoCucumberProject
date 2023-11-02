package utilities;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import driverFactoryPkg.DriverFactory;

public class util 
{
	private static WebDriver driver=DriverFactory.getDriver();
	static ExcelReader excelReader= new ExcelReader();
	static ConfigReader configReader;
	static String ExcelFilePath = configReader.getexcelfilepath();
	static String tryEditorUrl = configReader.getcorrepondingUrl("tryEditor_url");

	public static boolean enterPythonCode(WebElement element, String code) {
		//Loggerload.info("Before sending keys to " + element.getText() );
		try {
			new Actions(driver).sendKeys(element, code).perform();
		} catch(Exception e) {
			element.sendKeys(code);
		}
		return true;
	}
	public static void clearCodeFirst(WebElement element) {
		//Loggerload.info("Clearing text in editor");
		new Actions(driver).keyDown(Keys.COMMAND).sendKeys("a").keyUp(Keys.COMMAND).sendKeys(Keys.DELETE).perform();
	} 
	public static void enterCodePractice(String code,WebElement element)
	{
		new Actions(driver).keyDown(Keys.COMMAND).sendKeys("a").sendKeys(Keys.DELETE).keyUp(Keys.COMMAND).perform();
		String[] str1=code.split("\n");
		for(int i=0;i<str1.length;i++)
		{
			if(str1[i].equalsIgnoreCase(("\\b")))
			{
				element.sendKeys(Keys.BACK_SPACE);
			}
			else
			{
				element.sendKeys(str1[i]);
				element.sendKeys(Keys.RETURN);
			}
		}	
	}
	public static String getCodeFromExcel(String Sheetname, Integer rownumber) throws InvalidFormatException, IOException {
		List<Map<String,String>> testData = 
				excelReader.getData(ExcelFilePath, Sheetname);
	    String excelCode=testData.get(rownumber).get("pythonCode");
	    return excelCode;
	}
	public static void tryEditorPage()
	{
		System.out.println("************"+tryEditorUrl);
		 driver.get(tryEditorUrl);
	}

}
