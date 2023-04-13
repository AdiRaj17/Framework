package com.amazon.Dashboard;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.amazon.Common.BaseClass;
import com.amazon.Common.BrowserAppLaunch;
import com.amazon.Common.Helper;
import com.amazon.Dashboard.HomePage;

public class TC_HomePage extends BaseClass{
	
 //WebDriver driver1;
 //Object Initialization 
 
 @Test
 public void HomePage()
 {
	 try {
			initialize(new Object() {
			}.getClass());
			
		//logger=report.createTest("Amazon Dashbord check");
		
	    driver=BrowserAppLaunch.launchBrowser(driver, "Chrome","https://www.amazon.in/");
	    HomePage hp= new HomePage(driver);
	    logger=report.createTest("Amazon Dashbord check");
		//This will verify the Amazon logo
		hp.verifyAmazonLogo();
		logger.info("Verified Amazon logo");
		Helper.captureScreenshots(driver);
		
		/*//This will verify the Search box and corresponding text
		hp.verifyAmazonSearchBox();		
		//hp.verifyAmazonSearchBoxText("Search Amazon.in");
		
		//This will search product in Amazon home page
		hp.searchProductInAmazonHome(jsonConfig.getString("searchProductName"));
		
		//Print all auto suggestion in search bar
		hp.printProductAutoSuggestion(jsonConfig.getString("searchProductName"));
*/		
		//Hover over language drop down
		hp.hoverLanguageDropDown();
		logger.info("Hover over language drop down");
		
		//Select Preferred language
		hp.selectPreferredLanguage(jsonConfig.getString("language"));
		logger.info("Selected Preferred from language drop down");
		
		//BrowserAppLaunch.quitBrowser(driver);
		logger.pass("Test is passed");
		Helper.captureScreenshots(driver);
 }
	 catch (Exception ex) {
			System.out.println("Caught Exception");
			//LCUtils.analyzeAndThrowException(driver, ex);
		}
  }
}
