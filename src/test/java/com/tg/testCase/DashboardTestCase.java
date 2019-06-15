package com.tg.testCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.tg.base.Base;
import com.tg.webPages.DashboardPage;
import com.tg.webPages.LoginPage;


public class DashboardTestCase extends Base {
	
	LoginPage loginPage;
	DashboardPage dashboardPage;
	
	public DashboardTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		dashboardPage = loginPage.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test
	public void dashboardTestCase() {
		System.out.println("In dashboardTestCase Method ");
		extentTest = extent.startTest("To verify title of Dashboard Page", "Title Test on Dashboard page");
		String dashboardTitle = dashboardPage.validateDashboardPageTitle();
		Assert.assertEquals(dashboardTitle, prop.getProperty("DashboardTitle"));
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
