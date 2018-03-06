package com.crm.base;



import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.util.Testutil;
import com.crm.util.WebEventListener;



public class TestBase_Driver {
	
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
	public TestBase_Driver() 
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("D:\\Pom_Project\\Maven_Pom_Project\\src\\main\\java\\com\\crm\\config\\config.properties");
			prop.load(ip);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		
		
	}
	public static void initialization()
	{
		String  browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Library\\Drivers\\chromedriver.exe");
			 driver=new ChromeDriver();
			
		}else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Library\\Drivers\\geckodriver.exe");
			 driver=new FirefoxDriver();
			
			
			
		}
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
		
		
		
		
		
		
		
		
		
	}

}
