package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListner;

public class TestBase {
	
	Logger log= Logger.getLogger(TestBase.class);

	public static Properties prop;
	public static WebDriver driver;
	public WebEventListner eventListner;

	public TestBase() {

		try {
			FileInputStream path = new FileInputStream(
					"C:/Users/310259741/Documents/ProjectManagment/FreeCRM/src/main/java/com/crm/qa/config/config.properties");
			prop = new Properties();
			prop.load(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void initization() {
		String Browsername = prop.getProperty("browser");
		if (Browsername.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:/Users/310259741/Documents/ProjectManagment/FreeCRMTest/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Launched the chrome Browser");
		}

		else if (Browsername.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					"C:/Users/310259741/Documents/ProjectManagment/FreeCRMTest/drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		EventFiringWebDriver e_driver = new EventFiringWebDriver(driver);
		eventListner = new WebEventListner();
		e_driver.register(eventListner);
		driver = e_driver;

		driver.manage().deleteAllCookies();
		log.info("Deleted all the cookies");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIME_OUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
