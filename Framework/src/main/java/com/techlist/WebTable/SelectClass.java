package com.techlist.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.amazon.Common.Utility;

public class SelectClass {
WebDriver driver=null;
	
	public static final String XP_OLD_SELECT_DD ="//select[@id='oldSelectMenu']";
	public static final String XP_MULTI_SELECT_DD ="//select[@id='cars']";	
	public static final String XP_CUSTOMER_COULMN_DATA ="//table[@id='customers']//tr//td[colindex]";	
	public static final String XP_SEARCHED_PRODUCT ="//div[@id='search']/span/div/h1/div/div[1]/div/div/span[contains(text(),'varProduct')]";

	
	public SelectClass(WebDriver driver) {
		this.driver = driver;
    }	
	
	/**
	 * Print all the values of Select Value drop down 
	 * @author aditya
	 * */
	public void printDropDownValue() {		
		WebElement dropDown=driver.findElement(By.xpath(XP_OLD_SELECT_DD));
		Select select = new Select(dropDown);		
		List<WebElement> ele= select.getOptions();
		for(WebElement e : ele)
		{
			String values=e.getText();
	    	System.out.println("old select drop down values are " +values);
	    }		
	}
	
	/**
	 * Select drop down value using Index and Value
	 * @author aditya
	 * @throws Exception 
	 * */
	public void selectOldStyleValue(int value,String abc) throws Exception {
		Utility.selectFromDropdownByIndex(driver, XP_OLD_SELECT_DD, value);
		Thread.sleep(5000);
		Utility.selectFromDropdownByValue(driver, XP_OLD_SELECT_DD, abc);
		Thread.sleep(5000);
		System.out.println("Select drop down values are " +value);
		
	}
	
	/**
	 * Multi select drop down value using Index and Value
	 * @author aditya
	 * @throws Exception 
	 * */
	public void selectMultipleDDValue(int value,String abc) throws Exception {
		Utility.selectFromDropdownByIndex(driver, XP_MULTI_SELECT_DD, value);
		Thread.sleep(5000);
		Utility.selectFromDropdownByValue(driver, XP_MULTI_SELECT_DD, abc);
		Thread.sleep(5000);
		System.out.println("Selected drop down values from multi select dd  " +value);
		System.out.println("Selected drop down values from multi select dd  " +abc);
	}
	
	/**
	 * Multi select drop down value using Index and Value
	 * @author aditya
	 * @throws Exception 
	 * */
	public void deselectMultipleDDValue(int value,String abc) throws Exception {
		Utility.deselectFromDropdownByIndex(driver, XP_MULTI_SELECT_DD, value);
		Thread.sleep(5000);
		Utility.deselectFromDropdownByValue(driver, XP_MULTI_SELECT_DD, abc);
		Thread.sleep(5000);
		System.out.println("Selected drop down values from multi select dd  " +value);
		System.out.println("Selected drop down values from multi select dd  " +abc);
	}
	
	/**
	 * Multi select drop down value using Index and Value
	 * @author aditya
	 * @throws Exception 
	 * */
	public void verfiyColourDDSortedOrNot() throws Exception {
		Utility.verfiyDDValuesSortedOrNott(driver, XP_MULTI_SELECT_DD);		
		System.out.println("Verified colour drop down is sorted or not " );
		
	}
}
