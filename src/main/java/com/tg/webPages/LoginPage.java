package com.tg.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.tg.base.Base;
import com.tg.helper.Helper;


public class LoginPage extends Base {
	
	//Page Factory - Object Repository
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"user\"]")@CacheLookup WebElement username;
	@FindBy(how = How.XPATH, using = "//*[@id=\"login_form\"]/div/button")@CacheLookup	WebElement clickUserButton;
	@FindBy(how = How.NAME, using = "password")	@CacheLookup	WebElement password;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password-form\"]/div[6]/div[2]/button")	@CacheLookup	WebElement clickPassButton;
	@FindBy(how = How.XPATH, using = "//*[@id=\"accept_btn\"]")	@CacheLookup	WebElement agree;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	} 
	
	
	public DashboardPage validateLoginFunctionality(String un, String pass) throws InterruptedException {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("user")));
		Assert.assertTrue(username.isDisplayed());
		username.sendKeys(un);
		Assert.assertTrue(clickUserButton.isDisplayed());
		clickUserButton.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		Assert.assertTrue(password.isDisplayed());
		password.sendKeys(pass);
		
		Helper.waitFor5Seconds();
		Assert.assertTrue(clickPassButton.isDisplayed());
		clickPassButton.click();
		
		return new DashboardPage();
	}
	
}
