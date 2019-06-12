package com.tg.testCase;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.tg.base.Base;
import com.tg.helper.ScreenShotCaptured;
import com.tg.webPages.DashboardPage;
import com.tg.webPages.LoginPage;

import junit.framework.Assert;

public class LoginTestCase extends Base {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginTestCase() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		extentTest = extent.startTest("To verify title of Login Page", "Title Test on login page");
		String loginTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginTitle, prop.getProperty("loginPageTitle"));
	}
	
	@Test(priority=2)
	public void verifyValidLoginTest() throws InterruptedException {
		extentTest = extent.startTest("To verify correct login functionality", "Correct login credentials test");
		dashboardPage = loginPage.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}
	
}
