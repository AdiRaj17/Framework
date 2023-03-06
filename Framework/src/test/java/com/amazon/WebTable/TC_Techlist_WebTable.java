package com.amazon.WebTable;

import org.testng.annotations.Test;

import com.amazon.Common.BaseClass;
import com.amazon.Common.BrowserAppLaunch;
import com.amazon.Common.Helper;
import com.amazon.Dashboard.HomePage;
import com.techlist.WebTable.CustomerWebtable;

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
	    
	    CustomerWebtable cusTable= new CustomerWebtable(driver);
	    //Print column headers
	    //cusTable.printCustomerColumnData(jsonConfig.getString("index"));
	    int columnsize=cusTable.printCustomerColumnHeaders();
	    for(int i=0;i<columnsize;i++)
	    {
	    	String s=String.valueOf(i);
	    	cusTable.printCustomerColumnData(s);
	    }
	    /*//Print given column values
	    cusTable.printCustomerColumnData(jsonConfig.getString("index"));
	    
	   //Print values of all the column present in a Webtable
	    //for(int i=0;)
	    cusTable.printCustomerRowData(jsonConfig.getString("rowindex"));*/
	    
	    logger.info("Printed customer header name");
	    Helper.captureScreenshots(driver);
  }
	 catch (Exception ex) {
			System.out.println("Caught Exception" +ex);
			//LCUtils.analyzeAndThrowException(driver, ex);
		}
 }
}
