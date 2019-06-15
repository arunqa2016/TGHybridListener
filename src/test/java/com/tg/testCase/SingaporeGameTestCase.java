package com.tg.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tg.base.Base;
import com.tg.webPages.DashboardPage;
import com.tg.webPages.LoginPage;
import com.tg.webPages.SingaporeGamePage;

public class SingaporeGameTestCase extends Base {

	LoginPage loginPage;
	DashboardPage dashboardPage;
	SingaporeGamePage sgPoolGame;
	
	public SingaporeGameTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		sgPoolGame = new  SingaporeGamePage();
		dashboardPage = loginPage.validateLoginFunctionality(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test
	public void validateSingaporeGameTest() {
		sgPoolGame.clickOnTogelViewGames();
		sgPoolGame.clickOnSGPoolsGame();
		sgPoolGame.enterBetNumberAndAmount();
		sgPoolGame.bayarAmtCaclulation();
		sgPoolGame.clickKirimButton();
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	
}
