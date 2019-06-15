package com.tg.webPages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tg.base.Base;
import com.tg.utility.Support;

public class SingaporeGamePage extends Base {
	

	@FindBy(how = How.XPATH, using = "//*[@id=\"content-wrapper-main\"]/div/div[2]/div/div/div/div[2]/a/img")
	@CacheLookup WebElement clickTogelGameView;
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[3]/td/button[2]")
	@CacheLookup
	static WebElement clickKirim;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[1]")
	@CacheLookup
	WebElement betNum_4D_1;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[2]")
	@CacheLookup
	WebElement betNum_4D_2;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[3]")
	@CacheLookup
	WebElement betNum_4D_3;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tbody/tr[1]/td[2]/div/input[4]")
	@CacheLookup
	WebElement betNum_4D_4;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[1]/td[4]/input")
	@CacheLookup
	static WebElement bayarAmt_4d;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[1]/td[5]/input")
	@CacheLookup
	static WebElement bayarAmt_3d;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[1]/td[6]/input")
	@CacheLookup
	static WebElement bayarAmt_2d;
	@FindBy(how = How.XPATH, using = "//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[2]/td[4]/small")
	@CacheLookup
	static WebElement totalBayar;
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/div/div[2]/button[2]")
	@CacheLookup
	static WebElement clickOK;
	
	public SingaporeGamePage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTogelViewGames() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/header/div[2]/ul/li[3]")));
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/ul/li[3]")).click();
	}
	
	public void clickOnSGPoolsGame() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"togel_list\"]/ul/li[1]")));
		driver.findElement(By.xpath("//*[@id=\"togel_list\"]/ul/li[1]")).click();
	}
	
	public void enterBetNumberAndAmount() {

		Support.scrollPage(driver);

		betNum_4D_1.sendKeys(prop.getProperty("4D_Number_1"));
		betNum_4D_2.sendKeys(prop.getProperty("4D_Number_2"));
		betNum_4D_3.sendKeys(prop.getProperty("4D_Number_3"));
		betNum_4D_4.sendKeys(prop.getProperty("4D_Number_4"));

		List<WebElement> listofbetamt = driver.findElements(By.id("txtbetamount"));
		for (int i = 0; i < listofbetamt.size(); i++) {
			WebElement listelement = listofbetamt.get(i);
			String betrow = listelement.getAttribute("data-game-number");
			String betcol = listelement.getAttribute("data-game");
			// System.out.println(listelement.getAttribute("data-game"));

			if (betrow.equals("1") && betcol.equals("4d")) {
				listelement.sendKeys(prop.getProperty("4D_BetAmount"));
			}
			if (betrow.equals("1") && betcol.equals("3d")) {
				listelement.sendKeys(prop.getProperty("3D_BetAmount"));
			}
			if (betrow.equals("1") && betcol.equals("2d")) {
				listelement.sendKeys(prop.getProperty("2D_BetAmount"));
			}
		}
		System.out.println("Bet Amount entered in 4D/3D/2D game");
	}

	public void bayarAmtCaclulation() {

		String bayar4D = bayarAmt_4d.getText();
		String bayar3D = bayarAmt_3d.getText();
		String bayar2D = bayarAmt_2d.getText();
		System.out.println("Bayar Amount is - " + bayar4D + ", " + ", " + bayar3D + ", " + ", " + bayar2D);
		String totalAmount = totalBayar.getText();
		System.out.println("Total amount is -" + totalAmount);
	}

	public void clickKirimButton() {
		
		driver.findElement(By.xpath("//*[@id=\"fourdgame\"]/div[2]/div/div/table/tfoot/tr[3]/td/button[2]")).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div/div/div[2]/button[1]")));
		driver.findElement(By.xpath("/html/body/div[3]/div/div/div[2]/button[1]")).click();

		//String screenShotPath = ScreenShotCaptured.currentScreenShot(driver, "4D3D2D_Bet_Transaction");
		//logger.log(LogStatus.INFO, "4D/3D/2D Game Page Screen with popup - " + logger.addScreenCapture(screenShotPath));
	}

}
