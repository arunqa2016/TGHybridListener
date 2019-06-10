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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.tg.utility.Utility;
import com.tg.utility.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tg.extentReportListener.ExtentReporterNG;
import com.tg.helper.ScreenShotCaptured;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
//	public static EventFiringWebDriver e_driver;
//	public static WebEventListener eventListener;
	public static WebDriverWait wait;
	private String propPath = "E:\\Arun Backup Data\\workspace-eclipse\\TestNGListener\\src\\main\\java\\com\\tg\\config\\Config.properties";
	protected String reportLocation = "E:\\Automation_Reports\\TestNGListener_Report.html";
	public ExtentReports extent;
	public ExtentTest extentTest;
	
	
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
	
	
	public void initialization(){
		
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");	
		driver = new ChromeDriver(); 
		
		/*e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListenerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;*/
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICIT_WAIT, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		extent = new ExtentReports(reportLocation);
		driver.get(prop.getProperty("url"));
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = ScreenShotCaptured.currentScreenShot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		//driver.quit();
		
	}
	
	@AfterTest
	public void endReport() {
		extent.flush();
		driver.close();
		driver.get(reportLocation);
	}
	

}
