package com.tg.extentReportListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tg.base.Base;
import com.tg.helper.ScreenShotCaptured;

public class NGExtentReport extends Base implements ITestListener {
	
	//ExtentManager ext = new ExtentManager();

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		//extent.endTest(extentTest);
		//driver.get(reportLocation);
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		//ext.ExtentReport();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		/*String imagePath = null;
		try {
			imagePath = ScreenShotCaptured.currentScreenShot(driver, "ScreenShot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		extentTest.log(LogStatus.FAIL, result.getName());
		//extentTest.addScreenCapture(imagePath)
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//extent.startTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		extentTest.log(LogStatus.PASS, result.getName());
	}

}
