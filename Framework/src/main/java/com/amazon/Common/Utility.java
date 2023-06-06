package com.amazon.Common;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class Utility {
	WebDriver driver;
	
	/**
	 * Chooses an element from a Select dropdown on the basis of visible text given
	 * 
	 * @author aditya
	 * @param driver
	 * @param xpath
	 * @param visibleText
	 * @throws Exception
	 */
	public static void selectFromDropdownByVisibleText(WebDriver driver,String xpath,String visibleText) throws Exception {
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByVisibleText(visibleText);
	}

	public static void selectFromDropdownByIndex(WebDriver driver, String xpath, int index) throws Exception {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByIndex(index);
	}
	
	public static void selectFromDropdownByValue(WebDriver driver, String xpath, String value) throws Exception {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.selectByValue(value);
	}
	
	public static void deselectFromDropdownByIndex(WebDriver driver, String xpath, int index) throws Exception {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.deselectByIndex(index);
	}
	
	public static void deselectFromDropdownByValue(WebDriver driver, String xpath, String value) throws Exception {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		select.deselectByValue(value);
	}

}
