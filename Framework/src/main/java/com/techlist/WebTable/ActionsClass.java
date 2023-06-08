package com.techlist.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
	
WebDriver driver=null;
	
	public static final String XP_INTERACTION_DRAG_ME ="//div[@id='draggable']";
	public static final String XP_INTERACTION_DROP_ME ="//div[@id='droppable']";
	public static final String XP_RESIZABLE ="//div[@id='resizable']";
	public static final String XP_SELECTABLE ="//ul[@id='verticalListContainer']//li";
	
	public ActionsClass(WebDriver driver) {
		this.driver = driver;
    }	
	
	/**
	 * Function to drag and drop using Actions class
	 * @author aditya
	 * */
	public void dragAndDropActions() {
		WebElement drag = driver.findElement(By.xpath(XP_INTERACTION_DRAG_ME));
		WebElement drop = driver.findElement(By.xpath(XP_INTERACTION_DROP_ME));
		Actions act = new Actions(driver);
		act.dragAndDrop(drag, drop).perform();
		System.out.println("Succesfully drageed and dropped");
	}
	
	/**
	 * Function to resize the element using Actions class
	 * @author aditya
	 * */
	public void resizableActions() {
		WebElement resize = driver.findElement(By.xpath(XP_RESIZABLE));		
		Actions act = new Actions(driver);
		act.clickAndHold(resize).moveByOffset(300, 300).perform();;
		System.out.println("Succesfully resized the element");
	}
	
	/**
	 * Function to select the element using Actions class
	 * @author aditya
	 * */
	public void selectableActions() {
		List<WebElement> select = driver.findElements(By.xpath(XP_SELECTABLE));		
		Actions act = new Actions(driver);
		for(WebElement e :select )
		{
			act.moveToElement(e).click().perform();
			System.out.println("Succesfully each element one by one " +e.getText());
		}		
		
	}

}
