package com.amazon.WebTable;

import org.testng.annotations.Test;

import com.amazon.Common.BaseClass;
import com.amazon.Common.BrowserAppLaunch;
import com.amazon.Common.Helper;
import com.amazon.Dashboard.HomePage;
import com.techlist.WebTable.SelectClass;

public class TC_DemoQA_Select extends BaseClass {
//WebDriver driver;	
	 @Test
	 public void Select()
	 {
		 try {
				initialize(new Object() {
				}.getClass());
			
		    driver=BrowserAppLaunch.launchBrowser(driver, "Chrome","https://demoqa.com/select-menu");
		    SelectClass sc = new SelectClass(driver);
		    HomePage hp= new HomePage(driver);
		    logger=report.createTest("Demo QA Site launched");
		    
		    System.out.println("The current thread Id is :" + Thread.currentThread().getId());
		    
		    //First drop down
		    //sc.printDropDownValue();
		    //Select drop down value using index
		    //sc.selectOldStyleValue(jsonConfig.getInt("index"),jsonConfig.getString("value"));
		    
		    // Verify drop down is sorted or not
		    sc.verfiyColourDDSortedOrNot();
		    logger.pass("Select drop down test case is passed");
}
		 catch (Exception ex) {
				System.out.println("Caught Exception " +ex.getMessage());
				//LCUtils.analyzeAndThrowException(driver, ex);
			}
	 }
	 @Test
	 public void MultiSelect()
	 {
		 //logger.info("Running Mutli Select DD test case");
		 try {
				initialize(new Object() {
				}.getClass());
				
			System.out.println("The current thread Id is :" + Thread.currentThread().getId());		
							
		    driver=BrowserAppLaunch.launchBrowser(driver, "Chrome","https://demoqa.com/select-menu");
		    SelectClass sc = new SelectClass(driver);
		    HomePage hp= new HomePage(driver);
		    logger=report.createTest("Demo QA Site launched");		    
		    //Select drop down value using index
		    sc.selectMultipleDDValue(jsonConfig.getInt("index"),jsonConfig.getString("value"));
		    logger.info("Selected Mutli Select DD value");
		    sc.deselectMultipleDDValue(jsonConfig.getInt("index"),jsonConfig.getString("value"));
		    Helper.captureScreenshots(driver);
		    logger.pass("DeSelected Mutli Select DD value");

}
		 catch (Exception ex) {
				System.out.println("Caught Exception " +ex.getMessage());
				
			}
	 }
}
