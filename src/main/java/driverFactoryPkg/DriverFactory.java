package driverFactoryPkg;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.safari.SafariDriver;

import utilities.ConfigReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class DriverFactory 
{
	private static final long PAGE_LOAD_TIMEOUT = 2000;
	private static final long IMPLICIT_WAIT = 2000;
	public static WebDriver driver;
	public static Properties prop;
	public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
	
	
	/*public DriverFactory() 
	{	
		
		//Inside the Constructor of base class we are initializing the properties
		
		try 
		{
			prop= new Properties();
			FileInputStream ip = new FileInputStream(".src/test/resources/ConfigProperties/config.properties");
			prop.load(ip);			
		}
		catch(FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch(IOException e) 
		{
			e.printStackTrace();
		}				
	}*/

	//Initialization method
	//This method is used to initialize the thread local driver	
	@SuppressWarnings("deprecation")
	public WebDriver initilization(String browserName) 
	{
	
		if (browserName.equalsIgnoreCase("chrome"))  
		{
			//WebDriverManager.chromedriver().setup();
			/*ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);*/
			//For selenium 4.11.0 we do not need webdrivermanager, selenium manager will automatically download the chromedriver.exe from CFT dashboard/URL
			driver = new ChromeDriver();
			tdriver.set(driver);
		}
	
		else if (browserName.equalsIgnoreCase("edge")) 
		{
			//WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			tdriver.set(new EdgeDriver());
		}

		else if (browserName.equalsIgnoreCase("safari")) 
		{
			//WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
			tdriver.set(new SafariDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(ConfigReader.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		getDriver().manage().timeouts().implicitlyWait(ConfigReader.IMPLICIT_WAIT,TimeUnit.SECONDS);
		driver. navigate(). refresh();
		//getDriver().get(prop.getProperty("url")); 		
		return getDriver();
	}
	public static synchronized WebDriver getDriver() //Multiple threads running in parallel execution and they all be calling this getdriver() method
	{                                                //so all the threads they should be in sync so we use sychronized Keyword
		return tdriver.get();                        //This is used to get the driver with Thread Local
	}

}
