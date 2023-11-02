package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactoryPkg.DriverFactory;


public class ConfigReader 
{
	private static Properties prop;
	private static WebDriver driver = DriverFactory.getDriver();
	private final static String propertyFilePath = "./src/test/resources/ConfigProperties/config.properties";
	//private DriverFactory driverFactory;
	//driverFactory= new DriverFactory();
	//This method is used to load the properties from config.properties file
	//@return it returns properties prop object
	public static Properties init_prop()
	{
		prop=new Properties();
		try 
		{
			FileInputStream ip = new FileInputStream(propertyFilePath);
			try
			{
				prop.load(ip);
				ip.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		return prop;
	}
	
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 10;
	
	public static boolean webElement_Click(WebElement element) {
		try {
			WebElement ele_toclick = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
				if(ele_toclick.isDisplayed())
				{
				  if(ele_toclick.isEnabled()) 
				  {
					try {
						ele_toclick.click();
						return true;
					    }
					catch(Exception e)
					{
						e.printStackTrace();
						return false;
					}	
				  }
				  else 
				  {
					throw new Exception("Element is not ENABLED");
				  }
				}
				  else {
						throw new Exception("Element is not DISPLAYED");
					}
				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static boolean webSendKeys(WebElement element, String text) {
		try {
				WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(10)).
					until(ExpectedConditions.visibilityOf(element));
				if(ele.isDisplayed())
				{
					if(ele.isEnabled()) 
					{
						try 
						{
							ele.clear();
							ele.sendKeys(text);	
							return true;
						}
						catch(Exception e) 
						{
							e.printStackTrace();
							return false;
						}	
					}
					else 
					{
						throw new Exception("Element is not enabled");
					}
				}
				else 
				{
					throw new Exception("Element is not displayed");
				}
			}
			
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return false;
	}
	public static String getApplicationUrl() {
		String url = prop.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getHomePageUrl() {
		String homepageurl = prop.getProperty("homepage_url");
		if (homepageurl != null)
			return homepageurl;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getcorrepondingUrl(String correspUrl) {
		String correspondingUrl = prop.getProperty(correspUrl);
		if (correspondingUrl != null)
			return correspondingUrl;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getPageTitle() {
		String title = DriverFactory.getDriver().getTitle();
		return title;
	}
	public static String getPageurl() {
		String url = DriverFactory.getDriver().getCurrentUrl();
		return url;
	}
	public static String getHomeUrl()
	{
		String home_url = DriverFactory.getDriver().getCurrentUrl();
		return home_url;

	}
//	 public void openDsalgoPortal()
//	    {
//	    	driver.get(ConfigReader.getApplicationUrl());
//		}
	
	//Returns a random number between 0 and 1000
	public static int getRandomNum() {
		Random ran = new Random();
		 return ran.nextInt(1000);
				
	}
	
	public static String getexcelfilepath() {
		String excelfilelpath = prop.getProperty("excelfilepath");
		if (excelfilelpath != null)
			return excelfilelpath;
		else
			throw new RuntimeException("Excel file path not specified in the Configuration.properties file.");
	}
	public static String getInvalidMsg() 
	{
		String invlaidMsg = prop.getProperty("InvaldiMessage");
		if (invlaidMsg != null)
			return invlaidMsg;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
	public static String getexpectedValidationMsg() 
	{
		String validationMsg = prop.getProperty("ExpectedValidationMsg");
		if (validationMsg != null)
			return validationMsg;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}
//	public static String getCellData(String SheetName,int rownum,int colnum) throws IOException {
//		
//		String path=System.getProperty("user.dir")+"/src/test/resources/TestData/DSAlgo_Login.xlsx";
//		File Excelfile= new File(path);
//		
//		FileInputStream Fis = new FileInputStream(Excelfile);
//		XSSFWorkbook workbook = new XSSFWorkbook(Fis);
//		XSSFSheet sheet = workbook.getSheet("PythonCode");
//		XSSFRow row = sheet.getRow(rownum);
//		XSSFCell cell = row.getCell(colnum);
//	
//		DataFormatter formatter=new DataFormatter();
//		String data;
//		
//		try {
//			data = formatter.formatCellValue(cell);
//			//System.out.println(data);
//		}
//		catch(Exception e)
//		{
//			data = "";
//		}
//		workbook.close();
//		Fis.close();
//		return data;
//		}
//	
//	public static String CapturewrongPythonCodeError() {
//		//switch focus to alert
//	      Alert a = driver.switchTo().alert();
//	      //get alert text
//	      String s= driver.switchTo().alert().getText();
//	      //System.out.println("Alert text is: " + s);
//	      //accepting alert
//	      a.accept();
//	      return s;
//	     
//	}
//
	

}
