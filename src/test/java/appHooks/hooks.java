package appHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import driverFactoryPkg.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import utilities.ConfigReader;
import utilities.Loggerload;

public class hooks 
{
	private static DriverFactory driverFactory;
	private static ConfigReader configReader;
	static Properties prop;
	 public static WebDriver driver;
	//private static final Logger LOG=LogManager.getLogger(Hooks.class);

	@BeforeAll
	public static void beforeScenario() 
	{	
		try 
		{	
			configReader = new ConfigReader();
			prop = configReader.init_prop();
		
		    if(driver== null) 
		    {
		    	String browserName = prop.getProperty("browser");
		    	driverFactory = new DriverFactory();
		    	driver = driverFactory.initilization(browserName);
		    }
            Loggerload.info("//////////////Browser is launched");
		 }
		 catch (Exception e) 
		 {
		 e.printStackTrace();
		 }
	}

	@AfterStep
	public void addScreenShot(Scenario scenario)
	{
		
		if(scenario.isFailed())//if(scenario.getStatus==Status.FAILED))
		{
			//ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Screenshot()).build());

			//LOG.error("Scenario failed");
			String ScreenShotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcePath, "image/png", ScreenShotName);
			//Allure.addAttachment("ScreenShotInAllure", new ByteArrayInputStream(sourcePath);
		}
	}

	public static WebDriver getDriver() 
	{
	    return driver;
	}
	@AfterAll
	public static void quitBrowser()
	{
		driver.quit();
	}
}

//	private static WebDriver driver = DriverFactory.getDriver();
//
//	@BeforeAll(order=0)
//	public void getProperty()
//	{
//		System.out.println("________Hooksruns before scenario________:");
//
//		configReader = new ConfigReader();
//		prop = configReader.init_prop();
//	}
//	
//	@Before(order=1)
//	public void launchBrowser()
//	{
//		
//		String browserName = prop.getProperty("browser");
//		//System.out.println("browserNameruns before scenario:"+ browserName);
//		driverFactory = new DriverFactory();
//		driver = driverFactory.initilization(browserName);
//	}
//	
//	@After(order=0)
//	public void quitBrowser()
//	{
//    	System.out.println("hooks runs after scenario:");
//
//		driver.quit();
//	}
//	
//	@AfterAll(order=1)
//	public void tearDown(Scenario scenario)
//	{
//		if(scenario.isFailed())
//		{
//			String screenshotName = scenario.getName().replaceAll("", "_");
//			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(sourcePath, "img/png", screenshotName);
//		}	
//	}
//	
//	public static WebDriver getDriver() {
//        return driver;
  //  }
  
