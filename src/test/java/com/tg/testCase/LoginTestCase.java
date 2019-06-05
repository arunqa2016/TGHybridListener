package com.tg.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tg.base.Base;
import com.tg.webPages.DashboardPage;
import com.tg.webPages.LoginPage;

import junit.framework.Assert;

public class LoginTestCase extends Base {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public LoginTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String loginTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals(loginTitle, prop.getProperty("loginPageTitle"));
	}
	
	@Test(priority=2)
	public void verifyValidLoginTest() throws InterruptedException {
		dashboardPage = loginPage.validateLoginFunctionality(prop.getProperty("usernamee"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
