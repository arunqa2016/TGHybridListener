package com.tg.helper;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShotCaptured {
	
	public static String currentScreenShot(WebDriver driver, String sGGameScreenShot) throws IOException {
		String datetime = null;
		String dateName = datetime;
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = "C:\\Reports\\Screenshots\\"+sGGameScreenShot+dateName+".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
		
	}

}
