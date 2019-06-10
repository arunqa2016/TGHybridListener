package com.tg.extentReportListener;

import com.relevantcodes.extentreports.ExtentReports;
import com.tg.base.Base;

public class ExtentManager extends Base {
	//String reportLocation = "C://";
	//String fileName = "E:\\Automation_Reports\\TG_Extent_Report.html";
	
	public void ExtentReport() {
	//	System.out.println("Report Location is - " + fileName);
		//extent = new ExtentReports(fileName);
		
		
	}
	
	public void endReport() {
		extent.flush();
		extent.close();
		extent.endTest(extentTest);
	}

}
