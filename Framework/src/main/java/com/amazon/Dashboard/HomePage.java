package com.amazon.Dashboard;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.*;

public class HomePage {
	
	WebDriver driver=null;
			
	public static final String XP_AMAZON_LOGO ="//a[@aria-label='Amazon.in']";
	public static final String XP_HOME_PAGE_SEARCH_BOX ="//input[@id='twotabsearchtextbox']";
	public static final String XP_HOME_PAGE_SEARCH_BOX_TEXT ="//input[@aria-label='Search Amazon.in']";
	public static final String XP_SEARCHED_PRODUCT ="//div[@id='search']/span/div/h1/div/div[1]/div/div/span[contains(text(),'varProduct')]";
	public static final String XP_SEARCHED_PRODUCT_AUTO_SUGGESTION ="//div[@class='s-suggestion-container']";
	public static final String XP_LANGUAGE_DROPDOWN ="//a[@id='icp-nav-flyout']";
	public static final String XP_AMAZON_LANGUAGE_SELECTION ="(//a[@href='#switch-lang=varLang_IN'])[1]";
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
		
		WebElement search= driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX_TEXT));
		search.sendKeys(searchedProduct);
		search.sendKeys(Keys.RETURN);
		Thread.sleep(3000);
		WebElement ele=driver.findElement(By.xpath(XP_SEARCHED_PRODUCT.replace("varProduct", searchedProduct)));	
		if(ele.getText().contains(searchedProduct))
			System.out.println("Amazon search feature is working as expected");		    
		else
			throw new Exception("Amazon search feature is not working");
			
	}
	
	/**
	 * Enter search product name and print all auto suggestion 
	 * @author aditya
	 * */
	public void printProductAutoSuggestion(String productName) throws Exception {		
		driver.findElement(By.xpath(XP_HOME_PAGE_SEARCH_BOX_TEXT)).sendKeys(productName);		
		Thread.sleep(3000);
		List<WebElement> ele= driver.findElements(By.xpath(XP_SEARCHED_PRODUCT_AUTO_SUGGESTION));
	    for(int i=0;i<ele.size();i++)
	    {
	    	String autosuggestion=ele.get(i).getText();
	    	System.out.println("Auto suggestion values are " +autosuggestion);
	    }		
	}
	
	/**
	 * Hover over language drop down on Home page
	 * @author aditya
	 * */
	public void hoverLanguageDropDown() throws Exception {		
		WebElement language=driver.findElement(By.xpath(XP_LANGUAGE_DROPDOWN));
		Actions actions = new Actions(driver);
		actions.moveToElement(language).perform();
		System.out.println("Hovered over the language drop down");		
	}
	
	/**
	 * Select Preferred language drop down on Home page
	 * @author aditya
	 * */
	public void selectPreferredLanguage(String language) throws Exception {		
		driver.findElement(By.xpath(XP_AMAZON_LANGUAGE_SELECTION.replace("varLang", language))).click();
		System.out.println("Preferred language is selected " +language);		
	}
}
