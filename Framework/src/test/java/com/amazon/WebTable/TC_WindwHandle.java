package com.amazon.WebTable;

import static org.testng.Assert.assertEquals;

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
	    
	  /*  String pageTitle=driver.getTitle();
	    String expected="Facebook";
	    
	    assertEquals(pageTitle, expected);*/
	    //assertEquals(pageTitle, expected);
	    
	    wh.clickNewBrowserWindow();
	    logger.info("Clicked on new browser window");
	    
	    wh.clickNewMessageWindow();
	    logger.info("Clicked on new message window");
	    
	    wh.getWindowHandles();
	    logger.info("Got all opened window details");
	    
	    wh.clickAndAcceptAlertPopUp();
	    logger.info("Clicked on Popup and accepted it");
	    
	   // assert.assertEquals(actual, expected);
}
		 catch (Exception ex) {
				System.out.println("Caught Exception " +ex);
				//LCUtils.analyzeAndThrowException(driver, ex);
			}
	  }
}
