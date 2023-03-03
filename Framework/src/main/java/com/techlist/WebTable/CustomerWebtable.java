package com.techlist.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerWebtable {
	
	WebDriver driver=null;
	
	public static final String XP_CUSTOMER_WEBTABLE ="//table[@id='customers']";
	public static final String XP_CUSTOMER_COULMN_HEADERS ="//table[@id='customers']//th";
	public static final String XP_CUSTOMER_COULMN_DATA ="//table[@id='customers']//tr//td['varColumn']";
	public static final String XP_CUSTOMER_ROW_DATA ="//table[@id='customers']//tr['varColumn']";
	public static final String XP_SEARCHED_PRODUCT ="//div[@id='search']/span/div/h1/div/div[1]/div/div/span[contains(text(),'varProduct')]";
	//public static final String XP_HOME_PAGE_SEARCH_BOX_TEXT ="//label[@for='twotabsearchtextbox']";
	
	public CustomerWebtable(WebDriver driver) {
		this.driver = driver;
    }	
   
	/**
	 * Print column headers names of customer webtable
	 * @author aditya
	 * */
	public void printCustomerColumnHeaders() {
		List<WebElement> ele= driver.findElements(By.xpath(XP_CUSTOMER_COULMN_HEADERS));		
	    for(int i=0;i<ele.size();i++)
	    {
	    	String headername=ele.get(i).getText();
	    	System.out.println("Customer header name is " +headername);
	    }		
	}
	
	/**
	 * Print column details of a particular column
	 * @author aditya
	 * */
	public void printCustomerColumnData(String index) {
		List<WebElement> ele= driver.findElements(By.xpath(XP_CUSTOMER_COULMN_DATA.replace("'varColumn'", index)));		
	    for(int i=0;i<ele.size();i++)
	    {
	    	String columnValues=ele.get(i).getText();
	    	System.out.println("Customer values are " +columnValues);
	    }		
	}
	
	/**
	 * Print row data of a particular row
	 * @author aditya
	 * */
	public void printCustomerRowData(String index) {
		List<WebElement> ele= driver.findElements(By.xpath(XP_CUSTOMER_ROW_DATA.replace("'varColumn'", index)));
		//List<WebElement> ele= driver.findElements(By.xpath(XP_CUSTOMER_ROW_DATA.re);
	    for(int i=0;i<ele.size();i++)
	    {
	    	String columnValues=ele.get(i).getText();
	    	System.out.println("Customer values are " +columnValues);
	    }		
	}
}
