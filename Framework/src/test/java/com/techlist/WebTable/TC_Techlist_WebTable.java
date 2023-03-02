package com.techlist.WebTable;

import org.testng.annotations.Test;

import com.amazon.Common.BaseClass;
import com.amazon.Common.BrowserAppLaunch;
import com.amazon.Common.Helper;
import com.amazon.Dashboard.HomePage;

public class TC_Techlist_WebTable extends BaseClass {
	
@Test
public void Techlist()
{
	 try {
			initialize(new Object() {
			}.getClass());
			
		logger=report.createTest("Techlist Webtable check");
		//BrowserAppLaunch ba = new BrowserAppLaunch();
	    driver=BrowserAppLaunch.launchBrowser(driver,"Chrome","https://www.techlistic.com/p/demo-selenium-practice.html");
	    
	    //CustomerWebtable cusTable= new CustomerWebtable(driver);
	    
	    //logger.info("Navigated to Techlist Webtable");
	    Helper.captureScreenshots(driver);
  }
	 catch (Exception ex) {
			System.out.println("Caught Exception" +ex);
			//LCUtils.analyzeAndThrowException(driver, ex);
		}
 }
}
