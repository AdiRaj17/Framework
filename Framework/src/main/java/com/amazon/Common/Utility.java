package com.amazon.Common;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public static void verfiyDDValuesSortedOrNott(WebDriver driver, String xpath) throws Exception {
		Select select = new Select(driver.findElement(By.xpath(xpath)));
		List<WebElement> ele=select.getOptions();
		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> tempList = new ArrayList<String>();
		for(WebElement e : ele)
		{
			originalList.add(e.getText());
			tempList.add(e.getText());
		}
		Collections.sort(tempList);
		if(originalList.equals(tempList)) 
			System.out.println("Given drop down is sorted");
		else
			System.out.println("Given drop down is Not sorted");
	}

}
