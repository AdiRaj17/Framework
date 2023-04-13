package com.techlist.WebTable;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WindowHandle {
	
WebDriver driver=null;
	
	public static final String XP_NEW_BROWSER_WINDOW="//button[@id='button1']";
	public static final String XP_NEW_MESSAGE_WINDOW ="//button[contains(text(),'New Message Window')]";	
	public static final String XP_ALERT_BOX ="//button[@id='alert']";
	/*//public static final String XP_CUSTOMER_ROW_DATA ="//table[@id='customers']//tr['varColumn']";
	public static final String XP_CUSTOMER_ROW_DATA ="//table[@id='customers']//tr[colindex]";
	public static final String XP_SEARCHED_PRODUCT ="//div[@id='search']/span/div/h1/div/div[1]/div/div/span[contains(text(),'varProduct')]";
	//public static final String XP_HOME_PAGE_SEARCH_BOX_TEXT ="//label[@for='twotabsearchtextbox']";
*/	
	public WindowHandle(WebDriver driver) {
		this.driver = driver;
    }	
	
	/**
	 * Click new browser window
	 * @author aditya
	 * */
	public void clickNewBrowserWindow() throws Exception {		
		driver.findElement(By.xpath(XP_NEW_BROWSER_WINDOW)).click();
		System.out.println("Clicked on new browser window");		
	}
    
	/**
	 * Click new message window
	 * @author aditya
	 * */
	public void clickNewMessageWindow() throws Exception {		
		driver.findElement(By.xpath(XP_NEW_MESSAGE_WINDOW)).click();
		System.out.println("Clicked on new message window");		
	}
	
	/**
	 * Get Window handle
	 * @author aditya
	 * */
	public void getWindowHandles() throws Exception {
		Set<String> windows=driver.getWindowHandles();
		for(String window:windows)
		//driver.findElement(By.xpath(XP_NEW_BROWSER_WINDOW)).click();
		System.out.println("Clicked on new browser window : " + window);		
	}
	
	/**
	 * Click and accept Alert pop up
	 * @author aditya
	 * */
	public void clickAndAcceptAlertPopUp() throws Exception {		
		driver.findElement(By.xpath(XP_ALERT_BOX)).click();
		Alert alert=driver.switchTo().alert();
		alert.accept();
		System.out.println("Clicked on Popup and accepted it");		
	}
}
