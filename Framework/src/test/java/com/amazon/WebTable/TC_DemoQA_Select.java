package com.amazon.WebTable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.amazon.Common.BaseClass;
import com.amazon.Common.BrowserAppLaunch;
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
				
			//logger=report.createTest("Amazon Dashbord check");
			
		    driver=BrowserAppLaunch.launchBrowser(driver, "Chrome","https://demoqa.com/select-menu");
		    SelectClass sc = new SelectClass(driver);
		    HomePage hp= new HomePage(driver);
		    logger=report.createTest("Demo QA Site launched");
		    
		    //First drop down
		    sc.printDropDownValue();
		    //Select drop down value using index
		    sc.selectOldStyleValue(jsonConfig.getInt("index"),jsonConfig.getString("value"));

}
		 catch (Exception ex) {
				System.out.println("Caught Exception " +ex.getMessage());
				//LCUtils.analyzeAndThrowException(driver, ex);
			}
	 }
}
