package com.amazon.WebTable;

import org.testng.annotations.Test;

import com.amazon.Common.BaseClass;
import com.amazon.Common.BrowserAppLaunch;
import com.amazon.Common.Helper;
import com.amazon.Dashboard.HomePage;
import com.techlist.WebTable.ActionsClass;
import com.techlist.WebTable.SelectClass;

public class TC_DemoQA_Actions extends BaseClass {
	
	@Test(priority=1,enabled=false)
	 public void DragDrop()
	 {	 
		 try {
				initialize(new Object() {
				}.getClass());			
			
		    driver=BrowserAppLaunch.launchBrowser(driver, "Chrome","https://demoqa.com/droppable");
		    ActionsClass actions = new ActionsClass(driver);
		    HomePage hp= new HomePage(driver);
		    logger=report.createTest("Demo QA Site launched");
		    
		    //Drag and Drop
		    actions.dragAndDropActions();
		    Helper.captureScreenshots(driver);
		    logger.pass("Drag and  drop test case is passed");
}
		 catch (Exception ex) {
				System.out.println("Caught Exception " +ex.getMessage());
				//LCUtils.analyzeAndThrowException(driver, ex);
			}
	 }
	
	@Test(priority=1,enabled=false)
	 public void Resizable()
	 {
		 try {
				initialize(new Object() {
				}.getClass());
			
		    driver=BrowserAppLaunch.launchBrowser(driver, "Chrome","https://demoqa.com/resizable");
		    ActionsClass actions = new ActionsClass(driver);
		    HomePage hp= new HomePage(driver);
		    logger=report.createTest("Demo QA Site launched");
		    
		    //Resizable
		    actions.resizableActions();
		    Helper.captureScreenshots(driver);
		    logger.pass("Resizing element test case is passed");
}
		 catch (Exception ex) {
				System.out.println("Caught Exception " +ex.getMessage());
				//LCUtils.analyzeAndThrowException(driver, ex);
			}
	 }
	
	@Test(priority=3)
	 public void Selectable()
	 {
		 try {
				initialize(new Object() {
				}.getClass());
			
		    driver=BrowserAppLaunch.launchBrowser(driver, "Chrome","https://demoqa.com/selectable");
		    ActionsClass actions = new ActionsClass(driver);
		    HomePage hp= new HomePage(driver);
		    logger=report.createTest("Demo QA Site launched");
		    
		    //Selectable
		    actions.selectableActions();
		    Helper.captureScreenshots(driver);
		    logger.pass("Selecting element using action class is passed");
}
		 catch (Exception ex) {
				System.out.println("Caught Exception " +ex.getMessage());
				//LCUtils.analyzeAndThrowException(driver, ex);
			}
	 }

}
