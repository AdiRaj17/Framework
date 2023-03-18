package com.amazon.WebTable;

import org.testng.annotations.Test;

import com.amazon.Common.BaseClass;
import com.amazon.Common.BrowserAppLaunch;
import com.techlist.WebTable.WindowHandle;

public class TC_WindwHandle extends BaseClass {
	
	 @Test
	 public void WindowHandle()
	 {
		 try {
				initialize(new Object() {
				}.getClass());
				
		logger=report.createTest("Techlist Window handle check");
	    driver=BrowserAppLaunch.launchBrowser(driver,"Chrome","http://www.seleniumframework.com/Practiceform/");
	    
	    WindowHandle wh = new WindowHandle(driver);
	    
	    wh.clickNewBrowserWindow();
	    logger.info("Clicked on new browser window");
	    
	    wh.clickNewMessageWindow();
	    logger.info("Clicked on new message window");
	    
	    wh.getWindowHandles();
	    logger.info("Got all opened window details");
	    
	    wh.clickAndAcceptAlertPopUp();
	    logger.info("Clicked on Popup and accepted it");
}
		 catch (Exception ex) {
				System.out.println("Caught Exception");
				//LCUtils.analyzeAndThrowException(driver, ex);
			}
	  }
}
