package com.amazon.Dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

public class HomePage {
	
	WebDriver driver=null;
			
	public static final String XP_AMAZON_LOGO ="//a[@aria-label='Amazon.in']";
	public static final String XP_HOME_PAGE_SEARCH_BOX ="//input[@id='twotabsearchtextbox']";
	public static final String XP_HOME_PAGE_SEARCH_BOX_TEXT ="//input[@aria-label='Search Amazon.in']";
	public static final String XP_SEARCHED_PRODUCT ="//div[@id='search']/span/div/h1/div/div[1]/div/div/span[contains(text(),'varProduct')]";
	//public static final String XP_HOME_PAGE_SEARCH_BOX_TEXT ="//label[@for='twotabsearchtextbox']";
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
    }	
  
//-------------------------------------------------------------------------------------------------	//
	
	/**
	 * Verifies Amazon logo is present or not
	 * @author aditya
	 * */
	public void verifyAmazonLogo() {
		boolean logo=driver.findElement(By.xpath(XP_AMAZON_LOGO)).isDisplayed();
		if(logo)
			System.out.println("Amazon logo is present");
		else
			System.out.println("Amazon logo is not present");
	}
	
	/**
	 * Verifies Amazon Search box is present or not
	 * @author aditya
	 * */
	public void verifyAmazonSearchBox() {
		boolean searchBar=driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX)).isDisplayed();
		if(searchBar)
			System.out.println("Amazon search box is present");
		    //driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX)).getText();
		else
			System.out.println("Amazon search box is not present");
	}
	
	/**
	 * Verifies Amazon search box text
	 * @author aditya
	 * *//*
	public void verifyAmazonSearchBoxText(String searchProductName) {
		//String actualtext =driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX_TEXT)).getText();
		driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX_TEXT))
		Thread.sleep(2000);
		WebElement ele=driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX_TEXT));
		String actualtext=ele.getText();
		if(actualtext.contains(expectedSearchText))
			System.out.println("Amazon search text is present");
		    //driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX)).getText();
		else
			System.out.println("Amazon search text is not present");
	}*/
	
	/**
	 * Verifies Amazon search box feature
	 * @author aditya
	 * @throws InterruptedException 
	 * */
	public void searchProductInAmazonHome(String searchedProduct) throws Exception {
		//String actualtext =driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX_TEXT)).getText();
		WebElement search= driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX_TEXT));
		search.sendKeys(searchedProduct);
		search.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.xpath(XP_SEARCHED_PRODUCT.replace("varProduct", searchedProduct)));
		//String serachedProductlist=ele.getText();
		if(ele.getText().contains(searchedProduct))
			System.out.println("Amazon search feature is working as expected");		    
		else
			throw new Exception("Amazon search feature is not working");
			//System.out.println("Amazon search feature is not working");
	}
}
