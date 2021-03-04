package com.qa.Rediff.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	private static Logger log = Logger.getLogger(TestBase.class);
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	public static Properties prop = null;

	public static String readProperties(String key) {
		log.info("Create object for properties");
		prop = new Properties();
		log.info("Read the properties file");
		try {
			FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\Rediff\\config\\config.properties");
			log.info("Load all the properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

	@BeforeSuite
	public  void setUp() {

		log.info("Lanch the browser");
		String browsername = readProperties("browser");

		if (browsername.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		} else if (browsername.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		log.debug("Implicit wait");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		log.debug("Maximize the browser");
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, 30);
		log.debug("Lanch the application url");
		driver.get(readProperties("applicationurl"));
	}

	@AfterSuite
	public void browserend() {
		driver.quit();

	}
}
