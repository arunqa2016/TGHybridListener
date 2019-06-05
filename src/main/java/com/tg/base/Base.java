package com.tg.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tg.utility.Utility;
import com.tg.utility.WebEventListener;
import com.tg.extentReportListener.ExtentReporterNG;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static WebDriverWait wait;
	private String propPath = "E:\\Arun Backup Data\\workspace-eclipse\\TestNGListener\\src\\main\\java\\com\\tg\\config\\Config.properties";
	
	public Base(){
		FileInputStream ip;
		try {
			ip = new FileInputStream(propPath);
			prop = new Properties();
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		
		driver.get(prop.getProperty("url"));
		
	}
	

}
