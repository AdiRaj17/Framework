package com.amazon.Common;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Helper extends BaseClass {
	
	public static String captureScreenshots(WebDriver driver)
	{
		String screenshotsPath = System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\Amazon"+getCurrentDateTime() +".png";
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		 // now copy the  screenshot to desired location using copyFile //method
		//FileHandler.copy(src, new File("./screenshots/" + getCurrentDateTime() + "error.png"));
		  FileHandler.copy(src, new File(screenshotsPath));
		//System.out.println("Screenshots got captured");
		  logger.info("Screenshots got captured");
		}

		catch (IOException e)
		 {
		  System.out.println(e.getMessage());

		 }
		return screenshotsPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat format= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date date = new Date();
		return format.format(date);
	}

}
